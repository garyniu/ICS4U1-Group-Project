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
        System.out.println("x: " + goToX + " y: " + goToY);
    }
    
    public void act(){
    
        pathFind(goToX, goToY, getWorld());
        
        System.out.println("x: " + goToX + " y: " + goToY);
    }
    
    public void goToLocation(int x, int y){
        goToX = x;
        goToY = y;
    }
    
    //pathfinding algo, very simple
    //not even pathfinding its literally just go forward
    private void pathFind(int x, int y, World w){
        GameWorld gw = (GameWorld)w;
        //get gameworld objects, and check x y interception, same as bus
        
        while (x != currentX && y != currentY){
            
            if (currentX < x){
                currentX++;
            } else if (currentX > x){
                currentX--;
            }
            
            if (currentY < y){
                currentY++;
            } else if (currentY > y){
                currentY--;
            }
            
            
            if (xBlocked){
                
            } else if (yBlocked){
                
            } else if (xBlocked && yBlocked){
                
            }
            
            setLocation (currentX, currentY);
            
        }
    }
    
}
