import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Write a description of class Shoes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shoes extends Items
{
    /**
     * Act - do whatever the Shoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean shoeMade;
    public Shoes(Machines m)
    {
        image = new GreenfootImage("shoesTemp.png");
        image.scale(30, 30);
        setImage(image);      
        
        onVertConveyor = false;
        shoeMade = false;
    }
    public void addedToWorld(World w){
        if(this.getX() <=512){
            for(LeftMachines lm : w.getObjects(LeftMachines.class)){
                this.prodSpeedA = lm.getDefaultSpeedA();
                side = "left";
            }
        } else if(this.getX()>512){
            for(Rightmachines rm: w.getObjects(Rightmachines.class)){
                this.prodSpeedB = rm.getDefaultSpeedB();
                side = "right";
            }
        }
        GameWorld gw = (GameWorld)getWorld();
    }
    public void act()
    {
       checkVertConveyor();
       if(side == "left" && !onVertConveyor){
           move(prodSpeedA);
       }
       else if(side == "right" && !onVertConveyor){
           move(prodSpeedB);
       }
       
        //setLocation(getX() + produceSpeed, getY());
       
       Actor b = getOneIntersectingObject(Hitboxes.class); 
       if(b != null && !onVertConveyor){
           shoeMade = true;
       }
       if(b != null && onVertConveyor)  
       {  
           if(side == "left"){
               GameWorld.addCurrencyA();
           }
           else if(side == "right"){
               GameWorld.addCurrencyB();
           }
           getWorld().removeObject(this);
       }
    }
    public void checkVertConveyor(){
        GameWorld gw = (GameWorld)getWorld();
        ArrayList<VertConveyor> vertConveyors = (ArrayList<VertConveyor>)gw.getObjects(VertConveyor.class); 
        for(VertConveyor v : vertConveyors){
            if(v.getX() <=512){
                vcLeftX = v.getX();
            }
            else if(v.getX() >512){
                vcRightX = v.getX();
            }
        }
        
        if(side == "left"){
            if(this.getX()>=vcLeftX){
                setLocation(this.getX(), this.getY() + prodSpeedA);
                this.onVertConveyor = true;
            }
        }
        else if(side == "right"){
            if(this.getX()>=vcRightX){
                setLocation(this.getX(), this.getY() + prodSpeedB);
                this.onVertConveyor = true;
            }
        }
    }
    public boolean getShoeMade(){
        return shoeMade;
    }
} 