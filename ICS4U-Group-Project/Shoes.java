import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoes extends Items
{
    
    public static int prodSpeedA;
    private static boolean exist;
    
    /**
     * Act - do whatever the Shoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shoes(Machines m)
    {
        image = new GreenfootImage("shoesTemp.png");
        exist = true;
        image.scale(30, 30);
        setImage(image);

        this.prodSpeedA = LeftMachines.getProdSpeedA();
    }
    public void act()
    {
        move(prodSpeedA);
        Actor b = getOneIntersectingObject(Hitboxes.class);  
        //World.showText("" + getExist(), 80, 80);
        if(b != null){  
            GameWorld.addCurrencyA();
            getWorld().removeObject(this);
            doesntExist();
        }
    }
    public static boolean getExist()
    {
        return exist;
    }
    public void doesExist()
    {
        exist = true;
    }
    public void doesntExist()
    {
        exist = false;
    }
}    
