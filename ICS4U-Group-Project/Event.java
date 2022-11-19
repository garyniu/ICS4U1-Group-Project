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
    }
    public void act()
    {
        timer++;
    }
}
