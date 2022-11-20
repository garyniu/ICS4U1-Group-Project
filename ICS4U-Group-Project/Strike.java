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
            for(RightMachines rm : getObjectsAtOffset(256, 400, LeftMachines.class)){
                rm.setProdSpeedB(0); 
            }
        }
        
    }
    public void startMachines(){
        for(Machines m : getObjectsAtOffset(256, 400, Machines.class)){
            //stop machines 
        }
    }
    public void splitWorkerNum(){
        for(HiredWorkers w : getObjectsAtOffset(256, 400, HiredWorkers.class)){
            int rand = Greenfoot.getRandomNumber(2);
            int removedWorkersCount =0;
            if(rand == 1){
                //if(removedWorkersCount <= workerCount/2){
                    removedWorkersCount++;
                    GameWorld gw = (GameWorld)getWorld();
                    gw.removeObject(w);
                //}
            }
            //remove half of workers
        }
    }
}
