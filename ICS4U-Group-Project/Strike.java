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
    private boolean machinesStopped; 
    public Strike(int d, boolean left, boolean right){
        super(d, left, right);
        machinesStopped = false;
        System.out.println("STRIKE STRIKE");
    }
    public void act()
    {
        if(!machinesStopped){
            stopMachines();
            machinesStopped = true;
        }
        eventTimer++;
        if(eventTimer == 900){
            startMachines();
            splitWorkerNum();
            endEvent();
        }
    }
    
    public void stopMachines(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                lm.setProdSpeedA(0); 
                System.out.println("left machine speed(stop): "+lm.getProdSpeedA());
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                rm.setProdSpeedB(0); 
                System.out.println("right machine speed(stop); "+ rm.getProdSpeedB());
            }
        }
    }
    public void startMachines(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                lm.setProdSpeedA(lm.getDefaultSpeedA()); 
                System.out.println("left machine speed(start): "+lm.getProdSpeedA());
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                rm.setProdSpeedB(rm.getDefaultSpeedB()); 
                System.out.println("rightt machine speed(start): "+rm.getProdSpeedB());
            }
        }
    }

    public void splitWorkerNum(){
        int removedWorkersCount = 0;
        int side = (left)? 0 : 1;
        GameWorld gw = (GameWorld)getWorld();
        for(HiredWorkers w : getObjectsInRange(400, HiredWorkers.class)){
            if(!(removedWorkersCount == gw.getWorkerCount(side)/2)){
                gw.removeObject(w); 
                removedWorkersCount++;
            }
        }
        System.out.println("# removed workers, 5, : "+removedWorkersCount);
        gw.setWorkerCount(gw.getWorkerCount(side)-removedWorkersCount, side);
        System.out.println("split worker count: "+gw.getWorkerCount(side));
    }
}
