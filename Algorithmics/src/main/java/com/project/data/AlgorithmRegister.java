package com.project.data;

import java.util.ArrayList;
import java.util.List;

import com.project.data.algorithms.AbstractAlgorithm;
import com.project.data.algorithms.RandomMove;
import com.project.data.algorithms.MiniMax;

/**
 * Algorithm register. Add all new algorithms here. They will automagically
 * appear on UI and will be used by game. Also statistics are automatically
 * collected.
 */
public class AlgorithmRegister {

	private static AlgorithmRegister instance = null;
	private List<AbstractAlgorithm> list;
	
	public static AlgorithmRegister getInstance() {
		if (instance == null) {
			instance = new AlgorithmRegister();
		}
		return instance;
	}

	public AlgorithmRegister() {
		list = new ArrayList<AbstractAlgorithm>();
		list.add(new RandomMove());
		list.add(new MiniMax());
	}

	public List<AbstractAlgorithm> getList() {
		return list;
	}

	public AbstractAlgorithm getByString(String algorithm) {
		for (AbstractAlgorithm alg : list) {
			if (algorithm.equals(alg.getName())) {
				return alg;
			}
		}
		return null;
	}

}
