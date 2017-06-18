package mycar.ui;

public interface ICarConstants {
	
	final public String ROAD_ELEMENTS = ".T+DNLlFMm";
	
	//Road obstacle id
	final public short ROAD = 0;
	final public short T_SECTION = 1;
	final public short CROSS_SECTION = 2;
	final public short RAIN = 3;
	final public short NO_RAIN = 4;
	final public short DAY = 5;
	final public short NIGHT = 6;
	final public short MIN_SPEED = 7;
	final public short MAX_SPEED = 8;
	final public short END = 9;
	
	//Road animation id
	final public short A_ROAD = 0;
	final public short A_T_SECTION = 1;
	final public short A_CROSS_SECTION = 2;
	final public short A_RAIN = 3;
	final public short A_DAY = 4;
	
	//Road animation rate id
	final public short SPEED_CHANGE = 10;
	
	//Dash object id
	final public short DASH_RAIN = 0;
	final public short DASH_LIGHTS = 1;
	final public short DASH_BRAKE = 2;
	final public short DASH_GAS = 3;
	final public short DASH_SPEED = 4;
	final public short DASH_RPM = 5;
	final public short DASH_SHIFT = 6;
	final public short DASH_CLEANERS = 7;
	final public short DASH_HEADERS = 8;
	
	//Dash alarms id
	final public short DASH_RAIN_ALARM = 9;
	final public short DASH_NIGHT_ALARM = 10;
	final public short DASH_DAY_ALARM = 11;
	final public short DASH_T_SECTION_ALARM = 12;
	final public short DASH_CROSS_SECTION_ALARM = 13;
	
	//Animation km/h conversion constant
	final public short FULL_ANIMATION_KM = 54;
}
