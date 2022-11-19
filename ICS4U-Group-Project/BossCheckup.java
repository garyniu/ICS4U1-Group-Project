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
        timer++;
        if(timer == 900){
            GameWorld gw = (GameWorld)getWorld();
            
            //randomize a #, if '0', workers get a raise, production speeds up , if '1', workers get pay deduction, less productive 
            int x = Greenfoot.getRandomNumber(2);
            if(x==0){
                increaseEfficiency();
            } else if (x==1){
                slowEfficiency();
            }
            
            //gw.removeObject(b);
            gw.removeObject(this);
        }
    }
    public void addedToWorld(GameWorld gw){
        //Boss b = new Boss(int x, int y); 
        //gw.addObject(b);
    }
}
