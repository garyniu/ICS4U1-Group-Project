import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Event here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Event extends Actor
{
    protected int duration; 
    protected int eventTimer;
    protected boolean left;
    protected boolean right;
    protected double newValue; 
    protected double newSpeed;
    
    public Event(int duration, boolean left, boolean right){
        this.duration = duration*60; 
        this.left = left;
        this.right = right;
    }
    public void act()
    {
        
    }
    public void endEvent(){
        GameWorld gw = (GameWorld) getWorld();
        eventTimer = 0;
        System.out.println("EVENT IS NOW OVER EVENT IS NOW OVER");
        if(left){
            gw.setEventStatusA(false);
        }
        else if(right){
            gw.setEventStatusB(false);
        }
        gw.removeObject(this);
    }
    //methods for changing speed/efficiency of workers
    public void increaseEfficiency(){
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    newSpeed = lm.getDefaultSpeedA()+0.5;
                    lm.setProdSpeedA(newSpeed);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    newSpeed = lm.getDefaultSpeedA()+0.1875;
                    lm.setProdSpeedA(newSpeed); 
                }
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    newSpeed = rm.getDefaultSpeedB()+0.5;
                    rm.setProdSpeedB(newValue);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    newSpeed = rm.getDefaultSpeedB()+0.1875;
                    rm.setProdSpeedB(newValue); 
                }
            }
        }
    }
    public void slowEfficiency(){
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    newSpeed = lm.getDefaultSpeedA()-0.5;
                    lm.setProdSpeedA(newValue);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    newSpeed = lm.getDefaultSpeedA()-0.1875;
                    lm.setProdSpeedA(newValue); 
                }
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    newSpeed = rm.getDefaultSpeedB()-0.5;
                    rm.setProdSpeedB(newValue);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    newSpeed = rm.getDefaultSpeedB()-0.1875;
                    rm.setProdSpeedB(newValue); 
                }
            }
        }
    }
    public void resumeEfficiency(){
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                lm.setProdSpeedA(lm.getDefaultSpeedA()); 
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                rm.setProdSpeedB(rm.getDefaultSpeedB());
            }
        }
    }
}
