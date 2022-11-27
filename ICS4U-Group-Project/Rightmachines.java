//Imports
import greenfoot.*; 

/**
 * Class for the Conveyers on the Right side of the screen
 * <p>
 * Holds workers, and spawns shoes on the conveyer belt.
 *
 * @author Victor Wei, Gary Niu, Harishan Ganeshanathan
 * @version November 2022
 */
public class Rightmachines extends Machines
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
    private Shoes shoe; 
    private HiredWorkers t_o, t_t, t_th, th_o, th_t, th_th;

    //Constructor
    public Rightmachines(){
        super();
    }

    public void act()
    {
        GameWorld gw = (GameWorld)getWorld(); 

         //Checks if the conveyer is not in strike or if its speed is set
        if(!gw.getStrikeStatusB()){
            actTimer++;
            updateSpeed();
        }
        if(!speedSet){
            updateDefaultSpeedB(); 
            updateSpeed();
            speedSet = true;
        }

        //Method to spawn shoes on the conveyer, after a certain amount of time
        checkShoeFinished(); 
    }

    //Method when the object is added to the world
    public void addedToWorld(World w){
        //Adds blocked boxes to the conveyer, for shoes to detect end of conveyer
        w.addObject(new BlockedBoxes(30, 80, true), (this.getX()+width/2)-10, this.getY()-height/2);
        spawnShoes();
        
        //MachineCover object, put over the machine so the shoes look like they are going through it
        MachineCover x = new MachineCover();
        getWorld().addObject(x, getX(), getY());
        
        //Spawning first 3 workers
        getWorld().addObject(new HiredWorkers(false), getX()/2  + 260, getY() -30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 120 + 260 , getY() - 30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 240 + 260, getY() - 30);
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
            
            getWorld().addObject(t_o, getX()/2 + 60 + 260, getY() -30);
            getWorld().addObject(t_t, getX()/2 + 120 + 60 + 260, getY() - 30);
            getWorld().addObject(t_th, getX()/2 + 240 + 60 + 260, getY() - 30);
            secWU = true;
        }

        //Level 3 (> 3 workers)
        if (WC == 1 && !firstWU){
            WC = 2;

            twoWorks = true;
            
            th_o = new HiredWorkers(true);
            th_t = new HiredWorkers(true);
            th_th = new HiredWorkers(true);
            
            getWorld().addObject(th_o, getX()/2 + 30 + 260, getY() -30);
            getWorld().addObject(th_t, getX()/2 + 120 + 30 + 260, getY() - 30);
            getWorld().addObject(th_th, getX()/2 + 240 + 30 + 260, getY() - 30);
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

    //Method used to spawn a new shoe on the conveyer
    public void spawnShoes(){
        GameWorld gw = (GameWorld)getWorld(); 
        gw.addObject(new Shoes(this) , this.getX()- this.getX()/6, this.getY()-height/4-10);
        updateSpeed();
        gw.setShoeBoxed(true);
        gw.itemsSold("right");
        itemValue = gw.getItemValueB();
    }

    //Method to check if a shoe has existed for a specific time, and if so, spawn a new one (Also based on upgrade)
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
        }else if(produceSpeed >= 5 && actTimer ==59){
            spawnShoes();
            actTimer = 0;
        }
        
        //if there are two workers per station
        if (twoWorks){
            if (produceSpeed <= 1){
                if (actTimer == 203){
                    spawnShoes(); 
                    actTimer = 0;
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes();
                    actTimer =0;
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes();
                    actTimer=0; 
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                    actTimer=0;
                }
            }
        }
        
        //if station has 3 workers
        if (threeWorks){
            if (produceSpeed <= 1){
                if (actTimer == 150){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 203){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 75){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 70){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 60){
                    spawnShoes();
                    actTimer=0; 
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 46){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 40){
                    spawnShoes(); 
                    actTimer=0;
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 35){
                    spawnShoes();
                    actTimer=0; 
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                    actTimer=0;
                }
                if (actTimer == 20){
                    spawnShoes(); 
                    actTimer=0;
                }
            }
        }
        
        //Prevents the actTimer from going over 300
        if (actTimer > 300) actTimer = 0;
    }
    
    //Getters and Setters
    public void updateSpeed(){
        GameWorld gw = (GameWorld)getWorld();
        produceSpeed = gw.getProdSpeedB();
    }

    public void updateDefaultSpeedB(){
        defaultSpeed = produceSpeed; 
    }

    public double getDefaultSpeedB(){
        return defaultSpeed; 
    }

    public double getProdSpeedB(){
        return produceSpeed; 
    }

    public void setProdSpeedB(double newSpd){
        produceSpeed = newSpd;
    }

    public static double getMachItemValueB(){
        return itemValue;
    }

    public static void setMachItemValueB(double value){
        itemValue = value; 
    }
    public int returnWorkers(){
        return WC;
    }
    
    public void resetWorkers(){
        WC = 1;
    }

}
