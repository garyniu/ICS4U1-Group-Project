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
    protected boolean flashAdded;
    
    protected GreenFlash gf; 
    protected RedFlash rf;
    
    public Event(int duration, boolean left, boolean right){
        this.duration = duration*60; 
        this.left = left;
        this.right = right;
        flashAdded = false;
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
                newSpeedLeft = lm.getDefaultSpeedA()+0.5; 
                lm.setProdSpeedA(newSpeedLeft);
            }
        }
        else if(right){
            for(RightMachines rm : gw.getObjects(RightMachines.class)){
                newSpeedRight = rm.getDefaultSpeedB()+0.5; 
                rm.setProdSpeedB(newSpeedRight);
            }
        }
    }
    public void slowEfficiency(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                slowSpeedLeft = lm.getDefaultSpeedA()-0.5; 
                lm.setProdSpeedA(slowSpeedLeft);
            }
        }
        else if(right){
            for(RightMachines rm : gw.getObjects(RightMachines.class)){
                slowSpeedRight = rm.getDefaultSpeedB()-0.5; 
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
            for(RightMachines rm : getObjectsAtOffset(256, 400, RightMachines.class)){
                rm.setProdSpeedB(rm.getDefaultSpeedB());
            }
        }
    }
    
    public void addRedFlash(){
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
    }
    public void addGreenFlash(){
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
    }
}
