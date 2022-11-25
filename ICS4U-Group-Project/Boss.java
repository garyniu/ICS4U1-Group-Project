import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boss(int locX, int locY, int UP, int bossImg){
        super(locX, locY);
        
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

    public void addedToWorld(World w){
        if(this.getX()<=512){
            side = "left";
        }else if(this.getX()>512){
            side = "right";
        }
        //goToLocation(goToX, goToY);
    }

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
                goToLocation(400, 500);
                randTimer = 0;
            }
            else if(side == "right"){
                randX = Greenfoot.getRandomNumber(456);
                randY = Greenfoot.getRandomNumber(650);
                goToX = randX+536;
                goToY = randY+50;
                System.out.println("test1");
                goToLocation(goToX, goToY); 
                randTimer = 0; 
            }
        }

        //another random timer
        //set upgrade status
        //in game world, just have check for upgrades constantly, then feed to machine

        if (bossImg == 0){
            if (1 == Greenfoot.getRandomNumber(100)){

                UpgradeNum = Greenfoot.getRandomNumber(101);

                if (UpgradeNum < WorkChance){
                    ((GameWorld)getWorld()).upgrades(side, 0);
                } else {
                    ((GameWorld)getWorld()).upgrades(side, 1);
                }

            }
        }

        randTimer++;
    }
}
