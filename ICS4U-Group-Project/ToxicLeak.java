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
        super();
        if(timer == 900){
            GameWorld gw = (GameWorld) getWorld();
            gw.remove(this);
        }
    }
    
    public void addedToWorld(World w){
        slowEfficiency();
    }
    
    public void slowEfficiency(){
        for(HiredWorkers w : getObjectsAtOffset(256, 400, HiredWorkers.class)){
            //slow workers
        }
    }
}
