import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Write a description of class Shoes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shoes extends SmoothMover
{
    private static double prodSpeedA;
    private static double prodSpeedB;
    private String side;  
    private int vcLeftX; 
    private int vcRightX; 
    private boolean onVertConveyor; 
    private GreenfootImage image;
    private boolean shoeMade;
    private GreenfootImage leather, shoe, box;
    private int timer = 0;
    public Shoes(Machines m)
    {
        leather = new GreenfootImage("Leather.png");
        leather.scale(30, 30);
        setImage(leather);   

        shoe = new GreenfootImage("Shoes.png");
        shoe.scale(30, 30);
        box = new GreenfootImage("ShoeBox.png");
        box.scale(30, 30);

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
        timer++;
        setSpeed();
        checkVertConveyor();
        GameWorld gw = (GameWorld)getWorld(); 
        if(side == "left" && !onVertConveyor){
            move(prodSpeedA);
        }
        else if(side == "right" && !onVertConveyor){
            move(prodSpeedB);
        }

        if (side == "left"){
            if (prodSpeedA < 2 ){
                if (timer < 110){
                    setImage(leather);
                } else if (timer >= 110 && timer <= 250){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            } else if (prodSpeedA >= 2 && prodSpeedA <= 3){
                if (timer < 60){
                    setImage(leather);
                } else if (timer >= 60 && timer <= 120){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            } else if (prodSpeedA >= 3 && prodSpeedA <= 4){
                if (timer < 40){
                    setImage(leather);
                } else if (timer >= 40 && timer <= 80){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            
            } else if (prodSpeedA > 4){
                if (timer < 30){
                    setImage(leather);
                } else if (timer >= 30 && timer <= 60){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            }
        } else if (side == "right"){
            if (prodSpeedB < 2 ){
                if (timer < 110){
                    setImage(leather);
                } else if (timer >= 110 && timer <= 250){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            } else if (prodSpeedB >= 2 && prodSpeedB <= 4){
                if (timer < 60){
                    setImage(leather);
                } else if (timer >= 60 && timer <= 120){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            } else if (prodSpeedB > 4){
                if (timer < 30){
                    setImage(leather);
                } else if (timer >= 30 && timer <= 60){
                    setImage(shoe);
                } else if (gw.getShoeBoxed()){
                    setImage(box);
                }
            }
        }

        Actor bb = getOneIntersectingObject(BlockedBoxes.class); 
        if(bb != null && onVertConveyor && ((BlockedBoxes)bb).isMachine())  
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

    public void setSpeed(){
        GameWorld gw = (GameWorld)getWorld();
        if(this.getX() <=512){
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                this.prodSpeedA = gw.getProdSpeedA();
                side = "left";
            }
        } else if(this.getX()>512){
            for(Rightmachines rm: gw.getObjects(Rightmachines.class)){
                this.prodSpeedB = gw.getProdSpeedB();
                side = "right";
            }
        }
    }

    public void checkVertConveyor(){
        GameWorld gw = (GameWorld)getWorld();
        ArrayList<VertConveyor> vertConveyors = (ArrayList<VertConveyor>)gw.getObjects(VertConveyor.class); 
        for(VertConveyor v : vertConveyors){
            if(v.getX() <=512){
                vcLeftX = v.getX()+9;
            }
            else if(v.getX() >512){
                vcRightX = v.getX()+9;
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