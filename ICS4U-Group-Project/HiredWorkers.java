import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HiredWorkers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HiredWorkers extends People
{
    /**
     * Act - do whatever the HiredWorkers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HiredWorkers(){
        direction = -2;
    }
    public void act()
    {
        if(this.getY() >= 800){
            direction = -2;
        }
        if(this.getY() <= 0){
            direction = 2;
        }
        setLocation(this.getX(), this.getY()+direction);
    }
}
