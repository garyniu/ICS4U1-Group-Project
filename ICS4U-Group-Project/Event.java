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
    protected double newValueLeft;
    protected double newValueRight;
    protected double newSpeedLeft;
    protected double newSpeedRight;
    protected double slowSpeedLeft;
    protected double slowSpeedRight;
    
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
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                /*if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    newSpeedLeft = lm.getDefaultSpeedA()+0.5;
                    lm.setProdSpeedA(newSpeedLeft);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    newSpeedLeft = lm.getDefaultSpeedA()+0.1875;
                    lm.setProdSpeedA(newSpeedLeft); 
                }*/
                newSpeedLeft = lm.getDefaultSpeedA()+0.1875; 
                lm.setProdSpeedA(newSpeedLeft);
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                /*if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    newSpeed = rm.getDefaultSpeedB()+0.5;
                    rm.setProdSpeedB(newSpeed);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    newSpeed = rm.getDefaultSpeedB()+0.1875;
                    rm.setProdSpeedB(newSpeed); 
                }*/
                newSpeedRight = rm.getDefaultSpeedB()+0.1875; 
                rm.setProdSpeedB(newSpeedRight);
            }
        }
    }
    public void slowEfficiency(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                /*if(lm.getItemChoiceA() == "tools" || lm.getItemChoiceA() == "shoes"){
                    newSpeedLeft = lm.getDefaultSpeedA()+0.5;
                    lm.setProdSpeedA(newSpeedLeft);
                }
                else if(lm.getItemChoiceA() == "phones"){
                    newSpeedLeft = lm.getDefaultSpeedA()+0.1875;
                    lm.setProdSpeedA(newSpeedLeft); 
                }*/
                slowSpeedLeft = lm.getDefaultSpeedA()-0.1875; 
                lm.setProdSpeedA(slowSpeedLeft);
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                /*if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    newSpeed = rm.getDefaultSpeedB()+0.5;
                    rm.setProdSpeedB(newSpeed);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    newSpeed = rm.getDefaultSpeedB()+0.1875;
                    rm.setProdSpeedB(newSpeed); 
                }*/
                slowSpeedRight = rm.getDefaultSpeedB()-0.1875; 
                rm.setProdSpeedB(slowSpeedRight);
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
