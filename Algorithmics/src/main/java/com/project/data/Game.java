package com.project.data;

import java.util.ArrayList;
import java.util.List;

import com.project.data.algorithms.AbstractAlgorithm;

public class Game {
	
	private static int totalTime1;
	private static int totalTime2;
	private AbstractAlgorithm algorithm1;
	private AbstractAlgorithm algorithm2;
	private List<Byte[]> boards = new ArrayList<Byte[]>();
	private static boolean firstAlgTurn;
	private static int totalWin1;
	private static int totalWin2;
	
	public static void main(String[] args) {
		
		double loops = 10000;
		for (int i = 0; i < loops; i++) {
			Game game = new Game("MiniMax2", "MiniMax5");
			playGame(game);
		}
		System.out.println("first Algorithm Time: " + totalTime1);
		System.out.println("secod Algorithm Time: " + totalTime2);
		System.out.println("first Algorithm avg. Time: " + totalTime1/loops);
		System.out.println("secod Algorithm avg. Time: " + totalTime2/loops);
		System.out.println("first wins: " + totalWin1);
		System.out.println("secod wins: " + totalWin2);
	}

	private static void playGame(Game game) {
		Byte[] move = game.getNextBoard();
		try {
			while (move != null) {
//				for (int i = 1; i <= move.length; i++) {
//					System.out.print(move[i - 1] + " ");
//					if (i != 0 && i % 8 == 0) {
//						System.out.println();
//					}
//				}
//				System.out.print("--------------------------------");
//				System.out.println();
				move = game.getNextBoard();
			}
		} catch (Exception e)  {

		}
		if (firstAlgTurn) {
			totalWin1++;
		} else {
			totalWin2++;
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

	public Byte[] getNextBoard() throws NullPointerException {
		Byte[] beforeBoard = boards.get(boards.size() - 1);
		Byte[] afterBoard = null;
		long start = System.currentTimeMillis();
		if (firstAlgTurn) {
			afterBoard = algorithm1.nextBoard(beforeBoard, 1);
			totalTime1 += System.currentTimeMillis() - start;
			firstAlgTurn = false;
		} else {
			afterBoard = algorithm2.nextBoard(beforeBoard, 2);
			totalTime2 += System.currentTimeMillis() - start;
			firstAlgTurn = true;
		}
		boards.add(afterBoard);
		return afterBoard;
	}
	
}