package com.project.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoardHelper {

	public static List<Byte[]> generateMoves(Byte[] beforeBoard, int color) {
		List<Byte[]> nextPossibleMoves = new ArrayList<Byte[]>();
		for (int i = 0; i < beforeBoard.length; i++) {
			if (beforeBoard[i] == color) {
				nextPossibleMoves.addAll(getButtonMoves(i, beforeBoard));
			}
		}
		return nextPossibleMoves;
	}

	private static List<Byte[]> getButtonMoves(Integer index, Byte[] beforeBoard) {
		List<Byte[]> list = new ArrayList<Byte[]>();

		// white button, we move up, else its black and we move down
		list.addAll(getMoves(index, beforeBoard));
		list.addAll(getJumps(index, beforeBoard));
		return list;
	}

	private static List<Byte[]> getMoves(Integer index, Byte[] beforeBoard) {
		List<Byte[]> list = new ArrayList<Byte[]>();
		if (beforeBoard[index] == 1) {
			index = -index;
		}
		int move1 = index + 7;
		int move2 = index + 9;
		if (isValidMove(Math.abs(index), Math.abs(move1), beforeBoard)) {
			list.add(generateMove(Math.abs(index), Math.abs(move1), beforeBoard));
		}
		
		if (isValidMove(Math.abs(index), Math.abs(move2), beforeBoard)) {
			list.add(generateMove(Math.abs(index), Math.abs(move2), beforeBoard));
		}
		return list;
	}

	private static Byte[] generateMove(int start, int move, Byte[] beforeBoard) {
		Byte[] board = Arrays.copyOf(beforeBoard, beforeBoard.length);
		byte a = board[start];
		byte b = board[move];
		board[start] = b;
		board[move] = a;
		return board;
	}

	private static boolean isValidMove(Integer index, int move, Byte[] beforeBoard) {
		if (move < 0 || move > 63) return false;
		if (beforeBoard[move] == 69) return false;
		if (beforeBoard[move] != 0) return false;
		return true;
	}
	
	private static List<Byte[]> getJumps(Integer index, Byte[] beforeBoard) {
		List<Byte[]> list = new ArrayList<Byte[]>();
		
		return list;
	}

}