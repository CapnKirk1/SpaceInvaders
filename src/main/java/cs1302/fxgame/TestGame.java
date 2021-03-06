package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Oval;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TestGame extends Game {

    int initial = 0;
    int move = 1;
    int end = 0;
    int level = 1;
    int shoot = 0;
    int rand;
    int lives = 3;
    int speed = 5;
    int mom = 0;
    int moveCount = 20;
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};
    
    private Rectangle gameOver = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK);
	 setVisible(false);
    }};

    

    // All of these instantiate objects used for the game such as the score, 
    // bunkers, aliens, or mothership.
    private Text health = new Text() {{
	setTranslateX(300);
	setTranslateY(20);
	setFill(Color.YELLOWGREEN);
    }};

    private Text text = new Text() {{
         setTranslateX(10);
         setTranslateY(470);
         setFill(Color.YELLOWGREEN);
    }};

    private Text timer = new Text() {{
         setTranslateX(10);
         setTranslateY(20);
         setFill(Color.YELLOWGREEN);
    }};
    private Text score = new Text() {{
	setTranslateX(500);
	setTranslateY(20);
	setFill(Color.YELLOWGREEN);
	
    }};
    private int kills = 0;
    /*
    private Image ship = new Image("https://a.fsdn.com/con/app/proj/partartspace/screenshots/Spaceship15.png");
    private ImageView shipView = new ImageView(){{
	shipView.setImage(ship);
	setTranslateX(50);
	setTranslateY(400);
    }};
    */
    private static Rectangle Mother = new Rectangle() {{
	setWidth(40);
	setHeight(5);
	setTranslateX(-30);
	setTranslateY(23);
	setFill(Color.LIMEGREEN);
    }};
            
    private static Rectangle Bunker = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(30);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker2 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(100);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker3 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(170);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker4 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(240);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker5 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(310);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker6 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(380);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker7 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(450);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Bunker8 = new Rectangle() {{
	    setWidth(40);
	    setHeight(20);
	    setTranslateX(520);
	    setTranslateY(430);
	    setFill(Color.GREEN);
    }};

	   static Rectangle[] Aliens = {new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle()}; 
    
    //static Rectangle[] Bunker = {new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle(),new Rectangle()};

    /**
      setAliens sets the aliens to their starting positions and also resets them
      to those positions when the level is increased.
     */
    public static void setAliens(){
	try{
    for(int i = 0; i < 55; i++){
	int xPos = 30;
	int yPos = 50;
	int cntX = i;
	int cntY = i;
	switch(cntX % 11){
	case 10 : 
	    xPos += 40;
	    cntX--;
	case 9 : 
	    xPos += 40;
	    cntX--;
	case 8 : 
	    xPos += 40;
	    cntX--;
	case 7 : 
	    xPos += 40;
	    cntX--;
	case 6 : 
	    xPos += 40;
	    cntX--;
	case 5 : 
	    xPos += 40;
	    cntX--;
	case 4: 
	    xPos += 40;
	    cntX--;
	case 3:
	    xPos += 40;
	    cntX--;
	case 2:
	    xPos += 40;
	    cntX--;
	case 1:
	    xPos += 40;
	    cntX--;
	case 0:
	    break;
	}
	switch(cntY / 11){
	case 4:
	    yPos += 40;
	    cntY--;
	case 3:
	    yPos += 40;
	    cntY--;
	case 2:
	    yPos += 40;
	    cntY--;
	case 1:
	    yPos += 40;
	    cntY--;
	case 0:
	    break;
	}
	Aliens[i].setTranslateX(xPos);
	Aliens[i].setTranslateY(yPos);
	Aliens[i].setFill(Color.WHITE);
	Aliens[i].setHeight(20);
	Aliens[i].setWidth(20);
	Aliens[i].setVisible(true);
	Bunker.setVisible(true);
	Bunker2.setVisible(true);
	Bunker3.setVisible(true);
	Bunker4.setVisible(true);
	Bunker5.setVisible(true);
	Bunker6.setVisible(true);
	Bunker7.setVisible(true);
	Bunker8.setVisible(true);
    }
	}
	catch(Exception e){
	    System.out.println("!");
	}
    }


    private Rectangle bullet = new Rectangle() {{
	setWidth(5);
	setHeight(20);
	setTranslateX(30);
	setTranslateY(510);
	setFill(Color.WHITE);
    }};
    private Rectangle lazer = new Rectangle() {{
	setWidth(5);
	setHeight(20);
	setTranslateX(30);
	setTranslateY(510);
	setFill(Color.RED);
    }};
    
    int time = 0;
    Timer myTimer = new Timer();
    TimerTask timerTask = new TimerTask() {
	    public void run(){
		try{
	    
		    if(bullet.getTranslateY() <= 470){
			bullet.setTranslateY(bullet.getTranslateY() - 1);
		    }
		    if (bullet.getTranslateY() < -60 || time == 1){
			bullet.setTranslateY(510);
			bullet.setTranslateX(text.getTranslateX());       	 
		    }
		    //for(int i = 0; i < 55; i++){
		    if(lazer.getTranslateY() >= Aliens[rand].getTranslateY()){
			lazer.setTranslateY(lazer.getTranslateY() + .5);
			//System.out.print("|");
		    }
		    if (lazer.getTranslateY() > 500){
			lazer.setTranslateY(-20);
			//System.out.print("Y");
			
		    }
		    if(Mother.getTranslateX() > -40){
			Mother.setTranslateX(Mother.getTranslateX() + .2);
		    }
		    if(Mother.getTranslateX() > 640){
			Mother.setTranslateX(-40);
		    }
		  
		    //}
		    time = 0;
		     }catch(Exception e){
		    System.out.print("Timer Error ");
	    }
	    }
	} ;
    
    Timer myTimer2 = new Timer();
    TimerTask timerTask2 = new TimerTask() {
	        public void run(){
		try{

		    //these if statements set the movements for the aliens.
		    if(move > 0 && move < moveCount){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateX(Aliens[i].getTranslateX() + speed);
		    }
		   
			move = move + 1;
		    }
		    if(move == moveCount){
			for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateY(Aliens[i].getTranslateY() + 20);
			}
		
			move = move + 1;

		    }

		    if(move >= moveCount && move < (moveCount*2)){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateX(Aliens[i].getTranslateX() - speed);
		    }
		   
			move = move + 1;

		    }
		    if(move == (moveCount*2)){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateY(Aliens[i].getTranslateY() + 20);
		    }
		   
			move = 1;
			end ++;
			if(end == 5){
			    gameOver.setVisible(true);
			    text.setText("GAME OVER");
			    
			    System.out.println("GAME OVER");
			    System.exit(0);
			}
		    }
		    shoot = 0;
		}catch(Exception e){
		    System.out.print("!");
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
	    getSceneNodes().getChildren().addAll(bg, Mother, Aliens[0], Aliens[1], Aliens[2], Aliens[3], Aliens[4], Aliens[5], Aliens[6], Aliens[7], Aliens[8], Aliens[9], Aliens[10], Aliens[11], Aliens[12], Aliens[13], Aliens[14], Aliens[15], Aliens[16], Aliens[17], Aliens[18], Aliens[19], Aliens[20], Aliens[21], Aliens[22], Aliens[23], Aliens[24], Aliens[25], Aliens[26], Aliens[27], Aliens[28], Aliens[29], Aliens[30], Aliens[31], Aliens[32], Aliens[33], Aliens[34], Aliens[35], Aliens[36], Aliens[37], Aliens[38], Aliens[39], Aliens[40], Aliens[41], Aliens[42], Aliens[43], Aliens[44], Aliens[45], Aliens[46], Aliens[47], Aliens[48], Aliens[49], Aliens[50], Aliens[51], Aliens[52], Aliens[53], Aliens[54],  Bunker,Bunker2,Bunker3,Bunker4,Bunker5,Bunker6,Bunker7,Bunker8, score, health, timer, bullet, gameOver, text, lazer);
	    
	    }catch(Exception e){
	    System.out.print("!");
	    }
    } // TestGame
    
    @Override
    public void update(Game game, GameTime gameTime) {
	try{
	    while(initial == 0){
		myTimer.scheduleAtFixedRate(timerTask,1,1);
		myTimer2.scheduleAtFixedRate(timerTask2,1000,1000);
		initial = 1;
		setAliens();
	    }
	    if (initial == 1){
		if (level == 1){

		    initial = 2;
		}
		if (level == 2){
		    speed = 10;
		    moveCount = 10;
		    System.out.println("level 2");

		    initial = 2;
		}
		if (level == 3){
		    speed = 20;
		    moveCount = 5;
		    initial = 2;
		}
		
		
	    }
	    if(kills == 550){
		System.out.println("YOU WIN");
		setAliens();
		move = 1;
		initial = 1;       //if the player kills all the aliens then
 		kills = 0;         //the levels and lives increases and the 
      		level++;           //aliens are reset.
		lives++;
	    }
		
	    health.setText("Lives: " + lives + "Level: " + level);
	    score.setText("Score: "+ (kills + mom));
	    timer.setText("Time: " + (gameTime.getTotalGameTime()));
	    text.setText("/o/|^|\\o\\");//"Time: " + (gameTime.getTotalGameTime()));
	    //if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 15);
	    //if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 15);
	    if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && text.getTranslateX() > 10) text.setTranslateX(text.getTranslateX() - 4);
	    if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT) && text.getTranslateX() < 500) text.setTranslateX(text.getTranslateX() + 4);
	    if (game.getKeyManager().isKeyPressed(KeyCode.SPACE) && bullet.getTranslateY() == 510){
		bullet.setTranslateY(470);
		bullet.setTranslateX(text.getTranslateX() + 21);      	 
	       
	    }
	    if (bullet.getTranslateY() < 0){
		//	    bullet.setTranslateY(bullet.getTranslateY() + 480);
	    }
	    //these statements are for when a players bullet hits an alien
	    for(int i = 0; i < 55; i++){
		if(bullet.getTranslateY() > Aliens[i].getTranslateY() && bullet.getTranslateY() < Aliens[i].getTranslateY() + 20 && bullet.getTranslateX() > Aliens[i].getTranslateX() && bullet.getTranslateX() < Aliens[i].getTranslateX() + 20 && Aliens[i].isVisible()){
		    Aliens[i].setVisible(false); 
		    time = 1;
		    System.out.println("PCHCHCWWWOOW");
		    kills = kills + 10;
		}
	    }
	    //when the player hits the mother ship.
	    if(bullet.getTranslateY() > Mother.getTranslateY() && bullet.getTranslateY() < Mother.getTranslateY() + 20 && bullet.getTranslateX() > Mother.getTranslateX() && bullet.getTranslateX() < Mother.getTranslateX() + 20 && Mother.isVisible()){
		
		Mother.setTranslateX(-40);
		System.out.println("BOOM");
		mom = mom + 100;
	    }
	    
	    
	    
	    //sets the aliens to fire randomly
	    rand = (int)(55 * Math.random());
	    if (Aliens[rand].isVisible() && (move % 2 == 0) && shoot == 0){
		lazer.setTranslateX(Aliens[rand].getTranslateX());
		lazer.setTranslateY(Aliens[rand].getTranslateY());
		System.out.println("Lazer Fired");
		shoot = 1;
		if(rand % 5 == 0){
		    Mother.setTranslateX(-39);
		}
	    } 
	    //detects if the aliens lazer hits the player or a bunker
	    for(int i = 0; i < 55; i++){
		if(lazer.getTranslateY() > text.getTranslateY() && lazer.getTranslateY() < text.getTranslateY() + 40 && lazer.getTranslateX() > text.getTranslateX() && lazer.getTranslateX() < text.getTranslateX() + 40){
		    System.out.println("Life Lost!");
		    lazer.setTranslateY(-20);
		    lives = lives - 1;
		    if (lives == 0){
			gameOver.setVisible(true);
			text.setText("GAME OVER");
			System.exit(0);
		    }
		}
	    }
	    

	    if(bullet.getTranslateY() > Bunker.getTranslateY() && bullet.getTranslateY() < Bunker.getTranslateY() + 40 && bullet.getTranslateX() > Bunker.getTranslateX() && bullet.getTranslateX() < Bunker.getTranslateX() + 40 && Bunker.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker2.getTranslateY() && bullet.getTranslateY() < Bunker2.getTranslateY() + 40 && bullet.getTranslateX() > Bunker2.getTranslateX() && bullet.getTranslateX() < Bunker2.getTranslateX() + 40 && Bunker2.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker2.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker3.getTranslateY() && bullet.getTranslateY() < Bunker3.getTranslateY() + 40 && bullet.getTranslateX() > Bunker3.getTranslateX() && bullet.getTranslateX() < Bunker3.getTranslateX() + 40 && Bunker3.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker3.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker4.getTranslateY() && bullet.getTranslateY() < Bunker4.getTranslateY() + 40 && bullet.getTranslateX() > Bunker4.getTranslateX() && bullet.getTranslateX() < Bunker4.getTranslateX() + 40 && Bunker4.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker4.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker5.getTranslateY() && bullet.getTranslateY() < Bunker5.getTranslateY() + 40 && bullet.getTranslateX() > Bunker5.getTranslateX() && bullet.getTranslateX() < Bunker5.getTranslateX() + 40 && Bunker5.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker5.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker6.getTranslateY() && bullet.getTranslateY() < Bunker6.getTranslateY() + 40 && bullet.getTranslateX() > Bunker6.getTranslateX() && bullet.getTranslateX() < Bunker6.getTranslateX() + 40 && Bunker6.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker6.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker7.getTranslateY() && bullet.getTranslateY() < Bunker7.getTranslateY() + 40 && bullet.getTranslateX() > Bunker7.getTranslateX() && bullet.getTranslateX() < Bunker7.getTranslateX() + 40 && Bunker7.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker7.setVisible(false);
	    }
	    if(bullet.getTranslateY() > Bunker8.getTranslateY() && bullet.getTranslateY() < Bunker8.getTranslateY() + 40 && bullet.getTranslateX() > Bunker8.getTranslateX() && bullet.getTranslateX() < Bunker8.getTranslateX() + 40 && Bunker8.isVisible() || lazer.getTranslateY() > Bunker.getTranslateY() && lazer.getTranslateY() < Bunker.getTranslateY() + 20 && lazer.getTranslateX() > Bunker.getTranslateX() && lazer.getTranslateX() < Bunker.getTranslateX() + 40){
		Bunker8.setVisible(false);
	    }


	    
	    
	}
	
	
 	catch(Exception e){
 	    System.out.print("?");
 	}
	
	
    } // update
} // TestGame





  