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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        background2 = new GreenfootImage(1024, 800);
        background2.setColor(Color.GRAY);
        Start startButton = new Start("Press to begin!"); 
        addObject(startButton,300,300); 
    }
    /*
     * 
     * DO NOT TOUCH
    public void act()
    {
      showText(startButton.buttonState.toString(), 500,100); 
      
      if(Greenfoot.mouseClicked(null))
      {
          showText("clicked", 300,300); 
        }
        
        else
        {
            showText("not clicked", 300,300); 
        }
    }
    */
}
