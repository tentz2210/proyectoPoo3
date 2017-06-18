package mycar;

import mycar.systems.AbstractSystem;
import mycar.systems.CoordinationSystem;
import mycar.systems.NavigationSystem;
import mycar.ui.DashView;
import mycar.ui.RoadView;

public class Simulator {

	private AbstractSystem[] carSystems;
	private Road road;
	private Dash dash;
	private RoadView roadView;
	private DashView dashView;
	
	public Simulator(){
		road = new Road();
		dash = new Dash();
		
		setRoadView(new RoadView(road));
		setDashView(new DashView(dash));
		
		
		carSystems[0] = new NavigationSystem(road, dash);
		carSystems[1] = new CoordinationSystem(road, dash);
		
		carSystems[1].setSystems(carSystems[0].createSystems());
	}

	public RoadView getRoadView() {
		return roadView;
	}

	public void setRoadView(RoadView roadView) {
		this.roadView = roadView;
	}

	public DashView getDashView() {
		return dashView;
	}

	public void setDashView(DashView dashView) {
		this.dashView = dashView;
	}
	
}
