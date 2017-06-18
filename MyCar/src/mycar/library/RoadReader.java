package mycar.library;

import java.util.ArrayList;

import mycar.ui.ICarConstants;

public class RoadReader implements ICarConstants {
	
	public static ArrayList<RoadPiece> readMap(String mapString){
		ArrayList<RoadPiece> map = new ArrayList<RoadPiece>();
		
		char[] dividedMapString = mapString.toCharArray();
		
		for (int index = 0; index < dividedMapString.length; index++){
			char roadPieceId = dividedMapString[index];
			if(roadPieceId == 'M' || roadPieceId == 'm'){
				String value = "";
				
				while(0 > ROAD_ELEMENTS.indexOf(dividedMapString[index+1])){
					index++;
					value += dividedMapString[index];
				}
				map.add(RoadPieceFactory.getRoadPiece(roadPieceId+"", Integer.parseInt(value)));
			} else {
				map.add(RoadPieceFactory.getRoadPiece(roadPieceId+"", 0));
			}
			
			index++;
		}
		
		return map;
	}

}
