
package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.control.Labeled;
public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Game game = new TestGame(primaryStage);
	/*
	  Animated game intro vvvvvv
	*/
	
	BackgroundImage backgroundImage = new BackgroundImage(new Image("http://i562.photobucket.com/albums/ss69/sargon2/3D%20rotated%20text/galaxy500x372.gif",640,480,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, 
	BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	 BorderPane root = new BorderPane();
	root.setBackground(new Background(backgroundImage));
	Label title = new Label("Space Invaders");
	//title.setFont(Font.loadFont("file:resources/zephyrean_brk", 18));
	title.setTextFill(Color.YELLOW);
	root.setCenter(title);
	Scene introScene = new Scene(root, 640, 480);
	
	primaryStage.setScene(introScene);
	/*
	  Animated game intro ^^^^^^
	*/
        //primaryStage.setTitle(game.getTitle());
	introScene.setOnKeyPressed( new EventHandler<KeyEvent>(){
		 Game game = new TestGame(primaryStage);
            @Override
		public void handle( KeyEvent keyEvent )
		{
		    primaryStage.setScene(game.getScene());
		    // primaryStage.show();
		     game.run();
		}
	    } );
	
	   
        primaryStage.show();
        //game.run();
    } // start
    
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver

