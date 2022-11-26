import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rightmachines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RightMachines extends Machines
{
    /**
     * Act - do whatever the Rightmachines wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imageB;
    private int produceTimeB;
    private static int upgradeAmount;
    private static double produceSpeed;
    private static double defaultSpeed; 
    private static double itemValue; 
    private boolean shoeCanBeMade;
    private int width;
    private int height;
    private Shoes shoe; 
   
    public RightMachines(int itemChoice){
       
        imageB = new GreenfootImage("shirtMachineTemp.png");
        imageB.scale(300, 100);
        setImage(imageB);
        
        this.intItemChoice = itemChoice; 
        
        width = imageB.getWidth();
        height = imageB.getHeight();
        upgradeAmount = GameWorld.getCurrencyB();
    }
    public void addedToWorld(World w){
        w.addObject(new Hitboxes(), (this.getX()+width/2), this.getY()-height/2);
        spawnShoes();
        //w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }
    public void act()
    {
        getWorld().showText("" + produceSpeed, 80, 80);
        shoeCanBeMade = this.shoe.getShoeMade(); 
        if(shoeCanBeMade){
            spawnShoes();
            this.shoeCanBeMade = false;
        }
    }
    public void spawnShoes(){
        GameWorld w = (GameWorld)getWorld();
        shoe = new Shoes(this); 
        w.addObject(shoe, this.getX()-width/2, this.getY()-height/4);
        produceSpeed = 1;
        itemValue = w.getItemValueB();
        defaultSpeed = produceSpeed; 
    }
    public double getDefaultSpeedB(){
        return defaultSpeed; 
    }
    public double getProdSpeedB(){
        return produceSpeed; 
    }
    public void setProdSpeedB(double newSpd){
        produceSpeed = newSpd;
    }
    public static double getMachItemValueB(){
        return itemValue;
    }
    public static void setMachItemValueB(double value){
        itemValue = value; 
    }
}
