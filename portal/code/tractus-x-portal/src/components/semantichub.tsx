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
        urn: 'urn:bamm:com.catenaX:0.0.1#TRACTUSXPoC',
        description: 'This is the BAMM Aspect Model for the data as used in the TRACTUS-X PoC.',
        version: '0.0.1'
      },
      {
        name: 'Gearbox Adhesives',
        urn: 'urn:bamm:com.catenaX:0.0.1#GearboxAdhesives',
        description: 'A number classifying a batch of produced materials',
        version: '0.0.1'
      },
      {
        name: 'OneID BusinessPartner',
        urn: 'urn:bamm:com.catenaX:0.0.1#OneIDBusinessPartner',
        description: '-',
        version: '0.0.1'
      },
    ]
    return (
      <div className='w100pc h100pc df fwrap p44'>
        {staticModelData.map((data, index) => (
          <div key={index} className='m5 p20 bgpanel br4 bsdatacatalog cpointer'>
            <span className="m0">Name:</span>
            <h3 className='fs18 bold pb8 m0'>{data.name}</h3>
            <p className="m0">URN:</p>
            <p className='fs16 m0 pb8 lh20'>{data.urn}</p>
            <p className="m0">Description:</p>
            <p className='fs16 m0 pb8 lh20'>{data.description}</p>
            <p className="m0">Version:</p>
            <p className='fs16 m0 lh20'>{data.version}</p>
          </div>
        ))}
      </div>
    );
  }
}
