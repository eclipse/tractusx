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

import ReactDOM from 'react-dom';
import './styles/reset.css';
import './styles/index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { runWithAdal } from 'react-adal';
import adalContext from './helpers/adalConfig';
import { BrowserRouter } from 'react-router-dom';

const DO_NOT_LOGIN = true;

runWithAdal(
  adalContext.AuthContext,
  () => {
    const rootDiv = document.getElementById('root') as HTMLElement;
    ReactDOM.render(<BrowserRouter><App /></BrowserRouter>, rootDiv);
  },
  DO_NOT_LOGIN
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
