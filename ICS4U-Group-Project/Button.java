import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    GreenfootImage background, nameImage, greyBackground; 

    public Button(int width, int height, String name)
    {
        background = new GreenfootImage(width, height); 
        background.setColor(Color.BLACK); 
        background.fill(); 

        nameImage = new GreenfootImage(name, 15, Color.WHITE, Color.BLACK);
        background.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);

        greyBackground = new GreenfootImage(width, height); 
        greyBackground.setColor(Color.GRAY); 
        greyBackground.fill(); 
        greyBackground.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);

        setImage(background); 
    }

    public void act() 
    {
        // Add your action code here.
        listenForClick();
    }    

    public void listenForClick()
    {
        if(Greenfoot.mousePressed(this))
        {
            greyBackground.scale(greyBackground.getWidth()+5, greyBackground.getHeight()+5);
            Greenfoot.delay(10); 
            greyBackground.scale(greyBackground.getWidth()-5, greyBackground.getHeight()-5);
            Greenfoot.setWorld(new ValueSetting());

        } 
        if (Greenfoot.mouseMoved(this)){
            setImage(greyBackground);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(background);
        }

    }

}