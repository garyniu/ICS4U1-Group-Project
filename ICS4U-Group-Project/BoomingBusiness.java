import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoomingBusiness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusiness extends Event
{
    private GreenFlash gf; 
    public BoomingBusiness(int d){
        super(d);
        gf = new GreenFlash(duration); 
        System.out.println("BOOMING BUSINESS");
    }
    public void addedToWorld(World w){
        w.addObject(gf, 256, 400);
        increaseStock();
    }
    public void act()
    {
        eventTimer++;
        if(eventTimer == duration){
            endEvent();
        }
    }
    
    public void increaseStock(){
        for(Shoes s : getObjectsAtOffset(256, 400, Shoes.class)){
            double newValue = s.getItemValue()+2;  
            s.setItemValue(newValue);
        }
    }
}
