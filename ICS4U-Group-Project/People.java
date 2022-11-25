import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class People here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class People extends Actor
{
    /**
     * Act - do whatever the People wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
<<<<<<< Updated upstream
=======

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

        tBlock = b.contact(); bBlock = t.contact(); lBlock = l.contact(); rBlock = r.contact();
        

        
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

>>>>>>> Stashed changes
}
