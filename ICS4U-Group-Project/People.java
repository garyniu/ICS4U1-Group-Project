import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * People superclass, Contains all the methods that are used by the people subclasses
 * <p>
 * Manages pathfinding of People
 * 
 * @author Gary Niu
 * @version November 2022
 */

public abstract class People extends Actor
{
    protected int direction;
    protected int currentX, currentY; //current x and y positions, will be filled for inital spawning
    protected int goToX, goToY; //coordinates to go to
    private boolean tBlock, bBlock, lBlock, rBlock;
    /**
     * Sets instance variables based on spawn position
     */
    protected void addedToWorld(World w){
        currentX = getX();
        currentY = getY();

        goToX = getX();
        goToY = getY();
    }
    /**
     * Calls the pathfind method to constantly pathfind
     */
    public void act(){
        pathFind(goToX, goToY, (GameWorld)getWorld());
    }
    
    /**
     * Sets location to move to
     * 
     * @param x - x coordinate to go to
     * @param y - y coordinate to go to
     */
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

    /**
     * Checks if any side is blocked, and modifies future position accordingly
     * 
     * @param LB Left Block
     * @param RB Right Block
     * @param TB Top Block
     * @param BB Bottom Block
     */
    private void blockedMovement(boolean LB, boolean RB, boolean TB, boolean BB){

        if (currentX < goToX && !RB){
            currentX++;
        } else if (currentX > goToX && !LB){
            currentX--;
        }

        if (currentY < goToY && !TB){
            currentY++;
        } else if (currentY > goToY && !BB){
            currentY--;
        }
    }

    /**
     * Pathfinding algorithm - very simplistic pathfinding algorithm, checks if it can move in any direction based on spawned BlockedBoxes
     * 
     * @param x The x coordinate to go to
     * @param y The y coordinate to go to
     * @param w The world to check for BlockedBoxes, not currently used
     */
    public void pathFind(int x, int y, GameWorld w){
        GameWorld gw = w;

        BlockedBoxes t = new BlockedBoxes(getImage().getWidth() - 10, 2, false);
        BlockedBoxes b = new BlockedBoxes(getImage().getWidth() - 10, 2, false);
        BlockedBoxes l = new BlockedBoxes(2, getImage().getHeight() - 5, false);
        BlockedBoxes r = new BlockedBoxes(2, getImage().getHeight() - 5, false);

        w.addObject(t, getX(), getY() - (getImage().getHeight()/2) - 9);
        w.addObject(b, getX(), getY() + (getImage().getHeight()/2) + 9);
        w.addObject(l, getX() - (getImage().getWidth()/2) - 3, getY());
        w.addObject(r, getX() + (getImage().getWidth()/2) + 3, getY());

        tBlock = b.contact(); bBlock = t.contact(); lBlock = l.contact(); rBlock = r.contact();
        
        //make rest of cases
        //make method for movement each case, flip x/y, disable x++, x--, y++, y--

        //8 cases
        //4 cases 1 edge
        //4 cases 2 edge, 1 corner
        //  _
        // |p|
        //  -     

        if (x != currentX || y != currentY){
            // check for collision on left and right, 2 seperate vars
            // check for collision on top and bottom, 2 seperate vars

            //if moving up / down, change a variable (direction)

            //if moving right / left, change a variable (direction)
            
            blockedMovement(lBlock, rBlock, tBlock, bBlock);
            setLocation (currentX, currentY);
        }

        //w.removeObject(t); w.removeObject(b); w.removeObject(l); w.removeObject(r);
        tBlock = false; bBlock = false; lBlock = false; rBlock = false;
    }

}
