//Imports
import greenfoot.*; 

/**
 * Win Screen World
 * <p>
 * Displays the image of the Win Screen, and respective text for the winning side.
 * After a couple of seconds, it will switch to a screen that prompts the player to play again. 
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class WinScreen extends World
{
    private String winner; 
    private GreenfootImage background;
    private int timer = 0; 
    private GreenfootSound end;
    
    /**
     * Constructor for objects of class WinScreen
     * <p>
     * Sets background for the world.
     * 
     * @param winner The winning side of the game, sent in as either "left" or "right"
     */
    public WinScreen(String winner)
    {    
        // Create a new world of 1024 x 800
        super(1024, 800, 1);
        
        //Setting audio for background music
        end = new GreenfootSound("end.mp3");
        
        //Setting world background, based on the winning side
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
    /**
     * Started() method - used for playing music in a loop
     */
    public void started(){
        end.playLoop();
    }
    /**
     * Stopped() method - stops music if the world is stopped
     */
    public void stopped(){
        end.stop();
    }
    /**
     * After the timer reaches 300 Greenfoot Acts, it will switch the world to End. 
     */
    public void act(){
        timer++; 
        if(timer == 300){
            Greenfoot.setWorld(new End());
            stopped();
        }
    }
}
