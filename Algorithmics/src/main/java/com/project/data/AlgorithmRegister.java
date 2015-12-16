package com.project.data;

import java.util.ArrayList;
import java.util.List;

import com.project.data.algorithms.AbstractAlgorithm;
import com.project.data.algorithms.Random;
import com.project.data.algorithms.Random2;

/**
 * Algorithm register. Add all new algorithms here. They will automagically
 * appear on UI and will be used by game. Also statistics are automatically
 * collected.
 */
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
