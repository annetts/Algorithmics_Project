package com.project.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoardHelper {

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
        list.addAll(recursiveJumps(index, beforeBoard));
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

    private static List<Byte[]> recursiveJumps(Integer start, Byte[] beforeBoard) {
        List<Byte[]> list = new ArrayList<Byte[]>();
        
        int move1 = start + 14;
        int jump1 = start + 7;
        if (isValidJump(start, jump1, move1, beforeBoard)) {
            Byte[] board = generateJumps(start, jump1, move1, beforeBoard);
            list.add(board);
            list.addAll(recursiveJumps(move1, board));
        }
        
        int move2 = start - 14;
        int jump2 = start - 7;
        if (isValidJump(start, jump2, move2,  beforeBoard)) {
            Byte[] board = generateJumps(start, jump2, move2, beforeBoard);
            list.add(board);
            list.addAll(recursiveJumps(move2, board));
        }
        
        int move3 = start + 18;
        int jump3 = start + 9;
        if (isValidJump(start, jump3, move3,  beforeBoard)) {
            Byte[] board = generateJumps(start, jump3, move3, beforeBoard);
            list.add(board);
            list.addAll(recursiveJumps(move3, board));
        }
        
        int move4 = start - 18;
        int jump4 = start - 9;
        if (isValidJump(start, jump4, move4,  beforeBoard)) {
            Byte[] board = generateJumps(start, jump4, move4, beforeBoard);
            list.add(board);
            list.addAll(recursiveJumps(move4, board));
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
	
	   
    private static boolean isValidJump(int start, int jump, int move, Byte[] beforeBoard) {
        if (move < 0 || move > 63) return false; // move will be out of board.
        
        int startColor = beforeBoard[start];
        int jumpColor = beforeBoard[jump];
        int moveColor = beforeBoard[move];
        
        // conquered button must be opposite color of start color.
        if (jumpColor == startColor || jumpColor == 0 || jumpColor == 69) return false;
        // move place must not be occupied.
        if (moveColor != 0) return false;
        
        return true;
    }
}