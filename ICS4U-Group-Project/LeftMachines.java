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
    private static double produceSpeed;
    private static double defaultSpeed;
    private static double itemValue;
   
    public LeftMachines(){
        super();
    }
    public void addedToWorld(World w){
        w.addObject(new Hitboxes(), (this.getX()+width/2)-10, this.getY()-height/2);
        spawnShoes();
    }
    public void act()
    {
        GameWorld gw = (GameWorld)getWorld(); 
        if(!gw.getStrikeStatusA()){
            actTimer++;
            updateSpeed();
        }
        if(!speedSet){
            updateSpeed();
            updateDefaultSpeedA(); 
            speedSet = true;
        }
        checkShoeFinished(); 
    }
    
    public void spawnShoes(){
        GameWorld gw = (GameWorld)getWorld();
        gw.addObject(new Shoes(this) , this.getX()-width/2, this.getY()-height/4);
        updateSpeed(); 
        itemValue = gw.getItemValueA(); 
    }
    public void checkShoeFinished(){
        if(produceSpeed == 1 && actTimer == 293){
            spawnShoes(); 
            actTimer = 0;
        }else if(produceSpeed == 1.5 && actTimer == 195){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 2 && actTimer == 147){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 2.5 && actTimer == 117){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 3 && actTimer == 98){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 3.5 && actTimer ==84){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 4 && actTimer ==74){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 4.5 && actTimer ==65){
            spawnShoes();
            actTimer = 0;
        }else if(produceSpeed == 5 && actTimer ==59){
            spawnShoes();
            actTimer = 0;
        }
    }
    public void updateSpeed(){
        GameWorld gw = (GameWorld)getWorld();
        produceSpeed = gw.getProdSpeedA();
    }
    public void updateDefaultSpeedA(){
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
}