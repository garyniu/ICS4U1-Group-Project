//Imports
import greenfoot.*;

/**
 * Button class, used in menus, to detect if the button is clicked.
 * 
 * @author Gary Niu, Arsham Zare Moayedi, Anthony Ung
 * @version November 2022
 */
public class Button extends Actor
{
    
    //Instance variables
    protected GreenfootImage background, nameImage, greyBackground; 
    private GreenfootSound Click;
    private boolean click;

    /**
     * Constructor for Button
     * <p>
     * Creates a new Button object with a normal state and hover state
     * 
     * @param a The normal image of the button
     * @param b The hover image of the button
     */
    public Button(GreenfootImage a, GreenfootImage b)
    {
        //Creates click sound
        Click = new GreenfootSound ("Click.mp3");
        
        //Sets the normal and hover images
        background = a;
        greyBackground = b;

        //Sets the image to the normal image
        setImage(background); 
    }

    public void act() 
    {
        click = listenForClick();
    }    

    /**
     * Returns if the button is clicked
     * 
     * @return Button clicked
     */
    public boolean listenForClick()
    {
        //If the mouse clicks on the button, return true
        if(Greenfoot.mousePressed(this))
        {
            //Sets the image to the regular image, scales it up slightly, and plays the click sound
            greyBackground.scale(greyBackground.getWidth()+5, greyBackground.getHeight()+5);
            Greenfoot.delay(10);
            greyBackground.scale(greyBackground.getWidth()-5, greyBackground.getHeight()-5);
            Click.play();
            
            return true;
        } 
        //If the mouse is hovering over the button, set the image to the hover image
        if (Greenfoot.mouseMoved(this)){
            setImage(greyBackground);
        }
        //If the mouse is not hovering over the button, set the image to the normal image
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(background);
        }
        
        return false;

    }
    
    //Returns if the button is clicked
    public boolean getClick(){
        return click;
    }

}