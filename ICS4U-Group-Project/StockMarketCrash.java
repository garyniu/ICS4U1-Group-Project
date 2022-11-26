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
    private RedFlash rf;
    private boolean flashAdded;
    private double itemA;
    private double itemB;
    /**
     * Act - do whatever the StockMarketCrash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public StockMarketCrash(int d, boolean left, boolean right){
        super(d, left, right);
        flashAdded=false;
        System.out.println("STOCK MARKET CRASH");
    }

    public void addedToWorld(World w){
        decreaseStock();
    }

    public void act(){
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
        }
        eventTimer++;
        //decrease
        if(eventTimer == 180){
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
            itemB = RightMachines.getMachItemValueB();
            newValueRight= itemB - 25; 
            RightMachines.setMachItemValueB(newValueRight);
            System.out.println("right machine item: shoes and value " +newValueRight);
            gw.setItemValueB(newValueRight);
            System.out.println("right machine shoes: "+gw.getItemValueB());
        }
    }
}
