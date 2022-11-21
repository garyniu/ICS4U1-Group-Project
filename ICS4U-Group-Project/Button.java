import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage background; 
   
    public Button(int width, int height)
    {
        background = new GreenfootImage(width, height); 
        background.setColor(Color.BLACK); 
        background.fill(); 
    }
    public void act() 
    {
        // Add your action code here.
    }    
    
    public boolean listenForClick()
    {
        if(Greenfoot.mousePressed(this))
        {
            background.scale(background.getWidth()+5, background.getHeight()+5);
            Greenfoot.delay(10); 
            background.scale(background.getWidth()-5, background.getHeight()-5);
            Greenfoot.setWorld(new ValueSetting());
            return true;
            
        }
        
        else
        {
         return false;   
        }
    }
    
    
    
    
}