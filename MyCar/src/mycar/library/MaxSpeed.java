package mycar.library;

public class MaxSpeed implements RoadPiece {

	final public int id = MAX_SPEED;
	
	public int limit;
	
	public MaxSpeed(int value){
		this.limit = value;
	}
	
	@Override
	public int getPieceId() {
		return id;
	}

	@Override
	public int getPieceValue() {
		return limit;
	}

	@Override
	public void setPieceValue(int value) {
		this.limit = value;
		
	}

}
