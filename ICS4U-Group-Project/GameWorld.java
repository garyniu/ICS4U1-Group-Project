import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    private GreenfootImage background;
    private static int currencyA;
    private static int currencyB;
    private double timer;
    
    //booleans for preferences
    private boolean workerUpgradePref;
    private boolean machUpgradePref;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        currencyA = 0;
        currencyB = 0;
        spawnMachines();
        addObject(new Hitboxes(), 300,100);
        background = new GreenfootImage(1024, 800);
        background.setColor(Color.GRAY);
        background.fillRect(0, 0, 1024, 800);
        setBackground(background);
        
        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);
        
        // addObject(new HiredWorkers(), 200, 800);
        
        //set variables 
        workerUpgradePref = true;
        machUpgradePref = false;
        
        // showText("MONEY: " + currency, 200, 20);
        // showText("MONEY: " + currency, 700, 20);
        // hitbox();
        
        // showText("MONEY2: " + currency, 200, 20);
        
    }
    
    public void act()
    {
        timer();
        // hitbox();
        showText("MONEY: " + currencyA, 200, 20);
        showText("MONEY: " + currencyB, 700, 20);

    }
    //add the conveyers
    public void spawnMachines()
    {
        addObject(new LeftMachines(), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(), 150, 550);
        
        addObject(new Rightmachines(), 682, 150);
        //if(workerCountB == 3 && machUpgradePref)
        addObject(new Rightmachines(), 682, 350);
        //if(workerCountB == 6 && machUpgradePref)
        addObject(new Rightmachines(), 682, 550);

        //just duplicate on top of the current worker
        //every time a new worker appears
        //addObject(new Hitboxes(), 150,50);
        
    }
    //adds the machines depending on the workers for the left side
    public void machineWorkerA()
    {
        addObject(new LeftMachines(), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(), 150, 550);
    }
    
    public static int getCurrencyA()
    {
        return currencyA;
    }
    public static void addCurrencyA()
    {
        currencyA += 10;
    }
    public static int getCurrencyB()
    {
        return currencyB;
    }
    public static void addCurrencyB()
    {
        currencyB += 10;
    }
    public void timer()
    {
        timer += 0.016;
        int time = (int)Math.floor(timer * 100)/100;
        showText("Time: " + time, 512, 20);
    }
}
