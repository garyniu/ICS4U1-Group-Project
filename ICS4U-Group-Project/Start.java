import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Button
{
    private int myPoints;
    GreenfootImage nameImage;
    GreenfootImage pointsImage;
    
     /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Start(String name){
        super(100,100); 
        nameImage = new GreenfootImage(name, 15, Color.WHITE, Color.BLACK);
        super.background.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);
        
        /*
        image.setColor(Color.BLUE);
        image.fillRect(0,0,100,50); 
        image.setColor(Color.WHITE); 
        image.drawString(name,image.getWidth()/2-15, image.getHeight()/2+5); 
        */
        setImage(super.background); 
        
    }
    
     public void act() 
    {
        if (listenForClick())
        {
            
            
        }
    }  
    
    private void upDatePoints()
    {
        pointsImage = new GreenfootImage(Integer.toString(myPoints),30,Color.WHITE, Color.BLACK);
        super.background.drawImage(pointsImage,background.getWidth()/2-pointsImage.getWidth()/2, background.getHeight()-pointsImage.getHeight());
    }
}