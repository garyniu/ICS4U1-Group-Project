import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * There are two bosses, which are determined by the image set to them. 
 * <p>
 * A normal boss is the owner of the factory who can buy upgrades for workers, machines and more. 
 * <p>
 * A super boss is the main funder for the company, and spawns during BossCheckups.
 * <p>
 * All bosses will pathfind, but only normal bosses can buy upgrades. Super bosses can cause pay raises and deductions, coded in the BossCheckup Event class. 
 * @author Gary Niu
 * @version November 2022
 */

public class Boss extends People
{
    private int randTimer;
    private String side; 
    private int randX;
    private int randY;
    private GreenfootImage image;
    private int WorkChance, MachineChance;
    private int UpgradeNum, bossImg;

    /**
     * Constructor calls the superConstructor and sets the image for Boss based on if it is a normal or super Boss. 
     * 
     * @param UP    
     * @param bossImg   Passes through the constructor if the image set should be a super or normal Boss
     */
    public Boss(int UP, int bossImg){
        super();
        
        this.bossImg = bossImg;

        if (bossImg == 0){
            image = new GreenfootImage("baby1.png");
            setImage(image);
        } else if (bossImg == 1){
            image = new GreenfootImage("baby2.png");
            setImage(image);
        }

        if (UP == 0){
            WorkChance = 50;

        } else if (UP == 1){
            WorkChance = 30;

        } else if (UP == 2){
            WorkChance = 70;

        }

        randTimer = 600;
    }
    /**
     * Calls the super addedToWorld method, and determines if the side the boss is on is left or right. 
     */
    public void addedToWorld(World w){
        super.addedToWorld(w);
        if(this.getX()<=512){
            side = "left";
        }else if(this.getX()>512){
            side = "right";
        }
        
    }
    /**
     * Calls the super act method and randomizes when the boss should move around and to where, if it is a normal boss, it will randomly buys upgrades. 
     */
    public void act()
    {
        super.act();
        if(randTimer == 600){

            if(side == "left"){
                randX = Greenfoot.getRandomNumber(456);
                randY = Greenfoot.getRandomNumber(650);
                goToX = randX+20;
                goToY = randY+50;
                System.out.println("test2");
                goToLocation(goToX, goToY);
                randTimer = 0;
            }
            else if(side == "right"){
                randX = Greenfoot.getRandomNumber(456);
                randY = Greenfoot.getRandomNumber(650);
                goToX = randX+536;
                goToY = randY+50;
                //System.out.println("test1");
                goToLocation(goToX, goToY); 
                randTimer = 0; 
            }
        }

        if (bossImg == 0){
            if (1 == Greenfoot.getRandomNumber(100)){

                UpgradeNum = Greenfoot.getRandomNumber(101);

                if (UpgradeNum < WorkChance){
                    
                    ((GameWorld)getWorld()).upgrades(side, 0, this);
                } else {
                    
                    ((GameWorld)getWorld()).upgrades(side, 1, this);
                }

            }
        }

        randTimer++;
    }
}
