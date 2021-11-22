/*
Author: Eli Elad Elrom
Website: https://EliElrom.com
License: MIT License
Component: src/component/Dashboard/Dashboard.tsx

Created with;
$ npx generate-react-cli component Dashboard --type=d3class

*/

import React, { RefObject } from 'react'
import './Dashboard.scss'
import * as d3 from 'd3'
import data from './data.json';
import { NetworkGraph } from '../NetworkGraph/NetworkGraph';

export default class Dashboard extends React.PureComponent<IDashboardProps, IDashboardState> {
  ref: RefObject<HTMLDivElement>

  constructor(props: IDashboardProps) {
    super(props)
    this.state = {
      width: 640,
      height: 480,
      nodes: [],
      links: []
    }
    this.ref = React.createRef()
  }

  componentDidMount() {
    this.setState({nodes: [{x: 50, y: 60}, {x: 100, y: 200}]})
    d3.select(this.ref.current).append('p').text('Hello World')
    d3.select(this.ref.current).append('svg')
      .attr('width', this.state.width)
      .attr('height',  this.state.height);
    d3.forceSimulation(this.state.nodes)
    .force("link", d3.forceLink(this.state.links))
    .force("charge", d3.forceManyBody().strength(-150))
    .force("x", d3.forceX())
    .force("y", d3.forceY());
  }

  nodeHoverTooltip() {
    /* return React.useCallback((node) => {
      return `<div>${node.name}</div>`;
    }, []); */
    console.log('hello');
}

  render() {
    return (
      <div className="Dashboard" ref={this.ref}>
        <NetworkGraph linksData={data.links} nodesData={data.nodes} nodeHoverTooltip={this.nodeHoverTooltip} />
      </div>
    )
  }
}

interface IDashboardProps {
  // TODO

}

interface IDashboardState {
  width: number,
  height: number,
  nodes: {x: number, y: number}[], //needs to be its own type
  links: { source: number, target: number }[]  //needs to be its own type
}
