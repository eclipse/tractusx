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

@observer
export default class DigitalTwins extends React.Component {

  private getIcon(data:any) {
    return <span className='mt10 mr20'>
        <svg x="0px" y="0px" viewBox="0 0 1000 1000" enableBackground="new 0 0 1000 1000" height="20px" width="20px"><g><g transform="translate(0.000000,511.000000) scale(0.100000,-0.100000)"><path d="M4394.5,4982.7c-927.6-125.1-1797.7-496.6-2502.8-1070.6c-204.6-166.9-566.1-532.3-727-735C292.7,2076.6-70.8,628.6,175.5-755.9c147-812.4,478.7-1553.3,987.2-2204.9c172.8-220.5,649.5-681.3,887.9-858.1c647.6-482.7,1386.5-790.6,2228.7-933.6c305.9-51.6,1136.2-51.6,1442.1,0c1098.5,184.7,1996.3,641.6,2747.1,1392.5c401.3,401.2,685.3,796.5,917.7,1269.3c574.1,1173.9,671.4,2510.8,270.2,3738.3c-236.4,723-603.9,1330.9-1130.3,1875.1c-786.6,814.4-1779.8,1307-2941.8,1462C5314.2,5020.4,4666.6,5020.4,4394.5,4982.7z M5775,4641c965.4-174.8,1795.7-605.8,2469.1-1283.2c719.1-723,1164-1603,1318.9-2614.1c47.7-313.8,47.7-957.4,0-1271.3c-190.7-1235.5-842.2-2324-1831.4-3059c-590-437-1231.5-709.1-2006.2-848.2c-282.1-49.7-1162-49.7-1450,0c-754.8,131.1-1426.2,415.2-2000.3,844.2C1268-2839.6,630.3-1774.9,437.7-527.5c-47.7,315.8-47.7,955.4,0,1271.3c156.9,1011.1,593.9,1885.1,1305,2600.1c659.5,665.4,1452,1092.5,2363.8,1273.3c339.7,67.5,480.7,77.5,973.3,69.5C5445.3,4682.7,5596.2,4672.8,5775,4641z"/><path d="M4879.2,4005.4c-405.2-258.2-826.3-1205.7-1009.1-2268.4c-73.5-427.1-153-1273.3-123.2-1303.1c4-4,570.1-7.9,1257.4-7.9h1247.4v145c0,79.5-13.9,292-31.8,472.8c-113.2,1199.8-443,2230.7-882,2757.1c-113.2,133.1-276.1,260.2-335.7,260.2C4984.5,4061,4928.8,4035.2,4879.2,4005.4z M5121.5,3578.3c252.3-311.9,512.5-985.2,653.5-1682.5c61.6-301.9,133.1-820.4,141-1023l6-119.2h-923.7h-921.7l6,119.2c11.9,216.5,83.4,731,143,1023c125.1,623.7,333.7,1195.8,566.1,1561.3c87.4,135.1,188.7,250.3,216.5,240.4C5020.2,3693.5,5071.8,3639.9,5121.5,3578.3z"/><path d="M3629.8,3884.2c-361.5-143-588-258.2-856.1-435c-816.4-538.3-1412.3-1378.5-1656.6-2336c-63.6-254.3-131.1-641.6-115.2-671.4c4-9.9,476.7-15.9,1046.8-15.9h1038.9l13.9,254.3c63.6,1203.7,325.8,2274.4,754.8,3084.8c61.6,115.2,111.2,216.5,111.2,222.5C3967.4,4013.3,3915.8,3997.4,3629.8,3884.2z M3238.4,3153.2c-218.5-619.7-399.3-1551.3-446.9-2320.1l-6-79.5l-711.1-6c-665.4-4-709.1-2-709.1,29.8c0,19.9,21.9,121.2,49.7,228.4c129.1,508.5,321.8,917.7,623.7,1322.9c158.9,212.5,516.5,574.1,719.1,725c143,107.3,528.4,349.6,558.2,351.6C3321.9,3405.5,3288.1,3292.3,3238.4,3153.2z"/><path d="M6033.3,3993.5c0-6,79.5-168.8,176.8-365.5c395.3-804.5,621.7-1777.8,689.2-2957.7l13.9-244.3h1038.9h1040.9v65.5c0,216.5-133.1,770.7-260.2,1094.5c-431,1088.5-1257.4,1883.1-2405.5,2314.1C6057.1,4001.4,6033.3,4009.3,6033.3,3993.5z M6865.5,3304.2c740.9-425.1,1350.7-1166,1628.8-1980.4c51.6-153,141-496.6,141-546.3c0-31.8-43.7-33.8-709.1-29.8l-711.1,6l-13.9,178.8c-59.6,770.7-206.6,1529.5-411.2,2125.4c-51.6,153-101.3,294-109.2,313.8c-9.9,17.9-11.9,33.8-6,33.8S6766.2,3359.8,6865.5,3304.2z"/><path d="M1003.8-219.6c-19.9-19.9,47.7-419.1,113.2-675.4c288-1128.3,1038.9-2061.8,2075.7-2582.3c208.6-103.3,750.8-317.8,766.7-301.9c6,4-69.5,168.8-166.9,363.5c-387.3,790.6-607.8,1704.3-683.3,2838.5l-23.8,367.5H2050.6C1480.5-209.7,1009.7-213.7,1003.8-219.6z M2791.5-626.8c11.9-220.5,89.4-844.2,135.1-1090.5c89.4-496.6,252.3-1098.5,367.5-1368.6c21.9-49.7,35.7-93.4,31.8-97.3c-15.9-13.9-371.5,200.6-536.3,323.8C2088.3-2333.1,1599.7-1588.2,1403-750c-19.9,89.4-37.7,176.8-37.7,194.7c0,23.8,95.3,27.8,711.1,23.8l709.1-5.9L2791.5-626.8z"/><path d="M3746.9-217.6c-29.8-29.8,49.7-876,123.2-1303c184.7-1074.6,617.8-2038,1023-2276.4c107.3-63.6,147-55.6,286,53.6c345.6,272.1,705.2,1038.9,882,1883.1c107.3,504.5,190.7,1166,190.7,1505.7v145H5004.3C4317-209.7,3750.9-213.7,3746.9-217.6z M5920-541.4c11.9-21.8-37.7-504.5-75.5-760.8c-101.3-649.5-278.1-1255.4-498.6-1690.4c-83.4-166.9-240.4-407.2-303.9-462.8c-41.7-37.7-41.7-37.7-93.3,9.9c-27.8,25.8-89.4,105.3-137.1,176.8c-321.8,488.6-574.1,1295.1-683.3,2185c-47.7,397.3-59.6,532.3-45.7,546.2C4098.5-521.5,5910.1-525.5,5920-541.4z"/><path d="M6899.3-461.9c-61.6-1148.1-296-2149.3-691.3-2951.7c-97.3-196.7-172.8-361.5-166.8-365.5c15.9-17.9,564.1,200.6,772.7,305.9c887.9,452.9,1553.3,1183.9,1918.8,2105.5c129.1,323.8,260.2,876,260.2,1094.5v63.6H7952.1H6913.2L6899.3-461.9z M8635.4-557.3c0-115.2-139.1-570.1-258.2-846.2c-305.9-709.1-951.5-1404.3-1607-1736.1c-91.4-45.7-105.3-47.7-91.4-15.9c51.6,115.2,214.5,627.7,266.2,830.3c121.2,486.7,218.5,1096.5,252.2,1569.2c8,109.2,17.9,204.6,21.9,214.5c4,8,325.8,13.9,713.1,13.9C8536.1-527.5,8635.4-531.5,8635.4-557.3z"/></g></g></svg>
      </span>
  }

  public render() {
    const staticTwinData: any[] = [
      {
        id: {
          namespace:'urn:vehicle:org.schema:vin',
          name:'WBABW33496PX84330'
        },
        description:"OEM E-LINE 42.20b EU5",
        aliases: [
          {
            namespace:'urn:bom:com.oem:partid',
            name:'8a1633c0dd7d75ef77c05dd80ada991f'
          },
          {
            namespace:'urn:openid:net.catena-x:nodeid',
            name:'8a1633c0dd7d75ef77c05dd80ada991f'
          }
        ],
        aspects: [
          {
            name:'Effective BOM',
            model:'urn:bamm:io.openmanufactoring:effectivebom:1.2.0',
            service:{
              methods:'GET,PROPS',
              params:{
                nodeid:'8a1633c0dd7d75ef77c05dd80ada991f'
              },
              url:'https://services.catena-x.net/partrelationship?8a1633c0dd7d75ef77c05dd80ada991f',
              uri:'https://services.catena-x.net/partrelationship'
            },
            app:{
              uri:'https://portal.catena-x.net/apps/partrelationship?part=urn:bom:com.oem:partid#8a1633c0dd7d75ef77c05dd80ada991f'     
            }
          },
          {
            name:'Circular Economy',
            model:'urn:bamm:io.openmanufactoring:circulareconomy:1.2.0',
            service:{
              methods:'GET,PUT,POST',
              params:{
                assetid:"com.oem#4711",
                artifactid:"com.oem#8a1633c0dd7d75ef77c05dd80ada991f"
              },
              uri:'urn:Vocabulary:com.ids:Connector'
            },
            app:{
              uri:'https://portal.catena-x.net/apps/circularEconomy?part=urn:vehicle:org.schema:vin#WBABW33496PX84330'     
            }
          },
        ]
      }
    ]
    return (
      <div className='w100pc h100pc df fdc p44'>
        <div className='df fdc'>
          {staticTwinData.map((data, index) => (
            <div key={index} className='m5 p20 bgpanel w100-100 br4 bsdatac'>
              <div className='df aic jcsb'>
                <span className='fs24 bold'>{data.id.namespace}#{data.id.name}</span>
                {this.getIcon(data)}
              </div>
              <p className='fs14 pt8 lh20 mr70'>{data.description}</p>
              <div className='mt20 mb30'>
                  <span className='dib minw150 fs14 fggrey'>Aliases</span>
                  <span className='fs14 fg5a'>{data.aliases.map( alias => (<span>{alias.namespace}#{alias.name}&nbsp;</span>))}</span>
                  {data.aspects.map( aspect => (
                    <div>
                      <br />
                      <span className='dib minw150 fs14 fggrey'>Aspect</span>
                      <span className='fs14 fg5a'><a href={'semantichub#'+aspect.model}>{aspect.name}</a></span>
                      <br />
                      <span className='dib minw150 fs14 fggrey'>Endpoint</span>
                      <span className='fs14 fg5a'>
                        { aspect.url ?  
                          <a href={aspect.service.url}>{aspect.service.uri}</a> : 
                          <span>{aspect.service.uri}</span>
                        }
                      </span>
                      <br />
                      <span className='dib minw150 fs14 fggrey'>Methods</span>
                      <span className='fs14 fg5a'>{aspect.service.methods}</span>
                      {Object.keys(aspect.service.params).map((key,index)=> (
                        <div>
                          <span className='dib minw150 fs14 fggrey'>Param{index}</span>
                          <span className='fs14 fg5a'>{key}={aspect.service.params[key]}</span>
                        </div>
                      ))
                      }
                      <span className='dib minw150 fs14 fggrey'>App</span>
                      <span className='fs14 fg5a'>
                          <a href={aspect.app.uri}>{aspect.app.uri}</a> 
                      </span>
                    </div>
                  ))}
                </div>

            </div>
          ))}
        </div>
      </div>
    );
  }
}
