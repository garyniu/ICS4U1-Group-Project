import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoomingBusiness here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoomingBusiness extends Event
{
    private GreenFlash gf; 
    private boolean flashAdded; 
    private boolean stockIncreased;
    private double itemA;
    private double itemB;
    
    public BoomingBusiness(int d, boolean left, boolean right){
        super(d, left, right);
        flashAdded=false;
        stockIncreased = false;
        System.out.println("BOOMING BUSINESS");
    }

    public void act()
    {
        if(!flashAdded){
            GameWorld w = (GameWorld)getWorld();
            if(left){
                gf = new GreenFlash(duration); 
                w.addObject(gf, 256, 400);
            }
            else if(right){
                gf = new GreenFlash(duration);
                w.addObject(gf, 768, 400);
            }
            flashAdded = true;
        }
        if(!stockIncreased){
            increaseStock();
            stockIncreased = true;
        }
        eventTimer++;
        if(eventTimer == duration){
            endEvent();
        }
    }

    public void increaseStock(){
        GameWorld gw = (GameWorld)getWorld();
        if(left){
            itemA = LeftMachines.getMachItemValueA();
            newValueLeft = itemA + 25; 
            LeftMachines.setMachItemValueA(newValueLeft);
            System.out.println("left machine item: shoes " + " and value: "+ newValueLeft);
            gw.setItemValueA(newValueLeft);
            System.out.println("Left machine shoes: "+gw.getItemValueA());
        }
        else if(right){
            itemB = RightMachines.getMachItemValueB();
            newValueRight= itemB + 25; 
            RightMachines.setMachItemValueB(newValueRight);
            System.out.println("right machine item: shoes and value " +newValueRight);
            gw.setItemValueB(newValueRight);
            System.out.println("right machine shoes: "+gw.getItemValueB());
        }
    }
}
