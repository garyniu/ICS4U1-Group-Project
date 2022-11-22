import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Value extends Button
{
    private int myPoints;
    GreenfootImage nameImage;
    GreenfootImage pointsImage;
    
     /**
     *  
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Value(String name, int points){
        super(100,100,name, 0); 
        myPoints = points;
        pointsImage = new GreenfootImage(Integer.toString(points),30,Color.GREEN, Color.BLACK); 
        nameImage = new GreenfootImage(name, 50, Color.WHITE, Color.BLACK);
        super.background.drawImage(nameImage, background.getWidth()/2-nameImage.getWidth()/2,background.getHeight()/2-nameImage.getHeight()/2);
        super.background.drawImage(pointsImage,background.getWidth()/2-pointsImage.getWidth()/2, background.getHeight()-pointsImage.getHeight()); 
        
       
        setImage(super.background); 
        
    }
    
     public void act() 
    {
        if (listenForClick())
        {
            myPoints++;
            upDatePoints();
        }
    }  
    
    private void upDatePoints()
    {
        pointsImage = new GreenfootImage(Integer.toString(myPoints),30,Color.WHITE, Color.BLACK);
        background.drawImage(pointsImage,300,300);
    }
}