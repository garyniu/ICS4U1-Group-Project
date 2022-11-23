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
    
    public Value( int points, GreenfootImage a, GreenfootImage b){
        super(a, b); 
        myPoints = points;
        
        
       
        setImage(super.background); 
        
    }
    
    public void act() 
    {
        
        if (listenForClick())
        {
            myPoints++;
            System.out.println(myPoints);
            upDatePoints();
        }
    }  
    
    private void upDatePoints()
    {
        pointsImage = new GreenfootImage(Integer.toString(myPoints),30,Color.WHITE, Color.BLACK);
        background.drawImage(pointsImage,300,300);
    }
}