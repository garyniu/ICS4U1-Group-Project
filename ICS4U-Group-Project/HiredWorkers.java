import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HiredWorkers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HiredWorkers extends People
{

    private static int workercount = 0;

    public HiredWorkers(int locX, int locY){
        super(locX, locY);
        //incrementing worker count
        workercount++;

        //add image / scale image 

    }

    public void act()
    {
        super.act();

    }
    
    //dies
    public void death(){
        workercount--;
        getWorld().removeObject(this);
    }
}
