import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class People here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class People extends Actor
{
    protected int direction;
    protected int currentX, currentY; //current x and y positions, will be filled for inital spawning
    protected int goToX, goToY; //coordinates to go to
    private boolean xBlocked, yBlocked;
    
    
    //TODO
    //spawn hiredworker
    //"holding" an object / having object in hand
    //implement manufactoring 
    //implement pathfinding, go to machine with pathfinding
    
    /**
     * Act - do whatever the People wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public People(int locX, int locY){
        
        //setting positions
        currentX = locX;
        currentY = locY;

        goToX = locX;
        goToY = locY;

    }
    
    public void act(){
        
        pathFind(goToX, goToY, (GameWorld)getWorld());
        
        

    }
    
    public void goToLocation(int x, int y){
        if (x > getWorld().getWidth()){
            x = getWorld().getWidth();
        } else if (x < 0){
            x = 0;
        }
        
        if (y > getWorld().getHeight()){
            y = getWorld().getHeight();
        } else if (y < 0){
            y = 0;
        }
        goToX = x;
        goToY = y;
    }
    
    //pathfinding algo, very simple
    private void pathFind(int x, int y, GameWorld w){
        GameWorld gw = w;
        Actor xImp = getOneObjectAtOffset((getImage().getWidth()/2), 0, Machines.class);
        Actor yImp = getOneObjectAtOffset(0, (getImage().getHeight()/2), Machines.class);
        
        xBlocked = (xImp != null) ? true : false;
        yBlocked = (yImp != null) ? true : false;
        
        System.out.println(getImage().getHeight()/2);
        
        
        if (x != currentX && y != currentY){
            
            
            if (!yBlocked){
                if (currentX < x){
                    currentX++;
                } else if (currentX > x){
                    currentX--;
                }
            } 
            
            
            if (!xBlocked){
                if (currentY < y){
                    currentY++;
                } else if (currentY > y){
                    currentY--;
                }
            }
            
            
            
            
            
            if (xBlocked && yBlocked){
                currentX++;
            } 
            
            setLocation (currentX, currentY);
            
        }
    }
    
}
