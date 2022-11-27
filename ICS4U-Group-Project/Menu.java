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
     * Constructor for objects of class Menu
     * <p>
     * Sets background and generates a button.
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

    //Methods to start and stop music
    public void started(){
        Theme.playLoop();
    }

    public void stopped(){
        Theme.stop();
    }

    public void act(){
        //If the button is clicked, go to ValueSetting and stop the music
        if (b.getClick()){
            Greenfoot.setWorld(new ValueSetting());
            stopped();
        }
    }
}
