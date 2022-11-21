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
    protected int timer; 
    protected String side;
    
    public Event(int duration){
        this.duration = duration;
        findSide(); 
    }
    public void act()
    {
        
    }
    public void endEvent(){
        GameWorld gw = (GameWorld) getWorld();
        gw.removeObject(this);
        timer = 0;
    }
    public void findSide(){
        if(this.getX()<=512){
            side = "left";
        } else if(this.getX()>512){
            side = "right";
        }
    }
    //methods for changing speed/efficiency of workers
    public void increaseEfficiency(){
        if(side == "left"){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                int x = lm.getDefaultSpeedA();
                x++;
                lm.setProdSpeedA(x); 
            }
        }
        else if(side == "right"){
            for(RightMachines rm : getObjectsAtOffset(256, 400, RightMachines.class)){
                int y = rm.getDefaultSpeedB();
                y++;
                rm.setProdSpeedB(y); 
            }
        }
    }
    public void slowEfficiency(){
        if(side == "left"){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                int x = lm.getDefaultSpeedA();
                x--;
                lm.setProdSpeedA(x); 
            }
        }
        else if(side == "right"){
            for(RightMachines rm : getObjectsAtOffset(256, 400, RightMachines.class)){
                int y = rm.getDefaultSpeedB();
                y--;
                rm.setProdSpeedB(y); 
            }
        }
    }
    public void resumeEfficiency(){
        if(side == "left"){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                lm.setProdSpeedA(lm.getDefaultSpeedA()); 
            }
        }
        else if(side == "right"){
            for(RightMachines rm : getObjectsAtOffset(256, 400, RightMachines.class)){
                rm.setProdSpeedB(rm.getDefaultSpeedB()); 
            }
        }
    }
}
