//Imports
import greenfoot.*;  

/**
 * Class used as an image object for the BoomingBusiness class;
 * <p>
 * The corresponding event subclass (BoomingBusiness) already has its image set (the arrow animation). My simple solution for adding an event icon into 
 * the world is by adding an actor with their image set as the event icon. 
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class BoomingBusinessImage extends Effect
{
    /**
     * Constructor that simply sets the image of the BoomingBusinessImage actor and scales it
     */
    public BoomingBusinessImage(){
        GreenfootImage image = new GreenfootImage("STOCKMARKETBOOMINTEXT.png");
        setImage(image);
        getImage().scale(100,100); 
    }
}
