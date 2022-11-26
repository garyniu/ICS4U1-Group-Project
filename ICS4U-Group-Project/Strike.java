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
    private boolean strikeStatusA;
    private boolean strikeStatusB; 
    public Strike(int d, boolean left, boolean right){
        super(d, left, right);
        machinesStopped = false;
        strikeStatusA = left;
        strikeStatusB = right; 
        System.out.println("STRIKE STRIKE");
    }
    public void act()
    {
        if(!machinesStopped){
            GameWorld gw = (GameWorld)getWorld(); 
            gw.setStrikeStatusA(strikeStatusA);
            gw.setStrikeStatusB(strikeStatusB);
            stopMachines();
            machinesStopped = true;
        }
        eventTimer++;
        if(eventTimer == 900){
            GameWorld gw = (GameWorld)getWorld(); 
            startMachines();
            splitWorkerNum();
            if(left){
                gw.setStrikeStatusA(false);
            }else if(right){
                gw.setStrikeStatusB(false); 
            }
            endEvent();
        }
    }
    
    public void stopMachines(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                //lm.updateDefaultSpeedA(); //default speed = produce speed = 1
                gw.setProdSpeedA(0); //gw produce speed = 0 
                lm.updateSpeed(); //produce speed = gw produce speed = 0
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                gw.setProdSpeedB(0); 
                rm.updateSpeed(); 
            }
        }
    }
    public void startMachines(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){ 
                gw.setProdSpeedA(lm.getDefaultSpeedA()); //gw speed = defaultspeed = 0 
            }
        }
        else if(right){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                gw.setProdSpeedB(rm.getDefaultSpeedB()); 
            }
        }
    }

    public void splitWorkerNum(){
        int removedWorkersCount = 0;
        GameWorld gw = (GameWorld)getWorld();
        for(HiredWorkers w : getObjectsInRange(400, HiredWorkers.class)){
            if(!(removedWorkersCount == gw.getWorkerCount()/2)){
                gw.removeObject(w); 
                removedWorkersCount++;
            }
        }
        System.out.println("# removed workers, 5, : "+removedWorkersCount);
        gw.setWorkerCount(gw.getWorkerCount()-removedWorkersCount);
        System.out.println("split worker count: "+gw.getWorkerCount());
    }
}
