import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rightmachines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rightmachines extends Machines
{
    /**
     * Act - do whatever the Rightmachines wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageB;
    private int produceTimeB;
    private static int upgradeAmount;
    private static double produceSpeed;
    private static double defaultSpeed; 
    private int width;
    private int height;
   
    public Rightmachines(){
       
        imageB = new GreenfootImage("shirtMachineTemp.png");
        imageB.scale(300, 100);
        setImage(imageB);
        produceSpeed = 1.5;
        defaultSpeed = produceSpeed; 
        
        width = imageB.getWidth();
        height = imageB.getHeight();
        upgradeAmount = GameWorld.getCurrencyB();
    }
    public void addedToWorld(World w){
        //w.addObject(new Hitboxes(), this.getX()+width/2, this.getY()-height/2);
        w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }
    public void act()
    {
        
    }
   
    public void produceB()
    {
       
    }
   
    public void upgradeB()
    {
       produceSpeed +=0.2; 
       defaultSpeed = produceSpeed;
    }
    public static double getDefaultSpeedB(){
        return defaultSpeed; 
    }
    public void setProdSpeedB(double newSpd){
        produceSpeed = newSpd;
    }
}
