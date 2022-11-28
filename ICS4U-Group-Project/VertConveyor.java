import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A VertConveyor is what transports shoes from the end of the Left or Right conveyer. 
 * <p>
 * Mostly a visual aspect, shoes do the transportation themselves. 
 * 
 * @author Harishan Ganeshanathan 
 * @version November 2022
 */
public class VertConveyor extends Machines
{
    private GreenfootImage image;
    /**
     * Constructor sets and scales the image of the vertical conveyor
     */
    public VertConveyor(){
        GreenfootImage image = new GreenfootImage("VertConveyer.png");
        setImage(image);
        getImage().scale(52,380);
    }
    /**
     * When added to the world, a BlockedBoxes object will spawn at the end of the vertical conveyor. 
     */
    public void addedToWorld(World w){
        w.addObject(new BlockedBoxes(30, 80, true), this.getX()+9, 700);
    }
    
}
