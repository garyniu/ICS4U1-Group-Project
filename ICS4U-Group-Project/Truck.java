import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class truck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Truck extends Actor
{
    private int timer = 0, xCoordBeforeStop = 0, distFromStop = 0;
    private double unit = 2.0;
    private boolean dropOff = false;
    private int stopPointA = 500;
    public Truck(){
        System.out.println(getImage().getWidth() * 5 / 6);
        getImage().scale((getImage().getWidth() * 2 / 3), (getImage().getHeight() * 2 / 3));
    }

    public void act(){
        
        //remake below function to consider 2 points
        
        System.out.println("xCoord: " + getX());

        if (((getX() + 100) >= stopPointA) && !dropOff){
            
            System.out.println("test");
            
            distFromStop = getX() - xCoordBeforeStop;

            if (distFromStop >= 50) unit = 2;
            else if (distFromStop < 50 && distFromStop >= 25) unit = 1.5;
            else if (distFromStop < 25 && distFromStop >= 12) unit = 1;
            else if (distFromStop < 12 && distFromStop >= 6) unit = 0.5;
            else if (distFromStop < 6 && distFromStop > 0) unit = 0;
            else if (distFromStop == 0) dropOff = true;
                
            System.out.println("Distance from stop: " + distFromStop);
        } else {
            xCoordBeforeStop = getX()+(int)Math.round(unit);
            unit = 2;
        }
        
        System.out.println("remembered x coord: " + xCoordBeforeStop);
        System.out.println("Speed: " + unit + "\n");

        moving(unit);

    }

    private void moving(double movement){
        setLocation((int)(Math.round(getX() + movement)), getY());
    }

}
