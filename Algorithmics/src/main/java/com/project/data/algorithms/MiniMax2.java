package com.project.data.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.project.data.GameBoardHelper;

public class MiniMax2 extends AbstractAlgorithm {

	protected static int MAX_LEVELS;
	private int[] scores = {
		4, 4, 4, 4, 4, 4, 4, 4,
		4, 3, 3, 3, 3, 3, 3, 4,
		4, 3, 2, 2, 2, 2, 3, 4,
		4, 3, 2, 1, 1, 2, 3, 4,
		4, 3, 2, 1, 1, 2, 3, 4,
		4, 3, 2, 2, 2, 2, 3, 4,
		4, 3, 3, 3, 3, 3, 3, 4,
		4, 4, 4, 4, 4, 4, 4, 4
	};
	
	
	public MiniMax2() {
		this("MiniMax2");
		MAX_LEVELS = 2;
	}
	
	public MiniMax2(String name) {
		super(name);
	}

	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {
		Map<Byte[], Integer> evaluatedBoards = null;
		
		// get all possible moves
		List<Byte[]> possibleJumpMove = GameBoardHelper.generateJumpMoves(beforeBoard, color);
		evaluatedBoards = evaluate(possibleJumpMove, color);
		
		if (possibleJumpMove.isEmpty()) {
			// get all possible jumps
			List<Byte[]> possibleMove = GameBoardHelper.generateMoves(beforeBoard, color);
			evaluatedBoards = evaluate(possibleMove, color);
		}
		
		Byte[] board = null;
		Integer bestValue = null;
		for (Entry<Byte[], Integer> eBoard : evaluatedBoards.entrySet()) {
			if (bestValue == null || eBoard.getValue() > bestValue) {
				board = eBoard.getKey();
				bestValue = eBoard.getValue();
			}
		}
		
		return board;
	}

	private Map<Byte[], Integer> evaluate(List<Byte[]> possibleMove, Integer color) {
		Map<Byte[], Integer> evaluations = new HashMap<>();
		currentColor = color;
		
		for (Byte[] move : possibleMove) {
			List<Byte[]> moveList = new ArrayList<>();
			moveList.add(move);
			List<Byte[]> levels = generateLevels(moveList);
			evaluations.put(move, evaluateMove(levels, color));
		}
		
		return evaluations;
	}

	private int currentLevel;
	private int currentColor;
	private List<Byte[]> generateLevels(List<Byte[]> boards) {
		List<Byte[]> list = new ArrayList<>();
		for (Byte[] move : boards) {
			if (!list.addAll(GameBoardHelper.generateJumpMoves(move, currentColor))) {
				list.addAll(GameBoardHelper.generateMoves(move, currentColor));
			}
		}
		// changeColor for next level
		currentColor = currentColor == 1 ? 0 : 1;
		
		// there were not possible further moves
		if (list.isEmpty()) {
			return boards;
		// reccursion depth is not reached yet, go deeper.
		} else if (currentLevel < MAX_LEVELS) {
			currentLevel++;
			return generateLevels(list);
		} else {
			return list;
		}
	}

	private Integer evaluateMove(List<Byte[]> boards, Integer color) {
		int blackScore = 0;
		int whiteScore = 0;
		
		for (Byte[] board : boards) {
			for (int i = 0; i < board.length; i++) {
				
				int score = scores[i];
				if (board[i] == 1) {
					whiteScore += score;
				}
				if (board[i] == 2) {
					blackScore += score;
				}
			}
		}
		
		if (color == 1) {
			return whiteScore - blackScore;
		}
		
		return blackScore - whiteScore;
		
	}

}
