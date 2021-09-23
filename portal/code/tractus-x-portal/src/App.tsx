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
import { initializeIcons, loadTheme } from '@fluentui/react';
import { createBrowserHistory } from 'history';
import { observer } from 'mobx-react';
import { Redirect, Route, Router, Switch } from 'react-router-dom';
import './styles/App.css';
import Home from './components/home';
import DataUpload from './components/apps/dataupload';
import DataUpload2 from './components/apps/dataupload2';
import Registration from './components/registration/register';
import VerifyCompany from './components/registration/verifycompany';
import { withAdalLoginApi } from './helpers/adalConfig';
import Loading from './components/loading';
import { AppState } from './stores/appstate';

const history = createBrowserHistory();

@observer
export default class App extends React.Component {
  private static first = true;
  constructor(props: any) {
    super(props);
    if (App.first) {
      initializeIcons();
      loadTheme({ palette: { themePrimary: '#BAC938', themeDarkAlt: '#E6AA1E' } })
    }

    AppState.state = new AppState();

    App.first = false;
  }

  public render() {
    const ProtectedHome = withAdalLoginApi(Home, () => <Loading/>, () => <div>Application timeout. Please refresh your browser (F5)</div>);
    const ProtectedUpload1 = withAdalLoginApi(DataUpload, () => <Loading/>, () => <div>Application timeout. Please refresh your browser (F5)</div>);
    const ProtectedUpload2 = withAdalLoginApi(DataUpload2, () => <Loading/>, () => <div>Application timeout. Please refresh your browser (F5)</div>);
    return (
      <Router history={history}>
        <Switch>
          <Redirect path='/' exact to='/home/dashboard' />
          <Route path='/home' render={(props) => <ProtectedHome/>} />
          <Route path='/registration' component={(props) => <Registration {...props}/>} />
          <Route path='/register' component={(props) => <Registration {...props}/>} />
          <Route path='/verifyoneid' component={(props) => <VerifyCompany {...props}/>} />
          <Route path='/dataupload' render={()=><ProtectedUpload1/>} />
          <Route path='/dataupload2' render={()=><ProtectedUpload2/>} />
        </Switch>
      </Router>
    );
  }
}
