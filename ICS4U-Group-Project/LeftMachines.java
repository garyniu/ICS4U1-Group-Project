import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftMachines here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftMachines extends Machines
{
    /**
     * Act - do whatever the LeftMachines wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageA;
    private int items;
    private int timer;
    protected static int produceSpeed;
    private static int upgradeAmount;
    private int width;
    private int height;
    
    public LeftMachines()
    {
        imageA = new GreenfootImage("shirtMachineTemp.png");
        imageA.scale(300, 100);
        setImage(imageA);
        produceSpeed = 1;
        width = imageA.getWidth();
        height = imageA.getHeight();
        //upgradeA();
 
        upgradeAmount = GameWorld.getCurrency();
    }
    public void addedToWorld(World w)
    {
        w.addObject(new Hitboxes(), this.getX() + width/2, this.getY() - height/4);
        w.addObject(new Shoes(this), this.getX() - width/2, this.getY() - height/4);
    }
    public void act()
    {
        //getWorld().showText("" + produceSpeed, 80, 80);
        
    }
    
    //people interaction
    //method to check items on conveyer
    //  Move items to next worker, call workers work method with the item
    //    If it reaches the end of the conveyer, just move the object 
    //    far enough to the middle of the exit conveyer
    
    protected static void upgradeA()
    {
        produceSpeed += 1;
    }
    
    public static int getProdSpeedA()
    {
        return produceSpeed;
    }
}
