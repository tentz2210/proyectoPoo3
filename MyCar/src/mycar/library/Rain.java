package mycar.library;

public class Rain implements RoadPiece{

	public final int id = RAIN;
	
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
