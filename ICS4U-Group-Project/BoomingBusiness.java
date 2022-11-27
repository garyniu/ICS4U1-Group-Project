//Imports
import greenfoot.*; 
import java.awt.Font;
/**
 * Booming Business Event, Spawns 2 effects, and increases value of sold items by 25 dollars.
 * <p>
 * Spawns two effects, one of which is the arrow visual effect, the other being the flashing screen effect..
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class BoomingBusiness extends Event
{
    //Instance variables
    private boolean flashAdded; 
    private boolean stockIncreased;
    private boolean animated; 
    private boolean imageAdded;
    
    private double itemA;
    private double itemB;
    
    private GreenfootImage[] upArrow; 
    private int imageIndex; 
    private int imageCounter;
    private SimpleTimer animationTimer; 
    
    private GreenfootImage image; 
    private BoomingBusinessImage bbImage; 


    /**
     * Constructor for BoomingBusiness
     * <p>
     * Sets instance variables, and creates an array of the up arrow images to be used in the animation.
     * 
     * @param d Duration of the event
     * @param left If the event is on the left side of the screen
     * @param right If the event is on the right side of the screen
     */
    public BoomingBusiness(int d, boolean left, boolean right){
        
        super(d, left, right);

        //Sets instance variables
        flashAdded=false;
        stockIncreased = false;
        animated = false;
        imageAdded = false;
        
        //Creates an array of the up arrow images to be used in the animation
        upArrow = new GreenfootImage[19];
        imageIndex = 0;
        animationTimer = new SimpleTimer();
        bbImage = new BoomingBusinessImage(); 
        
        for(int i = 0; i<upArrow.length;i++){
            upArrow[i] = new GreenfootImage("images/UpStonk/UpStonk"+i+".png");
        }
        animationTimer.mark();
    }

    //Method to run through arrow array, to create animation
    public void animateArrow(){
        if(animationTimer.millisElapsed() < 80){
            return; 
        }
        animationTimer.mark();
        setImage(upArrow[imageIndex]);
        imageIndex = (imageIndex+1)%upArrow.length;
        imageCounter++;
        if(imageCounter == 19){
            animated = true; 
        }
    }


    public void act()
    {
        eventTimer++;
        GameWorld gw = (GameWorld)getWorld();
        gw.addObject(bbImage, this.getX()-190, 625);
            
        if(!animated){
            animateArrow();
        }
        if(animated){
            setImage(new GreenfootImage("images/UpStonk/UpStonk18.png"));
        }
        addGreenFlash();
        if(!stockIncreased){
            increaseStock();
            stockIncreased = true;
        }
        if(eventTimer == duration){
            gw.removeObject(bbImage); 
            endEvent();
        }
    }

    //Method to increase the value of the sold items depending on side
    public void increaseStock(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            itemA = LeftMachines.getMachItemValueA();
            newValueLeft = itemA + 25; 
            LeftMachines.setMachItemValueA(newValueLeft);
            System.out.println("left machine item: shoes " + " and value: "+ newValueLeft);
            gw.setItemValueA(newValueLeft);
            System.out.println("Left machine shoes: "+gw.getItemValueA());
        }
        else if(right){
            itemB = Rightmachines.getMachItemValueB();
            newValueRight= itemB + 25; 
            Rightmachines.setMachItemValueB(newValueRight);
            System.out.println("right machine item: shoes and value " +newValueRight);
            gw.setItemValueB(newValueRight);
            System.out.println("right machine shoes: "+gw.getItemValueB());
        }
    }
}
