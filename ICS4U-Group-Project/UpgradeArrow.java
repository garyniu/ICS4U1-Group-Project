import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeArrow extends Actor
{
    
    private int type;
    private int duration;
    private GreenfootImage image;
    
    private GreenfootSound upgrade;
    
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
     * Act - do whatever the UpgradeArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation (getX(), getY() - 1);
        
        if (duration == 0){
            getWorld().removeObject(this);
        } else if (duration <= 60){
            fadeOut (duration);
        }
        duration--;
    }
    
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
