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
        firstSpawn = FS;

        
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
        //System.out.println(fadein);
        
        //if (fadein >= 0 && firstSpawn){
            //System.out.println("testsed");
            //entry(fadein, originalPos);
        //    entry(fadein, originalPos);

        //} 
    }

    private void entry(int fadetime, int ogposition){
        
        int upMovement = ogposition - 120;
        
        System.out.println(upMovement);
        double perc = (double)fadetime / 120;
        perc = 1 - perc;
        int transp = (int)(perc * 255);
        
        

        if (transp > 255){
            transp = 255;
        } else if (transp < 0){
            transp = 0;
        }
        
        //System.out.println(transp);

        getImage().setTransparency(transp);
        setLocation(getX(), originalPos + upMovement + 150);
    }

}