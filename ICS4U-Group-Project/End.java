//Imports
import greenfoot.*;  

/**
 * End screen world 
 * <p>
 * Displays the image of the end screen, and a button to return to the main menu.
 * 
 * @author Gary Niu, Anthony Ung
 * @version November 2022
 */
public class End extends World
{
    private Button b;

    /**
     * Constructor for objects of class End.
     * <p>
     * Sets background and generates a button.
     */
    public End()
    {    
        // Create a new world of 1024 x 800
        super(1024, 800, 1); 

        //setting background
        GreenfootImage background2 = new GreenfootImage("EndScreen.png");
        background2.scale(1024,800);
        setBackground(background2);

        //Hoverstate and button images
        GreenfootImage background = new GreenfootImage("NormalPlayAgain.png");
        background.scale(background.getWidth()/4, background.getHeight()/4);

        GreenfootImage greyBackground = new GreenfootImage("HoverPlayAgain.png");
        greyBackground.scale(greyBackground.getWidth()/4, greyBackground.getHeight()/4);

        //create the button with hoverstate and regular image
        b = new Button(background, greyBackground);
        addObject(b,getWidth()/2,getHeight()/2 + 100); 

    }

    public void act(){
        //if clicked, go to the main menu
        if (b.getClick()){
            Greenfoot.setWorld(new Menu());
        }
    }

}
