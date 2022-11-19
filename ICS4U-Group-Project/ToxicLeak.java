import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToxicLeak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToxicLeak extends Event
{
    public ToxicLeak(int d){
        super(d);
    }
    public void act()
    {
        timer++;
        if(timer == 900){
            resumeEfficiency();
            endEvent();
        }
    }
    
    public void addedToWorld(GameWorld gw){
        slowEfficiency();
    }
}
