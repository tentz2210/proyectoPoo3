package mycar.systems;

public class ElectricSystem extends System{
	
	public ElectricSystem(){
		systemStatus = new int[3];
		systemStatus[LIGHTS] = OFF;
		systemStatus[HEADER] = OFF;
		systemStatus[CLEANERS] = OFF;
	}

}
