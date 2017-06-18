package mycar.library;

public class TSection implements RoadPiece {

	final private int id = T_SECTION;
	
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
