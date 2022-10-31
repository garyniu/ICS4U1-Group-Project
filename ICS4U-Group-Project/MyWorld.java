import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private GreenfootImage background;

    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        background = new GreenfootImage(1024, 800);
        background.setColor(Color.GRAY);
        background.fillRect(0, 0, 1024, 800);
        setBackground(background);
        
        getBackground().setColor(new Color(0, 0, 0));
        getBackground().drawLine(512, 0, 512, 800);
        addObject(new FifthMachine(), 400, 600);
        addObject(new FifthMachine(), 624, 600);
        addObject(new FirstMachine(), 362, 120);
        addObject(new FirstMachine(), 662, 120);
    }
    
    public void act(){

        
    }
}
