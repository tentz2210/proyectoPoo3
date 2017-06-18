package mycar.systems;

import mycar.Dash;
import mycar.Road;

public class CoordinationSystem extends AbstractSystem{

	
	public CoordinationSystem(Road road, Dash dash){
		this.road = road;
		this.dash = dash;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean turnLeft() {
		if(road.getCurrentRoadPiece().getPieceId() == T_SECTION || road.getCurrentRoadPiece().getPieceId()== CROSS_SECTION){
			return true;
		}
		return false;
	}

	@Override
	public boolean turnRight() {
		if(road.getCurrentRoadPiece().getPieceId() == T_SECTION || road.getCurrentRoadPiece().getPieceId()== CROSS_SECTION){
			return true;
		}
		return false;
	}

	@Override
	public boolean goStraight() {
		if(road.getCurrentRoadPiece().getPieceId() == T_SECTION || road.getCurrentRoadPiece().getPieceId()== CROSS_SECTION){
			return true;
		}
		return false;
	}

	@Override
	public boolean leftHeaderLight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rightHeaderLight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accelerate() {
		int[] currentMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		int currentSpeed = currentMotorStatus[SPEED];
		int currentRevolutions = currentMotorStatus[REVOLUTIONS];
		
		if (road.getCurrentRoadPiece().getPieceId() == ROAD) { //Checks if you're on road

			if (((currentSpeed + ACCELERATION_CONSTANT) > CAR_MAX_SPEED) && ((currentRevolutions + REVOLUTIONS_CONSTANT) < CAR_MAX_REVOLUTIONS) ) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean brake() {
		int currentSpeed = systems[MOTOR_SYSTEM].getSystemStatus()[SPEED];
		if(currentSpeed > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean shiftUp() {
		int currentShift = systems[MOTOR_SYSTEM].getSystemStatus()[SHIFT];
		if(currentShift < 5){
			return true;
		}
		return false;
	}

	@Override
	public boolean shiftDown() {
		int currentShift = systems[MOTOR_SYSTEM].getSystemStatus()[SHIFT];
		if(currentShift > 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean switchLights() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchCleaners() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reset() {
		// TODO Auto-generated method stub
		return false;
	}

}