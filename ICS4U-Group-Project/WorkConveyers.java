import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorkConveyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorkConveyers extends Machines
{
   
   private int timer;
    private int speed;
    
    public WorkConveyers(){
        timer = 0;
        speed = 1;
    }
    
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

