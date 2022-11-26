import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Button b;
    private GreenfootSound Theme;
    private GreenfootSound Click;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        
        Theme = new GreenfootSound ("Theme.mp3");
        Click = new GreenfootSound ("Click.mp3");
        
        /*if (Theme == null){
            Theme = new GreenfootSound("Theme.mp3");
            Theme.setVolume(50);
            Theme.play();
        
        
        }
        */
        GreenfootImage background2 = new GreenfootImage("IntroScreen.png");
        background2.scale(1024,800);
        setBackground(background2);

        GreenfootImage background = new GreenfootImage("NormalButton.png");
        background.scale(background.getWidth()/4, background.getHeight()/4);

        GreenfootImage greyBackground = new GreenfootImage("PressedButton.png");
        greyBackground.scale(greyBackground.getWidth()/4, greyBackground.getHeight()/4);
        
        b = new Button(background, greyBackground);
        addObject(b,getWidth()/2,getHeight()/2 + 100); 
        
        
    }
    
    
    
    public void started(){
        Theme.playLoop();
    }
    
    public void stopped(){
        Theme.stop();
    }
    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new ValueSetting());
            Click.play();
            stopped();
        }
    
    }
}
