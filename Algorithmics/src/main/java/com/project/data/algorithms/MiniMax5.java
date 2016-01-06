package com.project.data.algorithms;

public class MiniMax5 extends MiniMax2 {

	public MiniMax5() {
		super("MiniMax5");
		MAX_LEVELS = 5;
	}
	
	@Override
	public Byte[] nextBoard(Byte[] beforeBoard, Integer color) {
		return super.nextBoard(beforeBoard, color);
	}

}
