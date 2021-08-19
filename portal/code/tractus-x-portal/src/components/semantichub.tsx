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

  private getIcon(data:any) {
      return <span className='mt10 mr20'>
        <svg
   version="1.1"
   x="0px"
   y="0px"
   width="20px"
   height="20px"
   viewBox="0 0 32 32"
   enable-background="new 0 0 32 32"
   id="svg2"><g
     id="background"><rect
       fill="none"
       width="32"
       height="32"
       id="rect6" /></g><path
     id="path9"
     d="M 26.997,20.09 V 11.91 C 29.834,11.435 32,8.973 32,6 32,2.687 29.312,0 26,0 c -3.316,0 -6,2.687 -6,6 0,0.609 0.092,1.196 0.261,1.75 l -9.423,4.711 C 9.747,10.972 7.989,10 6,10 c -3.314,0 -6,2.687 -6,6 0,3.312 2.686,6 6,6 1.99,0 3.748,-0.973 4.839,-2.464 l 9.423,4.712 C 20.092,24.803 20,25.391 20,26 c 0,3.312 2.684,6 6,6 3.312,0 6,-2.688 6,-6 0,-2.972 -2.166,-5.435 -5.003,-5.91 z M 11.739,17.751 C 11.908,17.197 12,16.609 12,16 12,15.39 11.908,14.801 11.738,14.247 l 9.422,-4.71 c 0.903,1.235 2.266,2.109 3.839,2.374 v 8.18 c -1.573,0.265 -2.934,1.139 -3.838,2.372 l -9.422,-4.712 z" />
     </svg>
      </span>
  }

  public render() {
    const staticModelData: any[] = [
      {
        name: 'Catena-X Traceability Aspect',
        URN: 'urn:bamm:com.catenaX:0.0.1#TRACTUSXPoC',
        description: 'This is the BAMM Aspect Model for the data as used in the Traceability part of TRACTUS-X PoC.',
        show: '/semantics/traceability_en.html',
        download: '/semantics/traceability.ttl',
        version: '0.0.1',
        public: false,
        vocabulary: 'BAMM'
      },
      {
        name: 'Catena-X Circular Economy Aspect',
        URN: 'urn:bamm:com.catenaX:0.0.1#GearboxAdhesives',
        description: 'Example gearbox modelling of the circular economy aspect/requirements.',
        download: '/semantics/circular_economy.ttl',
        show: '/semantics/circular_economy_en.html',
        version: '0.0.1',
        public: true,
        vocabulary: 'BAMM'
      },
      {
        name: 'Catena-X GPDM Aspect',
        URN: 'urn:bamm:com.catenaX:0.0.1#OneIDBusinessPartner',
        description: '-',
        download: '/semantics/gdpm.ttl',
        show: '/semantics/gdpm_en.html',
        version: '0.0.1',
        public: true,
        vocabulary: 'BAMM'
      },
      {
        name: 'International Data Spaces Vocabulary',
        URN: 'https://w3id.org/idsa',
        description: 'Official W3C specification',
        download: 'https://international-data-spaces-association.github.io/InformationModel/docs/4.1.0/serializations/ontology.ttl',
        show: 'https://international-data-spaces-association.github.io/InformationModel/docs/index.html',
        version: '4.1.0',
        public: true,
        vocabulary: 'OWL'
      }
      
    ]
    return (
      <div className='w100pc h100pc df fdc'>
        <div className='mt50 df fdc'>
          {staticModelData.map((data, index) => (
            <div key={index} className='ml50 mt10 bgpanel w100-100 df fdc br4 bsdatacatalog'>
              <div className='df aic mt20'>
                <span className='fs24 bold fg191 pl20'><a href={data.show}>{data.name}</a></span><span>&nbsp;(<a href={data.download}>Download</a>)</span>
                <div className='flex1'/>
                {this.getIcon(data)}
              </div>
              <span className='fs14 fg191 pl20 pt8 lh20 mr70'>{data.description}</span>
              <div className='mt20 mb30'>
                  <span className='fs14 fg5a pl20 pt28 fggrey lh16'>Namespace</span>
                  <span className='fs14 fg5a pl50 pt28 fg5a mr30'>{data.URN}</span>
                  <br />
                  <span className='fs14 fg5a pl20 pt28 fggrey lh16'>Model Version</span>
                  <span className='fs14 fg5a pl29 pt28 fg5a mr30'>{data.version}</span>
                  <br />
                  <span className='fs14 fg5a pl20 pt28 fggrey lh16'>Bas Vocabulary</span>
                  <span className='fs14 fg5a pl29 pt28 fg5a mr30'>{data.vocabulary}</span>
                  <br />
                  <span className='fs14 fg5a pl20 pt28 fggrey lh16'>Public Available</span>
                  <span className='fs14 fg5a pl29 pt28 fg5a mr30'>{data.public ? 'true' : 'false'}</span>
                </div>

            </div>
          ))}
        </div>
      </div>
    );
  }
}
