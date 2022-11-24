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

    //booleans for events 
    private boolean bossCheckA;
    private boolean bossCheckB;
    private boolean businessBoomA;
    private boolean businessBoomB;
    private boolean stockCrashA;
    private boolean stockCrashB;
    private boolean strikeA;
    private boolean strikeB; 
    
    private boolean activeEventA;
    private boolean activeEventB; 
    
    private int eventTimeElapsed; 
    
    private boolean normalMode; //true = normal, false = extreme 

    private int workerCount; 

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        setPaintOrder(Effect.class, Event.class, Shoes.class, People.class, Machines.class);
        
        //set variables
        currencyA = 0;
        currencyB = 0;
        workerUpgradePref = true;
        machUpgradePref = false;
        workerCount = 0;
        counter = 0;
        timer = 0;

        //set event booleans
        bossCheckA =false;
        bossCheckB = false;
        businessBoomA = false;
        businessBoomB = false;
        stockCrashA = false;
        stockCrashB = false;
        strikeA = false;
        strikeB = false;
        normalMode = true; 
        
        activeEventA = false;
        activeEventB = false;
        
        spawnMachines();
        addObject(new Boss(0, 50), 0, 50);
        background = new GreenfootImage(1024, 800);
        background.setColor(Color.GRAY);
        background.fillRect(0, 0, 1024, 800);
        setBackground(background);

        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);
        
        
        

        // addObject(new HiredWorkers(), 200, 800);

        
        //addObject(new Truck(), 50, 75);

        // showText("MONEY: " + currency, 200, 20);
        // showText("MONEY: " + currency, 700, 20);
        // hitbox();

        // showText("MONEY2: " + currency, 200, 20);
        
        
    }

    public void act()
    {
        timer();
        showText("MONEY: " + currencyA, 200, 20);
        // hitbox();
        showText("MONEY: " + currencyB, 700, 20);
        if(activeEventA){
            eventTimeElapsed++; 
        }
        if(eventTimeElapsed >= 900){
            activeEventA = false;
        }
        if(normalMode){
            if(Greenfoot.getRandomNumber(1000) == 0){
                if(!activeEventA){
                    chooseEvent();
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
        addObject(new LeftMachines(), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(), 150, 550);
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
        currencyA += 1;
    }

    public static void addCurrencyB()
    {
        currencyB += 1;
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
    /**
     * The event choosing process is repeated for both sides. 
     * 
     * In order to avoid/minimize events repeating, there are booleans tracking 
     * if an event has happened yet or not. If the boolean is false, the event has
     * not occured yet. 
     * However, if the booleans are simply checked in the same order every time
     * an event is chosen, then there is no randomization to it, as it will always 
     * check the first boolean first, meaning in one cycle, the first event will 
     * be the one corresponding to the first boolean checked.
     * 
     * This is an ordering + event choice algorithm, that has 4 different orders 
     * that the booleans will be checked in, and thus, being able to check the 
     * booleans in a random order, and having events occur in a random order. 
     * 
     * First, the code will check if all four events have already happened. If so, 
     * all the booleans will be reset back to false. 
     * Next, the order choice is randomized (there are 4 orders as there are 4 events)
     * The algorithm will skip over to the if statement for the corresponding order number
     * Within the if statement are 4 nested if statements, checking if each event has happened
     * or not. If the event has happened, it will move onto the next. Otherwise, 
     * the event will occur/spawn, and the boolean of the event occuring is set to true
     * 
     * Note that the order chosen for each side is different, so the chances of the 
     * same event happening on both sides in a given instance is possible, but not guaranteed
     * 
     * Any variables ending with 'A' are correlated to the left side, 'B' to the right side
     */
    public void chooseEvent(){
        int eventA = Greenfoot.getRandomNumber(4);
        int eventB = Greenfoot.getRandomNumber(4);
        if(!activeEventA){
            activeEventA = true;
            if(eventA == 0){
                addObject(new BossCheckup(15), 256, 400);
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5), 256, 400); 
            } else if(eventA == 2){
                addObject(new StockMarketCrash(5), 256, 400);
            } else if(eventA == 3){
                addObject(new Strike(15), 256, 400);
            }
        }
        
        
        //randomize orders
        //int orderA = Greenfoot.getRandomNumber(1);
        //int orderB = Greenfoot.getRandomNumber(4);
        
        //reset booleans if all events occured
        /*
        if(bossCheckA && businessBoomA && stockCrashA && strikeA){
            bossCheckA = false;
            businessBoomA = false;
            stockCrashA = false;
            strikeA = false; 
        }
        if(bossCheckB && businessBoomB && stockCrashB && strikeB){
            bossCheckB = false;
            businessBoomB = false;
            stockCrashB = false;
            strikeB = false; 
        }
        
        //event spawns on left side 
        if(orderA == 0){
            if(!bossCheckA){
                addObject(new BossCheckup(15), 256, 400);
                bossCheckA = true;
            }
            else if(!businessBoomA){
                addObject(new BoomingBusiness(5), 256, 400); 
                businessBoomA = true;
            }
            else if(!stockCrashA){
                addObject(new StockMarketCrash(5), 256, 400); 
                stockCrashA = true;
            }
            else if(!strikeA){
                addObject(new Strike(15), 256, 400); 
                strikeA = true;
            }
        }
        
        else if(orderA == 1){
            if(!businessBoomA){
                addObject(new BoomingBusiness(5), 256, 400); 
                businessBoomA = true;
            }
            else if(!stockCrashA){
                addObject(new StockMarketCrash(5), 256, 400); 
                stockCrashA = true;
            }
            else if(!strikeA){
                addObject(new Strike(15), 256, 400); 
                strikeA = true;
            }
            else if(!bossCheckA){
                addObject(new BossCheckup(15), 256, 400);
                bossCheckA = true;
            }
        }
        else if(orderA == 2){
            if(!stockCrashA){
                addObject(new StockMarketCrash(5), 256, 400); 
                stockCrashA = true;
            }
            else if(!strikeA){
                addObject(new Strike(15), 256, 400); 
                strikeA = true;
            }
            else if(!bossCheckA){
                addObject(new BossCheckup(15), 256, 400);
                bossCheckA = true;
            }
            else if(!businessBoomA){
                addObject(new BoomingBusiness(5), 256, 400); 
                businessBoomA = true;
            }
        }
        else if(orderA == 3){
            if(!strikeA){
                addObject(new Strike(15), 256, 400); 
                strikeA = true;
            }
            else if(!bossCheckA){
                addObject(new BossCheckup(15), 256, 400);
                bossCheckA = true;
            }
            else if(!businessBoomA){
                addObject(new BoomingBusiness(5), 256, 400); 
                businessBoomA = true;
            }
            else if(!stockCrashA){
                addObject(new StockMarketCrash(5), 256, 400); 
                stockCrashA = true;
            }
        }

        //event spawning on right side 
        if(orderB == 0){
            if(!bossCheckB){
                addObject(new BossCheckup(15), 768, 400);
                bossCheckB = true;
            }
            else if(!businessBoomB){
                addObject(new BoomingBusiness(5), 768, 400); 
                businessBoomB = true;
            }
            else if(!stockCrashB){
                addObject(new StockMarketCrash(5), 768, 400); 
                stockCrashB = true;
            }
            else if(!strikeB){
                addObject(new Strike(15), 768, 400); 
                strikeB = true;
            }
        }
        else if(orderB == 1){
            if(!businessBoomB){
                addObject(new BoomingBusiness(5), 768, 400); 
                businessBoomB = true;
            }
            else if(!stockCrashB){
                addObject(new StockMarketCrash(5), 768, 400); 
                stockCrashB = true;
            }
            else if(!strikeB){
                addObject(new Strike(15), 768, 400); 
                strikeB = true;
            }
            else if(!bossCheckB){
                addObject(new BossCheckup(15), 768, 400);
                bossCheckB = true;
            }
        }
        else if(orderB == 2){
            if(!stockCrashB){
                addObject(new StockMarketCrash(5), 768, 400); 
                stockCrashB = true;
            }
            else if(!strikeB){
                addObject(new Strike(15), 768, 400); 
                strikeB = true;
            }
            else if(!bossCheckB){
                addObject(new BossCheckup(15), 768, 400);
                bossCheckB = true;
            }
            else if(!businessBoomB){
                addObject(new BoomingBusiness(5), 768, 400); 
                businessBoomB = true;
            }
        }
        else if(orderB == 3){
            if(!strikeB){
                addObject(new Strike(15), 768, 400); 
                strikeB = true;
            }
            else if(!bossCheckB){
                addObject(new BossCheckup(15), 768, 400);
                bossCheckB = true;
            }
            else if(!businessBoomB){
                addObject(new BoomingBusiness(5), 768, 400); 
                businessBoomB = true;
            }
            else if(!stockCrashB){
                addObject(new StockMarketCrash(5), 768, 400); 
                stockCrashB = true;
            }
        }
        */
        //orderA = 5;
        //orderB = 5;
    }
}
