package com.project.data;

public abstract class AbstractAlgorithm {

	private String name;
	
	public AbstractAlgorithm(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
