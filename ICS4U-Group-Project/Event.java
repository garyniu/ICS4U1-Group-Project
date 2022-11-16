import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Event here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Event extends Actor
{
    protected int duration; 
    protected int timer; 
    
    public Event(int duration){
        this.duration = duration; 
        timer =0; 
    }
    
    /**
     * Act - do whatever the Event wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer++;
    }
}
