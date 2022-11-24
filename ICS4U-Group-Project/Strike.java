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
    public Strike(int d, boolean left, boolean right){
        super(d, left, right);
        System.out.println("STRIKE STRIKE");
    }
    public void act()
    {
        eventTimer++;
        if(eventTimer == 900){
            splitWorkerNum();
            startMachines();
            endEvent();
        }
    }
    public void addedToWorld(){
        stopMachines();
    }
    
    public void stopMachines(){
        if(left){
            for(LeftMachines lm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                lm.setProdSpeedA(0); 
            }
        }
        else if(right){
            for(Rightmachines rm : getObjectsAtOffset(256, 400, Rightmachines.class)){
                rm.setProdSpeedB(0); 
            }
        }
    }
    public void startMachines(){
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

    public void splitWorkerNum(){
        int removedWorkersCount =0;
        for(HiredWorkers w : getObjectsAtOffset(256, 400, HiredWorkers.class)){
            GameWorld gw = (GameWorld)getWorld();
            if(!(removedWorkersCount == gw.getWorkerCount()/2)){
                gw.removeObject(w); 
                removedWorkersCount++;
            }
        }
    }
}
