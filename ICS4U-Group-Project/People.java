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
    private boolean tBlock, bBlock, lBlock, rBlock;

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
        //System.out.println(currentX + " " + currentY + " "  + goToX + " " + goToY);
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

    //pathfinding algo, very simple
    private void pathFind(int x, int y, GameWorld w){
        GameWorld gw = w;

        BlockedBoxes t = new BlockedBoxes(0, 0, getImage().getWidth() - 10, 2, Color.RED);
        BlockedBoxes b = new BlockedBoxes(0, 0, getImage().getWidth() - 10, 2, Color.BLUE);
        BlockedBoxes l = new BlockedBoxes(0, 0, 2, getImage().getHeight() - 5, Color.GREEN);
        BlockedBoxes r = new BlockedBoxes(0, 0, 2, getImage().getHeight() - 5, Color.YELLOW);

        w.addObject(t, getX(), getY() - (getImage().getHeight()/2) - 9);
        w.addObject(b, getX(), getY() + (getImage().getHeight()/2) + 9);
        w.addObject(l, getX() - (getImage().getWidth()/2) - 3, getY());
        w.addObject(r, getX() + (getImage().getWidth()/2) + 3, getY());

        tBlock = t.contact(); bBlock = b.contact(); lBlock = l.contact(); rBlock = r.contact();
        

        
        //System.out.println("\ntop blocked: " + tBlock + "\nbottom blocked: " + bBlock + "\nleft blocked: " + lBlock + "\nright blocked: " + rBlock);
        
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
