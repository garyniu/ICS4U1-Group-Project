import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Strike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strike extends Event
{
    /**
     * Act - do whatever the Strike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Strike(int d){
        super(d);
    }
    public void act()
    {
        timer++;
        if(timer == 900){
            splitWorkerNum();
            startMachines();
            endEvent();
            timer = 0;
        }
    }
    public void addedToWorld(){
        findSide();
        stopMachines();
    }
    
    public void stopMachines(){
        if(side == "left"){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                lm.setProdSpeedA(0); 
            }
        }
        else if(side == "right"){
            for(RightMachines rm : getObjectsAtOffset(256, 400, RightMachines.class)){
                rm.setProdSpeedB(0); 
            }
        }
    }
    public void startMachines(){
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

    public void splitWorkerNum(){
        int removedWorkersCount =0;
        for(HiredWorkers w : getObjectsAtOffset(256, 400, HiredWorkers.class)){
            GameWorld gw = (GameWorld)getWorld();
            if(!(removedWorkerCount == gw.getWorkerCount()/2)){
                gw.removeObject(w); 
                removedWorkerCount++;
            }
        }
    }
}
