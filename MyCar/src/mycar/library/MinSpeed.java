package mycar.library;

public class MinSpeed implements RoadPiece {

	final public int id = MIN_SPEED;
	public int limit;
	
	public MinSpeed(int value){
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
