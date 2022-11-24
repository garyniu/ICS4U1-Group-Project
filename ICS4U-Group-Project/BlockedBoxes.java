import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

/**
 * Write a description of class BlockedBoxes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockedBoxes extends Actor
{
    // instance variables - replace the example below with your own
    private int x, y, w, h, timer = 0;
    private GreenfootImage image;

    /**
     * Constructor for objects of class BlockedBoxes
     */
    public BlockedBoxes(int x, int y, int w, int h, Color c)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        
        image = new GreenfootImage(w, h);
        image.setColor(c);
        image.fillRect(0, 0, w-1, h - 1);
        setImage(image);
        
    }
    
    public void act(){
        timer++;
        if (timer > 1) getWorld().removeObject(this);
    }

    public boolean contact(){
        return (isTouching(Machines.class) || isTouching(People.class)) ? true : false;
    }
}
