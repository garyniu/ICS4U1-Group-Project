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
    private static double produceSpeed;
    private static double defaultSpeed; 
    private static double itemValue; 
   
    public RightMachines(){
       super();
    }
    public void addedToWorld(World w){
        w.addObject(new Hitboxes(), (this.getX()+width/2)-10, this.getY()-height/2);
        spawnShoes();
    }
    public void act()
    {
        GameWorld gw = (GameWorld)getWorld(); 
        if(!gw.getStrikeStatusB()){
            actTimer++;
            updateSpeed();
        }
        if(!speedSet){
            updateSpeed();
            updateDefaultSpeedB(); 
            speedSet = true;
        }
        checkShoeFinished(); 
    }
    public void spawnShoes(){
        GameWorld gw = (GameWorld)getWorld(); 
        gw.addObject(new Shoes(this), this.getX()-width/2, this.getY()-height/4);
        updateSpeed();
        itemValue = gw.getItemValueB();
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
        produceSpeed = gw.getProdSpeedB();
    }
    public void updateDefaultSpeedB(){
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
