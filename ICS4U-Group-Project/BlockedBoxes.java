//Imports
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

/**
 * Object used to detect if there is a collision between two objects.
 * <p>
 * Used in People for pathfinding, and in Shoes to see if it has reached the end of the conveyer.
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class BlockedBoxes extends Actor
{
    // instance variables - replace the example below with your own
    private int w, h, timer = 0;
    private GreenfootImage image;
    private boolean wC;

    /**
     * Constructor for BlockedBoxes
     * <p>
     * Creates a new BlockedBoxes object with a width and height, and sets it to an invisible image
     * 
     * @param w Width of the BlockedBoxes object
     * @param h Height of the BlockedBoxes object
     * @param wC If the BlockedBoxes is used by People or Machines, true if Machines, false if People
     */
    public BlockedBoxes(int w, int h, boolean isMachineUsing)
    {

        //Sets the width and height of the BlockedBoxes object
        wC = isMachineUsing;
        this.w = w;
        this.h = h;

        //Creates a new invisible image with the width and height
        image = new GreenfootImage(w, h);
        image.setColor(new Color(0,0,0,0));
        image.fillRect(0, 0, w-1, h - 1);
        setImage(image);

    }

    public void act(){
        //If the BlockedBoxes is used by People, it will be removed after 1 second
        if (!wC){
            timer++;
            if (timer > 1) getWorld().removeObject(this);
        }
    }

    /**
     * Returns if the BlockedBoxes is colliding with a Machine
     * 
     * @return If collision is detected
     */
    public boolean contact(){
        return (isTouching(Machines.class) && !isTouching(VertConveyor.class)) ? true : false;
    }

    //Getter method to see if it is being used by a Machine
    public boolean isMachine(){
        return wC;
    }
}
