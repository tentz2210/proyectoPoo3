package mycar.library;

public class End implements RoadPiece {
	public final int id = END;
	
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
