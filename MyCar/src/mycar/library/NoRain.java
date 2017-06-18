package mycar.library;

public class NoRain implements RoadPiece{
	public final int id = NO_RAIN;
	
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
