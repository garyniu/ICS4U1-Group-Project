/**
 * Write a description of class StockMarketCrash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockMarketCrash extends Event
{
    private double newValue; 
    /**
     * Act - do whatever the StockMarketCrash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StockMarketCrash(int d){
        super(d);
    }
    public void act(){
       timer++;
       //decrease
       if(timer == 180){
          endEvent();
        }
    }
    public void addedToWorld(GameWorld gw){
        //draw effects for stock market crash
        decreaseStock();
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
