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
        itemA = LeftMachines.getMachItemValueA();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                if(lm.getItemChoiceA() == "shoes"){
                    newValueLeft = itemA-25;
                    lm.setMachItemValueA(newValueLeft);
                    System.out.println("left machine item: "+lm.getItemChoiceA() + " and value: "+newValueLeft);
                }
            }
            Shoes.setItemValue(newValueLeft);
        }
        else if(right){
            itemB = Rightmachines.getMachItemValueB();
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                newValueRight = itemB-25; 
                rm.setMachItemValueB(newValueRight); 
                System.out.println("right machine item: shoes and value: "+newValueRight);
            }
            Shoes.setItemValue(newValueRight);
        }
    }

}
