package com.project.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoardHelper {

    private static int jump;

    public static List<Byte[]> generateJumpMoves(Byte[] beforeBoard, int color) {
        List<Byte[]> nextPossibleJumpMoves = new ArrayList<Byte[]>();
        for (int i = 0; i < beforeBoard.length; i++) {
			if (beforeBoard[i] == color) {
                nextPossibleJumpMoves.addAll(getButtonJumps(i, beforeBoard));
            }
        }
        return nextPossibleJumpMoves;
    }

    public static List<Byte[]> generateMoves(Byte[] beforeBoard, int color) {
        List<Byte[]> nextPossibleMoves = new ArrayList<Byte[]>();
        for (int i = 0; i < beforeBoard.length; i++) {
            if (beforeBoard[i] == color) {
                nextPossibleMoves.addAll(getButtonMoves(i, beforeBoard));
            }
        }
        return nextPossibleMoves;
    }

    private static List<Byte[]> getButtonJumps(Integer index, Byte[] beforeBoard) {
        List<Byte[]> list = new ArrayList<Byte[]>();

		// white button, we move up, else its black and we move down
		list.addAll(getJumps(index, beforeBoard));
		return list;
	}

    private static List<Byte[]> getButtonMoves(Integer index, Byte[] beforeBoard) {
        List<Byte[]> list = new ArrayList<Byte[]>();

        // white button, we move up, else its black and we move down
        list.addAll(getMoves(index, beforeBoard));
        return list;
    }

	private static List<Byte[]> getMoves(Integer index, Byte[] beforeBoard) {
		List<Byte[]> list = new ArrayList<Byte[]>();

		int move1 = 0;
		int move2 = 0;

		if (beforeBoard[index] == 1) {
			move1 = index - 7;
			move2 = index - 9;
		}

		if (beforeBoard[index] == 2) {
			move1 = index + 7;
			move2 = index + 9;
		}

		if (isValidMove(index, move1, beforeBoard)) {
			list.add(generateMove(index, move1, beforeBoard));
		}

		if (isValidMove(index, move2, beforeBoard)) {
			list.add(generateMove(index, move2, beforeBoard));
		}
		return list;
	}

    private static List<Byte[]> getJumps(Integer index, Byte[] beforeBoard) {
        List<Byte[]> list = new ArrayList<Byte[]>();

        int move3 = 0;
        int move4 = 0;
        int move5 = 0;
        int move6 = 0;

        for (jump = 1; jump <= 12; jump++) {
            if (beforeBoard[index] == 1) {

                if (((index - (7 * 2 * jump)) > 0) && (beforeBoard[(index - (7 * jump))] == 2) && (beforeBoard[(index - (7 * 2 * jump))] == 0)) {
                    move3 = index - (7 * 2 * jump); // up right
                    list.add(generateJumps(index, (index - (7 * jump)), move3, beforeBoard));
                }
                if (((index - (9 * 2 * jump)) > 0) && (beforeBoard[(index - (9 * jump))] == 2) && (beforeBoard[(index - (9 * 2 * jump))] == 0)) {
                    move4 = index - (9 * 2 * jump); // up left
                    list.add(generateJumps(index, (index - (9 * jump)), move4, beforeBoard));
                }
                if (((index + (7 * 2 * jump)) < 63) && (beforeBoard[(index + (7 * jump))] == 2) && (beforeBoard[(index + (7 * 2 * jump))] == 0)) {
                    move5 = index + (7 * 2 * jump); // down right
                    list.add(generateJumps(index, (index + (7 * jump)), move5, beforeBoard));
                }
                if (((index + (9 * 2 * jump)) < 63) && (beforeBoard[(index + (9 * jump))] == 2) && (beforeBoard[(index + (9 * 2 * jump))] == 0)) {
                    move6 = index + (9 * 2 * jump); // down left
                    list.add(generateJumps(index, (index + (9 * jump)), move6, beforeBoard));
                }
            }
            if (beforeBoard[index] == 2) {
                if (((index - (7 * 2 * jump)) > 0) && (beforeBoard[(index - (7 * jump))] == 1) && (beforeBoard[(index - (7 * 2 * jump))] == 0)) {
                    move3 = index - (7 * 2 * jump); // up right
                    list.add(generateJumps(index, (index - (7 * jump)), move3, beforeBoard));
                }
                if (((index - (9 * 2 * jump)) > 0) && (beforeBoard[(index - (9 * jump))] == 1) && (beforeBoard[(index - (9 * 2 * jump))] == 0)) {
                    move4 = index - (9 * 2 * jump); // up left
                    list.add(generateJumps(index, (index - (9 * jump)), move4, beforeBoard));
                }
                if (((index + (7 * 2 * jump)) < 63) && (beforeBoard[(index + (7 * jump))] == 1) && (beforeBoard[(index + (7 * 2 * jump))] == 0)) {
                    move5 = index + (7 * 2 * jump); // down right
                    list.add(generateJumps(index, (index + (7 * jump)), move5, beforeBoard));
                }
                if (((index + (9 * 2 * jump)) < 63) && (beforeBoard[(index + (9 * jump))] == 1) && (beforeBoard[(index + (9 * 2 * jump))] == 0)) {
                    move6 = index + (9 * 2 * jump); // down left
                    list.add(generateJumps(index, (index + (9 * jump)), move6, beforeBoard));
                }
            }
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

    private static Byte[] generateJumps(int start, int jump, int move, Byte[] beforeBoard) {
        Byte[] board = Arrays.copyOf(beforeBoard, beforeBoard.length);
        byte c = board[start];
        byte d = board[move];
        board[start] = d;
        board[jump] = 0;
        board[move] = c;
        return board;
    }

	private static boolean isValidMove(Integer index, int move, Byte[] beforeBoard) {
		if (move < 0 || move > 63) return false;
		if (beforeBoard[move] == 0) return true;
		return false;
    }
}
