import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Truck class, a visual effect of a truck, that stops at certian points to drop off cargo
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class Truck extends Actor
{
    //Instance variables
    private int timer = 120, xCoordBeforeStop = 0, distFromStop = 0, transInt, stopTime = 0;
    private double unit = 2.0, trans = 0;
    private boolean dropOff = false;
    private int stopPointA = 150, stopPointB = 680;
    
    private GreenfootSound truckNoise;
    private GreenfootSound delivery;

    private GreenfootImage image = new GreenfootImage("truck.png");

    /**
     * Constructor for Truck
     * <p>
     * Sets the image of the Truck, and plays a sound
     */
    public Truck(){
        setImage(image);

        getImage().scale((getImage().getWidth() * 2 / 3), (getImage().getHeight() * 2 / 3));

        truckNoise = new GreenfootSound("truck.mp3");
        delivery = new GreenfootSound("delivery.mp3");
        delivery.setVolume(40);
        truckNoise.setVolume(35);
        truckNoise.play();
    }

    public void act(){
        //Moves the truck, and stops at two points, and drops off cargo
        //If reaching a stopping point, it calls the stopping method
        if (timer > 0){
            timer--;
            fadeIn(timer);
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

        //System.out.println(getWorld().getWidth());
        //System.out.println(getX());

        //Spawns cargo at the dropoff point
        if (stopTime == 60 || stopTime == 120 || stopTime == 180){
            getWorld().addObject(new TruckItems(), getX(), getY()+50);
            delivery.play();
        }

        //If the truck is at the end of the world, it removes itself
        if (getX() > getWorld().getWidth()-2){
            GameWorld gw = (GameWorld)getWorld();
            gw.changeTruckStatus();
            getWorld().removeObject(this);
        }

    }

    //Method to move the truck
    private void moving(double movement){
        setLocation((int)(Math.round(getX() + movement)), getY());
    }

    /**
     * Method to stop the truck
     * <p>
     * Slows down the truck by .5 increments
     * 
     * @param stopLoc The location to stop at
     */
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

    //Method to fade in the truck
    private void fadeIn(int timer){
        trans = (120 - timer);
        trans = trans / 120;
        trans = trans * 250;
        transInt = (int)Math.round(trans);
        getImage().setTransparency(transInt);
    }

}
