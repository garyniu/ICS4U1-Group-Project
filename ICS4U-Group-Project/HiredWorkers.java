import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HiredWorkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HiredWorkers extends People
{

    private int fadepercent = 0, fadein = 120, originalPos;
    private boolean firstSpawn;

    public HiredWorkers(boolean FS){
        super();
        //incrementing worker count
        GameWorld gw = (GameWorld)getWorld();
        FS = firstSpawn;

        GreenfootImage image = new GreenfootImage("Char.png");
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);

        //add image / scale image
    }

    public void addedToWorld(){
        originalPos = getY();
    }

    public void act()
    {
        //play sliding down animation, fade in
        fadein--; originalPos++;

        if (fadein >= 0 && firstSpawn){
            entry(fadein, originalPos);

        } else {

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
            GameWorld gw = (GameWorld)getWorld();

            getWorld().removeObject(this);
        }

    }
}