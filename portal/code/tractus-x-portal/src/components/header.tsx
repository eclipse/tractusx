// Copyright (c) 2021 Microsoft
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as React from 'react';
import { observer } from 'mobx-react';
import { observable } from 'mobx';
import adalContext from '../helpers/adalConfig';
import { Icon, Pivot, PivotItem } from '@fluentui/react';
import { RouteComponentProps, withRouter } from 'react-router-dom';
import { AppState } from '../stores/appstate';
import Logo from './logo';
interface IProp extends RouteComponentProps{
  href: string;
  hidePivot?: boolean;
  appTitle?: string;
}

const pivots = ['Dashboard', 'App Store', 'Data Catalog', 'Digital Twins', 'Semantic Hub', 'Developer Hub'];
const keys = pivots.map((p) => p.toLowerCase().replace(' ', ''));

@observer
class Header extends React.Component<IProp> {
  @observable username = '';
  @observable initials = '';
  @observable selectedKey = '';
  @observable isAdmin = false;

  public async componentDidMount() {
    this.username = adalContext.getFullName();
    this.initials = adalContext.getInitials(this.username);
    if (adalContext.getDomain(adalContext.getUsername()) === 'Daimler') { // Hack for MS Graph
      AppState.state.isAdmin = true;
    } else if (AppState.state.isAdmin === undefined) {
      AppState.state.isAdmin = false;
      try {
        const groups = await adalContext.getGroups();
        if (groups) {
          for (const g of groups.value) {
            const group = g as string;
            if (group === 'ec5a8b75-4839-4ff1-b50d-f8159653d9f0' || group === '463512e5-968f-4b2d-8283-737be4a67182') {
              AppState.state.isAdmin = true;
            }
          }
        }
      } catch { }
    }
  
    this.isAdmin = AppState.state.isAdmin;
  }

  private pivotClick(item: PivotItem): void {
    this.selectedKey = item.props.headerText.replace(' ', '').toLowerCase();
    this.props.history.push(`/home/${this.selectedKey}`);
  }

  private homeClick(): void {
    this.props.history.push('/home/dashboard');
  }

  private userClick() {
    const token = adalContext.getCachedToken();
    console.log(token);
  }

  public render() {
    const href = window.location.href;
    const path = href.substr(href.lastIndexOf('/') + 1);
    const key = String(keys.indexOf(path));
    return (
      <div className='w100pc minh80 df aic bgwhite'>
        <div className='df cpointer' onClick={() => this.homeClick()}>
          <Logo/>
        </div>
        {this.props.appTitle && <div className='df aic'>
          <Icon className='fs14 bold fgblack' iconName='ChromeMinimize' />
          <div className='fs16 bold fgblack ml10 mb4'>{this.props.appTitle}</div>
        </div>}
        <div className='flex1' />
        {!this.props.hidePivot && <Pivot selectedKey={key} className='px30' aria-label='Header' onLinkClick={(item) => this.pivotClick(item)}>
          {pivots.map((p) => {
            return <PivotItem key={p.toLowerCase().replace(' ', '')} className='ml20 mr20' headerText={p} />
          })}
          <PivotItem key='search' className='ml20 mr20' headerText='' itemIcon='search' />
        </Pivot>}
        <div className='flex1' />
        <div className='bgblue fgwhite aic jcc df fs16 br50pc h40 w40 mr10' onClick={() => this.userClick()}>{this.initials}</div>
        <div className='df fdc mr50'>
          <span className='fs14'>{this.username}</span>
          <div className='df'>
            <span className='fs14'>{adalContext.getDomain(adalContext.getUsername())}</span>
            {this.isAdmin && <span className='ml5 fs14'>(Admin)</span>}
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Header);
