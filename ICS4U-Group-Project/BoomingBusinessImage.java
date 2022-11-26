import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The corresponding event subclass (BoomingBusiness) already has its image set (the arrow animation). My simple solution for adding an event icon into 
 * the world is by adding an actor with their image set as the event icon. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusinessImage extends Effect
{
    public BoomingBusinessImage(){
        GreenfootImage image = new GreenfootImage("STOCKMARKETBOOMINTEXT.png");
        setImage(image);
        getImage().scale(100,100); 
    }
    /**
     * Act - do whatever the BoomingBusinessImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}