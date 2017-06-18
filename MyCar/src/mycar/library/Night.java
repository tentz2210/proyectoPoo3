package mycar.library;

public class Night implements RoadPiece{

	final public int id = NIGHT;
	
	@Override
	public int getPieceId() {
		return id;
	}

	@Override
	public int getPieceValue() {
		return 0;
	}

	@Override
	public void setPieceValue(int value){}

}
