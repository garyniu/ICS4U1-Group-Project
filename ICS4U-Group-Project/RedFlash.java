//Imports
import greenfoot.*; 

/**
 * Red Flash class, used to create a red flash effect on the screen.
 * <p>
 * Creates a red flash effect on the screen, which is used in the Stock Market Crash event.
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class RedFlash extends Effect
{
//Instance variables
   private int duration;
   private int flashTimer;
   private int durationTimer;
   private GreenfootImage flashing; 

   /**
     * Constructor for RedFlash.
     * <p>
     * Sets instance variables, and creates the red flash effect from the Effect superclass.
     * 
     * @param duration Duration of the red flash effect
     */
   public RedFlash(int duration){
       this.duration = duration;
       durationTimer = 0;
       flashTimer = 0;

       //Creates the green flash effect from the Effect superclass
       flashing = flashRed(0, 0, 512, 800);
       flashing.setTransparency(100);
       setImage(flashing);
   }
   /**
    * If the flashTimer reaches a certain time, it will set the flash transparency to 0, turning it "off".
    * If the flashTimer reaches another set time, it will reset the flash transparency to 1, turning it back 'on". 
    * Finally, if the durationTimer reaches the set duration of the effect, it will remove itself from the world
    */
   public void act()
   {
       flashTimer++;
       durationTimer++;

       //Flashing based on transparency
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

   /**
     * Method to draw on the generated flashing image onto the Game World.
     * 
     * @param x The x coordinate of the green flash effect
     * @param y The y coordinate of the green flash effect
     * @param width The width of the green flash effect
     * @param height The height of the green flash effect
     * @return The green flash effect
     */
   private GreenfootImage flashRed(int x, int y, int width, int height){
        GreenfootImage canvas = new GreenfootImage(width, height); 
        image = createFlash(512 ,800, "red");
        image.setTransparency(100);
        canvas.drawImage(image, x,y);
        return canvas; 
    }
}
