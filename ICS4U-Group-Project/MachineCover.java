//Imports
import greenfoot.*; 

/**
 * Simple class for an image object to cover Shoes while it travels along the conveyer.
 * 
 * @author Gary Niu
 * @version November 2022
 */

public class MachineCover extends Machines
{
    /**
     * Constructor - sets Image for MachineCover
     */
    public MachineCover(){
        GreenfootImage image = new GreenfootImage("ConveyerC.png");
        setImage(image);
        getImage().scale(333, 72);
    }
}
