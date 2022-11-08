import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorkConveyors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorkConveyors extends Machines
{
    private double speed;
    private double timer;
    /**
     * Act - do whatever the WorkConveyors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WorkConveyors(){
        speed = 1.0;
        timer = 0;
    }
    public void act()
    {
        timer++;
        if(timer >= ((10.0/speed)*(60.0))){
            //output x items 
            timer = 0;
        }
    }
    public void getNumWorkers(){
        
    }
    public void increaseSpeed(){
        speed+=0.25;
    }
}
