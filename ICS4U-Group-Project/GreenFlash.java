import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenFlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenFlash extends Effect
{
    /**
     * Act - do whatever the RedFlash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private int duration;
   private int flashTimer;
   private int durationTimer;
   private GreenfootImage flashing; 
   public GreenFlash(int duration){
       this.duration = duration;
       durationTimer = 0;
       flashTimer = 0;
       flashing = flashGreen(0, 0, 512, 800);
       flashing.setTransparency(100);
       setImage(flashing);
   }
   
   public void act()
   {
       flashTimer++;
       durationTimer++;
       if((flashTimer/31 == 1)){
           getImage().setTransparency(100);
           flashTimer = 0;
       }
       if((flashTimer/17) == 1){
           getImage().setTransparency(0);
       }
       if(durationTimer == duration){
           GameWorld gw = (GameWorld)getWorld();
           gw.removeObject(this);
       }
   }
   private GreenfootImage flashGreen(int x, int y, int width, int height){
        GreenfootImage canvas = new GreenfootImage(width, height); 
        image = createFlash(512 ,800, "green");
        image.setTransparency(100);
        canvas.drawImage(image, x,y);
        return canvas; 
    }
}