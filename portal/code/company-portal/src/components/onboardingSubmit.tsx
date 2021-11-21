// Copyright (c) 2021 Microsoft
//
// Licensed under the Apache License, Version 2.0 (the 'License');
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an 'AS IS' BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as React from 'react';
import { observer } from 'mobx-react';
import { PrimaryButton } from '@fluentui/react';
import UserService from '../helpers/UserService';
import { toast } from 'react-toastify';
import { observable } from 'mobx';
import AlertDialog from './alertdialog';

@observer
export default class OnboardingSubmit extends React.Component {

    @observable alertRef

    private onSubmitClick(){
        var realm = UserService.realm;
        const token = UserService.getToken();
        var u = `https://catenax-dev003-app-onboarding-service.azurewebsites.net/api/onboarding/company/${realm}/finishOnboarding`;
      
        fetch(u, { method: 'PUT', headers: { 'Authorization': `Bearer ${token}`, 'Content-Type': 'application/json' } })
          .then((response) => {
            if (response.ok) {
              toast.success('Data Saved');
              this.alertRef?.show(false); 
            }
            else throw Error();
          }
    
          ).catch((error) => {
            toast.error('Unable to save data');
            this.alertRef?.show(false); 
          });
        }
    
        cancelClick() { 
          this.alertRef?.show(false); 
        }
      

        onButtonClick() {
            console.log( this.alertRef);
            this.alertRef?.show(true, 'Information', 'By clicking on submit, the onboarding process will get finished. You will receive an invite email with the respective user data, as soon as the onboarding is confirmend by Catena-X Cancel');
          }
 
  public render() {
    return (
        <div className='pb8 mt50 p24 pb20 brbt df fdc fdrr'>
                   <PrimaryButton text='SAVE' onClick={()=>this.onButtonClick()}/>
                   <AlertDialog message='By clicking on submit, the onboarding process will get finished. You will receive an invite email with the respective user data, as soon as the onboarding is confirmend by Catena-X' ref={(ref)=>this.alertRef = ref} button1Text='SUBMIT' button1Action={()=>this.onSubmitClick()} button2Text='CANCEL' button2Action={()=>this.cancelClick()} />
                </div>
                
    )} 
}