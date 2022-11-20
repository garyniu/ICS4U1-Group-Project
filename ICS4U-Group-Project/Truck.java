import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class truck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Truck extends Actor
{
    private int timer = 120, xCoordBeforeStop = 0, distFromStop = 0, transInt, stopTime = 0;
    private double unit = 2.0, trans = 0;
    private boolean dropOff = false;
    private int stopPointA = 300, stopPointB = 700;

    private GreenfootImage image = new GreenfootImage("truck.png");

    public Truck(){
        setImage(image);
        System.out.println(getImage().getWidth() * 5 / 6);
        getImage().scale((getImage().getWidth() * 2 / 3), (getImage().getHeight() * 2 / 3));

    }

    public void act(){
        if (timer > 0){
            timer--;
            fadeIn(timer);
        }

        if (getX() > 700){

        }


        if (getX() < stopPointA - 1){
            stopping(stopPointA);
            stopTime = 0;
        } else if (getX() == stopPointA - 1 && stopTime < 240){
            unit = 0;
            stopTime++;
        } else if (getX() < stopPointB - 1){
            stopping(stopPointB);
            stopTime = 0;
        } else if (getX() == stopPointB - 1 && stopTime < 240){
            unit = 0;
            stopTime++;
        } else {
            unit = 2;
            stopTime = 0;
        }

        moving(unit);
        
        System.out.println(getWorld().getWidth());
        System.out.println(getX());

        if (getX() > getWorld().getWidth()-2){
            getWorld().removeObject(this);
        }

    }

    private void moving(double movement){
        setLocation((int)(Math.round(getX() + movement)), getY());
    }

    private void stopping(int stopLoc){

        if (((getX() + 100) > stopLoc)){

            distFromStop = stopLoc - getX();

            if (distFromStop >= 70) unit = 2;
            else if (distFromStop < 70 && distFromStop >= 50) unit = 1.5;
            else if (distFromStop < 50 && distFromStop >= 25) unit = 1;
            else if (distFromStop < 25 && distFromStop >= 2) unit = 0.5;
            else if (distFromStop < 2) unit = 0; 

        } else {
            unit = 2;
        }

    }

    private void fadeIn(int timer){
        trans = (120 - timer);
        trans = trans / 120;
        trans = trans * 250;
        transInt = (int)Math.round(trans);
        getImage().setTransparency(transInt);
    }

}
