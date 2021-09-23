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

import { AdalConfig, adalGetToken, AuthenticationContext, withAdalLogin } from 'react-adal';

// Endpoint URL
export const endpoint = process.env.REACT_APP_PORTAL_URL;

export function getReplyUrl() {
  const url = new URL(window.location.href);
  let protocol = url.protocol;
  if (url.host.indexOf('localhost') < 0) {
    protocol = 'https:';
  }
  const ret = protocol + '//' + url.host + '/';
  return ret;
}

// App Registration ID bb01c83a-f70e-44d9-a0ac-f6b3b70c1775
const appId = process.env.REACT_APP_APPLICATION_ID;
export const adalConfig: AdalConfig = {
  cacheLocation: 'localStorage',
  clientId: appId,
  endpoints: {
    api: endpoint
  },
  redirectUri: getReplyUrl(),
  // popUp: true,
  postLogoutRedirectUri: window.location.origin,
  tenant: process.env.REACT_APP_DEFAULT_TENANT_ID
};

const ctx: any = new AuthenticationContext(adalConfig);

export const withAdalLoginApi = withAdalLogin(ctx, adalConfig.clientId);

class AdalContext {
  private readonly authContext: AuthenticationContext;
  private readonly isAdmin: boolean = false;
  constructor() {
    this.authContext = ctx;
  }

  get AuthContext() {
    return this.authContext;
  }

  get IsAdmin() {
    return this.isAdmin;
  }

  public acquireToken(resource?: string): Promise<string> {
    resource = resource || appId;
    const promise = new Promise<string>((resolve, reject) => {
      const tok = this.AuthContext.getCachedToken(resource);
      if (tok) {
        resolve(tok);
        return;
      }

      const user = this.AuthContext.getCachedUser();
      if (user) {
        this.authContext.config.extraQueryParameter = 'login_hint=' + (user.profile.upn || user.userName);
      }
  
      adalGetToken(this.authContext, resource).then((token) => {
        resolve(token);
      }, (error) => {
        if (error) {
          console.log(error);
          if (error.msg === 'login_required' || error.msg === 'interaction_required') {
            this.authContext.login();
          } else {
            // AlertDialog.(error.message);
          }
        }
      });
    });
  
    return promise;
  }
  
  public getToken(): Promise<string | null> {
    return adalGetToken(this.authContext, endpoint);
  }

  public getCachedToken(resource?: string): string {
    return this.authContext.getCachedToken(resource || this.authContext.config.clientId);
  }

  public getGroups() {
    const promise = new Promise<any>((resolve, reject) => {
      adalContext.acquireToken('https://graph.microsoft.com').then((token) => {
        const u = 'https://graph.microsoft.com/v1.0/me/getMemberGroups';
        fetch(u, {
          method: 'POST', body: JSON.stringify({ 'securityEnabledOnly': false }),
          headers: { 'Authorization': `Bearer ${token}`, 'Content-Type': 'application/json' }
        }).then((val) => val.json().then((json) => resolve(json)));
      }).catch((error) => {
        console.log(error.message);
        reject(error.message);
      })
    });
  
    return promise;
  }
  
  public getFullName(): string {
    let name = '';
    const user = this.authContext.getCachedUser();
    if (user) {
      name = user.profile?.name || user.userName;
    }

    const n = name.indexOf('(');
    if (n >= 0) {
      name = name.substring(0, n).trim();
    }

    return name;
  }

  public getInitials(username: string): string {
    let initials = 'XX';
    if (username.indexOf('@') < 0) {
      const parts = username.split(' ');
      initials = parts[0].substr(0, 1);
      if (parts.length > 1) {
        initials += parts[1].substr(0, 1);
      }
    } else {
      const parts = username.split('@');
      if (parts.length > 0) {
        initials = parts[0].substr(0, 1);
        const words = parts[0].split(/[^a-zA-Z]/);
        if (words.length > 1) {
          initials += words[1].substr(0, 1);
        } else {
          for (let i = 1; i < parts[0].length; i++) {
            const ch = parts[0].substr(i, 1);
            if ('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.indexOf(ch) > 0) {
              initials += ch;
              break;
            }
          }
        }

        if (initials.length < 2 && parts[0].length > 1) {
          initials = parts[0].substr(0, 2);
        }
      }
    }

    return initials.toUpperCase();
  }

  public getDomain(username: string) {
    let domain = '';
    if (username) {
      const parts = username.split('@');
      const u = parts[0].toLowerCase();
      if (u === 'gris' || u === 'bosch' || u === 'zf' || u === 'basf') {
        domain = parts[0];
      } else if (u.includes('_microsoft')) {
        domain = 'Microsoft';
      } else if (u.includes('bilstein')) {
        domain = 'Bilstein';
      } else if (u.includes('tier1')) {
        domain = 'Tier1';
      } else if (parts.length > 1) {
        domain = parts[1];
        const p = domain.split('.');
        if (p.length >= 1) {
          domain = p[0];
          if ((domain === 'partner' || domain === 'de') && p.length > 1) {
            domain = p[1];
          }
        }
      }

      if (domain.length > 0) {
        domain = domain.substring(0, 1).toUpperCase() + domain.substr(1);
      }

      if (domain.length < 4) {
        domain = domain.toUpperCase();
      }

      if (domain === 'Bmwgroup') {
        domain = 'BMW';
      }
    }

    return domain;
  }

  public getUsername(): string {
    let username = '';
    const user = this.authContext.getCachedUser();
    if (user) {
      username = user.userName;
    }

    return username;
  }

  public logOut() {
    this.authContext.logOut();
  }
}

const adalContext: AdalContext = new AdalContext();
export default adalContext;
