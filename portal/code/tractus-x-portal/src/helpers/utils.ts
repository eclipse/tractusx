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

import { OrganizationalDetails } from '../data/organizationdetails';
import adalContext from './adalConfig';

export function readTextFile(file: File): Promise<string> {
  const promise = new Promise<string>((resolve, reject) => {
    const reader = new FileReader();
    reader.onload = (f: any) => {
      if (f.currentTarget && f.currentTarget.readyState === 2) {
        const buf = Buffer.from(f.currentTarget.result, 'binary');
        const contents = buf.toString();
        resolve(contents);
      }
    }
    reader.readAsArrayBuffer(file);
  });

  return promise;
}

export function getOneIDDetails(oneId: String): Promise<OrganizationalDetails> {
  const auth = process.env.REACT_APP_BASIC_SERVICES_AUTHENTICATION;
  const url = process.env.REACT_APP_BUSINESSPARTNER_SERVICE_URL;
  const u = `${url}?businessPartnerOneId=${oneId}`;
  let myResponseData: OrganizationalDetails;
  const promise = new Promise<OrganizationalDetails>((resolve, reject) => {
    fetch(u, { method: 'GET', headers: { 'Authorization': `Basic ${auth}` } })
      .then((response) => response.json().then((json) => {
        myResponseData = new OrganizationalDetails();
        Object.assign(myResponseData, json);
        if (response.ok) {
          resolve(myResponseData);
        } else {
          resolve(null);
        }
      }).catch((error) => {
        alert(error);
        console.log(error, error.message, error.status);
        reject(error.message);
      })
      );
  });

  return promise;
}

export function convertDate(str: String): string {
  let dt = new Date();
  try {
    str = str || '9999-09-01T00:00:00.004Z';
    dt = new Date(str.toString());
  } catch (error) {
    alert(error);
    console.log(error);
  }
  return dt.toDateString();
}

export function Random(limit: number): number {
  return Math.floor(Math.random() * limit);
}

export function randomNumber(max: number, min: number): number {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

export function percentageOf(n: number): number {
  return Math.floor(n * 100);
}

export const formatMB = (value: number) => {
  value = value || 0;
  let text;
  if (value >= 1000000000000) {
    text = format(Math.round(value / 10000000000) / 100) + ' TB';
  }
  else if (value >= 1000000000) {
    text = format(Math.round(value / 10000000) / 100) + ' GB';
  }
  else if (value >= 1000000) {
    text = format(Math.round(value / 10000) / 100) + ' MB';
  }
  else if (value >= 1000) {
    text = format(Math.round(value / 10) / 100) + ' KB';
  }
  else {
    text = format(Math.round(value * 100) / 100) + ' bytes';
  }
  return text;
};

export function format(n: number) {
  if (n !== undefined && n !== null) {
    return n.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,');
  }
  else {
    return '';
  }
}

export function sleep(ms: number) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

export function UUID(): string {
  const nbr = Math.random();
  let randStr = '';
  do {
    randStr += (nbr).toString(16).substr(2);
  } while (randStr.length < 30);

  // tslint:disable-next-line: no-bitwise
  return [randStr.substr(0, 8), '-', randStr.substr(8, 4), '-4', randStr.substr(12, 3), '-', ((nbr * 4 | 0)
    + 8).toString(16), randStr.substr(15, 3), '-', randStr.substr(18, 12)].join('');
}

// Takes a data URI and returns the Data URI corresponding to the resized image at the wanted size.
export function resizedataURL(datas: string, wantedWidth: number, wantedHeight: number): Promise<string> {
  return new Promise<string>((resolve, reject) => {

    // We create an image to receive the Data URI
    const img = document.createElement('img');

    // When the event "onload" is triggered we can resize the image.
    // tslint:disable-next-line: only-arrow-functions
    img.onload = function () {
      const aspect = img.width / img.height;
      const wantedAspect = wantedWidth / wantedHeight;
      // We create a canvas and get its context.
      const canvas = document.createElement('canvas');
      const ctx = canvas.getContext('2d');

      // We set the dimensions at the wanted size.
      canvas.width = wantedWidth;
      canvas.height = wantedHeight;

      if (wantedAspect > aspect) {
        const scale = img.width / wantedWidth;
        const h = wantedHeight * scale;
        const b = (img.height - h) / 2;
        ctx.drawImage(img, 0, b, img.width, h, 0, 0, wantedWidth, wantedHeight);
      } else {
        const scale = img.height / wantedHeight;
        const w = wantedWidth * scale;
        const b = (img.width - w) / 2;
        ctx.drawImage(img, b, 0, w, img.height, 0, 0, wantedWidth, wantedHeight);
      }

      const dataURI = canvas.toDataURL();

      // This is the return of the Promise
      resolve(dataURI);
    };

    img.onerror = function () { reject('Invalid image') };

    // We put the Data URI in the image's src attribute
    img.src = datas;
  });
}

export function compare(a: any, b: any): number {
  if (a > b) {
    return 1;
  } else if (a === b) {
    return 0;
  } else {
    return -1;
  }
}

export function calculateLength(str: String): number {
  return str.length;
}

const map = [{ oneId: 'Partner_00001_BOSCH', company: 'Bosch', domain: 'Bosch' },
{ oneId: 'Partner_00002_BILSTEIN', company: 'Bilstein', domain: 'Bilstein' },
{ oneId: 'Partner_00003_GRIS', company: 'Gris', domain: 'Gris' },
{ oneId: 'Partner_00004_ZF', company: 'ZF Friedrichshafen AG', domain: 'ZF' },
{ oneId: 'Partner_00005_TIER1', company: 'TIER1', domain: 'Tier1' },
{ oneId: 'Partner_00006_Mercedes', company: 'Mercedes-Benz AG', domain: 'Daimler' },
{ oneId: 'Partner_00007_BMW', company: 'Bayerische Motoren Werke Aktiengesellschaft', domain: 'BMW' },
{ oneId: 'Partner_00008_BASF', company: 'BASF', domain: 'Basf' },
{ oneId: 'Partner_00009_MICROSOFT', company: 'Microsoft', domain: 'Microsoft' },
{ oneId: 'Partner_00010_TSY', company: 'T-Systems International GmbH', domain: 't-systems' },
{ oneId: 'Partner_ERROR_CP', company: 'ERROR CP', domain: 'Error' }
];

export function mapOneId(username: string) {
  const domain = adalContext.getDomain(username);
  const records = map.filter((m) => m.domain === domain);
  if (records.length === 1) {
    return records[0].oneId;
  }

  return 'Partner_ERROR_CP';
}