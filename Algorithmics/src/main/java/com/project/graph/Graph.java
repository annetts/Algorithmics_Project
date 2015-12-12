package com.project.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Ideas of implemation is taken from com.sun.corba.se.impl.orbutil.graph.GraphImpl.
 * @author Rauno
 *
 */
public final class Graph {

	private Map<String, NodeData> nodes = new HashMap<String, NodeData>();
	private boolean directed;
	
	public Graph(boolean directed) {
		this.directed = directed;
	}

	public void addEdge(String src, String dest) {
				
		NodeData srcNode = nodes.get(src);
		NodeData destNode = nodes.get(dest);
		
		if (srcNode == null) {
			srcNode = new NodeData();
			nodes.put(src, srcNode);
		}
		
		if (destNode == null) {
			destNode = new NodeData();
			nodes.put(dest, destNode);
		}
		
		srcNode.addNeighbor(dest);
		
		// of graph is not directed we can move both ways
		if (!directed) {
			destNode.addNeighbor(src);
		}
	}
	
	public NodeData getNodeData(String node) {
		return nodes.get(node);
	}
	
	public Map<String, NodeData> getNodes() {
		return nodes;
	}
	
}
