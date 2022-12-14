import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rightmachines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rightmachines extends Machines
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
    private int width;
    private int height;
   
    public Rightmachines(String itemChoice){
       
        imageB = new GreenfootImage("shirtMachineTemp.png");
        imageB.scale(300, 100);
        setImage(imageB);
        
        this.itemChoice = itemChoice; 
        
        width = imageB.getWidth();
        height = imageB.getHeight();
        upgradeAmount = GameWorld.getCurrencyB();
    }
    public void addedToWorld(World w){
        //w.addObject(new Hitboxes(), this.getX()+width/2, this.getY()-height/2);
        chooseItemSpawn();
        //w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }
    public void act()
    {
        
    }
   
    public void produceB()
    {
       
    }
   
    public void upgradeB()
    {
       produceSpeed +=0.2; 
       defaultSpeed = produceSpeed;
    }
    public static double getDefaultSpeedB(){
        return defaultSpeed; 
    }
    public void setProdSpeedB(double newSpd){
        produceSpeed = newSpd;
    }
    
    public void chooseItemSpawn(){
        GameWorld w = (GameWorld)getWorld();
        if(itemChoice == "phones"){
            w.addObject(new Phones(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 0.5;
            itemValue = Phones.getItemValue();
        } else if(itemChoice == "shoes"){
            w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 2;
            itemValue = Shoes.getItemValue();
        } else if(itemChoice == "tools"){
            w.addObject(new Tools(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 5;
            itemValue = Tools.getItemValue();
        }
        defaultSpeed = produceSpeed; 
    }
    
    public static double getMachItemValueB(){
        return itemValue;
    }
    public void setMachItemValueB(double value){
        this.itemValue = value; 
    }
    public String getItemChoiceB(){
        return itemChoice; 
    }
}
