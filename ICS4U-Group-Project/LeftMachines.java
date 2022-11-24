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
    private static int upgradeAmount;
    private static double produceSpeed;
    private static double defaultSpeed;
    private static double itemValue;
    private int width;
    private int height;
   
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
        
        
    }
    public void act()
    {
        getWorld().showText("" + produceSpeed, 80, 80);
    }
    public void addedToWorld(World w){
        //w.addObject(new Hitboxes(), this.getX()+width/2, this.getY()-height/2);
        chooseItemSpawn();
        //w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
    }
   
    //people interaction
    //method to check items on conveyer
    //  Move items to next worker, call workers work method with the item
    //    If it reaches the end of the conveyer, just move the object
    //    far enough to the middle of the exit conveyer

    
    public void chooseItemSpawn(){
        GameWorld w = (GameWorld)getWorld();
        if(intItemChoice == 2){
            itemChoice = "phones";
            w.addObject(new Phones(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 0.5;
            itemValue = Phones.getItemValue(); 
        } else if(intItemChoice == 0){
            itemChoice = "shoes";
            w.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 2;
            itemValue = Shoes.getItemValue();
        } else if(intItemChoice == 1){
            itemChoice = "tools";
            w.addObject(new Tools(this), this.getX()-width/2, this.getY()-height/4);
            produceSpeed = 5;
            itemValue = Tools.getItemValue();
        }
        defaultSpeed = produceSpeed; 
    }
    
    public static double getDefaultSpeedA(){
        return defaultSpeed;
    }
    public void setProdSpeedA(double newSpd){
        produceSpeed = newSpd;
    }
    public static double getMachItemValueA(){
        return itemValue;
    }
    public void setMachItemValueA(double value){
        this.itemValue = value; 
    }
    public String getItemChoiceA(){
        return itemChoice; 
    }
}