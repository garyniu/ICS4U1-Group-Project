import greenfoot.*;
/**
 * StockMarketCrash Event, Spawns 2 effects, and decreases value of sold items by 25 dollars.
 * <p>
 * Spawns two effects, one of which is the arrow visual effect, the other being the flashing screen effect..
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class StockMarketCrash extends Event
{
    private double newValue; 
    
    private boolean flashAdded;
    private boolean stockDecreased;
    private boolean animated; 
    private boolean imageAdded; 
    
    private double itemA;
    private double itemB;
    
    private GreenfootImage[] downArrow; 
    private int imageIndex; 
    private int imageCounter;
    private SimpleTimer animationTimer; 
    private StockMarketCrashImage smcImage; 
    /**
     * Constructor for StockMarketCrash
     * <p>
     * Sets instance variables, and creates an array of the down arrow images to be used in the animation.
     * 
     * @param d Duration of the event
     * @param left If the event is on the left side of the screen
     * @param right If the event is on the right side of the screen
     */
    public StockMarketCrash(int d, boolean left, boolean right){
        super(d, left, right);
        
        flashAdded=false;
        stockDecreased = false;
        animated = false;
        imageAdded = false;
        
        downArrow = new GreenfootImage[19];
        imageIndex = 0;
        animationTimer = new SimpleTimer();
        smcImage = new StockMarketCrashImage(); 
        
        for(int i = 0; i<downArrow.length;i++){
            downArrow[i] = new GreenfootImage("images/DownStonks/DownStonks"+i+".png");
        }
        animationTimer.mark();
    }
    /**
     * This method loops through an image array, preloaded with all the images for the arrow animation, and sets the image of the actor to the current iterated image in the array. 
     */
    public void animateArrow(){
        if(animationTimer.millisElapsed() < 80){
            return; 
        }
        animationTimer.mark();
        setImage(downArrow[imageIndex]);
        imageIndex = (imageIndex+1)%downArrow.length;
        imageCounter++;
        if(imageCounter == 19){
            animated = true; 
        }
    }
    /**
     * In the act method, the StockMarketCrash event image will be added in the corner. 
     * If the arrow has not been animated, it will animate the arrow, and if it has been animated,
     *  it will constantly set the image of the arrow to the final image.  
     */
    public void act(){
        eventTimer++;
        GameWorld gw = (GameWorld)getWorld();
        gw.addObject(smcImage, this.getX()-190, 625);
        if(!animated){
            animateArrow();
        }
        if(animated){
            setImage(new GreenfootImage("images/DownStonks/DownStonks18.png"));
        }
        addRedFlash();
        if(!stockDecreased){
            decreaseStock();
            stockDecreased = true; 
        }
        if(eventTimer == duration){
            gw.removeObject(smcImage); 
            endEvent();
        }
    }    
    /**
     * Decreases the value of a shoe. Ex: If a shoe is originally worth $100, after decreaseStock() is called, its value will be $75.
     */
    public void decreaseStock(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            itemA = LeftMachines.getMachItemValueA();
            newValueLeft = itemA - 25; 
            LeftMachines.setMachItemValueA(newValueLeft);
            gw.setItemValueA(newValueLeft);
        }
        else if(right){
            itemB = Rightmachines.getMachItemValueB();
            newValueRight= itemB - 25; 
            Rightmachines.setMachItemValueB(newValueRight);
            gw.setItemValueB(newValueRight);
        }
    }
}
