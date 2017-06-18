package mycar;

import java.util.ArrayList;

import mycar.library.Observable;
import mycar.systems.ISystemConstants;
import mycar.library.IObserver;

public class Dash extends Observable implements ISystemConstants{
	
	private boolean lights;
	private boolean cleaners;
	private int headerLight;
	private int shift;
	private int speed;
	private int rpm;
	
	private boolean[] score;
	
	public Dash(){
		observers = new ArrayList<IObserver>();
		lights = false;
		setCleaners(false);
		headerLight = OFF;
		shift = 1;
		speed = 0;
		rpm = 0;
		score = new boolean[5];
		for(int index = 0; index < score.length; index++){
			score[index] = true;
		}
	}
	
	
	public boolean isLights() {
		return lights;
	}
	
	public void setLights(boolean lights) {
		this.lights = lights;
	}
	
	public int getHeaderLight() {
		return headerLight;
	}
	
	public void setHeaderLight(int headerLight) {
		this.headerLight = headerLight;
	}

	public boolean[] getScore(){
		return score;
	}
	
	public void setScore(boolean[] score){
		this.score = score;
	}


	public int getShift() {
		return shift;
	}


	public void setShift(int shift) {
		this.shift = shift;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getRpm() {
		return rpm;
	}


	public void setRpm(int rpm) {
		this.rpm = rpm;
	}


	public boolean isCleaners() {
		return cleaners;
	}


	public void setCleaners(boolean cleaners) {
		this.cleaners = cleaners;
	}

	
	
	

}
