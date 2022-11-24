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
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    //newValue = lm.getMachItemValueA()-0.5;
                    //lm.setMachItemValueA(newValue);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    //newValue = lm.getMachItemValueA()-0.1875;
                   //lm.setMachItemValueA(newValue); 
                }
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    //newValue = rm.getMachItemValueB()-0.5;
                    //rm.setMachItemValueB(newValue);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    //newValue = rm.getMachItemValueB()-0.1875;
                    //rm.setMachItemValueB(newValue); 
                }
            }
        }
    }

}
