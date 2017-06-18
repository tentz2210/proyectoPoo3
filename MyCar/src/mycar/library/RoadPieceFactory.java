package mycar.library;

public class RoadPieceFactory {
	
	private RoadPieceFactory(){};
	
	public static RoadPiece getRoadPiece(String pieceType, int value){
		
		switch (pieceType) {
		
		case ".":
			return new Straight();
			
		case "+":
			return new CrossSection();
			
		case "T":
			return new TSection();
			
		case "m":
			return new MinSpeed(value);
			
		case "M":
			return new MaxSpeed(value);
			
		case "D":
			return new Day();
			
		case "N":
			return new Night();
			
		case "L":
			return new Rain();
			
		case "l":
			return new NoRain();
			
		case "F":
			return new End();
		}
		
		return null;
	}

}
