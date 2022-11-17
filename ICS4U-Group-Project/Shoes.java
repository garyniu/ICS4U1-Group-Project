import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoes extends Clothes
{
    
    public static int prodSpeedA;
    /**
     * Act - do whatever the Shoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shoes()
    {
        image = new GreenfootImage("shoesTemp.png");
        image.scale(30, 30);
        setImage(image);

        this.prodSpeedA = LeftMachines.getProdSpeedA();
    }
    public void act()
    {
       move(prodSpeedA);
        //setLocation(getX() + produceSpeed, getY());
       
       Actor b = getOneIntersectingObject(Hitboxes.class);  
       if(b != null)  
       {  
           GameWorld.addCurrency();
           
           
           getWorld().removeObject(this);
           return;
       }  
        
    }
}    
