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
    private int counter;
    private int timer;

    //booleans for preferences
    private boolean workerUpgradePref;
    private boolean machUpgradePref;
    
    private String itemChoiceA; 
    private String itemChoiceB;

    private boolean activeEventA;
    private boolean activeEventB; 
    
    private boolean normalMode; //true = normal, false = extreme 

    private int workerCount; 

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public GameWorld() //String leftItemSold, String rightItemSold
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        setPaintOrder(Effect.class, Event.class, Items.class, People.class, Machines.class);
        
        //set variables
        currencyA = 0;
        currencyB = 0;
        workerUpgradePref = true; 
        machUpgradePref = false;
        workerCount = 0;
        counter = 0;
        timer = 0;

        normalMode = true;
        
        itemChoiceA = "phones"; 
        itemChoiceB = "tools"; 
        
        activeEventA = false;
        activeEventB = false;
        
        spawnMachines();
        addObject(new Boss(0, 50), 0, 50);
        background = new GreenfootImage("bg.png");
        background.scale(1200, 800);
        GreenfootImage bg = getBackground();
        bg.drawImage(background, -85, 0);
        
        setBackground(bg);

        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);
        
    }

    public void act()
    {
        timer();
        showText("MONEY: " + currencyA, 200, 750);
        // hitbox();
        showText("MONEY: " + currencyB, 700, 750);
        if(normalMode){
            if(!activeEventA){
                if(Greenfoot.getRandomNumber(1500) == 0){
                    chooseEventA();
                }
            }
            if(!activeEventB){
                if(Greenfoot.getRandomNumber(1500) == 0){
                    chooseEventB();
                }
            }
        }
        /*
        else{
            if((timer%8) == 0){
                chooseEvent();
            }
        }
        */
        
    }
    //add the conveyers
    public void spawnMachines()
    {
        addObject(new LeftMachines(itemChoiceA), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(itemChoiceA), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        //addObject(new LeftMachines(itemChoiceA), 150, 550);

        addObject(new Rightmachines(itemChoiceB), 682, 150);
        //if(workerCountB == 3 && machUpgradePref)
        //addObject(new Rightmachines(itemChoiceB), 682, 350);
        //if(workerCountB == 6 && machUpgradePref)
        //addObject(new Rightmachines(itemChoiceB), 682, 550);

        addObject(new VertConveyor(), 350, 350);
        addObject(new VertConveyor(), 882, 350);
        //just duplicate on top of the current worker
        //every time a new worker appears
        //addObject(new Hitboxes(), 150,50);

        //addObject(new Hitboxes(), 350,600);
        //addObject(new Hitboxes(), 882, 600); 

    }
    //adds the machines depending on the workers for the left side
    public void machineWorkerA()
    {
        addObject(new LeftMachines(itemChoiceA), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(itemChoiceA), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(itemChoiceA), 150, 550);
    }

    public int getWorkerCount(){
        return workerCount; 
    }

    public void setWorkerCount(int newWorkerCount){
        workerCount = newWorkerCount; 
    }

    public static int getCurrencyA()
    {
        return currencyA;
    }

    public static int getCurrencyB(){
        return currencyB;
    }

    public static void addCurrencyA()
    {
        currencyA += LeftMachines.getMachItemValueA();
    }

    public static void addCurrencyB()
    {
        currencyB += Rightmachines.getMachItemValueB();
    }
    public void setEventStatusA(boolean x){
        activeEventA = x;
    }
    public boolean getEventStatusA(){
        return activeEventA; 
    }
    public void setEventStatusB(boolean x){
        activeEventB = x;
    }
    public boolean getEventStatusB(){
        return activeEventB;
    }
    public void timer()
    {
        counter += 1;
        if(counter%60 == 0){
            timer += 1;
        }
        //int time = (int)Math.floor(timer * 100)/100;
        showText("Time: " + timer, 512, 20);
    }
    
    public void chooseEventA(){
        int eventA = Greenfoot.getRandomNumber(4);
        if(!activeEventA){
            activeEventA = true;
            if(eventA == 2){
                addObject(new BossCheckup(15, true, false), 256, 400);
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5, true, false), 256, 400); 
            } else if(eventA == 0){
                addObject(new StockMarketCrash(5, true, false), 256, 400);
            } else if(eventA == 3){
                addObject(new Strike(15, true, false), 256, 400);
            }
        }
    }
    public void chooseEventB(){
        int eventB = Greenfoot.getRandomNumber(4);
        if(!activeEventB){
            activeEventB = true;
            if(eventB == 2){
                addObject(new BossCheckup(15, false, true), 256, 400);
            } else if(eventB == 1){
                addObject(new BoomingBusiness(5, false, true), 256, 400); 
            } else if(eventB == 0){
                addObject(new StockMarketCrash(5, false, true), 256, 400);
            } else if(eventB == 3){
                addObject(new Strike(15, false, true), 256, 400);
            }
        }
    }    
}
