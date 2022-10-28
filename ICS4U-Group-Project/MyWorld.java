import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private GreenfootImage background, test;
    private MouseInfo mouse = Greenfoot.getMouseInfo();
    
    private int x = 0, y = 0;
    
    
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
        
    }
    
    public void act(){
        
        setBackground(background);
        
        test = new GreenfootImage(1024, 800);
        test.setColor(Color.BLACK);
        mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null){
            x = mouse.getX() / 4;
        }
        if (mouse != null){
            y = mouse.getY() / 4;
        }
        
        System.out.println(x + " " + y);
        
        
        test.fillRect(x, y, x + 400, y + 300);
        
        setBackground(test);
        
    }
}
