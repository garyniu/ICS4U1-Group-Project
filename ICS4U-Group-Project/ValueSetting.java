import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ValueSetting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValueSetting extends World
{

    private Button LLU, LRU, LLI, LRI, LLS, LRS;
    private Button RLU, RRU, RLI, RRI, RLS, RRS;  
    private Button LT, RT, LD, RD;
    private Button menu, start, defaults;

    private int LUP = 0, RUP = 0, LIS = 0, RIS = 0, LSM = 200, RSM = 200;
    private int time = 90;
    private boolean difficulty = false;

    private GreenfootImage background2, whiteRect;
    private String LUPstr, RUPstr, LISstr, RISstr;

    /**
     * Constructor for objects of class ValueSetting.
     * 
     */
    public ValueSetting()
    {    

        super(1024, 800, 1);
        background2 = new GreenfootImage("ValueScreen.png");
        background2.scale(1024,800);
        setBackground(background2);

        GreenfootImage left = new GreenfootImage("LeftButton.png");
        left.scale(left.getWidth()/3, left.getHeight()/3);
        GreenfootImage leftHover = new GreenfootImage("HOVERLEFT.png");
        leftHover.scale(leftHover.getWidth()/3, leftHover.getHeight()/3);

        GreenfootImage right = new GreenfootImage("RightButton.png");
        right.scale(right.getWidth()/3, right.getHeight()/3);
        GreenfootImage rightHover = new GreenfootImage("HOVERRIGHT.png");
        rightHover.scale(rightHover.getWidth()/3, rightHover.getHeight()/3);

        whiteRect = new GreenfootImage(200, 30);
        whiteRect.setColor(Color.WHITE);
        whiteRect.fill();

        //left side, left buttons
        LLU = new Button(left, leftHover);
        addObject(LLU, 60, 300); 

        LLI = new Button(left, leftHover);
        addObject(LLI, 60, 410); 

        LLS = new Button(left, leftHover);
        addObject(LLS, 60, 520); 

        //left side, right buttons
        LRU = new Button(right, rightHover);
        addObject(LRU, 410, 300); 

        LRI = new Button(right, rightHover);
        addObject(LRI, 410, 410); 

        LRS = new Button(right, rightHover);
        addObject(LRS, 410, 520); 

        //right side, left buttons
        RLU = new Button(left, leftHover);
        addObject(RLU, 610, 300); 

        RLI = new Button(left, leftHover);
        addObject(RLI, 610, 410); 

        RLS = new Button(left, leftHover);
        addObject(RLS, 610, 520); 

        //right side, right buttons
        RRU = new Button(right, rightHover);
        addObject(RRU, 960, 300); 

        RRI = new Button(right, rightHover);
        addObject(RRI, 960, 410); 

        RRS = new Button(right, rightHover);
        addObject(RRS, 960, 520); 

        //bottom buttons
        LT = new Button(left, leftHover);
        addObject(LT, 330, 635); 
        LD = new Button(left, leftHover);
        addObject(LD, 330, 735); 

        RT = new Button(right, rightHover);
        addObject(RT, 675, 635); 
        RD = new Button(right, rightHover);
        addObject(RD, 675, 735); 
        
        
        //Option buttons
        
        GreenfootImage startImg = new GreenfootImage("StartGame.png");
        startImg.scale(startImg.getWidth() / 3, startImg.getHeight() / 3);
        start = new Button(startImg, startImg);
        addObject(start, 860, 730);
        
        GreenfootImage defaultImg = new GreenfootImage("Default.png");
        defaultImg.scale(defaultImg.getWidth() / 3, defaultImg.getHeight() / 3);
        defaults = new Button(defaultImg, defaultImg);
        addObject(defaults, 160, 730);
        
        GreenfootImage menuImg = new GreenfootImage("Menu.png");
        menuImg.scale(menuImg.getWidth() / 3, menuImg.getHeight() / 3);
        menu = new Button(menuImg, menuImg);
        addObject(menu, 160, 650);
    }

    public void act(){

        //left side
        //left side
        //left side

        
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
        
        
        
        if (LLI.listenForClick()){
            LIS--;
        } else if (LRI.listenForClick()){
            LIS++;
        }
        
        if (LIS > 2){
            LIS = 2;
        } else if (LIS < 0){
            LIS = 0;
        }
        
        if (LIS == 0){
            LISstr = "Shoes";
        } else if (LIS == 1){
            LISstr = "Tools";
        } else if (LIS == 2){
            LISstr = "Phones";
        }

        GreenfootImage LIStext = new GreenfootImage(LISstr, 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 125, 389);
        background2.drawImage(LIStext, 190, 389);
        
        
        
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
        background2.drawImage(whiteRect, 125, 510);
        background2.drawImage(LSMtext, 210, 510);
        
        
        
        //right side
        //right side
        //right side
        
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
        
        
        if (RLI.listenForClick()){
            RIS--;
        } else if (RRI.listenForClick()){
            RIS++;
        }
        
        if (RIS > 2){
            RIS = 2;
        } else if (RIS < 0){
            RIS = 0;
        }
        
        if (RIS == 0){
            RISstr = "Shoes";
        } else if (RIS == 1){
            RISstr = "Tools";
        } else if (RIS == 2){
            RISstr = "Phones";
        }

        GreenfootImage RIStext = new GreenfootImage(RISstr, 30, Color.BLACK, Color.WHITE);
        background2.drawImage(whiteRect, 700, 389);
        background2.drawImage(RIStext, 750, 389);
        
        
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
        background2.drawImage(whiteRect, 700, 510);
        background2.drawImage(RSMtext, 770, 510);

        //base
        
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
        background2.drawImage(whiteRect, 400, 617);
        background2.drawImage(TIMEtext, 440, 617);
        
        
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
        
        background2.drawImage(whiteRect, 400, 717);
        background2.drawImage(Difftext, 425, 717);
        
        //buttons
        if (start.getClick()){
            Greenfoot.setWorld(new GameWorld());
            //Greenfoot.setWorld(new GameWorld(LUP, RUP, LIS, RIS, LSM, RSM, time, difficulty));
        }
        if (defaults.getClick()){
            LUP = 0; RUP = 0;
            LIS = 0; RIS = 0;
            LSM = 0; RSM = 0;
            time = 90;
            difficulty = false;
        }
        if (menu.getClick()){
            Greenfoot.setWorld(new Menu());
        }
    }

}
