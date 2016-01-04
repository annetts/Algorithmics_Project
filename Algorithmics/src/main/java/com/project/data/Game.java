package com.project.data;

import java.util.ArrayList;
import java.util.List;

import com.project.data.algorithms.AbstractAlgorithm;

public class Game {

	private AbstractAlgorithm algorithm1;
	private AbstractAlgorithm algorithm2;
	private List<Byte[]> boards = new ArrayList<Byte[]>();
	private boolean firstAlgTurn;
	
	public static void main(String[] args) {
		Game game = new Game("Random Algorithm", "Random Algorithm");
		
		Byte[] move = game.getNextBoard();
		while (move != null) {
			for (int i = 1; i <= move.length; i++) {
				System.out.print(move[i - 1] + " ");
				if (i != 0 && i % 8 == 0) {
					System.out.println();
				}
			}
			System.out.print("--------------------------------");
			System.out.println();
			move = game.getNextBoard();
		}
	}
	
	public Game(String algorithm1, String algorithm2) {
		this.algorithm1 = AlgorithmRegister.getInstance().getByString(algorithm1);
		this.algorithm2 = AlgorithmRegister.getInstance().getByString(algorithm2);
		
		initializeGame();
	}

	private void initializeGame() {
		firstAlgTurn = true;
		boards.add(new Byte[]{
				69, 2, 69, 2, 69, 2, 69, 2,
				2, 69, 2, 69, 2, 69, 2, 69,
				69, 2, 69, 2, 69, 2, 69, 2,
				0, 69, 0, 69, 0, 69, 0, 69,
				69, 0, 69, 0, 69, 0, 69, 0,
				1, 69, 1, 69, 1, 69, 1, 69,
				69, 1, 69, 1, 69, 1, 69, 1,
				1, 69, 1, 69, 1, 69, 1, 69
		});
	}

	public Byte[] getNextBoard() {
		Byte[] beforeBoard = boards.get(boards.size() - 1);
		Byte[] afterBoard = null;
		if (firstAlgTurn) {
			afterBoard = algorithm1.nextBoard(beforeBoard, 1);
		} else {
			afterBoard = algorithm2.nextBoard(beforeBoard, 2);
		}
		return afterBoard;
	}
	
}