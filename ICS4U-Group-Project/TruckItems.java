import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cargo dropped off by the truck
 * 
 * @author Gary Niu 
 * @version November 2022
 */
public class TruckItems extends Actor
{
    private int duration;
    private GreenfootImage image;
    
    /**
     * Constructor - sets image and duration value
     */
    public TruckItems(){
        image = new GreenfootImage("boximg.png");
        image.scale(40, 40);
        setImage(image);
        duration = 80;
    }
    /**
     * Sets location for truck, fade in effect, and removes the object if duration == 0 
     */
    public void act()
    {
        // Add your action code here.
        setLocation (getX(), getY() + 1);

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
