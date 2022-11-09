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
    private static int currency;
    private static int secondCurrency;
    
    //booleans for preferences
    private boolean workerUpgradePref;
    private boolean machUpgradePref;
    private boolean workerUpgraded;
    
    private HiredWorkers p;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
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
        workerUpgraded = true;
        
        p = new HiredWorkers(300, 400);
        WorkConveyors wcOne = new WorkConveyors();
        WorkConveyors wcTwo = new WorkConveyors();
        WorkConveyors wcThree = new WorkConveyors();
        
        addObject(p, 100, 400);
        addObject(wcOne, 300, 200);
        addObject(wcTwo, 300, 350);
        addObject(wcThree, 300, 500);
    }
    
    public void act(){
        p.goToLocation(10, 20);
        
    }
    /**
     * This method will randomize which gets upgraded(Workers or Machines)
     */
    public void chooseUpgrade(){
        
    }
    /*
     *   This will be the method that upgrades the machines that produces items
     *  It will 
    */
    public void machineUpgradeOne(){
        if(currency > 3){
            /**
             * Note that workers can't be upgraded two times in a row and 
             */
            if(workerUpgradePref && !machUpgradePref){ //worker is priorityupgrade
                if(!workerUpgraded){//if worker wasn't upgraded before
                    //upgrade worker speed
                    workerUpgraded = true;
                }
                else{//if worker was upgraded before
                    //upgrade machine speed
                }
            }
            else if(machUpgradePref && !workerUpgradePref){ //machine is priority
                if(workerUpgraded){//if worker was last upgraded
                    //upgrade machine speed
                }
                else{//if machine was last upgraded
                    //upgrade worker speed
                }
            }
            //random upgrade
            else if(!machUpgradePref && !workerUpgradePref){
                int x = Greenfoot.getRandomNumber(2);
                if(x == 0){
                    //upgrade worker speed
                }
                else if(x == 1){
                    //upgrade machine speed
                }
            }
        }
        
    }
}
