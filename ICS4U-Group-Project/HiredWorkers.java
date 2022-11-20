import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HiredWorkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HiredWorkers extends People
{

    private static int workerCount = 0;
    private int fadepercent = 0, fadein = 120, originalPos;

    public HiredWorkers(int locX, int locY){
        super(locX, locY);
        //incrementing worker count
        GameWorld gw = (GameWorld)getWorld();
        gw.workercCount++;

        originalPos = locY;

       
       
        //add image / scale image

    }

    public void act()
    {
        //play sliding down animation, fade in
        fadein--; originalPos++;
        if (fadein >= 0){
            entry(fadein, originalPos);
           
        } else {

            //test pathfinding
           
                //super.act();
           
           
           
            work();

        }
    }
    
    private void entry(int fadetime, int ogposition){

        int upMovement = ogposition - 120;
        double perc = (double)fadetime / 120;
        perc = 1 - perc;
        int transp = (int)(perc * 255);

        if (transp > 255){
            transp = 255;
        } else if (transp < 0){
            transp = 0;
        }


        getImage().setTransparency(transp);

        setLocation(getX(), upMovement);
    }

    //animation for creating new items + working
    public void work(){

    }

    //dies
    public void death(int time){

        //play sound, delay 2 seconds, rotate 90 degrees, delete

        //setRotation(90);

        if (time > 120){
            gw.workercount--;
            getWorld().removeObject(this);
        }

    }
}