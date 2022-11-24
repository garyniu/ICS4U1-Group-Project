import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedFlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedFlash extends Effect
{
    /**
     * Act - do whatever the RedFlash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private int duration;
   private GreenfootImage flashing; 
   public RedFlash(int duration){
       this.duration = duration;
   }
   public void addedToWorld(World w){
       flashing = flashRed(0, 0, 512, 800);
       flashing.setTransparency(100);
       setImage(flashing);
   }
   public void act()
   {
       GreenfootImage i = getImage();
       for(int x = 0; x < duration*60; x++){
           i.setTransparency(0);
           Greenfoot.delay(20);
           i.setTransparency(100);
           Greenfoot.delay(20);
       }
   }
}
