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
    return (
      <div className='w100pc h100pc df fdc'>
        <div className='ml50 mr50 mt50 bgfe w100-100 df fdc'>
          <div className='df fdc aic'>
            <img className='mt100' src='/comingsoon.png' width='570' height='270' alt='Coming Soon' />
            <span className='fs18 mt40 mb50 w570'>The Vocabulary hub will be a central service that stores the CX ontology and meta data models and
              enable collaboration. Collaboration includes search, selection, matching, updating, requests for changes, version management,
              deletion, duplicate identification, and unused vocabularies.</span>
          </div>
        </div>
      </div>
    );
  }
}
