import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftMachines here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftMachines extends Machines
{
    /**
     * Act - do whatever the LeftMachines wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageA;
    private int items;
    private int timer;
    protected static double produceSpeed;
    private static int upgradeAmount;
    private int width;
    private int height;
    
    public LeftMachines()
    {
        imageA = new GreenfootImage("shirtMachineTemp.png");
        imageA.scale(300, 100);
        setImage(imageA);
        produceSpeed = 1;
        width = imageA.getWidth();
        height = imageA.getHeight();
        upgradeA();
        //getWorld().showText("" + produceSpeed, this.getX(), this.getY());
        upgradeAmount = GameWorld.getCurrencyA();
        
    }
    public void addedToWorld(World w)
    {
        w.addObject(new Hitboxes(), this.getX() + width/2, this.getY() - height/2);
        w.addObject(new Shoes(this), this.getX() - width/2, this.getY() - height/4);
        w.showText("" + produceSpeed + "x", this.getX(), this.getY());
    }
    public void act()
    {
        //getWorld().showText("" + produceSpeed, 80, 80);
        //getWorld().addObject(new Shoes(this), this.getX() - width/2, this.getY() - height/4);
        if(Shoes.getExist() == false)
        {
            //getWorld().showText("true", this.getX() - width/2, this.getY() - height/4);
            getWorld().addObject(new Shoes(this), this.getX() - width/2, this.getY() - height/4);
            getWorld().showText("" + this.getX() + this.getY(), this.getX(), this.getY());
            //Shoes.setLocation(imageA.getX(), imageA.getY());
            //getWorld().showText("LMFAO", 150, 150);
            
            /*
            if((getWorld().getMachUpgradePref && (getWorld().getWorkerCount() == 3)) == true)
            {
                
            }
            if((getWorld().getMachUpgradePref && (getWorld().getWorkerCount() == 6)) == true)
            {
                
            }
            if((getWorld().getMachUpgradePref && (getWorld().getWorkerCount() == 9)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePref && (LeftMachines.getProdSpeedA() > 1.5)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePref && (LeftMachines.getProdSpeedA() > 2)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePref && (LeftMachines.getProdSpeedA() > 3)) == true)
            {
                
            }
            if((getWorld().getMachUpgradePrefB && (getWorld().getWorkerCountB() == 3)) == true)
            {
                
            }
            if((getWorld().getMachUpgradePrefB && (getWorld().getWorkerCountB() == 6)) == true)
            {
                
            }
            if((getWorld().getMachUpgradePrefB && (getWorld().getWorkerCountB() == 9)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePrefB && (LeftMachines.getProdSpeedB() > 1.5)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePrefB && (LeftMachines.getProdSpeedB() > 1.5)) == true)
            {
                
            }
            if((getWorld().getPeopleUpgradePrefB && (LeftMachines.getProdSpeedB() > 1.5)) == true)
            {
                
            }
            */
        } else {
            getWorld().showText("true", this.getX() - width/3, this.getY() - height/4);
        }
        
    }
    
    //people interaction
    //method to check items on conveyer
    //  Move items to next worker, call workers work method with the item
    //    If it reaches the end of the conveyer, just move the object 
    //    far enough to the middle of the exit conveyer
    
    protected void upgradeA()
    {
        produceSpeed += 0.5;
    }
    public static double getProdSpeedA()
    {
        return produceSpeed;
    }
}
