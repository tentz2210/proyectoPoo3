package mycar.systems;

import java.util.ArrayList;
import mycar.Dash;
import mycar.Road;
import mycar.library.IObserver;
import mycar.library.RoadPiece;

public class NavigationSystem extends AbstractSystem {
	
	
	public NavigationSystem(Road road, Dash dash){
		this.road = road;
		this.road.attach(this);

		observers = new ArrayList<IObserver>();
	}

	@Override
	public boolean turnLeft() {
		int[] left = {LEFT};
		systems[DIRECTION_SYSTEM].setSystemStatus(left);
		road.nextRoadPiece();
		return true;
	}

	@Override
	public boolean turnRight() {
		int[] right = {RIGHT};
		systems[DIRECTION_SYSTEM].setSystemStatus(right);
		road.nextRoadPiece();
		return true;
	}

	@Override
	public boolean goStraight() {
		int[] center = {CENTER};
		systems[DIRECTION_SYSTEM].setSystemStatus(center);
		road.nextRoadPiece();
		return true;
	}

	@Override
	public boolean accelerate() {
		int[] currentMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		int currentSpeed = currentMotorStatus[SPEED];
		int currentRevolutions = currentMotorStatus[REVOLUTIONS];
		int currentShift = currentMotorStatus[SHIFT];
		
		
		currentSpeed += ACCELERATION_CONSTANT;
		currentRevolutions += REVOLUTIONS_CONSTANT;
			
		int[] updatedMotorStatus = new int[3];
		updatedMotorStatus[SPEED] = currentSpeed;
		updatedMotorStatus[REVOLUTIONS] = currentRevolutions;
		updatedMotorStatus[SHIFT] = currentShift;
		
		systems[MOTOR_SYSTEM].setSystemStatus(updatedMotorStatus);
		
		dash.setSpeed(currentSpeed);
		dash.setState(DASH_SPEED);
		
		dash.setRpm(currentRevolutions);
		dash.setState(DASH_RPM);
		
		road.setCurrentSpeed(currentSpeed);
		road.setState(SPEED_CHANGE);
		
		return true;
	}

	@Override
	public boolean brake() {
		int[] currentMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		int currentSpeed = currentMotorStatus[SPEED];
		int currentRevolutions = currentMotorStatus[REVOLUTIONS];
		int currentShift = currentMotorStatus[SHIFT];
		
		
		currentSpeed -= ACCELERATION_CONSTANT;
		currentRevolutions -= REVOLUTIONS_CONSTANT;
			
		int[] updatedMotorStatus = new int[3];
		updatedMotorStatus[SPEED] = currentSpeed;
		updatedMotorStatus[REVOLUTIONS] = currentRevolutions;
		updatedMotorStatus[SHIFT] = currentShift;
		
		systems[MOTOR_SYSTEM].setSystemStatus(updatedMotorStatus);
		
		dash.setSpeed(currentSpeed);
		dash.setState(DASH_SPEED);
		
		dash.setRpm(currentRevolutions);
		dash.setState(DASH_RPM);
		
		road.setCurrentSpeed(currentSpeed);
		road.setState(SPEED_CHANGE);
		
		return true;
	}

	@Override
	public boolean switchLights() {
		int[] currentElectricStatus = systems[ELECTRIC_SYSTEM].getSystemStatus();
		int currentLights = currentElectricStatus[LIGHTS];
		if(currentLights == OFF){
			currentLights = ON;
			dash.setLights(true);
		} else {
			currentLights = OFF;
			dash.setLights(false);
		}
		
		currentElectricStatus[LIGHTS] = currentLights;
		systems[ELECTRIC_SYSTEM].setSystemStatus(currentElectricStatus);
		
		dash.setState(DASH_LIGHTS);
		return true;
	}

	@Override
	public boolean switchCleaners() {
		int[] currentElectricStatus = systems[ELECTRIC_SYSTEM].getSystemStatus();
		int currentCleaners = currentElectricStatus[CLEANERS];
		if(currentCleaners == OFF){
			currentCleaners = ON;
			dash.setCleaners(true);
		} else {
			dash.setCleaners(false);
			currentCleaners = OFF;
		}
		
		currentElectricStatus[CLEANERS] = currentCleaners;
		systems[ELECTRIC_SYSTEM].setSystemStatus(currentElectricStatus);
		
		dash.setState(DASH_CLEANERS);
		return true;
	}

	@Override
	public boolean leftHeaderLight() {
		int[] currentElectricStatus = systems[ELECTRIC_SYSTEM].getSystemStatus();
		int currentHeader = currentElectricStatus[HEADER];
		
		if(currentHeader == LEFT){
			currentHeader = OFF;
		} else {
			currentHeader = LEFT;
		}
		
		currentElectricStatus[HEADER] = currentHeader;
		
		systems[ELECTRIC_SYSTEM].setSystemStatus(currentElectricStatus);
		
		dash.setHeaderLight(currentHeader);
		dash.setState(DASH_HEADERS);
		return true;
	}

	@Override
	public boolean rightHeaderLight() {
		int[] currentElectricStatus = systems[ELECTRIC_SYSTEM].getSystemStatus();
		int currentHeader = currentElectricStatus[HEADER];
		
		if(currentHeader == RIGHT){
			currentHeader = OFF;
		} else {
			currentHeader = RIGHT;
		}
		
		currentElectricStatus[HEADER] = currentHeader;
		
		systems[ELECTRIC_SYSTEM].setSystemStatus(currentElectricStatus);
		
		dash.setHeaderLight(currentHeader);
		dash.setState(DASH_HEADERS);
		return true;
	}

	@Override
	public void update() {
		RoadPiece currentRoadPiece = road.getCurrentRoadPiece();
		if(currentRoadPiece.getPieceId() == T_SECTION || currentRoadPiece.getPieceId() == CROSS_SECTION){
			int currentSpeed = systems[MOTOR_SYSTEM].getSystemStatus()[SPEED];
			int[] updatedMotorStatus = new int[3];
			updatedMotorStatus[SPEED] = 0;
			updatedMotorStatus[SHIFT] = 1;
			updatedMotorStatus[REVOLUTIONS] = 0;
			
			if(currentSpeed > 15){
				
			}
		}
		
	}

	@Override
	public boolean shiftUp() {
		int[] currentMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		int currentShift = currentMotorStatus[SHIFT];
		int currentRPM = currentMotorStatus[REVOLUTIONS];
		currentShift++; 
		currentRPM -= 2500;
		if(currentRPM < 0){
			currentRPM = 0;
		}
		int[] updatedMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		updatedMotorStatus[SHIFT] = currentShift;
		updatedMotorStatus[REVOLUTIONS] = currentRPM;
		systems[MOTOR_SYSTEM].setSystemStatus(updatedMotorStatus);
		
		dash.setShift(currentShift);
		dash.setState(DASH_SHIFT);
		
		dash.setRpm(currentRPM);
		dash.setState(DASH_RPM);
		return true;
	}

	@Override
	public boolean shiftDown() {
		int[] currentMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		int currentShift = currentMotorStatus[SHIFT];
		int currentRPM = currentMotorStatus[REVOLUTIONS];
		currentShift--; 
		currentRPM += 2500;
		if(currentRPM > CAR_MAX_REVOLUTIONS){
			currentRPM = CAR_MAX_REVOLUTIONS;
		}
		int[] updatedMotorStatus = systems[MOTOR_SYSTEM].getSystemStatus();
		updatedMotorStatus[SHIFT] = currentShift;
		updatedMotorStatus[REVOLUTIONS] = currentRPM;
		systems[MOTOR_SYSTEM].setSystemStatus(updatedMotorStatus);
		
		dash.setShift(currentShift);
		dash.setState(DASH_SHIFT);
		
		dash.setRpm(currentRPM);
		dash.setState(DASH_RPM);
		
		return true;
	}

	@Override
	public boolean reset() {
		createSystems();
		return true;
	}

}
