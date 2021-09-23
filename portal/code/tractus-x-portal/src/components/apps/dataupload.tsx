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
import Header from '../header';
import { Link, RouteComponentProps, withRouter } from 'react-router-dom';
import { ActionButton, Icon, ComboBox, IComboBoxOption, SearchBox, DefaultButton, PrimaryButton, IDropdownOption, Dropdown} from '@fluentui/react';
import { Dialog, DialogType, DialogFooter } from '@fluentui/react';
import { AppState } from '../../stores/appstate';
import AppCard from '../appcard';
import { observable } from 'mobx';
import BackLink from '../navigation/backlink';

@observer
class DataUpload extends React.Component<RouteComponentProps> {
  @observable hideDialog = true;

  private newconnClick() {
    this.hideDialog = false;
  }

  private cancelClick() {
    this.hideDialog = true;
  }

  public render() {

    const dialogContentProps = {
      type: DialogType.normal,
      title: 'Create new connection'
    };

    const modelProps = {
      isBlocking: false,
      containerClassName: 'minw540 br7'
    };

    const moduleOptions: IDropdownOption[] = [
      { key: 'traceability', text: 'Traceability' },
      { key: 'sustainability', text: 'Sustainability' },
      { key: 'production', text: 'Production' }
    ];

    const connectorOptions: IDropdownOption[] = [
      { key: 'connectorVal1', text: 'Daimler connector' },
      { key: 'connectorVal2', text: 'BMW connector' }
    ];

    const datausageOptions: IDropdownOption[] = [
      { key: 'provideaccess', text: 'Provide Access' },
      { key: 'prohibitaccess', text: 'Prohibit Access' },
      { key: 'usageinterval', text: 'Usage during Interval' },
      { key: 'duration', text: 'Duration Usage' }
    ];

    const comboboxOptions: IComboBoxOption[] = [
      { key: 'A', text: 'CO2 Fußabdruck' },
      { key: 'B', text: 'Kreislaufwirtschaft' },
      { key: 'C', text: 'TERRA:track' }
    ];

    return (
      <div className='w100pc h100pc df fdc'>
        <Header href={window.location.href} hidePivot appTitle='Data Upload Appplication' />
        <div className='h1 bgde w100pc' />
        <SearchBox className='ml250 bcwhite' placeholder='Search' underlined={true} />
        <div className='bgf5 df fdc flex1'>
          <div className='ml250 mt20 mr50 mb30 w100-200 df fdc'>
            <BackLink history={this.props.history}/>
            <div className='df aic w100-100'>
              <span className='bold fs14 ml10'>My connected apps</span>
              <div className='flex1' />
              {AppState.state.isAdmin && <ActionButton className='fglgreen fs14 bold mr5' iconProps={{ iconName: 'Add', className: 'fglgreen' }} text='CREATE NEW CONNECTION'
                onClick={() => this.newconnClick()} />}
            </div>
            <Dialog hidden={this.hideDialog} dialogContentProps={dialogContentProps} modalProps={modelProps}>
              <Dropdown className='w100pc mb10' placeholder='Choose connector' options={connectorOptions} required />
              <Dropdown className='w100pc mb10' placeholder='Choose module' options={moduleOptions} required />
              <ComboBox className='w100pc mb10' dropdownWidth={490} placeholder='Choose application' multiSelect options={comboboxOptions} autoComplete='on' required />
              <Dropdown className='w100pc mb10' placeholder='Select data usage policy' options={datausageOptions} required />
              <DialogFooter>
                <DefaultButton onClick={() => this.cancelClick()} text='Cancel' />
                <PrimaryButton className='br4' text='CREATE CONNECTION' onClick={() => this.cancelClick()} />
              </DialogFooter>
            </Dialog>

            <div className='w100-100'>
              <div className='ovx h250 df'>
                {AppState.state.connectedApps.map((a, index) => <AppCard key={index} app={a} buttonText='UPLOAD' hideUsage hideRating />)}
              </div>
            </div>
          </div>
          <div className='df ml250 mt10 mb50 aic'>
            <Icon className='fgblack fs14 bold mr5' iconName='Forward' />
            <span className='fs14'>Find more apps in the</span>
            <Link className='fglgreen fs14 bold mr5 tdn ml5' to='/home/appstore'>APP STORE</Link>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(DataUpload);
