package com.project.data.algorithms;

import com.project.data.GameBoardHelper;

import java.lang.Math;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiniMax extends AbstractAlgorithm {
	private LinkedList<MiniMax> children = new LinkedList<MiniMax>();
	private double value = 0;
	private boolean isCapture;
	private int depth = 3;
	private static Map<Byte[], Integer> boardEvalueteMap = new HashMap<>();
	private int recursion = 1;

	public MiniMax() {
		super("Random2 Algorithm");
	}

	public static int evaluate(Byte[] beforeBoard) {
		int score = 0;
		for (int i = 1; i < 65; i++) {
			if (beforeBoard[i] != 69)
				score = score + beforeBoard[i];
		}
		return score;
	}

	// Returns the board with the smallest score.
	public static Byte[] minBoard(Byte[] a, Byte[] b) {
		if (evaluate(a) <= evaluate(b))
			return a;
		else
			return b;
	}

	// Returns the board with the largest score.
	public static Byte[] maxBoard(Byte[] a, Byte[] b) {
		if (evaluate(a) >= evaluate(b))
			return a;
		else
			return b;
	}

	public static Integer opponent(Integer player) {
		if (player == 1)
			return 2;
		else
			return 1;
	}

	public Byte[] findBestBoard(Integer color, Byte[] boardEvalueteMap) {
		Byte[] bestBoard = null;
	
		for (Byte bestBoard1 : boardEvalueteMap) {
			for (Byte bestBoard2 : boardEvalueteMap) {
		
			if (color == 1)
				bestBoard = maxBoard(bestBoard1, bestBoard2); //next board
			else
				bestBoard = minBoard(bestBoard1, bestBoard2);
			}
		}
		return bestBoard;
	}

	// The minimax algorithm without alpha-beta cutoff.
	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {
		
		return minimax(beforeBoard, 1, color);
	}

	public static Byte[] minimax(Byte[] beforeBoard, int recursion, Integer color){
			if (recursion > 0) {
				 List<Byte[]> possibleMoves = null;
				 List<Byte[]> possibleJumpMoves = null;
				 
				 possibleMoves = GameBoardHelper.generateMoves(beforeBoard, color);
	        	 possibleJumpMoves = GameBoardHelper.generateJumpMoves(beforeBoard, color);
				 
		         if (possibleMoves.size() == 0)
		            return null;
		         if (color == 1) {   // White aka 1 - min node.
		        	 
		         }
		        	 for (Byte[] board : possibleMoves) {
		        		 boardEvalueteMap.put(minimax(board, recursion - 1, opponent(color)));
		        		 return findBestBoard(color, boardEvalueteMap);
		        	 }
		         } else {      // Black aka 2 - max node.
		        	 for (Byte[] board : possibleMoves) {
		        		 boardEvalueteMap.put(minimax(board, recursion - 1, opponent(color)));
		        		 return findBestBoard(color, boardEvalueteMap);
		         } 
		         }	else {
		       return board;   // Recursion done -> leaf in game tree.
		   }
			
		}
		         
		         
