//Imports
import greenfoot.*; 

/**
 * Class for the Conveyers on the left side of the screen
 * <p>
 * Holds workers, and spawns shoes on the conveyer belt.
 *
 * @author Victor Wei, Gary Niu, Harishan Ganeshanathan
 * @version November 2022
 */
public class LeftMachines extends Machines
{
    //Instance variables
    private GreenfootImage imageA;
    private int items, WC = 1, conveyerLevel = 1;
    private int timer;
    private static int upgradeAmount, ShoeCount = 1;
    private static double produceSpeed;
    private static double defaultSpeed;
    private static double itemValue;
    private boolean shoeCanBeMade, firstWU = false, secWU = false;
    private boolean twoWorks = false, threeWorks = false;
    private int width;
    private int height; 
    private HiredWorkers t_o, t_t, t_th, th_o, th_t, th_th;

    /**
     * Constructor calls the super Constructor 
     */
    public LeftMachines(){
        super();
    }
    /**
     * If the strike event is inactive and if the speed has not been set, only then wil the speed be updated.
     * <p>
     * Checks if the current shoe is finished on the conveyor, so a new shoe Item can be spawned. 
     */
    public void act()
    {
        GameWorld gw = (GameWorld)getWorld(); 

        //Checks if the conveyer is not in strike or if its speed is set
        if(!gw.getStrikeStatusA()){
            updateSpeed();
            actTimer++;
        }
        if(!speedSet){
            updateDefaultSpeedA(); 
            updateSpeed();
            speedSet = true;
        }

        //Method to spawn shoes on the conveyer, after a certain amount of time
        checkShoeFinished(); 
    }

    /**
     * When this object is added to world, it will add a new BlockedBoxes object, spawn a new shoes,
     * create a MachineCover object and add it, as well as add 3 workers, one per station of the conveyor. 
     */
    public void addedToWorld(World w){
        //Adds blocked boxes to the conveyer, for shoes to detect end of conveyer
        w.addObject(new BlockedBoxes(30, 80, true), (this.getX()+width/2) - 10, this.getY()-height/2);
        spawnShoes();       
        
        //MachineCover object, put over the machine so the shoes look like they are going through it
        MachineCover x = new MachineCover();
        getWorld().addObject(x, getX(), getY());
        
        //Spawning first 3 workers
        getWorld().addObject(new HiredWorkers(false), getX()/2 , getY() -30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 120 , getY() - 30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 240, getY() - 30);
    }
    
    public void addWorkers(){
        //Adds workers to the conveyer based on level
        //Level 2 (> 6 workers)
        if (WC == 2 && !secWU){
            WC = 3;
            threeWorks = true;
            
            t_o = new HiredWorkers(true);
            t_t = new HiredWorkers(true);
            t_th = new HiredWorkers(true);
            
            getWorld().addObject(t_o, getX()/2 + 60, getY() -30);
            getWorld().addObject(t_t, getX()/2 + 120 + 60 , getY() - 30);
            getWorld().addObject(t_th, getX()/2 + 240 + 60, getY() - 30);
            secWU = true;
        }

        //Level 3 (> 3 workers)
        if (WC == 1 && !firstWU){
            WC = 2;
            twoWorks = true;
            
            th_o = new HiredWorkers(true);
            th_t = new HiredWorkers(true);
            th_th = new HiredWorkers(true);
            
            getWorld().addObject(th_o, getX()/2 + 30, getY() -30);
            getWorld().addObject(th_t, getX()/2 + 120 + 30 , getY() - 30);
            getWorld().addObject(th_th, getX()/2 + 240 + 30, getY() - 30);
            firstWU = true;
        } 

    }

    //Method used in GameWorld, removes the last 2 workers in each section in a strike
    public void strikeRemove(){
        getWorld().removeObject(t_o);
        getWorld().removeObject(t_t);
        getWorld().removeObject(t_th);
        getWorld().removeObject(th_o);
        getWorld().removeObject(th_t);
        getWorld().removeObject(th_th);
        firstWU = false;
        secWU = false;
        
        twoWorks = false;
        threeWorks = false;
    } 
    /**
     * Spawns a new shoe on the conveyor, updates the speed, sets ShoeBoxed to true, and gets the itemValue. 
     */
    public void spawnShoes(){
        GameWorld gw = (GameWorld)getWorld();
        gw.addObject(new Shoes(this) , this.getX() - (this.getX()/2), this.getY()-height/4-10);
        updateSpeed(); 
        gw.setShoeBoxed(true);
        gw.itemsSold("left");
        itemValue = gw.getItemValueA(); 
    }

    /**
     * Method for checking if a shoe is finished and a new one can be created. The shoe spawning is also worker count based. 
     * <p>
     * The reason this is timer based and not BlockedBoxes collision based is because we ran into problems with adding multiple shoes at a time,
     *  but with a delay (if there were 3 workers per station, we would want 3 shoes to spawn, but on a visual delay so it visually looks like 3 are made). 
     *  If we made it collision based, a for loop for delaying shoe spawning would break the spawning entirely, so we made it timer based. 
     */ 
    public void checkShoeFinished(){
        if(produceSpeed <= 1 && actTimer == 293){
            spawnShoes(); 
            actTimer = 0;
        }else if(produceSpeed == 1.5 && actTimer == 195){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 2 && actTimer == 147){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 2.5 && actTimer == 117){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 3 && actTimer == 98){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 3.5 && actTimer ==84){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 4 && actTimer ==74){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 4.5 && actTimer ==65){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 5 && actTimer ==59){
            spawnShoes();
            actTimer = 0;
        }
        
        //if there are two workers per station
        if (twoWorks){
            if (produceSpeed == 1){
                if (actTimer == 203){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes();
                    actTimer = 0; 
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                    actTimer = 0;
                }
            }
        }
        
        //if station has 3 workers
        if (threeWorks){
            if (produceSpeed <= 1){
                if (actTimer == 150){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 203){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 75){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 70){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 60){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 46){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 40){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 35){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                    actTimer = 0;
                }
                if (actTimer == 20){
                    spawnShoes(); 
                    actTimer = 0;
                }
            }
        }
        
        //Prevents the actTimer from going over 300
        if (actTimer > 300) actTimer = 0;
        
    }

    /**
     * Updates the speed of the conveyor so it is the speed set in GameWorld. 
     */
    public void updateSpeed(){
        GameWorld gw = (GameWorld)getWorld();
        produceSpeed = gw.getProdSpeedA();
    }
    /**
     * Updates the default speed of the conveyor. Default speed is a variable that keeps track of the speed of the conveyor once it is changed. It is pivotal for resetting the speed of the conveyor after a Strike. 
     */
    public void updateDefaultSpeedA(){
        defaultSpeed = produceSpeed; 
    }
    /**
     * Gets the default speed of the conveyor.
     * 
     * @return double   Returns the default speed. 
     */
    public double getDefaultSpeedA(){
        return defaultSpeed;
    }
    /**
     * Gets the produce speed of the conveyor.
     * 
     * @return double   Returns the produce speed of the conveyor.
     */
    public double getProdSpeedA(){
        return produceSpeed; 
    }
    /**
     * Sets the produce speed of the conveyor.
     * 
     * @param newSpd    The speed the conveyor will be set to. 
     */
    public void setProdSpeedA(double newSpd){
        produceSpeed = newSpd;
    }
    /**
     * Gets the value of the items on the conveyor belt
     * 
     * @return double   Returns the item value. 
     */
    public static double getMachItemValueA(){
        return itemValue;
    }
    /**
     * Sets the value of the items on the conveyor
     * 
     * @param value     New value the item value will be set to
     */
    public static void setMachItemValueA(double value){
        itemValue = value; 
    }
    /**
     * Gets the number of workers per conveyor
     * 
     * @return  Number of workers
     */
    public int returnWorkers(){
        return WC;
    }
    /**
     * Resets the number of workers to 1
     */
    public void resetWorkers(){
        WC = 1;
    }
}