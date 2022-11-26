import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Machines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Machines extends Actor
{
    //TODO
    //implement machines (conveyers)
    // - Static
    //  - just a rectangle, moves items on it
    // - Add
    //  - add new worker conveyers, 3 sections for each employee
    // create an
    protected double machineSpeed;
    protected int level;
    protected int upgradeAmount;     
    protected boolean speedSet;
    protected int actTimer;
    protected int width;
    protected int height;
    public Machines(){
       getImage().scale(333, 72);
       speedSet = false;
       actTimer = 0; 
       width = getImage().getWidth();
       height = getImage().getHeight();
    }
    public void act()
    {
        // Add your action code here.
       
    }
}