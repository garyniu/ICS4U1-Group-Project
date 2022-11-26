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
    private GreenfootImage strkImage; 
    public Strike(int d, boolean left, boolean right){
        super(d, left, right);
        strkImage = new GreenfootImage("STRIKE.png");
        strkImage.scale(100,100);
        setImage(strkImage); 
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
        if(eventTimer == 300){
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
}
