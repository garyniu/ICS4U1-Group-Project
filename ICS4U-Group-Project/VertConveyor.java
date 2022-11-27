import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VertConveyor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VertConveyor extends Machines
{
    private GreenfootImage image;
    private int width;
    private int height;
    public VertConveyor(){
        GreenfootImage image = new GreenfootImage("VertConveyer.png");
        setImage(image);
        getImage().scale(52,380);
    }
    /**
     * Act - do whatever the VertConveyor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void addedToWorld(World w){
        w.addObject(new BlockedBoxes(30, 80, true), this.getX()+9, 700);
    }
    
}
