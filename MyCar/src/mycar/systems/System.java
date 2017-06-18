package mycar.systems;

import mycar.library.Observable;

public class System extends Observable implements ISystemConstants{

	int[] systemStatus;
	
	public void setSystemStatus(int[] parameters){
		systemStatus = parameters;
	}
	
	public int[] getSystemStatus(){
		return systemStatus;
	}
	
}
