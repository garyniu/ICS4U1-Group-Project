import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    private Button b;
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        GreenfootImage background2 = new GreenfootImage("EndScreen.png");
        background2.scale(1024,800);
        setBackground(background2);
        
        GreenfootImage background = new GreenfootImage("NormalPlayAgain.png");
        background.scale(background.getWidth()/4, background.getHeight()/4);

        GreenfootImage greyBackground = new GreenfootImage("HoverPlayAgain.png");
        greyBackground.scale(greyBackground.getWidth()/4, greyBackground.getHeight()/4);
        
        b = new Button(background, greyBackground);
        addObject(b,getWidth()/2,getHeight()/2 + 100); 
    }

    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new Menu());
        }
    }

}
