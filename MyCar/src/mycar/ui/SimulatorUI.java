package mycar.ui;


import javafx.animation.Animation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import mycar.Dash;
import mycar.Road;
import mycar.Simulator;
import mycar.library.SpriteAnimation;
import mycar.systems.AbstractSystem;
import mycar.systems.CoordinationSystem;
import mycar.systems.NavigationSystem;

public class SimulatorUI extends Application {
	
	public static SpriteAnimation[] animations;

   /* public static void main(String[] args) {
    	final Image image = new Image("file:C:/Users/BISCUIT.pc06/Desktop/MyCar imagenes/straight_sprite.png");
    	ImageView imageView = new ImageView(image);
    	imageView.setViewport(new Rectangle2D(0, 0, 128, 47));
    	roadView = null;
    	animation = new SpriteAnimation(imageView, Duration.millis(300), 3, 3, 0, 0, 128, 47);
    	animation.setCycleCount(Animation.INDEFINITE);
    	animation.play();
        launch(args);  
    } */
	
	public static void main(){
		launch();
	}

    public void start(Stage primaryStage) {
    	//Simulator simulator = new Simulator();
    	
    	SpriteAnimation roadAnimation = RoadView.createRoadAnimation(new Image("file:straight_sprite_big.png"), Duration.millis(300), 3, 3, Animation.INDEFINITE);
    	roadAnimation.play();
    	
        primaryStage.setTitle("My Car");

        StackPane stackPane = new StackPane();
        
        BorderPane roadPane = new BorderPane();
        
        roadPane.setPrefSize(896, 560);
        roadPane.setMinSize(896, 560);
        
        BorderPane rainPane = new BorderPane();
        
        rainPane.setPrefSize(896, 560);
        rainPane.setMinSize(896, 560);
        rainPane.setStyle("-fx-background-color: transparent;");
        
        BorderPane dashPane = new BorderPane();
        
        Image dashImage = new Image("file:dashboardBig.png");
        ImageView dashImageView = new ImageView(dashImage);
        dashImageView.setStyle("-fx-background-color: transparent;");
        
        dashPane.setPrefSize(896, 560);
        dashPane.setMinSize(896, 560);
        dashPane.setStyle("-fx-background-color: transparent;");
        
        dashPane.getChildren().add(dashImageView);
        roadPane.getChildren().add(roadAnimation.getImageView());
        
        stackPane.getChildren().add(roadPane);
        stackPane.getChildren().add(dashPane);
        
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.getScene();
        primaryStage.show();
    }
}
