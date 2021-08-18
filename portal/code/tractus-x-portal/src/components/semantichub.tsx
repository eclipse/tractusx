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

@observer
export default class SemanticHub extends React.Component {

  public render() {
    const staticModelData: any[] = [
      {
        name: 'TRACTUSXPoC',
        URN: 'urn:bamm:com.catenaX:0.0.1#TRACTUSXPoC',
        description: 'This is the BAMM Aspect Model for the data as used in the TRACTUS-X PoC.',
        version: '0.0.1'
      },
      {
        name: 'Gearbox Adhesives',
        URN: 'urn:bamm:com.catenaX:0.0.1#GearboxAdhesives',
        description: 'A number classifying a batch of produced materials',
        version: '0.0.1'
      },
      {
        name: 'OneID BusinessPartner',
        URN: 'urn:bamm:com.catenaX:0.0.1#OneIDBusinessPartner',
        description: '-',
        version: '0.0.1'
      },
      
    ]
    return (
      <div className='w100pc h100pc df fdc'>
        <div className='mt50 df fdc'>
          {staticModelData.map((data, index) => (
            <div key={index} className='ml50 mt10 bgpanel w100-100 df fdc br4 bsdatacatalog'>
              <div className='df aic mt20'>
                <span className='fs24 bold fg191 pl20'>{data.name}</span>
              </div>
              <span className='fs14 fg191 pl20 pt8 lh20 mr70'>{data.description}</span>
            </div>
          ))}
        </div>
      </div>
    );
  }
}
