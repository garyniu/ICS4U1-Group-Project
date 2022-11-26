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
    private int items, WC = 1, conveyerLevel = 1;
    private int timer;
    private static int upgradeAmount, ShoeCount = 1;
    private static double produceSpeed;
    private static double defaultSpeed;
    private static double itemValue;
    private boolean shoeCanBeMade, firstWU = false, secWU = false;
    private int width;
    private int height;
    private Shoes shoe; 
    private HiredWorkers t_o, t_t, t_th, th_o, th_t, th_th;

    public LeftMachines(int itemChoice)
    {
        imageA = new GreenfootImage("shirtMachineTemp.png");
        imageA.scale(300, 100);
        setImage(imageA);
        defaultSpeed = produceSpeed; 

        this.intItemChoice = itemChoice; 
        //upgradeA();

        width = imageA.getWidth();
        height = imageA.getHeight();
        upgradeAmount = GameWorld.getCurrencyA();

        //StartingWorkers();
    }

    public void act()
    {
        getWorld().showText("" + produceSpeed, 80, 80);
        shoeCanBeMade = this.shoe.getShoeMade(); 
        if(shoeCanBeMade){

            //add a delay here
            

            this.shoeCanBeMade = false;
        }


    }

    public void addedToWorld(World w){
        w.addObject(new Hitboxes(), (this.getX()+width/2), this.getY()-height/2);
        spawnShoes();        
        
        getWorld().addObject(new HiredWorkers(false), getX()/2 - 30, getY() -20);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 60 , getY() - 20);
        getWorld().addObject(new HiredWorkers(false), getX()/2 + 150, getY() - 20);

        //w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }


    public void addWorkers(){

        System.out.println("worker level: " + WC);

        if (WC == 2 && !secWU){
            WC = 3;
            
            t_o = new HiredWorkers(true);
            t_t = new HiredWorkers(true);
            t_th = new HiredWorkers(true);
            
            getWorld().addObject(t_o, getX()/2 - 30+ 40, getY() -20);
            getWorld().addObject(t_t, getX()/2 + 60+ 40 , getY() - 20);
            getWorld().addObject(t_th, getX()/2 + 150+ 40, getY() - 20);
            secWU = true;
        }

        if (WC == 1 && !firstWU){
            WC = 2;
            
            th_o = new HiredWorkers(true);
            th_t = new HiredWorkers(true);
            th_th = new HiredWorkers(true);
            
            getWorld().addObject(th_o, getX()/2 - 30 + 20, getY() -20);
            getWorld().addObject(th_t, getX()/2 + 60+ 20 , getY() - 20);
            getWorld().addObject(th_th, getX()/2 + 150+ 20, getY() - 20);
            firstWU = true;
        } 

    }

    //people interaction
    //method to check items on conveyer
    //  Move items to next worker, call workers work method with the item
    //    If it reaches the end of the conveyer, just move the object
    //    far enough to the middle of the exit conveyer

    public void strikeRemove(){
        getWorld().removeObject(t_o);
        getWorld().removeObject(t_t);
        getWorld().removeObject(t_th);
        getWorld().removeObject(th_o);
        getWorld().removeObject(th_t);
        getWorld().removeObject(th_th);
        firstWU = false;
        secWU = false;
        
    }
    
    public void spawnShoes(){
        GameWorld w = (GameWorld)getWorld();
        shoe = new Shoes(this);
        w.addObject(shoe, this.getX()-width/2, this.getY()-height/4);
        produceSpeed = 1;
        itemValue = w.getItemValueA();
        defaultSpeed = produceSpeed; 
    }

    public double getDefaultSpeedA(){
        return defaultSpeed;
    }

    public double getProdSpeedA(){
        return produceSpeed; 
    }

    public void setProdSpeedA(double newSpd){
        produceSpeed = newSpd;
    }

    public static double getMachItemValueA(){
        return itemValue;
    }

    public static void setMachItemValueA(double value){
        itemValue = value; 
    }

    public int returnWorkers(){
        return WC;
    }
    
    public void resetWorkers(){
        WC = 1;
    }

}