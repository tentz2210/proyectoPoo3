package mycar.systems;

public class ObstacleSystem extends System{
	
	public ObstacleSystem(){
		systemStatus = new int[5];
		systemStatus[DAY] = ON;
		systemStatus[NIGHT] = OFF;
		systemStatus[MAX] = NONE;
		systemStatus[MIN] = NONE;
		systemStatus[RAIN] = OFF;
	}

}
