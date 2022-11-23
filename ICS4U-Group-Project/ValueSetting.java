import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValueSetting extends World
{
    private GreenfootImage background2;
    private Value b;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ValueSetting()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        GreenfootImage background = new GreenfootImage(100,100); 
        background.setColor(Color.BLACK); 
        background.fill(); 

        GreenfootImage nameImage = new GreenfootImage("# Of workers", 50, Color.WHITE, Color.BLACK);
        background.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);

        GreenfootImage greyBackground = new GreenfootImage(100,100); 
        greyBackground.setColor(Color.GRAY); 
        greyBackground.fill(); 
        nameImage = new GreenfootImage("# Of workers", 50, Color.WHITE, Color.GRAY);
        greyBackground.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);
        
        b = new Value(0, background, greyBackground);
        addObject(b,getWidth()/2,getHeight()/2); 
    }
    
    public void act(){
        
    }
    
   
    
    
   
    
}
