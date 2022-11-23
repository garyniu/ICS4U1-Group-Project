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
    private boolean tBlock, bBlock, lBlock, rBlock, test;

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
    protected void pathFind(int x, int y, GameWorld w){
        GameWorld gw = w;

        BlockedBoxes t = new BlockedBoxes(0, 0, getImage().getWidth() - 5, 2);
        BlockedBoxes b = new BlockedBoxes(0, 0, getImage().getWidth() - 5, 2);
        BlockedBoxes l = new BlockedBoxes(0, 0, 2, getImage().getHeight() -  5);
        BlockedBoxes r = new BlockedBoxes(0, 0, 2, getImage().getHeight() - 5);

        w.addObject(t, getX(), getY() + (getImage().getHeight()/2) - 5);
        w.addObject(b, getX(), getY() - (getImage().getHeight()/2) + 5);
        w.addObject(l, getX() - (getImage().getWidth()/2) - 10, getY());
        w.addObject(r, getX() + (getImage().getWidth()/2) + 10, getY());

        tBlock = b.contact(); bBlock = t.contact(); lBlock = l.contact(); rBlock = r.contact();

        //System.out.println("Top blocked: " + tBlock + "|| Bottom blocked: " + bBlock + "\nLeft blocked: " + lBlock + "|| Right blocked: " + rBlock + "\n");

        //make rest of cases
        //make method for movement each case, flip x/y, disable x++, x--, y++, y--

        //8 cases
        //4 cases 1 edge
        //4 cases 2 edge, 1 corner
        //  _
        // |p|
        //  -    

        //System.out.println(x + " " + y);
        //System.out.println(currentX + " " + currentY);

        if (x != currentX || y != currentY){

            //System.out.println("evenrunning");
            // check for collision on left and right, 2 seperate vars
            // check for collision on top and bottom, 2 seperate vars

            //if moving up / down, change a variable (direction)

            //if moving right / left, change a variable (direction)

            if (tBlock){
                System.out.println("1");
                if (rBlock){
                    System.out.println("2");

                    if (currentX < x){
                        //currentX++; //go right
                    } else if (currentX > x){
                        currentX--; //go left
                    }

                    if (currentY < y){
                        currentY++; //go down
                    } else if (currentY > y){
                        //currentY--; // go up
                    }

                } else if (lBlock){
                    System.out.println("3");

                    if (currentX < x){
                        currentX++; //go right
                    } else if (currentX > x){
                        //currentX--; //go left
                    }

                    if (currentY < y){
                        currentY++; //go down
                    } else if (currentY > y){
                        //currentY--; // go up
                    }

                } else {
                    System.out.println("4");

                    if (currentX < x){
                        currentX++;
                    } else if (currentX > x){
                        currentX--;
                    }

                    if (currentY < y){
                        currentY++;
                    } else if (currentY > y){
                        //currentY--;
                    }

                }

            } else if (bBlock) {
                System.out.println("6");
                if (rBlock){
                    System.out.println("7");

                    if (currentX < x){
                        //currentX++;

                    } else if (currentX > x){
                        //currentX--;

                    }

                    if (currentY < y){
                        currentY++;
                    } else if (currentY > y){
                        currentY--;
                    }

                } else if (lBlock){
                    System.out.println("8");

                    if (currentX < x){
                        currentX++; //go right
                    } else if (currentX > x){
                        //currentX--; //go left
                    }

                    if (currentY < y){
                        //currentY++; //go down
                    } else if (currentY > y){
                        currentY--; // go up
                    }

                } else {
                    if (currentX < x){
                        currentX++; //go right
                    } else if (currentX > x){
                        currentX--; //go left
                    }

                    if (currentY < y){
                        //currentY++; //go down
                    } else if (currentY > y){
                        currentY--; // go up
                    }
                    System.out.println("9");
                }

            } else if (lBlock){
                System.out.println("10");

                if (currentX < x){
                    currentX++; //go right
                } else if (currentX > x){
                    //currentX--; //go left
                }

                if (currentY < y){
                    currentY++; //go down
                } else if (currentY > y){
                    currentY--; // go up
                }

            } else if (rBlock){
                System.out.println("11");

                if (currentX > x){
                    currentX--;
                }

                if (currentY < y){
                    currentY++;
                } else if (currentY > y){
                    currentY--;
                }

            } else {

                //System.out.println("penis");
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
            }

            //System.out.println("penis1");

            setLocation (currentX, currentY);
        }

        w.removeObject(t); w.removeObject(b); w.removeObject(l); w.removeObject(r);
        tBlock = false; bBlock = false; lBlock = false; rBlock = false;
    }

}