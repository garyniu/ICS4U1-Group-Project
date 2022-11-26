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
    
    private int side;
    private GreenfootImage bcImage; 
    public BossCheckup(int d, boolean left, boolean right){
        super(d, left, right);
        bcImage = new GreenfootImage("BOSSCHECKUP.png");
        bcImage.scale(100,100);
        setImage(bcImage); 
        if(left){
            side = 0;
        } else if(right){
            side = 1; 
        }
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
                increaseEfficiency(side);
            } else if (x==1){
                slowEfficiency(side);
            }
            gw.removeObject(b);
            endEvent();
        }
    }

    public void addedToWorld(World w){
        GameWorld gw = (GameWorld)getWorld(); 
        if(left){
            b = new Boss(0, 1); 
            gw.addObject(b, 0, 50);
        }
        else if(right){
            b = new Boss(0, 1);
            gw.addObject(b, 572, 50);
        }
    }
}
