
import * as d3 from "d3";
//import "@fortawesome/fontawesome-free/css/all.min.css";
import "./NetworkGraph.scss";

export function runNetworkGraph(
  container: any,
  linksData: any,
  nodesData: any,
  nodeHoverTooltip: any
) {
  const links = linksData.map((d: any) => Object.assign({}, d));
  const nodes = nodesData.map((d: any) => Object.assign({}, d));

  console.log(links)
  console.log(nodes)

  const containerRect = container.getBoundingClientRect();
  const height = containerRect.height;
  const width = containerRect.width;

  const color = () => { return "#9D79A0"; };

  const icon = (d: any) => {
    return d.gender === "male" ? "male" : "female";
  }

  const getClass = (d: any) => {
    return d.gender === "male" ? 'male' : 'female';
  };

  const drag = (simulation: any) => {
    const dragstarted = (event: any, d: any) => {
      if (!event.active) simulation.alphaTarget(0.3).restart();
      d.fx = d.x;
      d.fy = d.y;
    };

    const dragged = (event: any, d: any) => {
      d.fx = event.x;
      d.fy = event.y;
    };

    const dragended = (event: any, d: any) => {
      if (!event.active) simulation.alphaTarget(0);
      d.fx = null;
      d.fy = null;
    };

    return d3
      .drag()
      .on("start", dragstarted)
      .on("drag", dragged)
      .on("end", dragended);
  };

  // Add the tooltip element to the graph
  const tooltip = document.querySelector("#graph-tooltip");
  if (!tooltip) {
    const tooltipDiv = document.createElement("div");
    tooltipDiv.classList.add('tooltip');
    tooltipDiv.style.opacity = "0";
    tooltipDiv.id = "graph-tooltip";
    document.body.appendChild(tooltipDiv);
  }
  const div = d3.select("#graph-tooltip");

  const addTooltip = (hoverTooltip: any, d: any, x: any, y: any) => {
    div
      .transition()
      .duration(200)
      .style("opacity", 0.9);
    div
      .html(hoverTooltip(d))
      .style("left", `${x}px`)
      .style("top", `${y - 28}px`);
  };

  const removeTooltip = () => {
    div
      .transition()
      .duration(200)
      .style("opacity", 0);
  };

  const simulation = d3
    .forceSimulation(nodes)
    .force("charge", d3.forceManyBody().strength(-150))
    .force("link", d3.forceLink(links))
    .force("x", d3.forceX())
    .force("y", d3.forceY());

  const svg = d3
    .select(container)
    .append("svg")
    .attr("viewBox", `${-width / 2} ${-height / 2} ${width} ${height}`)
/*     .call(d3.zoom().on("zoom", function (event) {
      svg.attr("transform", event.transform);
    })); */

  const link = svg
    .append("g")
    .attr("stroke", "#999")
    .attr("stroke-opacity", 0.6)
    .selectAll("line")
    .data(links)
    .join("line")
    .attr("stroke-width", '10');

  const node = svg
    .append("g")
    .attr("stroke", "#fff")
    .attr("stroke-width", 2)
    .selectAll("circle")
    .data(nodes)
    .join("circle")
    .attr("r", 30)
    .attr("fill", color)
    //.call(drag(simulation));

  const label = svg.append("g")
    .attr("class", "labels")
    .selectAll("text")
    .data(nodes)
    .enter()
    .append("text")
    .attr('text-anchor', 'middle')
    .attr('dominant-baseline', 'central')
    .attr("class", (d: any) => d.gender)
    .text((d: any) => d.name)
    //.call(drag(simulation));

  label.on("mouseover", (event, d) => {
    addTooltip(nodeHoverTooltip, d, event.pageX, event.pageY);
  })
    .on("mouseout", () => {
      removeTooltip();
    });

  simulation.on("tick", () => {
    //update link positions
    link
      .attr("x1", (d: any) => d.source.x)
      .attr("y1", (d: any) => d.source.y)
      .attr("x2", (d: any) => d.target.x)
      .attr("y2", (d: any) => d.target.y);

    // update node positions
    node
      .attr("cx", (d: any) => d.x)
      .attr("cy", (d: any) => d.y);

    // update label positions
    label
      .attr("x", (d: any) => { return d.x; })
      .attr("y", (d: any) => { return d.y; })
  });

  return {
    destroy: () => {
      simulation.stop();
    },
    nodes: () => {
      return svg.node();
    }
  };
}
