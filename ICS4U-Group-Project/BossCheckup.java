//Imports
import greenfoot.*; 

/**
 * During the BossCheckup Event, a super boss will be spawned on the corresponding side. It will walk around 
 * for the duration of the event. 
 * <p>
 * Once the duration of the event is over, the boss will be removed from the world and either give the workers a raise or reduce their pay
 * <p>
 * If they get a raise, they work faster. If their pay is reduced, they work slower.
 * <p>
 * A Boss and a BossCheckupImage are spawned into the world during a BossCheckup 
 * 
 * @author Harishan Ganeshanathan
 * @version November 2022
 */
public class BossCheckup extends Event
{
    private Boss b;
    private int side;
    private GreenfootImage bcImage; 
    /**
     * Constructor for BossCheckup 
     * <p>
     * Sets instance variables
     * 
     * @param d Duration of the event
     * @param left If the event is on the left side of the screen
     * @param right If the event is on the right side of the screen
     */
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
    }
    /**
     * Once the timer is over, it will first randomize if the workers get a raise or deduction, and if their speed is increased or decreased, then, the boss and the event are removed from the world
     */
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
    /**
     * The boss object is added to the world based on if it is on the left or right side. 
     * 
     * @param w World parameter
     */
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
    /**
     * Increases the speed of the workers on the side of the event 
     * 
     * @param side  The side that the event is taking place on. Note that this is an integer variable, not a boolean variables, which made checking for this specific event less confusing. 
     */
    public void increaseEfficiency(int side){
        GameWorld gw = (GameWorld)getWorld();
        if(side == 0){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                if(lm.getProdSpeedA() < maxSpeed){
                    newSpeedLeft = lm.getDefaultSpeedA()+0.5; 
                    lm.setProdSpeedA(newSpeedLeft);
                }
            }
        }
        else if(side == 1){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                if(rm.getProdSpeedB() <maxSpeed){
                    newSpeedRight = rm.getDefaultSpeedB()+0.5; 
                    rm.setProdSpeedB(newSpeedRight);
                }
            }
        }
    }
    /**
     * Decreases the speed of the workers on the side of the event 
     * 
     * @param side  The side that the event is taking place on. Note that this is an integer variable, not a boolean variables, which made checking for this specific event less confusing. 
     */
    public void slowEfficiency(int side){
        GameWorld gw = (GameWorld)getWorld();
        if(side == 0){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                slowSpeedLeft = lm.getDefaultSpeedA()-0.5; 
                lm.setProdSpeedA(slowSpeedLeft);
            }
        }
        else if(side == 1){
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                slowSpeedRight = rm.getDefaultSpeedB()-0.5; 
                rm.setProdSpeedB(slowSpeedRight);
            }
        }
    }
}
