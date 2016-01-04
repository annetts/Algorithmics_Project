package com.project.data.algorithms;

public abstract class AbstractAlgorithm {

	private String name;
	
	public AbstractAlgorithm(String name) {
		this.name = name;
	}
	
	public abstract Byte[] nextBoard(Byte[] beforeBoard, Integer color);
	
	
	public String getName() {
		return name;
	}

}
