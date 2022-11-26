import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    private String winner; 
    private GreenfootImage background;
    private int timer; 
    public WinScreen(String winner)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        timer = 0;
        if(winner == "left"){
          background = new GreenfootImage("images/TEAM_AWIN.png");
          setBackground(background);
          background.scale(1024,800);
        } else if(winner == "right"){
          background = new GreenfootImage("images/TEAM_BWIN.png");
          setBackground(background);
          background.scale(1024,800);
        }
    }
    public void act(){
        timer++; 
        if(timer == 180){
            Greenfoot.setWorld(new End());
        }
    }
}
