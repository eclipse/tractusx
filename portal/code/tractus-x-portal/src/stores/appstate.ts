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

import { observable } from 'mobx';
import { Application } from '../data/application';
import adalContext from '../helpers/adalConfig';

const A = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032a',
  title: 'Data Upload App', rating: 4.9, downloads: 577, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'OPEN',
  details: '',
  companyName: 'Catena-X', url:'/dataupload', background: ''
};

const B = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032b',
  title: 'PartChain', rating: 4.7, downloads: 183987, tags: ['FREE FOR USE', 'TRACKING', 'TRACEABILITY', 'CATENA-X'],
  screenshots: ['/PartChain4.png', '/PartChain2.png', '/PartChain3.png', '/PartChain1.png', '/PartChain5.png'],
  description: `<b>Seamless part traceability through the n-tier supply chain.</b><br />

  PartChain is an open-source software tool that allows you to track components in the n-tier supply chain. In addition to the unique relationship knowledge you get detailed information about the components of your direct suppliers as well as your direct customers. This lets you answer questions such as:<br />
  <br/>
  <li>What’s the exact lead time between the production of a subcomponent and your own components?</li>
  <li>To where in the world are my components distributed and where are my suppliers located?</li>
  <li>What’s the exact composition of my component on a unique ID level?</li>
  <br />Because all of that is important information, PartChain keeps a strong one-up one-down visibility rule. You and the other parties in the network always only see their direct suppliers and customers data as well as their own data. Your competitors won’t be able to get any sensitive information about your production data.<br />

  <br/><b>Recall management made easy</b><br />
  Because you and all other partners in the network now know the exact composition of the components that are produced, recall management is much simpler than before. No more tedious and messy emails, excel sheets and database dumps in case of a quality issue. You simply select the components that you need to recall, choose a quality alert criticality and distribute the information in the network. Of course, only your direct customers will be notified. In case you receive a quality alert, you can see at one glimpse, which of your parts could be affected by defective supplier parts and also immediately warn your own customers. All with one click.<br />

  <br/><b>Unlock the potential for dozens of new use cases</b><br />
  Recall management of course isn’t the only use case for PartChain. As soon as you have enough relationship about your supply chain, you can drastically simplify i.e.<br />
  <br/>
  <li>CO2 Emission handling</li>
  <li>Circular Economy</li>
  <li>Analysis of Quality Documents</li>
  <li>Customs processes</li>
  <li>Demand and Capacity Management</li>
  <li>and many more</li>
`,
  purchase: 'OPEN',
  details: '',
  companyName: 'Catena-X',
  usage: 'free for use', url: 'https://ui.zf.dev.catenax.partchain.dev/', background: ''
}

const M = {
  id : '0254dd4d-35af-43f5-a74c-7cc280840333',
  title: 'Digital Twin Aspect Debugger', rating: 3.2, downloads: 2, tags: ['FREE FOR USE', 'CONNECTOR', 'DEVELOPMENT', 'IDS', 'CATENA-X'],
  screenshots: ['/dataupload1.png'],
  description: '<b>Access and review semantically-annotated/transformed data from your business partners.</b><br/>A helper app in the form of a web-shell that allows to debug data access and structure conformant with the IDS/Catena-X standards.',
  usage: 'free for use',
  purchase: 'OPEN',
  details: '',
  companyName: 'Catena-X', url:'/home/aspect/urn:Vocabulary:com.ids:Connector?recipient=https://w3id.org/idsa/autogen/connectorEndpoint/a73d2202-cb77-41db-a3a6-05ed251c0b8a&offer=offer-windchill&representation=bom-aspect&artifact=bom-brake', background: ''
};

const C = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032c',
  title: 'CO2 Fußabdruck', rating: 3.8, downloads: 577, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Calculate your ECO Footprint</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'per month',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'T-System', url:'', background: ''
}

const D = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032d',
  title: 'Material Traceability', rating: 4.5, downloads: 577,
  tags: ['SUPPLY CHAIN ANALYTICS', 'SUPPLY CHAIN VISUALIZATION', 'PART TRACEABILITY', 'ALARMS', 'RECALLS', 'ROLE VIEWS', 'NETWORK VIEW', 'UPSTREAM VIEW', 'DOWNSTREAM VIEW'],
  screenshots: ['/material1.png'],
  description: `<b>Capabilities</b><br /><br />
  <li>Visualization of complex supply chains - connecting multiple business partners for inter-company collaboration and transparency</li>
<li>Role-Based Access for network participant - trust chain across an n-tiered value chain from raw material batch origin to finished product.</li>
<li>Streamlined Recalls - Initiate cross-company alerting for product issues</li>
<li>Tight integration with your logistics business - Linkage of data across suppliers is enabled by matching logistic events</li>
<br />
<b>Description</b><br />
Create an Intelligent Enterprise with Advanced Logistics Collaboration and Insights. SAP Logistics Business Network, material traceability option connects business partners for inter-company collaboration and transparency. It supports a comprehensive set of capabilities, allowing to manage freight more efficiently, benefit from situational awareness through track and trace, and create a trust chain for up- and downstream product genealogy.
`,
  usage: 'per year',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'SAP', url:'', background: ''
};

const E = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032e',
  title: 'Bedarfs-& kapazitätsmanagement', rating: 4.1, downloads: 577, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'demo',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'German Edge Cloud', url:'', background: ''
};

const F = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084032f',
  title: 'Kreislaufwirtschaft', rating: 4.7, downloads: 577, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'Catena-X', url:'', background: ''
};

const G = {
  id : '0253dd4d-35af-43f5-a84c-7cc28084033a',
  title: 'SAP Adaptor', rating: 4.8, downloads: 577, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'SAP', url:'', background: ''
};

const H = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840330',
  title: 'Siemens Adaptor', rating: 4.7, downloads: 877, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'Siemens', url:'', background: ''
};

const I = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840331',
  title: 'Data Quality Service', rating: 4.5, downloads: 877, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'T-Systems', url:'', background: ''
};

const J = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840332',
  title: 'GEC Adaptor', rating: 4.1, downloads: 377, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'German Edge Cloud', url:'', background: ''
};

const K = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840333',
  title: 'T-Systems Adpator', rating: 4.3, downloads: 543, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'T-Systems', url:'', background: ''
};

const L = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840334',
  title: 'Data Mapping Service', rating: 3.8, downloads: 543, tags: ['FREE FOR USE', 'UPLOADER', 'DATA UPLOAD', 'CONNECTOR', 'PRODUCTIVITY', 'IDS', 'MASTER DATA'],
  screenshots: ['/dataupload1.png', '/dataupload2.png', '/dataupload1.png', '/dataupload2.png'],
  description: '<b>Upload your data via standard connector</b><br/>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. <br/><br/><b>Easy to use and state of the art</b><br/>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild  Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.',
  usage: 'free for use',
  purchase: 'PURCHASE',
  details: '',
  companyName: 'DMG MORI', url:'', background: ''
};

const N = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840336',
  title: 'BPDM Services', rating: 4.8, downloads: 9.002, tags: ['SUPPLIER DATABASE', 'ONE ID', 'BUSINESS INFORMATION', 'COMPANY DATA'],
  screenshots: ['/PictureBPDM02.jpg', '/Picture-BPDM03.jpg', '/Picture-BPDM01.png'],
  description: '<b>Capabilities</b><br /><br /></strong></p><ul><li>Visualization of complex supply chains - connecting multiple bisiness partner for inter-company collaboration and transparency</li><li>ROle-Based Access for networkparticipant - trust chain across an n-tiered value chan from raw material batch origin to finished product</li><li>Streamlined Recalls - Initiate cross-company alerting for product issues</li><li>Tight integration with your logistics business - Linkage of data across suppliers is enabled by matching logistic events</li></ul><p><br /><br /><strong>Description</strong><br /><br />Create an Intelligent Enterprise with Advanced Logistic collabration and Insights. SAP Logistics Business Network, material traceability options connect partners for inter-company collaboration and transparency. It supports a comprehensive set capabilities, allowing to manage freight more efficiently, benefit form situational awareness through track&nbsp;and&nbsp;trace, and create a trust chain for up- and downstream product genealogy.</p>',
  usage: 'free for use',
  purchase: 'OPEN APP',
  details: 'SEE DETAILS',
  companyName: 'CDQ inside', url:'https://apps.cdq.com/signin/catenax', background: 'recom_image ase mt10 pl10 bgkey'
};

const O = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840337',
  title: 'Circular Economy-K.a.p.u.t.t', rating: 4.9, downloads: 57.784, tags: ['SUSTAINABILITY', 'RECYCLING', 'GREEN FUTURE', 'TRANSPARENCY', 'REPROCESSING', 'CIRCULAR ECONOMY', 'CIRCULAR', 'REUSE'],
  screenshots: ['/circular-Economy-001.png', '/circular-Economy-002.png'],
  description: '<b>Beschreiten Sie neue Wege in der Autoverwertung.</b><br /><br /><p>DESER ist die neue Software-Generation für Autoverwerter. Sie können die Plattform auf dem Desktop-PC, Tablet und Handy gleichermaßen nutzen. Erstellen Sie immer die aktuellen Verwertungsnachweise. Erfassen Sie die Daten mit dem Handy auf dem Platz und drucken Sie die Dokumente bequem im Büro aus.Führen Sie mit wenigen Handgriffen Ihr Betriebstagebuch. Mit der Fahrzeugannahme haben Sie schon Hälfte der Arbeit erledigt. Die Erfassung der Fraktionsausgänge ist ein Kinderspiel. DESER ist bereits für die neue Berechnung der Fraktionen vorbereitet.Kommen Sie rechtssicher durch Ihre Zertifizierung. Überwachen Sie Ihren Fahrzeugbestand, melden Sie Ihre Daten einfach an Behörden und Herstellernetze.</p><br /><br /><b>DESER unterstützt Ihre Erfassung</b><br /><br /><p>Einfache Erfassung der angenommen Fahrzeuge. Nur noch wenige Daten müssen eingegeben werden, alles andere wird automatisch ausgefüllt. Erfassen Sie die Fahrzeugdaten draußen mit dem Handy oder Tablet und arbeiten im Büro mit den gleichen Daten am PC weiter.<br />Jederzeit - überall!</p>',
  usage: 'Per month',
  purchase: 'OPEN APP',
  details: 'SEE DETAILS',
  companyName: 'K.a.p.u.t.t GmbH', url:'', background: 'recom_image ase mt10 pl10 bgleaf'
}

const P = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840338',
  title: 'Material Traceability', rating: 4.5, downloads: 577, tags: ['SUPPLY CHAIN ANALYTICS', 'SUPPLY CHAIN VISUALIZATION', 'ALARMS', 'PART TRACEABILITY', 'RECALLS', 'ROLE VIEWS', 'NETWORK VIEW', 'UPSTREAM VIEW', 'DOWNSTREAM VIEW'],
  screenshots: [],
  description: '<b>Capabilities</b><br /><br /></strong></p><ul><li>Visualization of complex supply chains - connecting multiple bisiness partner for inter-company collaboration and transparency</li><li>ROle-Based Access for networkparticipant - trust chain across an n-tiered value chan from raw material batch origin to finished product</li><li>Streamlined Recalls - Initiate cross-company alerting for product issues</li><li>Tight integration with your logistics business - Linkage of data across suppliers is enabled by matching logistic events</li></ul><p><br /><br /><strong>Description</strong><br /><br />Create an Intelligent Enterprise with Advanced Logistic collabration and Insights. SAP Logistics Business Network, material traceability options connect partners for inter-company collaboration and transparency. It supports a comprehensive set capabilities, allowing to manage freight more efficiently, benefit form situational awareness through track&nbsp;and&nbsp;trace, and create a trust chain for up- and downstream product genealogy.</p>',
  usage: 'per year',
  purchase: 'OPEN APP',
  details: 'SEE DETAILS',
  companyName: 'SAP', url:'',  background:'recom_image ase mt10 pl10 bgarrow'
}

const Q = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840339',
  title: 'Part Chain', rating: 4.7, downloads: 183.987, tags: ['FREE FOR USE', 'TRACKING', 'TRACEABILITY', 'CATENA-X'],
  screenshots: ['/app-Picture-PartChain.png', '/Picture-PartChain-Mock01.png', '/Picture-PartChain-Mock02.png'],
  description: '<b>SEamless part traceability through the n.tier supply chain</b><br /><br /><p>knowledge you get detailed information about the components of your direct suppliers as well as your direct customers. This lets your answer questions such as:</p><br /><br /><ul><li>What\'s the exact lead time between the produciton of a subcomponent an your own components?</li><li>To wehre in the world are my components distributed and where are my suppliers located?</li><li>What\'s the exact composition of my component on a unique ID level?</li></ul><br /><br /><p>Because all of that is important information. PartChain keeps a storng one-up, one-down visibilty rule. You and the other parties in the network always see - only their suppliers customers data well as own ata. Your competitors won\'t be able to get any sensitive information about your production data.</p>',
  usage: 'demo',
  purchase: 'OPEN APP',
  details: 'SEE DETAILS',
  companyName: 'Catena-X', url:'https://ui.zf.test.catenax.partchain.dev/',  background: 'recom_image ase mt10 pl10 bgctenax'
}

const R = {
  id : '0253dd4d-35af-43f5-a84c-7cc280840340',
  title: 'Circular Economy - SAP', rating: 4.7, downloads: 183.987, tags: ['SUSTAINABILITY', 'REUSE', 'GREEN FUTURE', 'TRANSPERANCY', 'REPROCESSING', 'CIRCULAR ECONOMY', 'RECYCLCLING'],
  screenshots: ['/Picture-CESAPApp01.png', '/Picture-CESAPApp02.png', '/Picture-CESAPApp03.png', '/Picture-CESAPApp04.png'],
  description: '<b>SAP Circular Economy Application</b><br /><br /><p>The SAP Circular Economy Application for the Catena-X comprises different solutions to collaborate on digital twin information across the entire lifecycle, be it a component, a part or an entire vehicle.</p><br /><br /><p>At the core of the application is SAPs Digital Vehicle Hub powered by the SAP Asset Intelligence Network, which integrates and interacts seamlessly along the automotive & mobility value chain. The application contains pre-delivered content for a vehicle\'s structure to easily model vehicle objects (e.g. model data, configuration data, technical data, lifecycle status, location).</p><br /><br /><p>The solutions help to manage all types of vehicle related master, transactional and usage data to support collaborative business models and processes.</p>',
  usage: 'free for use',
  purchase: 'OPEN APP',
  details: 'SEE DETAILS',
  companyName: 'SAP', url:'https://catenax-dt-rec.iam-prw.cfapps.eu10.hana.ondemand.com', background: 'recom_image ase mt10 pl10 bgleaf'
}


export class AppState {
  public static state: AppState;
  //public apps: Application[] = [F, E, C, A, D, B];
  public apps: Application[] = [N, O, P, Q, R];
  public topApps: Application[] = [B, D, C, F, E];
  public bizApps: Application[] = [C, E, F];
  public installedApps: Application[] = [A, B];
  public sapapps: Application[] = [D];
  public connectedApps: Application[] = [B, D, M];
  public addOns: Application[] = [G, H, I, J, K, L, M];
  @observable public isAdmin: boolean;
  public email = '';
  public readonly categories: any[] = [
    { text: 'Top 10 Downloads', apps: this.topApps },
    { text: 'Business Apps', apps: this.bizApps },
    { text: 'Add-Ons for Connectors', apps: this.addOns }];
    public readonly categoriesnew: any[] = [
      { text: 'Recommendation', apps: this.apps }];
  public readonly dashboardCategories: any[] = [{ text: 'Installed apps', apps: this.installedApps }];
  // { text: 'All apps', apps: this.apps }];

  constructor() {
    const domain = adalContext.getDomain(adalContext.getUsername());
    switch (domain) {
      case 'BMW':
      case 'Microsoft':
        B.url = 'https://ui.bmw.dev.catenax.partchain.dev/';
        break;
      case 'Tier1':
        B.url = 'https://ui.tier1.dev.catenax.partchain.dev/';
        break;
      case 'ZF':
        B.url = 'https://ui.zf.dev.catenax.partchain.dev';
        break;
      case 'Gris':
        B.url = 'https://ui.gris.dev.catenax.partchain.dev/';
        break;
      case 'Bilstein':
        B.url = 'https://ui.bilstein.dev.catenax.partchain.dev';
        break;
      case 'Daimler':
        B.url = '';
        D.url = 'https://mtoemmercedes-mt-business-approuter-lbn-mt.cfapps.eu10.hana.ondemand.com/cp.portal/site#Shell-home';
        break;
      default:
        B.url = '';
        break;
    }

    if (!B.url) {
      this.dashboardCategories[0].apps = [A, D, M];
      this.installedApps = [A, D, M];
    }
  }
}