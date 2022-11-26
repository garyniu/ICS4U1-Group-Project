import greenfoot.*;
/**
 * Write a description of class StockMarketCrash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockMarketCrash extends Event
{
    private double newValue; 
    
    private boolean flashAdded;
    private boolean stockDecreased;
    private boolean animated; 
    
    private double itemA;
    private double itemB;
    
    private GreenfootImage[] downArrow; 
    private int imageIndex; 
    private int imageCounter;
    private SimpleTimer animationTimer; 
    private StockMarketCrashImage smcImage; 
    public StockMarketCrash(int d, boolean left, boolean right){
        super(d, left, right);
        
        flashAdded=false;
        stockDecreased = false;
        animated = false;
        
        System.out.println("STOCK MARKET CRASH");
        
        GameWorld gw = (GameWorld)getWorld(); 
        gw.addObject(smcImage, this.getX()-181, 650);
        
        downArrow = new GreenfootImage[19];
        imageIndex = 0;
        animationTimer = new SimpleTimer();
        
        for(int i = 0; i<downArrow.length;i++){
            downArrow[i] = new GreenfootImage("images/DownStonks/DownStonks"+i+".png");
        }
        animationTimer.mark();
    }
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
    public void act(){
        eventTimer++;
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
            endEvent();
        }
    }    

    public void decreaseStock(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            itemA = LeftMachines.getMachItemValueA();
            newValueLeft = itemA - 25; 
            LeftMachines.setMachItemValueA(newValueLeft);
            System.out.println("left machine item: shoes " + " and value: "+ newValueLeft);
            gw.setItemValueA(newValueLeft);
            System.out.println("Left machine shoes: "+gw.getItemValueA());
        }
        else if(right){
            itemB = Rightmachines.getMachItemValueB();
            newValueRight= itemB - 25; 
            Rightmachines.setMachItemValueB(newValueRight);
            System.out.println("right machine item: shoes and value " +newValueRight);
            gw.setItemValueB(newValueRight);
            System.out.println("right machine shoes: "+gw.getItemValueB());
        }
    }
}
