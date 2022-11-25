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
            double itemA = Shoes.getItemValue();
            for(LeftMachines lm : gw.getObjects(LeftMachines.class)){
                /*if(lm.getItemChoiceA() == "tools"){
                    newValue = lm.getMachItemValueA()+15;
                    lm.setMachItemValueA(newValue);
                    Tools.setItemValue(newValue);
                    System.out.println("left machine item: "+lm.getItemChoiceA() + " and value: "+newValue);
                }*/
                if(lm.getItemChoiceA() == "shoes"){
                    newValue = itemA+25;
                    lm.setMachItemValueA(newValue);
                    newValue-=25;
                    System.out.println("left machine item: "+lm.getItemChoiceA() + " and value: "+newValue);
                }/*
                else if(lm.getItemChoiceA() == "phones"){
                    newValue = lm.getMachItemValueA()+75;
                    lm.setMachItemValueA(newValue); 
                    Phones.setItemValue(newValue);
                    System.out.println("left machine item: "+lm.getItemChoiceA() + " and value: "+newValue);
                }*/
            }
            Shoes.setItemValue(newValue);
        }
        else if(right){
            double itemB = Shoes.getItemValue();
            for(Rightmachines rm : gw.getObjects(Rightmachines.class)){
                /*if(rm.getItemChoiceB() == "tools" || rm.getItemChoiceB() == "shoes"){
                    newValue = rm.getMachItemValueB()+15;
                    rm.setMachItemValueB(newValue);
                    System.out.println("right machine item: "+rm.getItemChoiceB() + " and value: "+newValue);
                }
                else if(rm.getItemChoiceB() == "phones"){
                    newValue = rm.getMachItemValueB()+75;
                    rm.setMachItemValueB(newValue); 
                    System.out.println("right machine item: "+rm.getItemChoiceB() + " and value: "+newValue);
                }*/
                newValue = itemB+25; 
                rm.setMachItemValueB(newValue); 
                System.out.println("right machine item: shoes and value: "+newValue);
                newValue-=25;
            }
            Shoes.setItemValue(newValue);
        }
    }
}
