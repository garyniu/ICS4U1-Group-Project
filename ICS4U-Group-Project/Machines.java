//Imports
import greenfoot.*;  

/**
 * Machine class for the conveyer belts
 * <p>
 * Mainly holding instance variables for subclasses.
 *
 * @author Victor Wei, Gary Niu, Harishan Ganeshanathan
 * @version November 2022
 */
public abstract class Machines extends Actor
{
    //Instance variables
    protected double machineSpeed;
    protected int level;
    protected int upgradeAmount;     
    protected boolean speedSet;
    protected int actTimer;
    protected int width;
    protected int height;

    /**
     * Constructor for objects of class Machines
     */
    public Machines(){
        //Seting the image of the machine
        GreenfootImage image = new GreenfootImage("Conveyer.png");
        setImage(image);
        getImage().scale(333, 72);

        //Setting the instance variables
        speedSet = false;
        actTimer = 0; 
        width = getImage().getWidth();
        height = getImage().getHeight();
        
    }
}