package com.project.data.algorithms;
import com.project.data.GameBoardHelper;

import java.lang.Math;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MiniMax extends AbstractAlgorithm {
	private LinkedList<MiniMax> children = new LinkedList<MiniMax>();
	private double value = 0;
	private boolean isCapture;

	public MiniMax() {
		super("Random2 Algorithm");
	}

	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {

		List<Byte[]> possibleMove = GameBoardHelper.generateMoves(beforeBoard, color);
		
		System.out.println(possibleMove);
		
		return null;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}

	public void setChildren(LinkedList<MiniMax> children) {
		this.children = children;
	}

	public List<MiniMax> getChildren() {
		return this.children;
	}

	public double minimax(boolean isComputer) {
		if (this.getChildren().isEmpty()) {
			return this.getValue();
		}
		if (isComputer) {
			double a = Double.MAX_VALUE;
			for (Iterator<MiniMax> i = children.iterator(); i.hasNext();) {
				MiniMax minimax = (MiniMax) i.next();
				a = Math.min(a, minimax.minimax(!isComputer));
			}
			return a;
		} else {
			double a = Double.MAX_VALUE;
			for (Iterator<MiniMax> i = children.iterator(); i.hasNext();) {
				MiniMax minimax = (MiniMax) i.next();
				a = Math.min(a, minimax(!isComputer));
			}
			return a;
		}
	}

	public MiniMax getMove(boolean isComputer) {
		if (children.isEmpty()) {
			return null;
		}

		MiniMax best = null;
		double maxScore = (isComputer ? Double.MIN_EXPONENT : Double.MAX_VALUE);
		for (Iterator<MiniMax> i = children.iterator(); i.hasNext();) {
			MiniMax child = (MiniMax) i.next();
			double value = child.minimax(isComputer);
			if (best == null || value * (isComputer ? 1 : -1) > maxScore * (isComputer ? 1 : -1)) {
				maxScore = value;
				best = child;
			}
		}

		return best;
	}

}
