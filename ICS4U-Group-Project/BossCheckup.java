import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossCheckup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossCheckup extends Event
{
    private Boss b;
    /**
     * During BossCheckup, Boss spawns 
     */
    public BossCheckup(int d, boolean left, boolean right){
        super(d, left, right);
        System.out.println("BOSS CHECKUP BOSS CHECKUP");
    }

    public void act()
    {
        eventTimer++;
        if(eventTimer == 900){
            GameWorld gw = (GameWorld)getWorld();

            //randomize a #, if '0', workers get a raise, production speeds up , if '1', workers get pay deduction, less productive 
            int x = Greenfoot.getRandomNumber(2);
            if(x==0){
                increaseEfficiency();
            } else if (x==1){
                slowEfficiency();
            }

            gw.removeObject(b);
            endEvent();
        }
    }

    public void addedToWorld(GameWorld gw){
        if(left){
            b = new Boss(0, 1); 
            gw.addObject(b, 0, 50);
        }
        else if(right){
            b = new Boss(0, 1);
            gw.addObject(b, 1024, 50);
        }
    }
}
