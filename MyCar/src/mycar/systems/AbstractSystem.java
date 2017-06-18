package mycar.systems;

import mycar.Dash;
import mycar.Road;
import mycar.library.IObserver;
import mycar.library.Observable;
import mycar.library.RoadPiece;
import mycar.ui.ICarConstants;

public abstract class AbstractSystem extends Observable implements ISystemConstants, ICarConstants, IObserver {
	
	protected Road road;
	protected Dash dash;
	
	protected System[] systems;
	
	protected RoadPiece currentRoadPiece;
	
	public abstract boolean turnLeft();
	public abstract boolean turnRight();
	public abstract boolean goStraight();
	
	public abstract boolean leftHeaderLight();
	public abstract boolean rightHeaderLight();
	
	public abstract boolean accelerate();
	public abstract boolean brake();
	public abstract boolean shiftUp();
	public abstract boolean shiftDown();
	
	public abstract boolean switchLights();
	public abstract boolean switchCleaners();
	
	public abstract boolean reset();
	
	public System[] createSystems(){
		systems = new System[4];
		
		systems[ELECTRIC_SYSTEM] = new ElectricSystem();
		systems[DIRECTION_SYSTEM]= new DirectionSystem();
		systems[MOTOR_SYSTEM] = new MotorSystem();
		systems[OBSTACLE_SYSTEM] = new ObstacleSystem();
		
		return systems;
	}
	
	public void setSystems(System[] systems){
		this.systems = systems;
	}

}
