import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shoes extends Clothes
{
   
    public int prodSpeedA;
    public String facing; 
    /**
     * Act - do whatever the Shoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shoes(Machines m)
    {
        image = new GreenfootImage("shoesTemp.png");
        image.scale(30, 30);
        setImage(image);
        if(this.getX() <=256){
            facing = "left";
            LeftMachines lm = (LeftMachines)m; 
            this.prodSpeedA = lm.getDefaultSpeedA();
        } else if(this.getX()>256){
            facing = "right";
            Rightmachines rm = (Rightmachines)m; 
            this.prodSpeedA = rm.getDefaultSpeedB();
        }
        if(facing == "left"){
            
        }
        
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