// Copyright (c) 2021 T-Systems
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
import { Link } from 'react-router-dom';
import { Dropdown, IDropdownOption, IDropdownStyles, SearchBox } from '@fluentui/react';
import { observable } from 'mobx';

const staticData = [
  {
    id: 1,
    name: 'Catena-X Traceability Aspect',
    URN: 'urn:bamm:com.catenaX:0.0.1#TRACTUSXPoC',
    description: 'This is the BAMM Aspect Model for the data as used in the Traceability part of TRACTUS-X PoC.',
    img: '/semantics/traceability_en.png',
    download: '/semantics/traceability.ttl',
    version: '0.0.1',
    public: false,
    vocabulary: 'BAMM'
  },
  {
    id: 2,
    name: 'Catena-X Circular Economy Aspect',
    URN: 'urn:bamm:com.catenaX:0.0.1#GearboxAdhesives',
    description: 'Example gearbox modelling of the circular economy aspect/requirements.',
    download: '/semantics/circular_economy.ttl',
    img: '/semantics/circular_economy_en.png',
    version: '0.0.1',
    public: true,
    vocabulary: 'BAMM'
  },
  {
    id: 3,
    name: 'Catena-X GPDM Aspect',
    URN: 'urn:bamm:com.catenaX:0.0.1#OneIDBusinessPartner',
    description: '-',
    download: '/semantics/gdpm.ttl',
    img: '/semantics/gdpm_en.png',
    version: '0.0.1',
    public: true,
    vocabulary: 'BAMM'
  },
  { 
    id: 4,
    name: 'International Data Spaces Vocabulary',
    URN: 'https://w3id.org/idsa',
    description: 'Official W3C specification',
    download: 'https://international-data-spaces-association.github.io/InformationModel/docs/4.1.0/serializations/ontology.ttl',
    img: '/semantics/dataspace.svg',
    version: '4.1.0',
    public: true,
    vocabulary: 'OWL'
  }
]

@observer
export default class SemanticHub extends React.Component<any, any>{
  @observable public static searchInput = '';
  @observable public static modelData: any[] = staticData;
  
  constructor(props) {
    super(props);
    this.state = { models: staticData };

    this.onSearchClear = this.onSearchClear.bind(this);
    this.onInputSearch = this.onInputSearch.bind(this);
    this.onVocabDropdownChange = this.onVocabDropdownChange.bind(this);
    this.onPublicDropdownChange = this.onPublicDropdownChange.bind(this);
  }

  private getIcon(data:any) {
    return <span className='pt5'><svg version="1.1" x="0px" y="0px" width="20px" height="20px" viewBox="0 0 32 32" enableBackground="new 0 0 32 32" id="svg2"><g id="background"><rect fill="none" width="32" height="32" id="rect6" /></g><path id="path9"
      d="M 26.997,20.09 V 11.91 C 29.834,11.435 32,8.973 32,6 32,2.687 29.312,0 26,0 c -3.316,0 -6,2.687 -6,6 0,0.609 0.092,1.196 0.261,1.75 l -9.423,4.711 C 9.747,10.972 7.989,10 6,10 c -3.314,0 -6,2.687 -6,6 0,3.312 2.686,6 6,6 1.99,0 3.748,-0.973 4.839,-2.464 l 9.423,4.712 C 20.092,24.803 20,25.391 20,26 c 0,3.312 2.684,6 6,6 3.312,0 6,-2.688 6,-6 0,-2.972 -2.166,-5.435 -5.003,-5.91 z M 11.739,17.751 C 11.908,17.197 12,16.609 12,16 12,15.39 11.908,14.801 11.738,14.247 l 9.422,-4.71 c 0.903,1.235 2.266,2.109 3.839,2.374 v 8.18 c -1.573,0.265 -2.934,1.139 -3.838,2.372 l -9.422,-4.712 z" />
      </svg>
    </span>
  }

  onSearchClear(){
    this.setState({models: staticData});
  }

  onInputSearch(input){
    const searchedItems = staticData.filter(item => {
      input = input.toLowerCase();
      const descriptionContain = item.description.toLowerCase().includes(input);
      const nameContain = item.name.toLowerCase().includes(input);
      return descriptionContain || nameContain;
    });
    this.setState({models: searchedItems});
  }
  onVocabDropdownChange(ev, option){
    const filteredItems = staticData.filter(item => 
      item.vocabulary.toLowerCase() === option.text.toLowerCase());
    this.setState({models: filteredItems});
  }

  onPublicDropdownChange(ev, option){
    const convertedInput = option.key === 1;
    const filteredItems = staticData.filter(item => item.public === convertedInput);
    this.setState({models: filteredItems});
  }

  public render() {
    const dropdownStyles: Partial<IDropdownStyles> = {
      dropdown: { width: 150, marginRight: 20 },
    };
    const availableOptions: IDropdownOption[] = [
      { key: 1, text: 'Available' },
      { key: 0, text: 'Not available' }
    ];
    const vocabOptions: IDropdownOption[] = [
      { key: 'bamm', text: 'BAMM' },
      { key: 'owl', text: 'OWL' }
    ];
    return (
      <div className='p44'>
        <div className="df aife jcfe mb20">
          <Dropdown placeholder="Filter"
            label="Bas Vocabulary"
            options={vocabOptions}
            styles={dropdownStyles}
            onChange={this.onVocabDropdownChange}
          />
          <Dropdown placeholder="Filter"
            label="Public Available"
            options={availableOptions}
            styles={dropdownStyles}
            onChange={this.onPublicDropdownChange}
          />
          <SearchBox className="w300" placeholder="Filter name or description" onSearch={this.onInputSearch} onClear={this.onSearchClear}/>
        </div>
        <div className="df fwrap">
          {this.state.models.map((data, index) => (
            <div key={index} className='m5 p20 bgpanel flex40 br4 bsdatacatalog'>
              <div className='df aifs mb15'>
                <div className="df aib">
                  <Link className="mr20 tdn" to={{
                      pathname: `/home/semanticmodel/${data.id}`,
                      state: data
                  }}>
                    <span className='fs24 bold fg191'>{data.name}</span>
                  </Link>
                </div>
                <div className='flex1'/>
                {this.getIcon(data)}
              </div>
              <span className='fs14 pt8'>{data.description}</span>
              <div className='mt20 mb30'>
                <span className='dib minw150 fs14 fggrey'>Namespace</span>
                <span className='fs14 fg5a'>{data.URN}</span>
                <br />
                <span className='dib minw150 fs14 fggrey'>Model Version</span>
                <span className='fs14 fg5a'>{data.version}</span>
                <br />
                <span className='dib minw150 fs14 fggrey'>Bas Vocabulary</span>
                <span className='fs14 fg5a'>{data.vocabulary}</span>
                <br />
                <span className='dib minw150 fs14 fggrey'>Public Available</span>
                <span className='fs14 fg5a'>{data.public ? 'true' : 'false'}</span>
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  }
}
