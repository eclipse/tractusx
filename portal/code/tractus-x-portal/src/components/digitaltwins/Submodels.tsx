import DescriptionList from "../lists/DescriptionList";
import { Link } from "react-router-dom";

function Submodels(props){
  return(
    <div className="df fwrap mt20">
      {props.models.map(submodel => (
        <div key={submodel.identification} className='m5 p20 bgpanel flex40 br4'>
          <h3 className="fs18 bold mb10">{submodel.idShort}</h3>
          {submodel.description[0] &&
            <DescriptionList title="Description" description={submodel.description[0].text}/>
          }
          <dl className="df mb8">
            <dt className='dib minw150 fs14 fggrey'>Semantic ID</dt>
            <dd className='fs14 fg5a dib'>
              <Link
                to={{
                  pathname: `/home/semanticmodel/${encodeURIComponent(submodel.semanticId.value[0])}`,
                  state: submodel.semanticId.value[0]
                }}
              >
                {submodel.semanticId.value[0]}
              </Link>
            </dd>
          </dl>
          <h4 className="dib mt10 fs14">Endpoints</h4>
          {submodel.endpoints.map(endpoint => (
            <div key={endpoint.interface} className="ml25 mt10">
              <DescriptionList title="Interface" description={endpoint.interface}/>
              <dl>
                <dt className='dib minw150 fs14 fggrey'>Adress</dt>
                <dd className='fs14 fg5a dib'>
                  <Link to={{
                    pathname: `${endpoint.protocolInformation.endpointAddress}`
                  }}>Aspect IDS Connector URL</Link>
                </dd>
              </dl>
              <DescriptionList title="Protocol" description={endpoint.protocolInformation.endpointProtocol}/>
              <DescriptionList title="Protocol Version" description={endpoint.protocolInformation.endpointProtocolVersion}/>
            </div>
          ))}
        </div>
      ))}
    </div>
  )
}

export default Submodels;
