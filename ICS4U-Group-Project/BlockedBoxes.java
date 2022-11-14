import greenfoot.GreenfootImage;
import greenfoot.Actor;

/**
 * Write a description of class BlockedBoxes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlockedBoxes extends Actor
{
    // instance variables - replace the example below with your own
    private int x, y, w, h;
    private GreenfootImage image;

    /**
     * Constructor for objects of class BlockedBoxes
     */
    public BlockedBoxes(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        
        image = new GreenfootImage(w, h);
        setImage(image);
        
    }

    public boolean contact(){
        return (isTouching(Machines.class)) ? true : false;
    }
}
