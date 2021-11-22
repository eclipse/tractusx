import React from "react";
import { runNetworkGraph } from "./runNetworkGraph";

export function NetworkGraph({ linksData, nodesData, nodeHoverTooltip }: {linksData: any, nodesData: any, nodeHoverTooltip: Function}) {
  const containerRef = React.useRef(null);

  React.useEffect(() => {
    let destroyFn;

    if (containerRef.current) {
      const { destroy } = runNetworkGraph(containerRef.current, linksData, nodesData, nodeHoverTooltip);
      destroyFn = destroy;
    }

    return destroyFn;
  }, []);

  return <div ref={containerRef} className='container' />;
}

interface ILinks {
  id: number,
  source: number,
  target: number
}

interface INodes {
  id: number,
  name: string,
  gender: string
}
