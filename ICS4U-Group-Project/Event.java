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
    protected boolean flashAdded;
    
    private double newSpeedLeft;
    private double newSpeedRight;
    private double slowSpeedLeft;
    private double slowSpeedRight;
    
    protected GreenfootSound Goodstock;
    protected GreenfootSound Badstock;
    
    protected GreenFlash gf; 
    protected RedFlash rf;
    
    public Event(int duration, boolean left, boolean right){
        this.duration = duration*60; 
        this.left = left;
        this.right = right;
        flashAdded = false;
        
        Goodstock = new GreenfootSound("Goodstock.mp3");
        Goodstock.setVolume(30);
        Badstock = new GreenfootSound("Badstock.mp3");
        Badstock.setVolume(30);
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
    public void increaseEfficiency(int side){
        GameWorld gw = (GameWorld)getWorld();
        if(side == 0){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                newSpeedLeft = lm.getDefaultSpeedA()+0.5; 
                lm.setProdSpeedA(newSpeedLeft);
            }
        }
        else if(side == 1){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                newSpeedRight = rm.getDefaultSpeedB()+0.5; 
                rm.setProdSpeedB(newSpeedRight);
            }
        }
    }
    public void slowEfficiency(int side){
        GameWorld gw = (GameWorld)getWorld();
        if(side == 0){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                slowSpeedLeft = lm.getDefaultSpeedA()-0.5; 
                lm.setProdSpeedA(slowSpeedLeft);
            }
        }
        else if(side == 1){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                slowSpeedRight = rm.getDefaultSpeedB()-0.5; 
                rm.setProdSpeedB(slowSpeedRight);
            }
        }
    }
    public void resumeEfficiency(int side){
        GameWorld gw = (GameWorld)getWorld();
        if(side == 0){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                lm.setProdSpeedA(lm.getDefaultSpeedA()); 
            }
        }
        else if(side == 1){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
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
            Badstock.play();
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
            Goodstock.play();
        }
    }
}
