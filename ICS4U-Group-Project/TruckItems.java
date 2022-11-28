import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Simple image of an item, that spawns, moves down, and fades out
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class TruckItems extends Actor
{
    //Instance variables
    private int duration;
    private GreenfootImage image;
    
    /**
     * Constructor for TruckItems
     * <p>
     * Sets the image of the TruckItems to a box
     */
    public TruckItems(){
        image = new GreenfootImage("boximg.png");
        image.scale(40, 40);
        setImage(image);
        duration = 80;
    }

    public void act()
    {
        //Moves the item down
        setLocation (getX(), getY() + 1);

        //Checks a timer, if it reaches 0, remove itself, else, progressivly fade out
        if (duration == 0){
            getWorld().removeObject(this);
        } else if (duration <= 60){
            double percent = duration / (double)80;
            int transperency = (int)(percent * 255);
            
            // Prevent going out of bounds
            if (transperency > 255){
                transperency = 255;
            } else if (transperency < 0){
                transperency = 0;
            }
            image.setTransparency(transperency);
        }

        duration--;
    }
}
