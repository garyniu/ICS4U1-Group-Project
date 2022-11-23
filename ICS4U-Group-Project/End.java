import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{

    private Button b;
    private int width = 400, height = 100;
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        
        GreenfootImage background = new GreenfootImage(width, height); 
        background.setColor(Color.BLACK); 
        background.fill(); 

        GreenfootImage nameImage = new GreenfootImage("Restart the game", 50, Color.WHITE, Color.BLACK);
        background.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);

        GreenfootImage greyBackground = new GreenfootImage(width, height); 
        greyBackground.setColor(Color.GRAY); 
        greyBackground.fill(); 
        nameImage = new GreenfootImage("Restart the game", 50, Color.WHITE, Color.GRAY);
        greyBackground.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);

        b = new Button(background, greyBackground);
        addObject(b,this.getWidth()/2, this.getHeight()/2); 

    }

    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new Menu());
        }
    }
}
