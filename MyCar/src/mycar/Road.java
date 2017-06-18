package mycar;

import java.util.ArrayList;

import mycar.library.IObserver;
import mycar.library.Observable;
import mycar.library.RoadPiece;
import mycar.library.RoadReader;
import mycar.ui.ICarConstants;

public class Road extends Observable implements ICarConstants, Runnable{
	
	private boolean rain;
	
	private boolean day;
	
	private int currentSpeed;
	
	private int maxSpeed;
	
	private int minSpeed;
	
	private String roadMapString;
	
	private ArrayList<RoadPiece> constructedRoad;
	
	private int index;
	
	
	public Road(){
		index = -1;
		constructedRoad = new ArrayList<RoadPiece>();
		observers = new ArrayList<IObserver>();
		state = 0;
		setRain(false);
		setDay(true);
		setCurrentSpeed(0);
		setMinSpeed(0);
		setMaxSpeed(1000);
	}
	
	public void readMap(String roadMapString){
		constructedRoad = RoadReader.readMap(roadMapString);
	}

	@Override
	public void run() {
		
		nextRoadPiece();
		
  loop: while(true){
			RoadPiece currentRoadPiece = constructedRoad.get(index);
			int pieceId = currentRoadPiece.getPieceId();
			
			switch(pieceId){
			
			case ROAD:
				if(currentRoadPiece.getPieceValue() > 0){
					currentRoadPiece.setPieceValue(currentRoadPiece.getPieceValue() - (currentSpeed * (1000/3600)));
				} else {
					nextRoadPiece();
				}
				break;
				
			case RAIN:
				setRain(true);
				nextRoadPiece();
				break;
				
			case NO_RAIN:
				setRain(false);
				nextRoadPiece();
				break;
				
			case DAY:
				setDay(true);
				nextRoadPiece();
				break;
				
			case NIGHT:
				setDay(false);
				nextRoadPiece();
				break;
				
			case MIN_SPEED:
				setMinSpeed(currentRoadPiece.getPieceValue());
				nextRoadPiece();
				break;
				
			case MAX_SPEED:
				setMaxSpeed(currentRoadPiece.getPieceValue());
				nextRoadPiece();
				
			case END:
				break loop;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public RoadPiece getCurrentRoadPiece(){
		RoadPiece currentRoadPiece = constructedRoad.get(index);
		return currentRoadPiece;
	}
	
	public void nextRoadPiece(){
		if(index < constructedRoad.size()){
			index++;
			setState((short) getCurrentRoadPiece().getPieceId());
		}
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(int minSpeed) {
		this.minSpeed = minSpeed;
	}

	public boolean isRain() {
		return rain;
	}

	public void setRain(boolean rain) {
		this.rain = rain;
	}

	public boolean isDay() {
		return day;
	}

	public void setDay(boolean day) {
		this.day = day;
	}

	
	
}
