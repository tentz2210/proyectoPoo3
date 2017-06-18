package mycar.library;

import mycar.ui.ICarConstants;

public interface RoadPiece extends ICarConstants{
	
	public int getPieceId();
	
	public int getPieceValue();
	public void setPieceValue(int value);
	
}
