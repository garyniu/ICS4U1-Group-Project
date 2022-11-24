import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoomingBusiness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusiness extends Event
{
    private GreenFlash gf; 
    private boolean flashAdded; 
    public BoomingBusiness(int d, boolean left, boolean right){
        super(d, left, right);
        flashAdded=false;
        System.out.println("BOOMING BUSINESS");
    }
    public void addedToWorld(World w){
        increaseStock();
    }
    public void act()
    {
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
        }
        eventTimer++;
        if(eventTimer == duration){
            endEvent();
        }
    }
    
    public void increaseStock(){
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    //newValue = lm.getMachItemValueA()+0.5;
                    //lm.setMachItemValueA(newValue);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    //newValue = lm.getMachItemValueA()+0.1875;
                    //lm.setMachItemValueA(newValue); 
                }
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    //newValue = rm.getMachItemValueB()+0.5;
                    //rm.setMachItemValueB(newValue);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    //newValue = rm.getMachItemValueB()+0.1875;
                    //rm.setMachItemValueB(newValue); 
                }
            }
        }
    }
}
