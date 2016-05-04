package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TestGame extends Game {

    
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};

    // some text to display the time
    private Text text = new Text() {{
         setTranslateX(10);
         setTranslateY(470);
         setFill(Color.YELLOWGREEN);
    }};
    /*
    private Image ship = new Image("https://a.fsdn.com/con/app/proj/partartspace/screenshots/Spaceship15.png");
    private ImageView shipView = new ImageView(){{
	shipView.setImage(ship);
    
    }};
    */
    private Rectangle Alien = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(30);
	    setTranslateY(50);
	    setFill(Color.GREEN);
    }};
    private Rectangle Alien2 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(70);
	    setTranslateY(50);
	    setFill(Color.GREEN);
    }};
    private Rectangle Alien3 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(110);
	    setTranslateY(50);
	    setFill(Color.GREEN);
    }};
    private Rectangle bullet = new Rectangle() {{
	setWidth(5);
	setHeight(20);
	setTranslateX(30);
	setTranslateY(490);
	setFill(Color.WHITE);
    }};
    
    int time = 0;
    Timer myTimer = new Timer();
    TimerTask timerTask = new TimerTask() {
	    public void run(){
		try{
		    if(bullet.getTranslateY() < 490){
			bullet.setTranslateY(bullet.getTranslateY() - 1);       	   
		    }
		    if (bullet.getTranslateY() < -50){
			bullet.setTranslateY(text.getTranslateY() + 20);
			bullet.setTranslateX(text.getTranslateX() + 30);       	   
		    }
		}
		catch(Exception e){
		    System.out.print("Error ");
		}
	    }
	};
    
    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public TestGame(Stage stage) {
	
	super(stage, "TestGame", 60, 640, 480);
	try{
	    getSceneNodes().getChildren().addAll(bg, Alien, Alien2, Alien3, bullet, text);
	}
	catch(Exception e){
	    System.out.print("Error ");
	}
    } // TestGame
    
    @Override
    public void update(Game game, GameTime gameTime) {
	try{






	    
	    text.setText("/o/|^|\\o\\");//"The time is " + (gameTime.getTotalGameTime()));
	    //if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 15);
	    //if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 15);
	    if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && text.getTranslateX() > 10) text.setTranslateX(text.getTranslateX() - 4);
	    if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT) && text.getTranslateX() < 500) text.setTranslateX(text.getTranslateX() + 4);
	    if (game.getKeyManager().isKeyPressed(KeyCode.SPACE) && bullet.getTranslateY() == text.getTranslateY() + 20){
		bullet.setTranslateY(text.getTranslateY() + 19);
		bullet.setTranslateX(text.getTranslateX() + 21);      	 
		myTimer.scheduleAtFixedRate(timerTask,1,1);
	    }
	    if (bullet.getTranslateY() < 0){
		//	    bullet.setTranslateY(bullet.getTranslateY() + 480);
	    }
	    
	    if(bullet.getTranslateY() > Alien.getTranslateY() && bullet.getTranslateY() < Alien.getTranslateY() + 20 && bullet.getTranslateX() > Alien.getTranslateX() && bullet.getTranslateX() < Alien.getTranslateX() + 20){
		Alien.setTranslateX(1000);
		Alien.setTranslateY(1000);
		System.out.println("PCHCHCWWWOOW");
	    }
	    if(bullet.getTranslateY() > Alien2.getTranslateY() && bullet.getTranslateY() < Alien2.getTranslateY() + 20 && bullet.getTranslateX() > Alien2.getTranslateX() && bullet.getTranslateX() < Alien2.getTranslateX() + 20){
		Alien2.setTranslateX(1000);
		Alien2.setTranslateY(1000);
		System.out.println("PCHCHCWWWOOW");
	    }
	    if(bullet.getTranslateY() > Alien3.getTranslateY() && bullet.getTranslateY() < Alien3.getTranslateY() + 20 && bullet.getTranslateX() > Alien3.getTranslateX() && bullet.getTranslateX() < Alien3.getTranslateX() + 20){
		Alien3.setTranslateX(1000);
		Alien3.setTranslateY(1000);
		System.out.println("PCHCHCWWWOOW");
	    }
	    
	    
	    
	    
	}
	catch(Exception e)
	    {
		System.out.print("Error ");
	    }	    
	
    } // update
} // TestGame

