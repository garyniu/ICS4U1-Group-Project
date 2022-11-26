import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftMachines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LeftMachines extends Machines
{
    /**
     * Act - do whatever the LeftMachines wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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

    public LeftMachines()
    {
        super();
    }
    public void act()
    {
        GameWorld gw = (GameWorld)getWorld(); 
        if(!gw.getStrikeStatusA()){
            updateSpeed();
            actTimer++;
        }
        if(!speedSet){
            updateSpeed();
            updateDefaultSpeedA(); 
            speedSet = true;
        }
        checkShoeFinished(); 
        
    }

    public void addedToWorld(World w){
        w.addObject(new Hitboxes(), (this.getX()+width/2) - 10, this.getY()-height/2);
        spawnShoes();        
        
        getWorld().addObject(new HiredWorkers(false), getX()/2 , getY() -30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 120 , getY() - 30);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 240, getY() - 30);

        //w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }


    public void addWorkers(){

        System.out.println("worker level: " + WC);

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

    //people interaction
    //method to check items on conveyer
    //  Move items to next worker, call workers work method with the item
    //    If it reaches the end of the conveyer, just move the object
    //    far enough to the middle of the exit conveyer

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
        
    
    public void spawnShoes(){
        GameWorld gw = (GameWorld)getWorld();
        gw.addObject(new Shoes(this) , this.getX() - (this.getX()/2), this.getY()-height/4-10);
        updateSpeed(); 
        gw.setShoeBoxed(true);
        gw.itemsSold("left");
        itemValue = gw.getItemValueA(); 
    }
    public void checkShoeFinished(){
        
        System.out.println(produceSpeed + " " + actTimer);
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
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes(); 
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                }
            }
        }
        
        //if station has 3 workers
        if (threeWorks){
            if (produceSpeed <= 1){
                if (actTimer == 150){
                    spawnShoes(); 
                }
                if (actTimer == 203){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 1.5){
                if (actTimer == 110){
                    spawnShoes(); 
                }
                if (actTimer == 80){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 2){
                if (actTimer == 95){
                    spawnShoes(); 
                }
                if (actTimer == 75){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 2.5){
                if (actTimer == 80){
                    spawnShoes(); 
                }
                if (actTimer == 70){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 3){
                if (actTimer == 65){
                    spawnShoes(); 
                }
                if (actTimer == 60){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 3.5){
                if (actTimer == 60){
                    spawnShoes(); 
                }
                if (actTimer == 46){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 4){
                if (actTimer == 55){
                    spawnShoes(); 
                }
                if (actTimer == 40){
                    spawnShoes(); 
                }
            } else if (produceSpeed == 4.5){
                if (actTimer == 50){
                    spawnShoes(); 
                }
                if (actTimer == 35){
                    spawnShoes(); 
                }
            } else if (produceSpeed >= 5){
                if (actTimer == 45){
                    spawnShoes(); 
                }
                if (actTimer == 20){
                    spawnShoes(); 
                }
            }
        }
        
        if (actTimer > 300){
            actTimer = 0;
        }
        
    }
    public void updateSpeed(){
        GameWorld gw = (GameWorld)getWorld();
        produceSpeed = gw.getProdSpeedA();
    }
    public void updateDefaultSpeedA(){
        defaultSpeed = produceSpeed; 
    }

    public double getDefaultSpeedA(){
        return defaultSpeed;
    }

    public double getProdSpeedA(){
        return produceSpeed; 
    }

    public void setProdSpeedA(double newSpd){
        produceSpeed = newSpd;
    }

    public static double getMachItemValueA(){
        return itemValue;
    }

    public static void setMachItemValueA(double value){
        itemValue = value; 
    }

    public int returnWorkers(){
        return WC;
    }
    
    public void resetWorkers(){
        WC = 1;
    }
}