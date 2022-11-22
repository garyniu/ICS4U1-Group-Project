import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GreenfootImage background2;
    private Button b;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background2 = new GreenfootImage(1024, 800);
        background2.setColor(Color.GRAY);
        b = new Button(400, 100, "Click to Start!",0);
        addObject(b,getWidth()/2,getHeight()/2); 
    }
    
    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new ValueSetting());
        }
    }
    
}
