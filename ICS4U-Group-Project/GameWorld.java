import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is our GameWorld, where our SweatShop simulation will take place. GameWorld is responsible for storing many base variables, and as a result, there are a lot of getters and setters
 *  used here. We hope you enjoy!
 *
 * @author Harishan Ganeshanathan, Gary Niu, Victor Wei, Arsham Zare Moayedi, Anthony Ung
 * @version November 2022
 */
public class GameWorld extends World
{

    private GreenfootImage background;
    private static int currencyA;
    private static int currencyB;
    private int counter;
    private int timer;
    private int maxTimer; 

    //booleans for preferences
    //0 = random, 1 = workers, 2 = machines
    private int upgradePrefA;
    private int upgradePrefB;

    private int itemChoiceA; //0=shoes, 1 = tools, 2 = phones
    private int itemChoiceB;
    
    private int LitemSold = 0, RitemSold = 0;

    private boolean activeEventA;
    private boolean activeEventB; 
    private boolean strikeStatusA;
    private boolean strikeStatusB;
    

    private boolean hardMode; //true = hard, false = easy

    private boolean L2M = false, L3M = false, R2M = false, R3M = false;

    private int LworkerCount = 1, RworkerCount = 1; 

    private boolean truckActive, spawnedLTwo = false, spawnedLThree = false; 
    private boolean spawnedRTwo = false, spawnedRThree = false;
    private static double itemValueA;
    private static double itemValueB; 
    private boolean shoeBoxed;
    
    private static double produceSpeedA;
    private static double produceSpeedB;
    

    private String winner; 
    private Boss a, b;
    
    private LeftMachines Lone, Ltwo, Lthree;
    private Rightmachines Rone, Rtwo, Rthree;
    
    private GreenfootSound backgroundmusic;
    private GreenfootSound ambience;
    private GreenfootSound upgrade;
    private double newSpeedLeft;
    private double newSpeedRight;
    private double slowSpeedLeft;
    private double slowSpeedRight;
    
    private double maxSpeed;
     
    /**
     * Constructor - sets Paint order, all variables, sounds, spawns initial machines, background, and adds truck
     * <p>
     * All parameters are fed into the Constructor from the ValueSetting screen
     * 
     * @param LUP - Upgrade Priority for left side
     * @param RUP - Upgrade Priority for right side
     * @param LSM - Starting Money Amount for left side
     * @param RSM - Starting Money Amount for right side
     * @param time - Duration of the simulation 
     * @param difficulty - Difficulty level. Less events spawn if the difficulty is set to Easy rather than to Hard. 
     *
     */
    public GameWorld(int LUP, int RUP, int LSM, int RSM, int time, boolean difficulty) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        setPaintOrder(Effect.class, Event.class, MachineCover.class, Shoes.class, Boss.class, Machines.class, People.class);

        //set variables
        currencyA = LSM;
        currencyB = RSM;

        upgradePrefA = LUP;
        upgradePrefB = RUP;
        
        counter = 0;
        timer = 0;
        maxTimer = time; 

        hardMode = difficulty;
        
        ambience = new GreenfootSound ("ambience.mp3");
        ambience.setVolume(40);
        backgroundmusic = new GreenfootSound ("background.mp3");
        backgroundmusic.setVolume(30);
        upgrade = new GreenfootSound ("upgrade.mp3");
        upgrade.setVolume(20);

        itemChoiceA = 0; 
        itemChoiceB = 0; 

        activeEventA = false;
        activeEventB = false;
        strikeStatusA = false;
        strikeStatusB = false;
        shoeBoxed = false;
        
        itemValueA = 100; 
        itemValueB = 100; 

        spawnInitalMachines();
        
        produceSpeedA = 1;
        produceSpeedB = 1;
        maxSpeed = 5; 
        
        background = new GreenfootImage("bg.png");
        background.scale(1200, 800);
        GreenfootImage bg = getBackground();
        bg.drawImage(background, -85, 0);

        setBackground(bg);

        a = new Boss(LUP, 0);
        b = new Boss(RUP, 0);

        addObject(a, 40, 40);
        addObject(b, 800, 40);
        

        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);

        addObject(new Truck(), 0, 100);
        truckActive = true; 
        started();
    }
    /**
     * Started() method - used for playing music in a loop
     */
    public void started(){
        ambience.playLoop();
        backgroundmusic.playLoop();
    }
    /**
     * Stopped() method - stops music if the world is stopped
     */
    public void stopped(){
        ambience.stop();
        backgroundmusic.stop();
        upgrade.stop();
    }
    /**
     * HUD is set up, events and trucks are spawned randomly, and the timer is checked for if the timer is over. 
     */
    public void act()
    {
        timer();
        showText("REVENUE: " + currencyA, 80, 700);
        showText("REVENUE: " + currencyB, 637, 700);
        showText("SPEED; " + produceSpeedA, 215, 700); 
        showText("SPEED: " + produceSpeedB, 772, 700);
        showText("ITEM VALUE: "+ (int)itemValueA, 370, 700);
        showText("ITEM VALUE: "+ (int)itemValueB, 922, 700); 
        
        showText("TOTAL ITEMS SOLD: "+ LitemSold, 370, 750);
        showText("TOTAL ITEMS SOLD: "+ RitemSold, 670, 750); 
        
        spawnEvents();
        spawnTruck();
        
        checkTimerOver();
    }
    /**
     * Adds all the initial machines at the start of the simulation 
     */
    public void spawnInitalMachines()
    {
        
        Lone = new LeftMachines();
        addObject(new Transport(100, 300, "left"), 100, 300);
        addObject(Lone, 288, 300);
        
        Rone = new Rightmachines();
        addObject(new Transport(610, 300, "right"), 610, 300);
        addObject(Rone, 801, 300);
        

        addObject(new VertConveyor(), 465, 465);
        addObject(new VertConveyor(), 978, 465);
    }

    /**
     * Sets the number of workers per station to one for a certain side
     * 
     * @param side - Side of the simulation
     */
    public void halfWorkers(String side){
        if (side == "left"){
            LworkerCount = 1;
            
            ArrayList<LeftMachines> leftMachines = (ArrayList<LeftMachines>)this.getObjects(LeftMachines.class);
            for(LeftMachines m : leftMachines){
                m.strikeRemove();
                m.resetWorkers();
            }
            
            
        } else if (side == "right"){
            
            ArrayList<Rightmachines> rightMachines = (ArrayList<Rightmachines>)this.getObjects(Rightmachines.class);
            for(Rightmachines m : rightMachines){
                m.strikeRemove();
                m.resetWorkers();
            }
            
            RworkerCount = 1;
        }
    }
    /**
     * Method for spawning new machines if the previous conveyor belt is full, as well as one worker per station of the machine. 
     */
    public void laterMachines(){

        //worker will be tied to a machine
        //machine will spawn the workers
        //create method in machine to spawn wokers
        
        if (LworkerCount == 2){
            Lone.addWorkers();
        } else if (LworkerCount == 3){
            Lone.addWorkers();
            
        } else if (LworkerCount == 4 && !spawnedLTwo){
            //add machine, with workers
            Ltwo = new LeftMachines();
            addObject(new Transport(100, 450, "left"), 100, 450);
            addObject(Ltwo, 288, 450);
            spawnedLTwo = true;
        } else if (LworkerCount == 5){
            Ltwo.addWorkers();
        } else if (LworkerCount == 6){
            Ltwo.addWorkers();
        } else if (LworkerCount == 7 && !spawnedLThree){
            //add 2nd machine
            Lthree = new LeftMachines();
            addObject(new Transport(100, 600, "left"), 100, 600);
            addObject(Lthree, 288, 600);
            spawnedLThree = true;
        } else if (LworkerCount == 8){
            Lthree.addWorkers();
        } else if (LworkerCount == 9){
            Lthree.addWorkers();
        }
        
        if (RworkerCount == 2){
            Rone.addWorkers();
        } else if (RworkerCount == 3){
            Rone.addWorkers();
            
        } else if (RworkerCount == 4 && !spawnedRTwo){
            //add machine, with workers
            Rtwo = new Rightmachines();
            addObject(new Transport(610, 450, "right"), 610, 450);
            addObject(Rtwo, 801, 450);
            spawnedRTwo = true;
        } else if (RworkerCount == 5){
            Rtwo.addWorkers();
        } else if (RworkerCount == 6){
            Rtwo.addWorkers();
        } else if (RworkerCount == 7 && !spawnedRThree){
            //add 2nd machine
            Rthree = new Rightmachines();
            addObject(new Transport(610, 600, "right"), 610, 600);
            addObject(Rthree, 801, 600);
            spawnedRThree = true;
        } else if (RworkerCount == 8){
            Rthree.addWorkers();
        } else if (RworkerCount == 9){
            Rthree.addWorkers();
        }

        //true/false to spawn machine, add to workercount
    }
    /**
     * Method for adding to the number of items sold
     * 
     * @param side - side of the simulation 
     */
    public void itemsSold(String side){
        if (side == "left"){
            LitemSold++;
        } else if (side == "right"){
            RitemSold++;
        }
    }
    /**
     * Method responsible for upgrading, whether it is randomized or if an upgrade priority is set, and if there is enough money to buy an upgrade
     * 
     * @param side - side of the simulation 
     * @param Upgrade - upgrade priority
     * @param b - the boss that will be responsible for upgrading 
     */
    public void upgrades(String side, int Upgrade, Boss b){
        //only upgrade if enough money
        
        if (side == "left"){
            
            
            //check enough money
            
            if (Upgrade == 1 && currencyA > 500 && LworkerCount <= 9){
                if (currencyA > 600){
                    currencyA -= currencyA/4;
                } else {
                    currencyA -= 500;
                }
                LworkerCount++;
                laterMachines();
                addObject(new UpgradeArrow(0), b.getX(), b.getY());
            }
            if (Upgrade == 0 && currencyA > 400 && produceSpeedA  < maxSpeed){
                if (currencyA > 500){
                    currencyA -= currencyA/4;
                } else {
                    currencyA -= 400;
                }
                increaseEfficiency(0);
                addObject(new UpgradeArrow(1), b.getX(), b.getY());
            }
            upgrade.play();
            
        } else if (side == "right"){
            
            if (Upgrade == 1 && currencyB > 500 && RworkerCount <= 9){
                if (currencyB > 600){
                    currencyB -= currencyB/4;
                } else {
                    currencyB -= 500;
                }
                
                RworkerCount++;
                laterMachines();
                addObject(new UpgradeArrow(0), b.getX(), b.getY());
            }
            if (Upgrade == 0 && currencyB > 400 && produceSpeedB  < maxSpeed){
                if (currencyB > 500){
                    currencyB -= currencyB/4;
                } else {
                    currencyB -= 400;
                }
                increaseEfficiency(1);
                addObject(new UpgradeArrow(1), b.getX(), b.getY());
            }
            upgrade.play();
        }
    }
    /**
     * Method increases the produce speed in the GameWorld, which is the universal variable for setting the speed of machines, which sets the speed of shoes
     * 
     * @param side - side of the simulation 
     */
    public void increaseEfficiency(int side){
        if(side == 0){
            produceSpeedA+=0.5;
        }
        else if(side == 1){
            produceSpeedB+=0.5;
        }
    }
    /**
     * If a truck is currently not active in the world, a truck is randomly spawned
     */
    public void spawnTruck(){
        if(!truckActive){
            if(Greenfoot.getRandomNumber(600) == 0){
                addObject(new Truck(), 0, 100);
                truckActive = true; 
            }
        }
    }
    /**
     * Converts the timer from Greenfoot Acts to seconds and updates the timer in the HUD
     */
    public void timer(){
        counter += 1;
        if(counter%60 == 0){
            timer += 1;
        }
        showText("Time: " + timer, 512, 20);
    }
    /**
     * Checks if the time is over, and based on the winner, will set the winner parameter for the WinScreen and switch to WinScreen
     */
    public void checkTimerOver(){
        if(timer == maxTimer){
            if(currencyA >= currencyB){
                winner = "left"; //left side wins
                Greenfoot.setWorld(new WinScreen(winner));
                stopped();
            } else if(currencyB>currencyA){
                winner = "right"; //right side wins
                Greenfoot.setWorld(new WinScreen(winner));
                stopped();
            }
        }
    }
    /**
     * Randomly spawns events if an event is not currently active, and also depending on if hardMode is active or not, events may or may not spawn more frequently. 
     */
    public void spawnEvents(){
        if(!hardMode){
            if(!activeEventA){
                if(Greenfoot.getRandomNumber(1800) == 0){
                    chooseEventA();
                }
            }
            if(!activeEventB){
                if(Greenfoot.getRandomNumber(1800) == 0){
                    chooseEventB();
                }
            }
        }
        else if(hardMode){
            if(!activeEventA){
                if(Greenfoot.getRandomNumber(1200) == 0){
                    chooseEventA();
                }
            }
            if(!activeEventB){
                if(Greenfoot.getRandomNumber(1200) == 0){
                    chooseEventB();
                }
            }
        }
    }
    /**
     * Chooses the event for the left side
     */
    public void chooseEventA(){
        int eventA = Greenfoot.getRandomNumber(4);
        if(!activeEventA){
            activeEventA = true;
            if(eventA == 3){
                addObject(new BossCheckup(15, true, false), 66, 625);
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5, true, false), 256, 400);
            } else if(eventA == 0){
                addObject(new StockMarketCrash(5, true, false), 256, 400);
            } else if(eventA == 2 && !strikeStatusB){
                addObject(new Strike(10, true, false), 66, 625);
                strikeStatusA = true; 
            }
        }
    }
    /**
     * Chooses the events for the right side
     */
    public void chooseEventB(){
        int eventB = Greenfoot.getRandomNumber(4);
        if(!activeEventB){
            activeEventB = true;
            if(eventB == 3){
                addObject(new BossCheckup(15, false, true), 578, 625);
            } else if(eventB == 1){
                addObject(new BoomingBusiness(5, false, true), 768, 400);
            } else if(eventB == 0){
                addObject(new StockMarketCrash(5, false, true), 768, 450);
            } else if(eventB == 2 && !strikeStatusA){
                addObject(new Strike(10, false, true), 578, 625);
                strikeStatusB = true; 
            }
        }
    }
    /**
     * Gets the worker count for either side of the simulation 
     * 
     * @param side - Side of the simulation
     * @return int - Returns the number of workers for either side
     */
    public int getWorkerCount(int side){
        if (side == 0){
            return LworkerCount; 
        } else if (side == 1){
            return RworkerCount; 
        }
        return 0;
    }
    /**
     * Sets the workerCount for either side of the simulation 
     * 
     * @param newWorkerCount - The newWorkerCount to be set to
     * @param side - Side of the simulation 
     */
    public void setWorkerCount(int newWorkerCount, int side){
        if (side == 0){
            LworkerCount = newWorkerCount; 
        } else if (side == 1){
            RworkerCount = newWorkerCount; 
        }
    }
    /**
     * Get the currency of the left side
     * 
     * @return int - Returns the currency of left side
     */
    public static int getCurrencyA()
    {
        return currencyA;
    }
    /**
     * Add to the currency of the left side
     */
    public static void addCurrencyA()
    {
        currencyA += itemValueA;
    }
    /**
     * Get the currency of the right side
     * 
     * @return int - Returns the currency of right side
     */
    public static int getCurrencyB(){
        return currencyB;
    }
    /**
     * Add to the currency of the right side
     */
    public static void addCurrencyB()
    {
        currencyB += itemValueB;
    }
    //event and truck status getters and setters - to ensure multiple don't spawn at once
    /**
     * Sets the event status of the left side to ensure another event does not spawn simutaneously
     * 
     * @param x - Event status 
     */
    public void setEventStatusA(boolean x){
        activeEventA = x;
    }
    /**
     * Gets the event status of the left side
     * 
     * @return boolean - event status of left side
     */
    public boolean getEventStatusA(){
        return activeEventA; 
    }
    /**
     * Sets the event status of the right side to ensure another event does not spawn simutaneously
     * 
     * @param x - Event status 
     */
    public void setEventStatusB(boolean x){
        activeEventB = x;
    }
    /**
     * Gets the event status of the right side
     * 
     * @return boolean - event status of right side
     */
    public boolean getEventStatusB(){
        return activeEventB;
    }    
    /**
     * Gets if a strike is currently active on the left side or not 
     * 
     * @return boolean - Returns the strikeStatus of the left side
     */
    public boolean getStrikeStatusA(){
        return strikeStatusA; 
    }
    /**
     * Sets the strikeStatus of the left side to true or false
     * 
     * @param a - strikeStatus
     */
    public void setStrikeStatusA(boolean a){
        strikeStatusA = a;
    }
    /**
     * Gets if a strike is currently active on the right side or not 
     * 
     * @return boolean - Returns the strikeStatus of the right side
     */
    public boolean getStrikeStatusB(){
        return strikeStatusB;
    }
    /**
     * Sets the strikeStatus of the right side to true or false
     * 
     * @param a - strikeStatus
     */
    public void setStrikeStatusB(boolean b){
        strikeStatusB = b; 
    }
    /**
     * Gets if a truck is active or not
     * 
     * @return boolean - Returns truck status 
     */
    public boolean getTruckStatus(){
        return truckActive;
    }
    /**
     * Sets trucks status to false
     */
    public void changeTruckStatus(){
        truckActive = false;
    }
    /**
     * Gets the value of shoes made on the left side
     * 
     * @return double - Value of shoe on left side
     */
    public double getItemValueA(){
        return itemValueA;
    }
    /**
     * Sets the value of shoes made on the left side
     * 
     * @param newItemValue - New value of shoes made on left side
     */
    public void setItemValueA(double newItemValue){
        itemValueA = newItemValue; 
    }
    /**
     * Gets the value of shoes made on the right side
     * 
     * @return double - Value of shoe on right side
     */
    public double getItemValueB(){
        return itemValueB; 
    }
    /**
     * Sets the value of shoes made on the right side
     * 
     * @param newItemValue - New value of shoes made on right side
     */
    public void setItemValueB(double newItemValue){
        itemValueB = newItemValue; 
    }
    /**
     * Gets the produce speed of the left side 
     * 
     * @return double - Returns the produce speed of the left side
     */
    public double getProdSpeedA(){
        return produceSpeedA;
    }
    /**
     * Sets the produce speed of the left side 
     * 
     * @param produceSpd - New produce speed of left side
     */
    public void setProdSpeedA(double produceSpd){
        produceSpeedA = produceSpd; 
    }
    /**
     * Gets the produce speed of the right side 
     * 
     * @return double - Returns the produce speed of the right side
     */
    public double getProdSpeedB(){
        return produceSpeedB;
    }
    /**
     * Sets the produce speed of the right side 
     * 
     * @param produceSpd - New produce speed of right side
     */
    public void setProdSpeedB(double produceSpd){
        produceSpeedB = produceSpd; 
    }
    /**
     * Gets if a shoe has been boxed or not 
     * 
     * @return boolean - Returns if shoe has been boxed or not
     */
    public boolean getShoeBoxed(){
        return shoeBoxed; 
    }
    /**
     * Sets if a shoe has been boxed or not 
     * 
     * @param b - Whether a shoe has been boxed or not 
     */
    public void setShoeBoxed(boolean b){
        shoeBoxed = b; 
    }
}
