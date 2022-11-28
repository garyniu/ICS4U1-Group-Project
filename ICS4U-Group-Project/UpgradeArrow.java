import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An upgrade arrow that spawns when the boss buys an upgrade, rises and fades out.
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class UpgradeArrow extends Actor
{
    
    //Instance variables
    private int type;
    private int duration;
    private GreenfootImage image;
    
    private GreenfootSound upgrade;
    
    /**
     * Constructor for UpgradeArrow - Sets the image of the UpgradeArrow, and plays the upgrade sound
     * @param type The type of upgrade arrow to spawn, changes image based on type (0 for a worker arrow, 1 for a machine arrow)
     */
    public UpgradeArrow(int type){
        this.type = type;
        
        if (type == 0){
            image = new GreenfootImage("WorkerArrow.png");
            image.scale(image.getWidth()/10, image.getHeight()/10);
            setImage(image);
        } else if (type == 1){
            image = new GreenfootImage("MachineUpgrade.png");
            image.scale(image.getWidth()/4, image.getHeight()/4);
            setImage(image);
        }
        
        upgrade = new GreenfootSound("upgrade.mp3");
        upgrade.setVolume(30);
        upgrade.play();
        duration = 60;
    }

    /**
     * Moves the arrow up, starts fade out effect, and removes object if duration == 0
     */
    public void act()
    {
        //Move the arrow up
        setLocation (getX(), getY() - 1);
        
        //Fade out while there is still duraiton left
        if (duration == 0){
            getWorld().removeObject(this);
        } else if (duration <= 60){
            fadeOut (duration);
        }
        duration--;
    }
    
    /**
     * Fades out the image of the UpgradeArrow
     * 
     * @param timer Duration of the fade out
     */
    private void fadeOut(int timer){
        double percent = timer / (double)60;
        int transperency = (int)(percent * 255);
        
        // Prevent going out of bounds
        if (transperency > 255){
            transperency = 255;
        } else if (transperency < 0){
            transperency = 0;
        }
        image.setTransparency(transperency);
    }
}
