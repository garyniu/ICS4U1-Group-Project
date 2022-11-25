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
    private int maxTimer; 

    //booleans for preferences
    //0 = random, 1 = workers, 2 = machines
    private int upgradePrefA;
    private int upgradePrefB;
    
    private int itemChoiceA; //0=shoes, 1 = tools, 2 = phones
    private int itemChoiceB;

    private boolean activeEventA;
    private boolean activeEventB; 
    
    private boolean hardMode; //true = hard, false = easy

    private int workerCount; 

    private String winner; 
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public GameWorld(int LUP, int RUP, int LIS, int RIS, int LSM, int RSM, int time, boolean difficulty) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        setPaintOrder(Effect.class, Event.class, Items.class, People.class, Machines.class);
        
        //set variables
        currencyA = LSM;
        currencyB = RSM;
        
        upgradePrefA = LUP;
        upgradePrefB = RUP;
        
        
        //workerUpgradePref = true; 
        //machUpgradePref = false;
        
        //workerCount = 10;
        counter = 0;
        timer = 0;
        maxTimer = time; 
        System.out.println(maxTimer);

        hardMode = difficulty;
        
        itemChoiceA = 0; 
        itemChoiceB = 0; 
        
        activeEventA = false;
        activeEventB = false;
        
        spawnMachines();
        //addObject(new Boss(0, 50), 0, 50);
        
        background = new GreenfootImage("bg.png");
        background.scale(1200, 800);
        GreenfootImage bg = getBackground();
        bg.drawImage(background, -85, 0);

        setBackground(bg);
        

        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);
        
        addObject(new Truck(), 0, 100);
        
    }

    public void act()
    {
        timer();
        showText("MONEY: " + currencyA, 200, 20);
        // hitbox();
        showText("MONEY: " + currencyB, 700, 20);
        spawnEvents();
        checkTimerOver();
        
        
        
        
        
    }
    //add the conveyers
    public void spawnMachines()
    {
        addObject(new LeftMachines(itemChoiceA), 150, 150);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(itemChoiceA), 150, 350);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(itemChoiceA), 150, 550);

        addObject(new Rightmachines(itemChoiceB), 682, 150);
        //if(workerCountB == 3 && machUpgradePref)
        addObject(new Rightmachines(itemChoiceB), 682, 350);
        //if(workerCountB == 6 && machUpgradePref)
        addObject(new Rightmachines(itemChoiceB), 682, 550);

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
    public void timer(){
        counter += 1;
        if(counter%60 == 0){
            timer += 1;
        }
        //int time = (int)Math.floor(timer * 100)/100;
        showText("Time: " + timer, 512, 20);
    }
    public void checkTimerOver(){
        if(timer == maxTimer){
            if(currencyA > currencyB){
                winner = "left"; //left side wins
                Greenfoot.setWorld(new End(winner));
            } else if(currencyB>currencyA){
                winner = "right"; //right side wins
                Greenfoot.setWorld(new End(winner));
            } else if(currencyB == currencyA){
                winner = "tie";
                Greenfoot.setWorld(new End(winner));
            }
        }
    }
    //SPAWN EVENTS 
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
        else{
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
    public void chooseEventA(){
        int eventA = Greenfoot.getRandomNumber(2);
        eventA = 3;
        if(!activeEventA){
            activeEventA = true;
            if(eventA == 2){
                addObject(new BossCheckup(15, true, false), 256, 400);
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5, true, false), 256, 400); 
            } else if(eventA == 0){
                addObject(new StockMarketCrash(5, true, false), 256, 400);
            } else if(eventA == 3){
                addObject(new Strike(15, true, false), 112, 400);
            }
        }
    }
    public void chooseEventB(){
        int eventB = Greenfoot.getRandomNumber(2);
        eventB = 3;
        if(!activeEventB){
            activeEventB = true;
            if(eventB == 2){
                addObject(new BossCheckup(15, false, true), 768, 400);
            } else if(eventB == 1){
                addObject(new BoomingBusiness(5, false, true), 768, 400); 
            } else if(eventB == 0){
                addObject(new StockMarketCrash(5, false, true), 768, 400);
            } else if(eventB == 3){
                addObject(new Strike(15, false, true), 912, 400);
            }
        }
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
    public static void addCurrencyA()
    {
        currencyA += Shoes.getItemValue();
        /*
        if(LeftMachines.getItemChoiceA() == "tools"){
            currencyA += Tools.getItemValue();
        }
        else if(LeftMachines.getItemChoiceA() == "shoes"){
            currencyA += Shoes.getItemValue();
        }
        else if(LeftMachines.getItemChoiceA() == "phones"){
            currencyA += Phones.getItemValue();
        }*/
    }
    
    public static int getCurrencyB(){
        return currencyB;
    }
    public static void addCurrencyB()
    {
        currencyB += Shoes.getItemValue();
        /*
        if(Rightmachines.getItemChoiceB() == "tools"){
            currencyB += Tools.getItemValue();
        }
        else if(Rightmachines.getItemChoiceB() == "shoes"){
            currencyB += Shoes.getItemValue();
        }
        else if(Rightmachines.getItemChoiceB() == "phones"){
            currencyB += Phones.getItemValue();
        }*/
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
}
