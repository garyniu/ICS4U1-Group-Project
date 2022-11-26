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
    private GreenfootSound end;
    
    public WinScreen(String winner)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        
        end = new GreenfootSound("end.mp3");
        
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
        
        if(winner == "left"){
          //System.out.println("THe winner was left side");
          end.playLoop();
        } else if(winner == "right"){
            //System.out.println("the winner was right side");
            end.playLoop();
        }
    }
    
    public void started(){
        end.playLoop();
        
    }
    
    public void stopped(){
        end.stop();
    }
    
    public void act(){
        timer++; 
        if(timer == 300){
            Greenfoot.setWorld(new End());
            stopped();
        }
    }
}
