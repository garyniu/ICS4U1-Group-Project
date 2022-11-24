import greenfoot.*;
/**
 * Write a description of class StockMarketCrash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockMarketCrash extends Event
{
    private double newValue; 
    private RedFlash rf;
    /**
     * Act - do whatever the StockMarketCrash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StockMarketCrash(int d){
        super(d);
        rf = new RedFlash(duration);
        System.out.println("STOCK MARKET CRASH");
    }
    public void addedToWorld(World w){
        w.addObject(rf, 256, 400);
        decreaseStock();
    }
    public void act(){
       eventTimer++;
       //decrease
       if(eventTimer == 180){
          endEvent();
        }
    }    
    public void decreaseStock(){
        for(Shoes s : getObjectsAtOffset(256, 400, Shoes.class)){
            if(s.getItemValue() > 2){
                newValue = s.getItemValue()-2;  
                s.setItemValue(newValue);
            }
            else if(s.getItemValue() ==2){
                newValue = 1; 
                s.setItemValue(newValue);
            }
        }
    }
    
}
