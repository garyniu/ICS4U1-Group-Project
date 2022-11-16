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
     * During Strike, the production speed for machines will be set to 0
     * - Visual effects listed in google doc
     * - At the end, worker num is halfed 
     */
    
    public Strike(int d, int machineSpd, int workerNum){
        super(d);
    }
    
    /**
     * Act - do whatever the Strike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super();
        if(timer == 900){
            //end strike (half workers); 
            GameWorld gw = (GameWorld)getWorld();
            gw.removeObject(this);
        }
    }
    
    public void stopProduction(){
        
    }
    
    public void strikeEnd(){
        
    }
}
