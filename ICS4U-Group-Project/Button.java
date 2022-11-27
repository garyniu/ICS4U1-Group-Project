//Import
import greenfoot.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage background, nameImage, greyBackground; 
    private GreenfootSound Click;
    private boolean click;
    //protected width, height;
    private int timer = 0;

    public Button(GreenfootImage a, GreenfootImage b)
    {
        
        Click = new GreenfootSound ("Click.mp3");
        
        background = a;
        greyBackground = b;

        setImage(background); 
    }

    public void act() 
    {
        // Add your action code here.
        timer++;
        click = listenForClick();
    }    

    public boolean listenForClick()
    {
        if(Greenfoot.mousePressed(this))
        {
            
            
            
            greyBackground.scale(greyBackground.getWidth()+5, greyBackground.getHeight()+5);
            Greenfoot.delay(10);
            greyBackground.scale(greyBackground.getWidth()-5, greyBackground.getHeight()-5);
            Click.play();
            
            return true;
        } 
        if (Greenfoot.mouseMoved(this)){
            setImage(greyBackground);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(background);
        }
        
        return false;

    }
    
    public boolean getClick(){
        return click;
    }

}