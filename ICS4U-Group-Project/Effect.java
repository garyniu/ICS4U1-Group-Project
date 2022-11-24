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
}
