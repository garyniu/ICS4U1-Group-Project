import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossCheckup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossCheckup extends Event
{
    /**
     * During BossCheckup, Boss spawns 
     */
    public BossCheckup(int d){
        super(d);
    }
    public void act()
    {
        super();
        if(timer == 900){
            //remove boss object 
            //randomize a #, if '0', workers get a raise, production speeds up , if '1', workers get pay deduction, less productive 
            GameWorld gw = (GameWorld)getWorld();
            gw.removeObject(this);
        }
    }
}
