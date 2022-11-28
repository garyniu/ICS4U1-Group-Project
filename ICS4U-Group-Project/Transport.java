import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A transport worker takes materials from where the truck drops them off, and then moves them to the conveyor belt
 * 
 * @author Gary Niu
 * @version November 2022
 */
public class Transport extends People
{

    //Instance variables
    private int goX, goY;
    private int goingX, goingY, timer = 0, seqence = 1;
    private boolean pointT = false, pointC = true, moving = true;
    private String side;
    private GreenfootImage image, imageA;

    /**
     * Constructor for Transport - sets the image of the Transport
     * 
     * @param goX x coordinate to go to
     * @param goY y coordinate to go to
     * @param side Which side the transport worker is on, "left" or "right" 
     */
    public Transport(int goX, int goY, String side){
        this.goX = goX;
        this.goY = goY;
        this.side = side;

        //Sets the image of the Transport, and an image with it holding a box
        image = new GreenfootImage("Char.png");
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
        
        imageA = new GreenfootImage("CharBox.png");
        imageA.scale(imageA.getWidth()/4, imageA.getHeight()/4);

    }
    /**
     * Calls the super addedToWorld method
     */
    public void addedToWorld(World w){
        super.addedToWorld(w);
    }
    /**
     * Constantly switches between two coordinates, the pickup coordinate and the dropoff coordinate, and once it is at the pickup coordinates, ti will pick up a box and move to dropoff. 
     */
    public void act()
    {

        //constantly goes to two coordinates, one pickup, one dropoff
        //if it is at the pickup, it picks up a box, and then goes to the dropoff, through 2 booleans
        timer++;
        
        if (pointC && !pointT){

            goingX = goX;
            goingY = goY;

        }

        // midpo
        if (!pointC && pointT){

            if (side == "left"){
                goingX = 70;
                goingY = 150;
            } else {
                goingX = 570;
                goingY = 150;
            }
        }

        super.act();
        
        if (timer >= Greenfoot.getRandomNumber(200)+40){
            moving = true;
        }
        
        if (moving){
            goToLocation(goingX, goingY);
        }
        
        //Changing image based on point
        if (pointC){
            setImage(imageA);
        } else {
            setImage(image);
        }
        

        if (goingX == getX() && goingY == getY()){
            pointC = !pointC;
            pointT = !pointT;
            
            moving = false;

            timer = 0;
        }

    }
}
