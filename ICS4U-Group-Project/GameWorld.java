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

    private HiredWorkers p, p1;
    
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

        p = new HiredWorkers(300, 400);
        p1 = new HiredWorkers(200, 100);

        addObject(p, 300, 400);
        addObject(p1, 350, 450);

    }
    public void act(){
        p.goToLocation(400, 520);

    }

    /**
     * This method will randomize which gets upgraded(Workers or Machines)
     */
    public void chooseUpgrade(){
        if(workerUpgradePref && !machUpgradePref){
            //upgrade worker speed
        }
        else if(machUpgradePref && !workerUpgradePref){
            //upgrade machine speed 
        }
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

    /*
     *   This will be the method that upgrades the machines that produces items
     *  It will 
     */
    public void machineUpgradeOne(){
        if(currency > 3){

        }

    }
}
