//Imports
import greenfoot.*;  

/**
 * Main menu world
 * <p>
 * Displays the image of the Main menu, and a button connected to ValueWorld.
 * 
 * @author Gary Niu, Anthony Ung
 * @version November 2022
 */
public class Menu extends World
{
    private Button b;
    private GreenfootSound Theme;
    /**
     * Constructor for objects of class Menu - Sets background and generates a button to switch to ValueSetting
     */
    public Menu()
    {    
        // Create a new world of 1024 x 800
        super(1024, 800, 1); 

        //Setting audio for background music
        Theme = new GreenfootSound ("Theme.mp3");
        Theme.setVolume(30);        

        //Setting world background
        GreenfootImage background2 = new GreenfootImage("IntroScreen.png");
        background2.scale(1024,800);
        setBackground(background2);

        //Hoverstate and normalstate for buttons
        GreenfootImage background = new GreenfootImage("NormalButton.png");
        background.scale(background.getWidth()/4, background.getHeight()/4);

        GreenfootImage greyBackground = new GreenfootImage("PressedButton.png");
        greyBackground.scale(greyBackground.getWidth()/4, greyBackground.getHeight()/4);

        //create the button with hoverstate and regular image
        b = new Button(background, greyBackground);
        addObject(b,getWidth()/2,getHeight()/2 + 100); 
    }

    /**
     * Started() method - used for playing music in a loop
     */
    public void started(){
        Theme.playLoop();
    }
    /**
     * Stopped() method - stops music if the world is stopped
     */
    public void stopped(){
        Theme.stop();
    }
    /**
     * Checks to see if the button is clicked, and if so, it will switch to the ValueSetting screen and stop the music
     */
    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new ValueSetting());
            stopped();
        }
    }
}
