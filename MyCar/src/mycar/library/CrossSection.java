package mycar.library;

public class CrossSection implements RoadPiece{

	final private int id = CROSS_SECTION;
	
	public CrossSection(){}

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
