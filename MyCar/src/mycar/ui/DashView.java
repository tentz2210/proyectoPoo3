package mycar.ui;

import javafx.scene.control.Button;
import javafx.scene.control.*;
import mycar.Dash;
import mycar.library.IObserver;

public class DashView implements IObserver, ICarConstants {
	private Dash subject;
	private Button[] dashButtons;
	private TextField alarms;
	private TextField speed;
	private TextField rpm;
	
	public DashView(Dash subject){
		this.subject = subject;
		this.subject.attach(this);
		
		dashButtons = new Button[4];
		
		
		
		alarms = new TextField("Alarm System: Online");
		alarms.setEditable(false);
		alarms.setStyle("-fx-control-inner-background: black; -fx-text-inner-color: green;");
	}
	
	
	@Override
	public void update() {
		
		
	}

}
