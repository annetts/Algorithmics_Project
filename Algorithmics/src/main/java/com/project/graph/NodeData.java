package com.project.graph;

import java.util.ArrayList;
import java.util.List;

public class NodeData {

	private final List<String> neighbors;
	
	public NodeData() {
		this.neighbors = new ArrayList<String>();
	}
	
	public void addNeighbor(String node) {
		getNeighbors().add(node);
	}

	public List<String> getNeighbors() {
		return neighbors;
	}

}
