package mycar.ui;

import mycar.library.SpriteAnimation;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import mycar.Road;
import mycar.library.IObserver;

public class RoadView implements IObserver, ICarConstants { 
	private Road subject;
	private SpriteAnimation[] animations;
	
	public RoadView(Road subject){
		this.subject = subject;
		this.subject.attach(this);
		
		animations = new SpriteAnimation[5];
		
		animations[A_ROAD] = createRoadAnimation(new Image(""), Duration.millis(300), 3, 3, Animation.INDEFINITE);
		animations[A_T_SECTION] = createRoadAnimation(new Image(""), Duration.millis(300), 3, 3, 1);
		animations[A_CROSS_SECTION] = createRoadAnimation(new Image(""), Duration.millis(300), 3, 3, 1);
		animations[A_RAIN] = createRoadAnimation(new Image(""), Duration.millis(300), 3, 3, Animation.INDEFINITE);
		animations[A_DAY] = createRoadAnimation(new Image(""), Duration.millis(300), 3, 3, Animation.INDEFINITE);
	}
	
	@Override
	public void update() {
		short option = subject.getState();
		Runnable command;
		switch(option){
		
		case ROAD:
			command = new Runnable(){
				@Override
				public void run() {
					for(short x = 0; x <= A_CROSS_SECTION; x++){
						animations[x].getImageView().setVisible(false);
						animations[x].stop();
					}
					animations[A_ROAD].getImageView().setVisible(true);
					animations[A_ROAD].play();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case RAIN:
			command = new Runnable(){
				@Override
				public void run() {
					animations[A_RAIN].getImageView().setVisible(true);
					animations[A_RAIN].play();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case NO_RAIN:
			command = new Runnable(){
				@Override
				public void run() {
					animations[A_RAIN].getImageView().setVisible(false);
					animations[A_RAIN].stop();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case DAY:
			command = new Runnable(){
				@Override
				public void run() {
					animations[A_DAY].getImageView().setVisible(true);
					animations[A_DAY].play();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case NIGHT:
			command = new Runnable(){
				@Override
				public void run() {
					animations[A_DAY].getImageView().setVisible(false);
					animations[A_DAY].stop();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case T_SECTION:
			command = new Runnable(){
				@Override
				public void run() {
					for(short x = 0; x <= A_CROSS_SECTION; x++){
						animations[x].getImageView().setVisible(false);
						animations[x].stop();
					}
					animations[A_T_SECTION].getImageView().setVisible(true);
					animations[A_T_SECTION].play();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case CROSS_SECTION:
			command = new Runnable(){
				@Override
				public void run() {
					for(short x = 0; x <= A_CROSS_SECTION; x++){
						animations[x].getImageView().setVisible(false);
						animations[x].stop();
					}
					animations[A_CROSS_SECTION].getImageView().setVisible(true);
					animations[A_CROSS_SECTION].play();
				}
			};
			
			Platform.runLater(command);
			break;
			
		case SPEED_CHANGE:
			long speedRatio = speedConverter(subject.getCurrentSpeed());
			command = new Runnable(){
				@Override
				public void run() {
					for(int x = 0; x <= A_CROSS_SECTION; x++){
						animations[x].setRate(speedRatio);
					}
				}
			};
			
			Platform.runLater(command);
			break;
			
		case END:
			break;
		}
	}
	
	private long speedConverter(int currentSpeed){
		long speedRatio = (currentSpeed / FULL_ANIMATION_KM);
		return speedRatio;
	}
	
	public static SpriteAnimation createRoadAnimation(Image image, Duration duration, int frames, int columns, int cycles){
		ImageView imageView = new ImageView(image);
    	imageView.setViewport(new Rectangle2D(0, 0, 896, 329));
    	SpriteAnimation animation = new SpriteAnimation(imageView, duration, frames, columns, 0, 0, 896, 329);
    	animation.setCycleCount(cycles);
		return animation;
	}
	
	public SpriteAnimation[] getAnimations(){
		return animations;
	}

}
