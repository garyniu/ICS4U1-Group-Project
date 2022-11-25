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
        image = new GreenfootImage("shirtMachineTemp.png");
        image.scale(100, 500);
        setImage(image);
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
        w.addObject(new Hitboxes(), this.getX(), 650);
    }
    
}
