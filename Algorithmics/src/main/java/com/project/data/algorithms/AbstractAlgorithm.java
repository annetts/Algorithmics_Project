package com.project.data.algorithms;

import com.project.graph.NodeData;

public abstract class AbstractAlgorithm {

	private String name;
	
	public AbstractAlgorithm(String name) {
		this.name = name;
	}
	
	public abstract NodeData node();
	
	
	public String getName() {
		return name;
	}

}
