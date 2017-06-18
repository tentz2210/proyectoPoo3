package mycar.library;

public class Straight implements RoadPiece {
	
	private int distance;
	final private int id = ROAD;

	public Straight(){
		distance = 100;
	}
	
	@Override
	public int getPieceId() {
		return id;	
	}

	@Override
	public int getPieceValue() {
		return distance;
	}

	@Override
	public void setPieceValue(int value) {
		distance = value;
	}
	
	
}
