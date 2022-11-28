import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Events are randomized events that essentially make the simulation more random. At a base level, they change around variables to either help or hurt either side. 
 * <p>
 * 
 * @author Harishan Ganeshanathan 
 * @version November 2022
 */
public abstract class Event extends Actor
{
    protected int duration; 
    protected int eventTimer;
    protected boolean left;
    protected boolean right;
    protected double newValueLeft;
    protected double newValueRight;
    protected boolean flashAdded;
    
    protected double newSpeedLeft;
    protected double newSpeedRight;
    protected double slowSpeedLeft;
    protected double slowSpeedRight;
    protected double maxSpeed;
    
    protected GreenfootSound Goodstock;
    protected GreenfootSound Badstock;
    
    protected GreenFlash gf; 
    protected RedFlash rf;
    
    /**
     * Contructor - Sets all instance variable values, as well as sounds
     * 
     * @param duration  The duration of the event in seconds. In the constructor, it will convert the instance variable duration so it is in seconds.
     * @param left  Checks if the event is on the left side
     * @param right Checks if the event is on the right side
     */
    public Event(int duration, boolean left, boolean right){
        this.duration = duration*60; 
        this.left = left;
        this.right = right;
        flashAdded = false;
        maxSpeed = 5; 
        
        Goodstock = new GreenfootSound("Goodstock.mp3");
        Goodstock.setVolume(30);
        Badstock = new GreenfootSound("Badstock.mp3");
        Badstock.setVolume(30);
    }
    /**
     * The endEvent method first sets the activeEventStatus to false, depending on which side the event is on. 
     * Then, it removes the event object from the world. 
     */
    public void endEvent(){
        GameWorld gw = (GameWorld) getWorld();
        eventTimer = 0;
        if(left){
            gw.setEventStatusA(false);
        }
        else if(right){
            gw.setEventStatusB(false);
        }
        gw.removeObject(this);
    }
    /**
     * If a flash hasn't been added to the world yet, it will add only one 
     * red flash object to the world
     */
    public void addRedFlash(){
        if(!flashAdded){
            GameWorld w = (GameWorld)getWorld();
            if(left){
                rf = new RedFlash(duration);
                w.addObject(rf, 256, 400);
            } else if(right){
                rf = new RedFlash(duration);
                w.addObject(rf, 768, 400);
            }
            flashAdded = true;
            Badstock.play();
        }
    }
    /**
     * If a flash hasn't been added to the world yet, it will add only one 
     * green flash object to the world
     */
    public void addGreenFlash(){
        if(!flashAdded){
            GameWorld w = (GameWorld)getWorld();
            if(left){
                gf = new GreenFlash(duration); 
                w.addObject(gf, 256, 400);
            }
            else if(right){
                gf = new GreenFlash(duration);
                w.addObject(gf, 768, 400);
            }
            flashAdded = true;
            Goodstock.play();
        }
    }
}
