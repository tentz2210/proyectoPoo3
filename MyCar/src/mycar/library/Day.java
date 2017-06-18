package mycar.library;

public class Day implements RoadPiece{

	final private int id = DAY;
	
	@Override
	public int getPieceId() {
		return id;
	}

	@Override
	public int getPieceValue() {
		return 0;
	}

	@Override
	public void setPieceValue(int value) {}

}
