import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TruckItems here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TruckItems extends Actor
{
    private int duration;
    private GreenfootImage image;

    public TruckItems(){
        image = new GreenfootImage("boximg.png");
        image.scale(40, 40);
        setImage(image);
        duration = 80;
    }

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
