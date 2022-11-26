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
    private boolean strikeStatusA;
    private boolean strikeStatusB;
    
    private boolean hardMode; //true = hard, false = easy

    private int workerCount; 

    private boolean truckActive; 
    
    private static double itemValueA;
    private static double itemValueB; 
    
    private static double produceSpeedA;
    private static double produceSpeedB;
    
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

        hardMode = difficulty;
        
        itemChoiceA = 0; 
        itemChoiceB = 0; 
        
        activeEventA = false;
        activeEventB = false;
        strikeStatusA = false;
        strikeStatusB = false;
        
        itemValueA = 100; 
        itemValueB = 100; 
        
        produceSpeedA = 1;
        produceSpeedB = 1;
        
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
        truckActive = true; 
        
    }

    public void act()
    {
        timer();
        showText("REVENUE: $" + currencyA, 80, 20);
        showText("REVENUE: $" + currencyB, 637, 20);
        showText("SPEED; " + produceSpeedA, 215, 20); 
        showText("SPEED: "+ produceSpeedB, 772, 20);
        showText("ITEM VALUE: $"+ (int)itemValueA, 370, 20);
        showText("ITEM VALUE: $"+ (int)itemValueB, 922, 20); 
        //spawnEvents();
        spawnTruck();
        checkTimerOver();
        /*if(timer == 3 && !activeEventA){
            addObject(new Strike(15, true, false), 112, 400);
            activeEventA = true; 
        }*/
        if(timer == 4 && !activeEventB){
            addObject(new Strike(15, false, true), 912, 400);
            activeEventB = true; 
        }

    }
    //add the conveyers
    public void spawnMachines()
    {
        addObject(new LeftMachines(), 288, 300);
        //if(workerCountA == 3 && machUpgradePref)
        addObject(new LeftMachines(), 288, 450);
        //if(workerCountA == 6 && machUpgradePref)
        addObject(new LeftMachines(), 288, 600);

        addObject(new Rightmachines(), 801, 300);
        //if(workerCountB == 3 && machUpgradePref)
        addObject(new Rightmachines(), 801, 450);
        //if(workerCountB == 6 && machUpgradePref)
        addObject(new Rightmachines(), 801, 600);

        addObject(new VertConveyor(), 465, 465);
        addObject(new VertConveyor(), 978, 465);
    }
    public void spawnTruck(){
        if(!truckActive){
            if(Greenfoot.getRandomNumber(600) == 0){
                addObject(new Truck(), 0, 100);
                truckActive = true; 
            }
        }
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
    public void chooseEventA(){
        int eventA = Greenfoot.getRandomNumber(3);
        if(!activeEventA){
            activeEventA = true;
            if(eventA == 3){
                addObject(new BossCheckup(15, true, false), 256, 400);
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5, true, false), 256, 400); 
            } else if(eventA == 0){
                addObject(new StockMarketCrash(5, true, false), 256, 400);
            } else if(eventA == 2 && !strikeStatusB){
                addObject(new Strike(10, true, false), 112, 400);
                strikeStatusA = true; 
            }
        }
    }
    public void chooseEventB(){
        int eventB = Greenfoot.getRandomNumber(3);
        if(!activeEventB){
            activeEventB = true;
            if(eventB == 3){
                addObject(new BossCheckup(15, false, true), 768, 400);
            } else if(eventB == 1){
                addObject(new BoomingBusiness(5, false, true), 768, 400); 
            } else if(eventB == 0){
                addObject(new StockMarketCrash(5, false, true), 768, 400);
            } else if(eventB == 2 && !strikeStatusA){
                addObject(new Strike(10, false, true), 912, 400);
                strikeStatusB = true; 
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
        currencyA += itemValueA;
    }
    
    public static int getCurrencyB(){
        return currencyB;
    }
    public static void addCurrencyB()
    {
        currencyB += itemValueB;
    }
    //event and truck status getters and setters - to ensure multiple don't spawn at once
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
    public boolean getStrikeStatusA(){
        return strikeStatusA; 
    }
    public void setStrikeStatusA(boolean a){
        strikeStatusA = a;
    }
    public boolean getStrikeStatusB(){
        return strikeStatusB;
    }
    public void setStrikeStatusB(boolean b){
        strikeStatusB = b; 
    }
    public boolean getTruckStatus(){
        return truckActive;
    }
    public void changeTruckStatus(){
        truckActive = false;
    }
    //item value getter and setters
    public double getItemValueA(){
        return itemValueA;
    }
    public void setItemValueA(double newItemValue){
        itemValueA = newItemValue; 
    }
    public double getItemValueB(){
        return itemValueB; 
    }
    public void setItemValueB(double newItemValue){
        itemValueB = newItemValue; 
    }
    //produce speed getters and setters
    public double getProdSpeedA(){
        return produceSpeedA;
    }
    public void setProdSpeedA(double produceSpd){
        produceSpeedA = produceSpd; 
    }
    public double getProdSpeedB(){
        return produceSpeedB;
    }
    public void setProdSpeedB(double produceSpd){
        produceSpeedB = produceSpd; 
    }
}
