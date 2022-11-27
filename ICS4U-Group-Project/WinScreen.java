//Imports
import greenfoot.*; 

/**
 * Win Screen World
 * <p>
 * Displays the image of the Win Screen, and respective text with the winning side.
 * Also displays a button connected to the main menu.
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
    
    //Methods to start and stop music
    public void started(){
        end.playLoop();
    }
    
    public void stopped(){
        end.stop();
    }
    
    public void act(){
        //When the timer increments to 300, go to the Main Menu
        timer++; 
        if(timer == 300){
            Greenfoot.setWorld(new End());
            stopped();
        }
    }
}
