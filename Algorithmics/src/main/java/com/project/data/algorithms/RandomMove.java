package com.project.data.algorithms;

import java.util.List;
import java.util.Random;

import com.project.data.GameBoardHelper;

public class RandomMove extends AbstractAlgorithm {

	private Random random;

	public RandomMove() {
		super("Random Algorithm");
	}

	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {
		List<Byte[]> possibleJumpMove = GameBoardHelper.generateJumpMoves(beforeBoard, color);
		random = new Random();

		System.out.println(possibleJumpMove);
		//System.out.println(possibleMove);
		if (!possibleJumpMove.isEmpty()) {
			return possibleJumpMove.get(random.nextInt(possibleJumpMove.size()));
		} else {
			List<Byte[]> possibleMove = GameBoardHelper.generateMoves(beforeBoard, color);
			return possibleMove.get(random.nextInt(possibleMove.size()));

		}
	}
}
