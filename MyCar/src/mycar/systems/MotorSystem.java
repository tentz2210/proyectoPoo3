package mycar.systems;

public class MotorSystem extends System{
	
	public MotorSystem(){
		systemStatus = new int[3];
		systemStatus[SPEED] = 0;
		systemStatus[SHIFT] = 1;
		systemStatus[REVOLUTIONS] = 0;
	}
}
