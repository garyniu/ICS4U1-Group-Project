import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class conveyerstatic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class conveyerstatic extends Machines
{
    
    // For output conveyer only
    
    public conveyerstatic(){
        
    }
    
    
    /**
     * Act - do whatever the conveyerstatic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer;
    private int speed;
    
    
    
    public void act()
    {
        timer++;
        if(speed == 1){
          if (timer == 1200){ //after 20 seconds
            //output item (1 item is finished producing)
            //when outputing items, it will be 1*# workers
            timer=0;
          }  
        }
    }
    
    public void upgradeSpeed(){
        speed++;
    }
    //returns # of workers per station
    public void returnWorkers(){
        
    }
}
