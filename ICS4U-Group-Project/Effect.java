import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Effects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Effect extends Actor
{
    protected GreenfootImage image;
    protected Color color; 
    /**
     * This method was written by Mr. Cohen 
     */
    protected void fade (int timeLeft, int fadeTime) {
        double percent = timeLeft / (double)fadeTime;
        // Transparency 0 -- 255
        int newTransparency = (int)(percent * 255);
        image.setTransparency(newTransparency);
    }
    
    protected GreenfootImage createFlash(int width, int height, String colour){
        GreenfootImage flash = new GreenfootImage(width, height);
        
        if(colour == "red"){
            color = new Color(255, 0, 0);
        }
        else if(colour == "green"){
            color = new Color(0, 255, 0);
        }
        
        flash.setColor(color); 
        flash.fillRect(0,0, width,height);
        return flash;
    }
    protected GreenfootImage flashRed(int x, int y, int width, int height){
        GreenfootImage canvas = new GreenfootImage(width, height); 
        image = createFlash(512 ,800, "red");
        canvas.drawImage(image, x,y);
        return canvas; 
    }
    
    protected GreenfootImage flashGreen(int x, int y, int width, int height){
        GreenfootImage canvas = new GreenfootImage(width, height); 
        image = createFlash(512,800, "green");
        return canvas; 
    }
}
