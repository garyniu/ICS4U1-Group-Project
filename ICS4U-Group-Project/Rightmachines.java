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
   
    public void act()
    {
        // Add your action code here.
       
        imageB = new GreenfootImage("shirtMachineTemp.png");
        imageB.scale(300, 100);
        setImage(imageB);
        produceSpeed = 1;
        defaultSpeed = produceSpeed; 
       
    }
   
    public void produceB()
    {
       
    }
   
    public void upgradeB()
    {
       produceSpeed +=1; 
       defaultSpeed = produceSpeed;
    }
    public int getDefaultSpeedB(){
        return defaultSpeed; 
    }
    public void setProdSpeedB(int newSpd){
        produceSpeed = newSpd;
    }
}
