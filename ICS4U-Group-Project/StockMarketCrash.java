/**
 * Write a description of class StockMarketCrash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockMarketCrash extends Event
{
    /**
     * Act - do whatever the StockMarketCrash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StockMarketCrash(int d){
        super(d);
    }
    public void act(){
       super();
       //decrease
       if(timer == 180){
          GameWorld gw = (GameWorld)getWorld();
          gw.removeObject(this); 
        }
    }
    public void addedToWorld(GameWorld gw){
        //draw effects for stock market crash
        decreaseStock();
    }
    
    public void decreaseStock(){
        //half the stock/value of an item 
    }
    
}
