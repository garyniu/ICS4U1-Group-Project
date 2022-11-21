import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hitboxes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hitboxes extends Actor
{    
    private GreenfootImage image;
    
    private boolean visible;
    private int height, width;
    // private boolean destroy;
    
    public Hitboxes()
    {
        width = 30;
        height = 80;
        // set this to true to see the Spawners - might help with understanding of how this works:
        visible = false;
        image = new GreenfootImage(width, height);
        image.setColor(Color.BLUE);
        image.fill();
        //fillRect(90, 90, width, height);
        setImage(image);
    }
    
    public void act()
    {
        
    }
    
}
