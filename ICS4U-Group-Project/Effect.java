//Imports
import greenfoot.*;

/**
 * Effects class, used to create a flashing effect on the screen.
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class Effect extends Actor
{
    //Instance variables
    protected GreenfootImage image;
    protected Color color; 
    
    /**
     * Method to create flashing effect
     * 
     * @param color The color of the flashing effect, a string that is either "red" or "green"
     * @param width The width of the flashing effect
     * @param height The height of the flashing effect
     *
     */
    protected GreenfootImage createFlash(int width, int height, String colour){
        GreenfootImage flash = new GreenfootImage(width, height);
        
        if(colour == "red"){
            color = new Color(255, 0, 0);
        }
        else if(colour == "green"){
            color = new Color(0, 255, 0);
        }
        
        flash.setColor(color); 
        flash.fillRect(0,0, width,height);
        return flash;
    }
}
