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
        timer++;
        if(timer == 180){
            endEvent();
        }
    }
    
    public void addedToWorld(GameWorld gw){
        //draw effects for stock market crash
        increaseStock();
    }
    
    public void increaseStock(){
        for(Shoes s : getObjectsAtOffset(256, 400, Shoes.class)){
            double newValue = s.getItemValue()+2;  
            s.setItemValue(newValue);
        }
    }
}
