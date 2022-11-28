import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * During the Strike event, all workers will stop working and all item production will be stopped. At the end of the Strike, most of the workers will leave.
 * Only one worker will be left per station.
 * 
 * @authors Harishan Ganeshanathan 
 * @version November 2022
 */
public class Strike extends Event
{
    private boolean machinesStopped; 
    private boolean strikeStatusA;
    private boolean strikeStatusB; 
    private GreenfootImage strkImage; 
    /**
     * Constructor for Strike 
     * <p>
     * Sets instance variables
     * 
     * @param d Duration of the event
     * @param left If the event is on the left side of the screen
     * @param right If the event is on the right side of the screen
     */
    public Strike(int d, boolean left, boolean right){
        super(d, left, right);
        
        strkImage = new GreenfootImage("STRIKE.png");
        strkImage.scale(100,100);
        setImage(strkImage); 
        
        machinesStopped = false;
        strikeStatusA = left;
        strikeStatusB = right; 
    }
    /**
     * Sets the strikestatus, stops the machines, then if the event is over, starts the machines, resets the strikeStatuses, workers are set to 1 per station, and endEvent() is called from the superclass. 
     */
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
        if(eventTimer == 600){
            GameWorld gw = (GameWorld)getWorld(); 
            startMachines();
            if(left){
                gw.setStrikeStatusA(false);
            }else if(right){
                gw.setStrikeStatusB(false); 
            }
            if (strikeStatusA){
                gw.halfWorkers("left");
            }
            if (strikeStatusB){
                gw.halfWorkers("right");
            }
            endEvent();
        }
    }
    /**
     * Stops machines on either the left or right side/sets produce speed to 0. 
     */
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
    /**
     * Starts machines on either the left or right side/sets produce speed to the speed the machines were last set to before they were set to 0. 
     */
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
}
