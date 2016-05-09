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
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};

    // some text to display the time


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
	setTranslateX(30);
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
			lazer.setTranslateY(lazer.getTranslateY() + 1);
			//System.out.print("|");
		    }
		    if (lazer.getTranslateY() > 500){
			lazer.setTranslateY(-20);
			//System.out.print("Y");
			
		    }
		    //}
		    time = 0;
		     }catch(Exception e){
		    System.out.print("Timer Error ");
	    }
	    }
	} ;
    
    Timer myTimer2 = new Timer();
    Timer myTimer3 = new Timer();
    Timer myTimer4 = new Timer();
    Timer myTimer5 = new Timer();
    Timer myTimer6 = new Timer();
    Timer myTimer7 = new Timer();
    Timer myTimer8 = new Timer();
    TimerTask timerTask2 = new TimerTask() {
	        public void run(){
		try{

		  
		    if(move > 0 && move < 10){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateX(Aliens[i].getTranslateX() + 10);
		    }
		    /*
			Alien2.setTranslateX(Alien2.getTranslateX() + 10);
			Alien3.setTranslateX(Alien3.getTranslateX() + 10);
			Alien4.setTranslateX(Alien4.getTranslateX() + 10);
			Alien5.setTranslateX(Alien5.getTranslateX() + 10);
			Alien6.setTranslateX(Alien6.getTranslateX() + 10);
			Alien7.setTranslateX(Alien7.getTranslateX() + 10);
			Alien8.setTranslateX(Alien8.getTranslateX() + 10);
			Alien9.setTranslateX(Alien9.getTranslateX() + 10);
			Alien10.setTranslateX(Alien10.getTranslateX() + 10);
			Alien11.setTranslateX(Alien11.getTranslateX() + 10);
			Alien12.setTranslateX(Alien12.getTranslateX() + 10);
			
			
			Alien13.setTranslateX(Alien13.getTranslateX() + 10);
			Alien14.setTranslateX(Alien14.getTranslateX() + 10);
			Alien15.setTranslateX(Alien15.getTranslateX() + 10);
			Alien16.setTranslateX(Alien16.getTranslateX() + 10);
			Alien17.setTranslateX(Alien17.getTranslateX() + 10);
			Alien18.setTranslateX(Alien18.getTranslateX() + 10);
			Alien19.setTranslateX(Alien19.getTranslateX() + 10);
			Alien20.setTranslateX(Alien20.getTranslateX() + 10);
			Alien21.setTranslateX(Alien21.getTranslateX() + 10);
			Alien22.setTranslateX(Alien22.getTranslateX() + 10);
			Alien23.setTranslateX(Alien23.getTranslateX() + 10);
			Alien24.setTranslateX(Alien24.getTranslateX() + 10);
		    */
			move = move + 1;
		    }
		    if(move == 10){
			for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateY(Aliens[i].getTranslateY() + 20);
			}
			/*
			Alien2.setTranslateY(Alien2.getTranslateY() + 20);
			Alien3.setTranslateY(Alien3.getTranslateY() + 20);
			Alien4.setTranslateY(Alien4.getTranslateY() + 20);
			Alien5.setTranslateY(Alien5.getTranslateY() + 20);
			Alien6.setTranslateY(Alien6.getTranslateY() + 20);
			Alien7.setTranslateY(Alien7.getTranslateY() + 20);
			Alien8.setTranslateY(Alien8.getTranslateY() + 20);
			Alien9.setTranslateY(Alien9.getTranslateY() + 20);
			Alien10.setTranslateY(Alien10.getTranslateY() + 20);
			Alien11.setTranslateY(Alien11.getTranslateY() + 20);
			Alien12.setTranslateY(Alien12.getTranslateY() + 20);
			
			
			Alien13.setTranslateY(Alien13.getTranslateY() + 20);
			Alien14.setTranslateY(Alien14.getTranslateY() + 20);
			Alien15.setTranslateY(Alien15.getTranslateY() + 20);
			Alien16.setTranslateY(Alien16.getTranslateY() + 20);
			Alien17.setTranslateY(Alien17.getTranslateY() + 20);
			Alien18.setTranslateY(Alien18.getTranslateY() + 20);
			Alien19.setTranslateY(Alien19.getTranslateY() + 20);
			Alien20.setTranslateY(Alien20.getTranslateY() + 20);
			Alien21.setTranslateY(Alien21.getTranslateY() + 20);
			Alien22.setTranslateY(Alien22.getTranslateY() + 20);
			Alien23.setTranslateY(Alien23.getTranslateY() + 20);
			Alien24.setTranslateY(Alien24.getTranslateY() + 20);
			*/
			move = move + 1;

		    }

		    if(move >=10 && move < 20){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateX(Aliens[i].getTranslateX() - 10);
		    }
		    /*
			Alien2.setTranslateX(Alien2.getTranslateX() - 10);
			Alien3.setTranslateX(Alien3.getTranslateX() - 10);
			Alien4.setTranslateX(Alien4.getTranslateX() - 10);
			Alien5.setTranslateX(Alien5.getTranslateX() - 10);
			Alien6.setTranslateX(Alien6.getTranslateX() - 10);
			Alien7.setTranslateX(Alien7.getTranslateX() - 10);
			Alien8.setTranslateX(Alien8.getTranslateX() - 10);
			Alien9.setTranslateX(Alien9.getTranslateX() - 10);
			Alien10.setTranslateX(Alien10.getTranslateX() - 10);
			Alien11.setTranslateX(Alien11.getTranslateX() - 10);
			Alien12.setTranslateX(Alien12.getTranslateX() - 10);
			
			
			Alien13.setTranslateX(Alien13.getTranslateX() - 10);
			Alien14.setTranslateX(Alien14.getTranslateX() - 10);
			Alien15.setTranslateX(Alien15.getTranslateX() - 10);
			Alien16.setTranslateX(Alien16.getTranslateX() - 10);
			Alien17.setTranslateX(Alien17.getTranslateX() - 10);
			Alien18.setTranslateX(Alien18.getTranslateX() - 10);
			Alien19.setTranslateX(Alien19.getTranslateX() - 10);
			Alien20.setTranslateX(Alien20.getTranslateX() - 10);
			Alien21.setTranslateX(Alien21.getTranslateX() - 10);
			Alien22.setTranslateX(Alien22.getTranslateX() - 10);
			Alien23.setTranslateX(Alien23.getTranslateX() - 10);
			Alien24.setTranslateX(Alien24.getTranslateX() - 10);
		    */
			move = move + 1;

		    }
		    if(move == 20){
		    for(int i = 0; i < 55; i++){
			Aliens[i].setTranslateY(Aliens[i].getTranslateY() + 20);
		    }
		    /*
			Alien2.setTranslateY(Alien2.getTranslateY() + 20);
			Alien3.setTranslateY(Alien3.getTranslateY() + 20);
			Alien4.setTranslateY(Alien4.getTranslateY() + 20);
			Alien5.setTranslateY(Alien5.getTranslateY() + 20);
			Alien6.setTranslateY(Alien6.getTranslateY() + 20);
			Alien7.setTranslateY(Alien7.getTranslateY() + 20);
			Alien8.setTranslateY(Alien8.getTranslateY() + 20);
			Alien9.setTranslateY(Alien9.getTranslateY() + 20);
			Alien10.setTranslateY(Alien10.getTranslateY() + 20);
			Alien11.setTranslateY(Alien11.getTranslateY() + 20);
			Alien12.setTranslateY(Alien12.getTranslateY() + 20);
			
			
			Alien13.setTranslateY(Alien13.getTranslateY() + 20);
			Alien14.setTranslateY(Alien14.getTranslateY() + 20);
			Alien15.setTranslateY(Alien15.getTranslateY() + 20);
			Alien16.setTranslateY(Alien16.getTranslateY() + 20);
			Alien17.setTranslateY(Alien17.getTranslateY() + 20);
			Alien18.setTranslateY(Alien18.getTranslateY() + 20);
			Alien19.setTranslateY(Alien19.getTranslateY() + 20);
			Alien20.setTranslateY(Alien20.getTranslateY() + 20);
			Alien21.setTranslateY(Alien21.getTranslateY() + 20);
			Alien22.setTranslateY(Alien22.getTranslateY() + 20);
			Alien23.setTranslateY(Alien23.getTranslateY() + 20);
			Alien24.setTranslateY(Alien24.getTranslateY() + 20);
		    */
			move = 1;
			end ++;
			if(end == 5){
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
	    getSceneNodes().getChildren().addAll(bg, Mother, Aliens[0], Aliens[1], Aliens[2], Aliens[3], Aliens[4], Aliens[5], Aliens[6], Aliens[7], Aliens[8], Aliens[9], Aliens[10], Aliens[11], Aliens[12], Aliens[13], Aliens[14], Aliens[15], Aliens[16], Aliens[17], Aliens[18], Aliens[19], Aliens[20], Aliens[21], Aliens[22], Aliens[23], Aliens[24], Aliens[25], Aliens[26], Aliens[27], Aliens[28], Aliens[29], Aliens[30], Aliens[31], Aliens[32], Aliens[33], Aliens[34], Aliens[35], Aliens[36], Aliens[37], Aliens[38], Aliens[39], Aliens[40], Aliens[41], Aliens[42], Aliens[43], Aliens[44], Aliens[45], Aliens[46], Aliens[47], Aliens[48], Aliens[49], Aliens[50], Aliens[51], Aliens[52], Aliens[53], Aliens[54],  Bunker,Bunker2,Bunker3,Bunker4,Bunker5,Bunker6,Bunker7,Bunker8, score, health, timer, bullet, text);
	    
	    }catch(Exception e){
	    System.out.print("!");
	    }
    } // TestGame
    
    @Override
    public void update(Game game, GameTime gameTime) {
	try{
	    while(initial == 0){
		myTimer.scheduleAtFixedRate(timerTask,1,1);
		initial = 1;
		setAliens();
	    }
	    while (initial == 1){
		if (level == 1){ 
		    myTimer2.scheduleAtFixedRate(timerTask2,1000,1000);
		    initial = 2;
		}
		if (level == 2){ 
		    myTimer3.scheduleAtFixedRate(timerTask2,1000,60);
		    initial = 2;
		}
		if (level == 3){ 
		    myTimer4.scheduleAtFixedRate(timerTask2,1000,200);
		    initial = 2;
		}
		if (level == 4){ 
		    myTimer5.scheduleAtFixedRate(timerTask2,1000,100);
		    initial = 2;
		}
		if (level == 5){ 
		    myTimer6.scheduleAtFixedRate(timerTask2,1000,50);
		    initial = 2;
		}
		if (level == 6){ 
		    myTimer7.scheduleAtFixedRate(timerTask2,1000,40);
		    initial = 2;
		}
		if (level == 7){ 
		    myTimer8.scheduleAtFixedRate(timerTask2,1000,30);
		    initial = 2;
		}
	    }
	    if(kills == 550){
		System.out.println("YOU WIN");
		setAliens();
		move = 1;
		initial = 1;
		kills = 0;
		if (level != 7){
			level = level + 1;
			lives = lives +1;
			
		}	
		if (level == 7){
		    level = 1;
		}
	    }
		
	    health.setText("Lives: " + lives);
	    score.setText("Score: "+ kills);
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
	    for(int i = 0; i < 55; i++){
		if(bullet.getTranslateY() > Aliens[i].getTranslateY() && bullet.getTranslateY() < Aliens[i].getTranslateY() + 20 && bullet.getTranslateX() > Aliens[i].getTranslateX() && bullet.getTranslateX() < Aliens[i].getTranslateX() + 20 && Aliens[i].isVisible()){
		    Aliens[i].setVisible(false); 
		    //Aliens[i].setTranslateX(1000);
		    //Aliens[i].setTranslateY(1000);
		    time = 1;
		    System.out.println("PCHCHCWWWOOW");
		    kills = kills + 10;
		}
	    }
	    
	    

	    rand = (int)(55 * Math.random());
	    if (Aliens[rand].isVisible() && (move % 2 == 0) && shoot == 0){
		lazer.setTranslateX(Aliens[rand].getTranslateX());
		lazer.setTranslateY(Aliens[rand].getTranslateY());
		System.out.println("Lazer Fired");
		shoot = 1;
	    } 
	    
	    for(int i = 0; i < 55; i++){
		if(lazer.getTranslateY() > text.getTranslateY() && lazer.getTranslateY() < text.getTranslateY() + 40 && lazer.getTranslateX() > text.getTranslateX() && lazer.getTranslateX() < text.getTranslateX() + 40){
		    System.out.println("Life Lost!");
		    lazer.setTranslateY(-20);
		    lives = lives - 1;
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
	    System.out.print("!");
	}	    
    
    } // update
} // TestGame





    /*
    private static Rectangle Alien9 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(110);
	    setTranslateY(90);
	    setFill(Color.YELLOW);
    }};
    private static Rectangle Alien10 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(150);
	    setTranslateY(90);
	    setFill(Color.YELLOW);
    }};
    private static Rectangle Alien11 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(190);
	    setTranslateY(90);
	    setFill(Color.YELLOW);
    }};
    private static Rectangle Alien12 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(230);
	    setTranslateY(90);
	    setFill(Color.YELLOW);
    }};




    private static Rectangle Alien13 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(30);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien14 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(70);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien15 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(110);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien16 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(150);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien17 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(190);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien18 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(230);
	    setTranslateY(130);
	    setFill(Color.GREEN);
    }};
    private static Rectangle Alien19 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(30);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    private static Rectangle Alien20 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(70);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    private static Rectangle Alien21 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(110);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    private static Rectangle Alien22 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(150);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    private static Rectangle Alien23 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(190);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    private static Rectangle Alien24 = new Rectangle() {{
	    setWidth(20);
	    setHeight(20);
	    setTranslateX(230);
	    setTranslateY(170);
	    setFill(Color.WHITE);
    }};
    */    
    //String[] Alienz = new String[]{ "Alien","Alien2","Alien3","Alien4","Alien5","Alien6","Alien7","Alien8","Alien9","Alien10","Alien11","Alien12","Alien13","Alien14","Alien15","Alien16","Alien17","Alien18","Alien19","Alien20","Alien21","Alien22","Alien23","Alien24","Alien25","Alien26","Alien27","Alien28","Alien29","Alien30","Alien31","Alien32","Alien33","Alien34","Alien35","Alien36","Alien37","Alien38","Alien39","Alien40","Alien41","Alien42","Alien43","Alien44","Alien45","Alien46","Alien47","Alien48","Alien49","Alien50","Alien51","Alien52","Alien53","Alien54","Alien55" };




	    /*    

	    if(bullet.getTranslateY() > Alien9.getTranslateY() && bullet.getTranslateY() < Alien9.getTranslateY() + 20 && bullet.getTranslateX() > Alien9.getTranslateX() && bullet.getTranslateX() < Alien9.getTranslateX() + 20){
		Alien9.setTranslateX(1000);
		Alien9.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 300;
	    }
	    if(bullet.getTranslateY() > Alien10.getTranslateY() && bullet.getTranslateY() < Alien10.getTranslateY() + 20 && bullet.getTranslateX() > Alien10.getTranslateX() && bullet.getTranslateX() < Alien10.getTranslateX() + 20){
		Alien10.setTranslateX(1000);
		Alien10.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 300;
	    }
	    if(bullet.getTranslateY() > Alien11.getTranslateY() && bullet.getTranslateY() < Alien11.getTranslateY() + 20 && bullet.getTranslateX() > Alien11.getTranslateX() && bullet.getTranslateX() < Alien11.getTranslateX() + 20){
		Alien11.setTranslateX(1000);
		Alien11.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 300;
	    }
	    if(bullet.getTranslateY() > Alien12.getTranslateY() && bullet.getTranslateY() < Alien12.getTranslateY() + 20 && bullet.getTranslateX() > Alien12.getTranslateX() && bullet.getTranslateX() < Alien12.getTranslateX() + 20){
		Alien12.setTranslateX(1000);
		Alien12.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 300;
	    }







	    if(bullet.getTranslateY() > Alien13.getTranslateY() && bullet.getTranslateY() < Alien13.getTranslateY() + 20 && bullet.getTranslateX() > Alien13.getTranslateX() && bullet.getTranslateX() < Alien13.getTranslateX() + 20){
		Alien13.setTranslateX(1000);
		Alien13.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 200;
	    }
	    if(bullet.getTranslateY() > Alien14.getTranslateY() && bullet.getTranslateY() < Alien14.getTranslateY() + 20 && bullet.getTranslateX() > Alien14.getTranslateX() && bullet.getTranslateX() < Alien14.getTranslateX() + 20){
		Alien14.setTranslateX(1000);
		Alien14.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 200;
	    }
	    if(bullet.getTranslateY() > Alien15.getTranslateY() && bullet.getTranslateY() < Alien15.getTranslateY() + 20 && bullet.getTranslateX() > Alien15.getTranslateX() && bullet.getTranslateX() < Alien15.getTranslateX() + 20){
		Alien15.setTranslateX(1000);
		Alien15.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 200;
	    }

	    if(bullet.getTranslateY() > Alien16.getTranslateY() && bullet.getTranslateY() < Alien16.getTranslateY() + 20 && bullet.getTranslateX() > Alien16.getTranslateX() && bullet.getTranslateX() < Alien16.getTranslateX() + 20){
		Alien16.setTranslateX(1000);
		Alien16.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 200;
	    }
	    if(bullet.getTranslateY() > Alien17.getTranslateY() && bullet.getTranslateY() < Alien17.getTranslateY() + 20 && bullet.getTranslateX() > Alien17.getTranslateX() && bullet.getTranslateX() < Alien17.getTranslateX() + 20){
		Alien17.setTranslateX(1000);
		Alien17.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 200;
	    }
	    if(bullet.getTranslateY() > Alien18.getTranslateY() && bullet.getTranslateY() < Alien18.getTranslateY() + 20 && bullet.getTranslateX() > Alien18.getTranslateX() && bullet.getTranslateX() < Alien18.getTranslateX() + 20){
		Alien18.setTranslateX(1000);
		Alien18.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien19.getTranslateY() && bullet.getTranslateY() < Alien19.getTranslateY() + 20 && bullet.getTranslateX() > Alien19.getTranslateX() && bullet.getTranslateX() < Alien19.getTranslateX() + 20){
		Alien19.setTranslateX(1000);
		Alien19.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien20.getTranslateY() && bullet.getTranslateY() < Alien20.getTranslateY() + 20 && bullet.getTranslateX() > Alien20.getTranslateX() && bullet.getTranslateX() < Alien20.getTranslateX() + 20){
		Alien20.setTranslateX(1000);
		Alien20.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien21.getTranslateY() && bullet.getTranslateY() < Alien21.getTranslateY() + 20 && bullet.getTranslateX() > Alien21.getTranslateX() && bullet.getTranslateX() < Alien21.getTranslateX() + 20){
		Alien21.setTranslateX(1000);
		Alien21.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien22.getTranslateY() && bullet.getTranslateY() < Alien22.getTranslateY() + 20 && bullet.getTranslateX() > Alien22.getTranslateX() && bullet.getTranslateX() < Alien22.getTranslateX() + 20){
		Alien22.setTranslateX(1000);
		Alien22.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien23.getTranslateY() && bullet.getTranslateY() < Alien23.getTranslateY() + 20 && bullet.getTranslateX() > Alien23.getTranslateX() && bullet.getTranslateX() < Alien23.getTranslateX() + 20){
		Alien23.setTranslateX(1000);
		Alien23.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }
	    if(bullet.getTranslateY() > Alien24.getTranslateY() && bullet.getTranslateY() < Alien24.getTranslateY() + 20 && bullet.getTranslateX() > Alien24.getTranslateX() && bullet.getTranslateX() < Alien24.getTranslateX() + 20){
		Alien24.setTranslateX(1000);
		Alien24.setTranslateY(1000);
		time = 1;
		System.out.println("PCHCHCWWWOOW");
		kills = kills + 100;
	    }

*/