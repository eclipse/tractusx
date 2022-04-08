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

import UserService from "../../helpers/UserService";

// limitations under the License.
const TWIN_URL = `${process.env.REACT_APP_SEMANTIC_SERVICE_LAYER_URL}twin-registry/registry/shell-descriptors`;

function handleRequest(res: Response){
  if(res.status >= 400) {
    throw new Error(`${res.statusText}: Server responds with ${res.status} error!`);
  }
  return res.json();
}

export function getTwins(params = {}){
  const requestOptions = {
    method: 'GET',
    headers: new Headers({"Content-Type": "application/json", "Authorization": `Bearer ${UserService.getToken()}`})
  }
  return fetch(`${TWIN_URL}?${params}`, requestOptions)
    .then(handleRequest);
}

export function getTwinById(id: string){
  const requestOptions = {
    method: 'GET',
    headers: new Headers({"Content-Type": "application/json", "Authorization": `Bearer ${UserService.getToken()}`})
  }
  return fetch(`${TWIN_URL}/${id}`, requestOptions)
    .then(handleRequest);
}
