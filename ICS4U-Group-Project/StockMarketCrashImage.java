import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class used as an image object for the StockMarketCrash class;
 * <p>
 * The corresponding event subclass already has its image set (the arrow animation). My simple solution for adding an event 
 * icon into the world is by adding an actor with their image set as the event icon. 
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class StockMarketCrashImage extends Effect
{
    /**
     * Constructor that simply sets the image of the StockMarketCrashImage actor and scales it
     */
    public StockMarketCrashImage(){
        GreenfootImage image = new GreenfootImage("STOCKMARKETCRASHTEXT.png");
        setImage(image);
        getImage().scale(100,100); 
    }
}
