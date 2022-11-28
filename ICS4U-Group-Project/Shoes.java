import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Shoes are the items that are made by machines and workers. They are responsible for moving themselves across the conveyor, but their speed is taken from its corresponding machines speed using a getter. 
 * <p>
 * Any manipulation of the speed at which shoes are produced at is due to the machine production speed being changed, and then the shoes speed being constantly updated so it is equal to the speed of the machines. 
 * <p>
 * For setting images based on their position on the conveyor (found in act()), BlockedBoxes could have been used, but adding them to the world and setting the images like that was becoming complicated, when we had to create, refer to, and keep track of 12 different BlockedBoxes. Therefore, we opted for a simple timer-based approach.
 *
 * @author Harishan Ganeshanathan, Victor Wei, Arsham Zare Moayedi, Gary Niu 
 * @version November 2022
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
    /**
     * Constructor for Shoes - Sets the starting image and creates the other images that the shoe will turn into, as well as essential variables
     * 
     * @param m     The machine that the shoe is on (whether it is a left or right machine) 
     */
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
    /**
     * Sets the side that the shoe is on (left or right side)
     * 
     * @param w World 
     */
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
    }
    /**
     * Act Method - The speed is set and the shoe checks if it is on a vertical conveyor or not (if not, it will move based on the produce speed of the machines of the side it is on),  
     * there is a timer based algorithm for changing the shoe images once they go through a station, 
     * if the shoe collides with the BlockedBox at the end of the vertConveyor, it will add to the currency and then remove the shoe object.
     */
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
    /**
     * This method constantly updates the speed of the shoe to ensure that the speed is accurate. 
     */
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
    /**
     * This method checks if the shoe is currently on a VertConveyor or not, and sets a boolean onVertConveyor to true if it is. 
     */
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
    /**
     * Gets if this current instance of a shoe has been made.
     * 
     * @return boolean Returns the boolean shoeMade. 
     */
    public boolean getShoeMade(){
        return shoeMade;
    }
} 