package com.project.data;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmRegister {

	
	private List<AbstractAlgorithm> list;

	public AlgorithmRegister() {
		list = new ArrayList<AbstractAlgorithm>(); 
		list.add(new Random());
		list.add(new Random2());
	}

	public List<AbstractAlgorithm> getList() {
		return list;
	}
	
}
