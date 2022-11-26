import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * Write a description of class BoomingBusiness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusiness extends Event
{
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
    public BoomingBusiness(int d, boolean left, boolean right){
        super(d, left, right);
        flashAdded=false;
        stockIncreased = false;
        animated = false;
        imageAdded = false;
        System.out.println("BOOMING BUSINESS");
                
        upArrow = new GreenfootImage[19];
        imageIndex = 0;
        animationTimer = new SimpleTimer();
        bbImage = new BoomingBusinessImage(); 
        
        
        for(int i = 0; i<upArrow.length;i++){
            upArrow[i] = new GreenfootImage("images/UpStonk/UpStonk"+i+".png");
        }
        animationTimer.mark();
    }
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
