//Imports
import greenfoot.*;  

/**
 * Value Screen World
 * <p>
 * Displays the image of the value screen, and multiple buttons / selections for game options.
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class ValueSetting extends World
{

    //Instance varuables
    private Button LLU, LRU, LLS, LRS;
    private Button RLU, RRU, RLS, RRS;  
    private Button LT, RT, LD, RD;
    private Button menu, start, defaults;

    private int LUP = 0, RUP = 0,  LSM = 200, RSM = 200;
    private int time = 90;
    private boolean difficulty = false;

    private GreenfootImage background2, whiteRect;
    private String LUPstr, RUPstr, LISstr, RISstr;

    private GreenfootSound Valuemusic;

    /**
     * Constructor for objects of class ValueSetting.
     * <p> 
     * Pregenerates buttons for all game settings.
     * 
     */
    public ValueSetting()
    {    
        // Create a new world of 1024 x 800
        super(1024, 800, 1);

        //Set background image
        background2 = new GreenfootImage("ValueScreen.png");
        background2.scale(1024,800);
        setBackground(background2);

        //Set background music
        Valuemusic = new GreenfootSound("ValueScreen.mp3");
        Valuemusic.setVolume(30);
        Valuemusic.playLoop();

        //Generates a left and right button template to be copied
        GreenfootImage left = new GreenfootImage("LeftButton.png");
        left.scale(left.getWidth()/3, left.getHeight()/3);
        GreenfootImage leftHover = new GreenfootImage("HOVERLEFT.png");
        leftHover.scale(leftHover.getWidth()/3, leftHover.getHeight()/3);

        GreenfootImage right = new GreenfootImage("RightButton.png");
        right.scale(right.getWidth()/3, right.getHeight()/3);
        GreenfootImage rightHover = new GreenfootImage("HOVERRIGHT.png");
        rightHover.scale(rightHover.getWidth()/3, rightHover.getHeight()/3);

        //A white rectangle, used to cover up text before drawing new text
        whiteRect = new GreenfootImage(200, 30);
        whiteRect.setColor(Color.WHITE);
        whiteRect.fill();

        //left side, left buttons
        LLU = new Button(left, leftHover);
        addObject(LLU, 60, 300); 

        LLS = new Button(left, leftHover);
        addObject(LLS, 60, 420); 

        //left side, right buttons
        LRU = new Button(right, rightHover);
        addObject(LRU, 410, 300); 

        LRS = new Button(right, rightHover);
        addObject(LRS, 410, 420); 

        //right side, left buttons
        RLU = new Button(left, leftHover);
        addObject(RLU, 610, 300); 

        RLS = new Button(left, leftHover);
        addObject(RLS, 610, 420); 

        //right side, right buttons
        RRU = new Button(right, rightHover);
        addObject(RRU, 960, 300); 

        RRS = new Button(right, rightHover);
        addObject(RRS, 960, 420); 

        //bottom buttons
        LT = new Button(left, leftHover);
        addObject(LT, 330, 520); 
        LD = new Button(left, leftHover);
        addObject(LD, 330, 620); 

        RT = new Button(right, rightHover);
        addObject(RT, 675, 520); 
        RD = new Button(right, rightHover);
        addObject(RD, 675, 620); 

        //Option buttons
        GreenfootImage startImg = new GreenfootImage("StartGame.png");
        startImg.scale(startImg.getWidth() / 3, startImg.getHeight() / 3);
        start = new Button(startImg, startImg);
        addObject(start, 860, 650);

        GreenfootImage defaultImg = new GreenfootImage("Default.png");
        defaultImg.scale(defaultImg.getWidth() / 3, defaultImg.getHeight() / 3);
        defaults = new Button(defaultImg, defaultImg);
        addObject(defaults, 160, 730);

        GreenfootImage menuImg = new GreenfootImage("Menu.png");
        menuImg.scale(menuImg.getWidth() / 3, menuImg.getHeight() / 3);
        menu = new Button(menuImg, menuImg);
        addObject(menu, 160, 650);
    }

    /**
     * Started() method - used for playing music in a loop
     */
    public void started(){
        Valuemusic.playLoop();
    }
    /**
     * Stopped() method - stops music if the world is stopped
     */
    public void stopped(){
        Valuemusic.stop();
    }
    /**
     * Act Method for ValueSetting - Checks to see if buttons are toggled/pressed or not. 
     * <p>
     * For the left and right side, there are buttons for UpgradePriority and Starting Money. The act method first checks 
     * both of those buttons on each side. Each button has a limit. For displaying text on the buttons, the value setting 
     * screen is an image with empty spaces where text can be written on top of. There are also buttons that apply 
     * to both sides, one for the time/duration of the event, one for the difficulty. 
     * Finally, buttons for setting default values, starting the game, and returning to the Menu are also checked. 
     */
    public void act(){

        //Buttons for the left side
        //Each button has specific limits
        //Text/Numbers is first drawn over by WhiteRect, then drawn, to prevent overlapping with previous texts
        //Left side, buttons for Upgrade Priority
        if (LLU.listenForClick()){
            LUP--; 
        } else if (LRU.listenForClick()){
            LUP++; 
        }

        if (LUP > 2){
            LUP = 2;
        } else if (LUP < 0){
            LUP = 0;
        }

        if (LUP == 0){
            LUPstr = "Random";
        } else if (LUP == 1){
            LUPstr = "Workers";
        } else if (LUP == 2){
            LUPstr = "Machines";
        }

        GreenfootImage LUPtext = new GreenfootImage(LUPstr, 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 125, 289);
        background2.drawImage(LUPtext, 190, 289);

        //Left side, buttons for Starting money
        if (LLS.listenForClick()){
            LSM-=100; 
        } else if (LRS.listenForClick()){
            LSM+=100; 
        }

        if (LSM > 1000){
            LSM = 1000;
        } else if (LSM < 200){
            LSM = 200;
        }

        GreenfootImage LSMtext = new GreenfootImage(Integer.toString(LSM), 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 125, 406);
        background2.drawImage(LSMtext, 210, 406);

        //Buttons for the right side
        //Right side, buttons for Upgrade Priority
        if (RLU.listenForClick()){
            RUP--; 
        } else if (RRU.listenForClick()){
            RUP++; 
        }

        if (RUP > 2){
            RUP = 2;
        } else if (RUP < 0){
            RUP = 0;
        }

        if (RUP == 0){
            RUPstr = "Random";
        } else if (RUP == 1){
            RUPstr = "Workers";
        } else if (RUP == 2){
            RUPstr = "Machines";
        }

        GreenfootImage RUPtext = new GreenfootImage(RUPstr, 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 700, 289);
        background2.drawImage(RUPtext, 750, 289);

        //Right side, buttons for Starting Money
        if (RLS.listenForClick()){
            RSM -= 100; 
        } else if (RRS.listenForClick()){
            RSM += 100; 
        }

        if (RSM > 1000){
            RSM = 1000;
        } else if (RSM < 200){
            RSM = 200;
        }

        GreenfootImage RSMtext = new GreenfootImage(Integer.toString(RSM), 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 700, 406);
        background2.drawImage(RSMtext, 770, 406);

        
        //Buttons for time, and for difficulty
        if (LT.listenForClick()){
            time -= 30; 
        } else if (RT.listenForClick()){
            time += 30; 
        }

        if (time > 120){
            time = 120;
        } else if (time < 60){
            time = 60;
        }

        GreenfootImage TIMEtext = new GreenfootImage(Integer.toString(time) + " Seconds", 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 400, 505);
        background2.drawImage(TIMEtext, 440, 505);

        if (LD.listenForClick() || RD.listenForClick()){
            if(difficulty) difficulty = false;
            else if(!difficulty) difficulty = true;
        } 

        GreenfootImage Difftext;
        if (difficulty){
            Difftext = new GreenfootImage("Hard Difficulty", 30, Color.BLACK, Color.WHITE);
        } else {
            Difftext = new GreenfootImage("Easy Difficulty", 30, Color.BLACK, Color.WHITE);
        }

        background2.drawImage(whiteRect, 400, 605);
        background2.drawImage(Difftext, 425, 605);

        //Checks if main buttons are clicked
        //Start button sends parameters, and starts the game
        if (start.getClick()){
            Greenfoot.setWorld(new GameWorld(LUP, RUP, LSM, RSM, time, difficulty));
            stopped();
        }
        //Default button resets all options to default settings
        if (defaults.getClick()){
            LUP = 0; RUP = 0;

            LSM = 0; RSM = 0;
            time = 90;
            difficulty = false;

        }
        //Menu button returns to Main Menu
        if (menu.getClick()){
            stopped();
            Greenfoot.setWorld(new Menu());
        }
    }

}
