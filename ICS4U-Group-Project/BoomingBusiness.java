import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoomingBusiness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusiness extends Event
{
    public BoomingBusiness(int d){
        super(d);
    }
    public void act()
    {
        super();
        if(timer == 180){
            GameWorld gw = (GameWorld)getWorld();
            gw.remove(this);
        }
    }
    
    public void addedToWorld(World w){
        //draw effects for stock market crash
        increaseStock();
    }
    
    public void increaseStock(){
        //double the stock/value of an item 
    }
}
