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

const SemanticModelDetail = (props) => {
  console.log(props.location.state.name)
  return(
    <div className='w100pc h100pc df fdc p44'>
      <h1 className="m0 pb20">{props.location.state.name}</h1>
      <iframe height="100%" title={props.location.state.name} src={props.location.state.show}></iframe>
    </div>
  );
}

export default SemanticModelDetail;
