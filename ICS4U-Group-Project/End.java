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
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 

        b = new Button(this.getWidth()/3, this.getHeight()/10, "Restart the game");
        addObject(b,this.getWidth()/2, this.getHeight()/2); 

    }

    public void act(){
        if (b.getClick()){
            Greenfoot.setWorld(new Menu());
        }
    }
}
