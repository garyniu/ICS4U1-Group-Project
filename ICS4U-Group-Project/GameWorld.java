import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    
    private static double produceSpeedA;
    private static double produceSpeedB;
    

    private String winner; 
    private Boss a, b;
    
    private LeftMachines Lone, Ltwo, Lthree;
    private Rightmachines Rone, Rtwo, Rthree;
    
    /*
    private GreenfootImage canvasA;
    private GreenfootImage canvasB;
    private GreenfootImage bbImage;
    private GreenfootImage bcImage;
    private GreenfootImage smcImage;
    private GreenfootImage strkImage; 
    */
    private double newSpeedLeft;
    private double newSpeedRight;
    private double slowSpeedLeft;
    private double slowSpeedRight;
    
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public GameWorld(int LUP, int RUP, int LSM, int RSM, int time, boolean difficulty) 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        setPaintOrder(Effect.class, Event.class, Items.class, Machines.class, People.class);

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

        spawnInitalMachines();
        
        produceSpeedA = 1;
        produceSpeedB = 1;
        
        /*
        canvasA = new GreenfootImage(75,75);
        canvasB = new GreenfootImage(75,75); 
        bbImage = new GreenfootImage("images/STOCKMARKETBOOMINTEXT.png");
        bcImage = new GreenfootImage("images/BOSSCHECKUP.png");
        smcImage = new GreenfootImage("images/STOCKMARKETCRASHTEXT.png"); 
        strkImage = new GreenfootImage("images/STRIKE.png"); 
        */
        //addObject(new Boss(0, 50), 0, 50);

        background = new GreenfootImage("bg.png");
        background.scale(1200, 800);
        GreenfootImage bg = getBackground();
        bg.drawImage(background, -85, 0);
        //bg.drawImage(canvasA, 0, 500);
        //bg.drawImage(canvasB, 512, 500); 

        setBackground(bg);

        a = new Boss(LUP, 0);
        b = new Boss(RUP, 0);

        addObject(a, 40, 40);
        addObject(b, 800, 40);
        

        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);

        addObject(new Truck(), 0, 100);
        truckActive = true; 
    }

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
    //add the conveyers
    public void spawnInitalMachines()
    {
        
        Lone = new LeftMachines();
        addObject(Lone, 288, 300);
        
        Rone = new Rightmachines();
        addObject(Rone, 801, 300);
        

        addObject(new VertConveyor(), 465, 465);
        addObject(new VertConveyor(), 978, 465);
        

    }

    
    //method called
    //leave only 1 wokers per conveyer
    public void halfWorkers(String side){
        if (side == "left"){
            LworkerCount = 1;
            
            ArrayList<LeftMachines> leftMachines = (ArrayList<LeftMachines>)this.getObjects(LeftMachines.class);
            for(LeftMachines m : leftMachines){
                m.strikeRemove();
                m.resetWorkers();
            }
            
            
        } else if (side == "right"){
            RworkerCount = 1;
        }
    }
    
    
    public void LaterMachines(){

        //worker will be tied to a machine
        //machine will spawn the workers
        //create method in machine to spawn wokers
        
        System.out.println(LworkerCount + " :worker count");
        
        if (LworkerCount == 2){
            Lone.addWorkers();
        } else if (LworkerCount == 3){
            Lone.addWorkers();
            
        } else if (LworkerCount == 4 && !spawnedLTwo){
            //add machine, with workers
            Ltwo = new LeftMachines();
            addObject(Ltwo, 288, 450);
            spawnedLTwo = true;
        } else if (LworkerCount == 5){
            Ltwo.addWorkers();
        } else if (LworkerCount == 6){
            Ltwo.addWorkers();
        } else if (LworkerCount == 7 && !spawnedLThree){
            //add 2nd machine
            Lthree = new LeftMachines();
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
            addObject(Rtwo, 801, 450);
            spawnedRTwo = true;
        } else if (RworkerCount == 5){
            Rtwo.addWorkers();
        } else if (RworkerCount == 6){
            Rtwo.addWorkers();
        } else if (RworkerCount == 7 && !spawnedRThree){
            //add 2nd machine
            Rthree = new Rightmachines();
            addObject(Rthree, 801, 600);
            spawnedRThree = true;
        } else if (RworkerCount == 8){
            Rthree.addWorkers();
        } else if (RworkerCount == 9){
            Rthree.addWorkers();
        }

        //true/false to spawn machine, add to workercount
    }
    
    
    public void itemsSold(String side){
        if (side == "left"){
            LitemSold++;
        } else if (side == "right"){
            RitemSold++;
        }
    }
    
    public void upgrades(String side, int Upgrade, Boss b){
        //System.out.println("boss upgrade side: " + side + "\nUpgrade type: " + Upgrade + "\n");
        //only upgreade if enough money
        
        if (side == "left"){
            
            
            //check enough money
            
            if (Upgrade == 1 && currencyA > 500 && LworkerCount <= 9){
                currencyA -= 200;
                LworkerCount++;
                LaterMachines();
                addObject(new UpgradeArrow(0), b.getX(), b.getY());
            }
            if (Upgrade == 0 && currencyA > 400){
                //currencyA -= 250;
                //conveyer speed
                addObject(new UpgradeArrow(1), b.getX(), b.getY());
            }
            
            
        } else if (side == "right"){
            
            if (Upgrade == 1 && currencyB > 500 && RworkerCount <= 9){
                currencyB -= 200;
                RworkerCount++;
                LaterMachines();
                addObject(new UpgradeArrow(0), b.getX(), b.getY());
            }
            if (Upgrade == 0 && currencyB > 400){
                //currencyB -= 250;
                //conveyer speed
                addObject(new UpgradeArrow(1), b.getX(), b.getY());
            }
            
            
        }
        
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
                //canvasA.drawImage(bcImage, 0, 500); 
            } else if(eventA == 1){
                addObject(new BoomingBusiness(5, true, false), 256, 400);
                //canvasA.drawImage(bbImage, 0, 500); 
            } else if(eventA == 0){
                addObject(new StockMarketCrash(5, true, false), 256, 400);
                //canvasA.drawImage(smcImage, 0, 500); 
            } else if(eventA == 2 && !strikeStatusB){
                addObject(new Strike(10, true, false), 112, 400);
                //canvasA.drawImage(strkImage, 0, 500); 
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
                //canvasB.drawImage(bcImage, 512, 500); 
            } else if(eventB == 1){
                addObject(new BoomingBusiness(5, false, true), 768, 400);
                //canvasB.drawImage(bbImage, 512, 500); 
            } else if(eventB == 0){
                addObject(new StockMarketCrash(5, false, true), 768, 400);
                //canvasB.drawImage(smcImage, 512, 500); 
            } else if(eventB == 2 && !strikeStatusA){
                addObject(new Strike(10, false, true), 912, 400);
                //canvasB.drawImage(strkImage, 512, 500); 
                strikeStatusB = true; 
            }
        }
    }
    //methods for changing efficiency
    public void increaseEfficiency(int side){
        if(side == 0){
            for(LeftMachines lm : getObjects(LeftMachines.class)){
                newSpeedLeft = lm.getDefaultSpeedA()+0.5; 
                lm.setProdSpeedA(newSpeedLeft);
            }
        }
        else if(side == 1){
            for(RightMachines rm : getObjects(RightMachines.class)){
                newSpeedRight = rm.getDefaultSpeedB()+0.5; 
                rm.setProdSpeedB(newSpeedRight);
            }
        }
    }
    public void slowEfficiency(int side){
        if(side == 0){
            for(LeftMachines lm : getObjects(LeftMachines.class)){
                slowSpeedLeft = lm.getDefaultSpeedA()-0.5; 
                lm.setProdSpeedA(slowSpeedLeft);
            }
        }
        else if(side == 1){
            for(RightMachines rm : getObjects(RightMachines.class)){
                slowSpeedRight = rm.getDefaultSpeedB()-0.5; 
                rm.setProdSpeedB(slowSpeedRight);
            }
        }
    }
    public void resumeEfficiency(int side){
        if(side == 0){
            for(LeftMachines lm : getObjects(LeftMachines.class)){
                lm.setProdSpeedA(lm.getDefaultSpeedA()); 
            }
        }
        else if(side == 1){
            for(RightMachines rm : getObjects(RightMachines.class)){
                rm.setProdSpeedB(rm.getDefaultSpeedB());
            }
        }
    }
    public int getWorkerCount(int side){
        if (side == 0){
            return LworkerCount; 
        } else if (side == 1){
            return RworkerCount; 
        }
        return 0;
    }

    public void setWorkerCount(int newWorkerCount, int side){
        if (side == 0){
            LworkerCount = newWorkerCount; 
        } else if (side == 1){
            RworkerCount = newWorkerCount; 
        }
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
