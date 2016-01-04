package com.project.data.algorithms;

import java.util.List;
import java.util.Random;

import com.project.data.GameBoardHelper;

public class RandomMove extends AbstractAlgorithm {
	
	public RandomMove() {
		super("Random Algorithm");
	}

	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {
		List<Byte[]> possibleMove = GameBoardHelper.generateMoves(beforeBoard, color);
		Random random = new Random();
		return possibleMove.get(random.nextInt(possibleMove.size()));
	}
	
}
