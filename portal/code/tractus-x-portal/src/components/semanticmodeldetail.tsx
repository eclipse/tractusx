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

import { useState } from "react";
import BackLink from "./navigation/backlink";
import DescriptionList from "./lists/descriptionlist";
import { Icon } from "@fluentui/react";

const properties = [
  { name: 'Individual Data',
    type: 'urn:bamm:com.catenaX:0.0.1#IndividualDataEntity',
    optional: false,
    in_payload: true,
    key_runtime: 'individualData',
    base_type: 'IndividualDataCharacteristic',
    children: [
      { name: 'productionCountryCode',
        description: 'Country code of production',
        type: 'http://www.w3.org/2001/XMLSchema#string',
        example: 'Optional[HUR]',
        optional: false,
        in_payload: true,
        key_runtime: 'productionCountryCode',
        base_type: 'CountryCodeCharacteristic'
      },
      { name: 'Production Date (GMT)',
        description: 'Production date without timestamp',
        type: 'http://www.w3.org/2001/XMLSchema#date',
        example: 'Optional[2021-05-30]',
        optional: false,
        in_payload: true,
        key_runtime: 'productionDateGMT',
        base_type: 'Date (without timestamp)'
      }
    ]
  },
  { name: 'Part Tree',
    type: 'urn:bamm:com.catenaX:0.0.1#PartTreeEntity',
    optional: false,
    in_payload: true,
    key_runtime: 'partTree',
    base_type: 'PartTreeCharacteristic',
    children: [
      { name: 'is Parent of',
        description: 'Set of Parts, identified by ID',
        type: 'http://www.w3.org/2001/XMLSchema#string',
        optional: false,
        in_payload: true,
        key_runtime: 'isParentOf',
        base_type: 'IsParentOfCharacteristic',
        order: false,
        duplicates_allowed: false,
        urn: 'http://www.w3.org/2001/XMLSchema#string'
      }
    ]
  }
]


const SemanticModelDetail = (props) => {
  const [category, setCategory] = useState<any | null>(undefined);

  return(
    <div className='df fdc p44'>
      <div className="df jcsb w100pc">
        <BackLink history={props.history} />
        <a className='fgblack fs15 fw600 tdn df mt10 mb20 aic cpointer' href={props.location.state.download} download>
          <Icon className='fgblack fs20 mt2 mr7' iconName='Installation' />
          Download TTL
        </a>
      </div>
      <h1 className="pb20 fs42">{props.location.state.name}</h1>
      <p className="mb30 fs20" >{props.location.state.description}</p>
      <img src={props.location.state.img} className="w100pc mb30"></img>
      <h2 className="fs32 pb20">Properties</h2>
      <ul className="mb30">
        {properties.map((prop, index) => (
          <li className="fs18 cpointer">
            <span className="tduhover" onClick={() => setCategory(properties[index])}>{prop.name}</span>
            {prop.children &&
              <ul>{
                prop.children.map((child, index2) =>(
                  <li onClick={() => setCategory(properties[index].children[index2])}
                      className="fs16 tduhover cpointer">
                      {child.name}
                  </li>
                ))
              }</ul>
            }
          </li>
        ))}
      </ul>
      {category && <div className="mb30 p20 bgpanel br4 bsdatacatalog">
          <h3 className="pb20 fs24">{category.name}</h3>
          {category.description && <p className="pb20 fs18">{category.description}</p>}
          <DescriptionList title="Type" description={category.type} />
          <DescriptionList title="Optional" description={category.optional ? 'true': 'false'} />
          {category.example && <DescriptionList title="Example" description={category.example} />}
          <DescriptionList title="In Payload" description={category.in_payload ? 'true': 'false'} />
          <DescriptionList title="Key runtime" description={category.key_runtime} />
          <DescriptionList title="Base Type" description={category.base_type} />
        </div>}
    </div>
  );
}

export default SemanticModelDetail;
