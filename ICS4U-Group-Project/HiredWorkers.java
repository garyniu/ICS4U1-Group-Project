//Imports
import greenfoot.*; 

/**
 * A HiredWorker is hired by a normal boss once they want to upgrade the number of workers per station. 
 *
 * @author Gary Niu
 * @version November 2022
 */
public class HiredWorkers extends People
{

    private int fadepercent = 0, fadein = 120, originalPos;
    private boolean firstSpawn;

    /**
     * Constructor calls the super Constructor and sets values+images
     * 
     * @param FS Unused now, used to determine if the HiredWorker will have a fade in animation
     */
    public HiredWorkers(boolean FS){
        super();
        //incrementing worker count
        GameWorld gw = (GameWorld)getWorld();
        firstSpawn = FS;

        //add image / scale image
        GreenfootImage image = new GreenfootImage("Char.png");
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
    }

    public void addedToWorld(){
        originalPos = getY();
    }

    public void act()
    {
        //play sliding down animation, fade in
        fadein--; originalPos++;
        
        //Unused, messed up spawn positions
        //if (fadein >= 0 && firstSpawn){
            //System.out.println("testsed");
            //entry(fadein, originalPos);
        //    entry(fadein, originalPos);

        //} 
    }

    /**
     * Slides the HiredWorker down the screen, and fades in
     * <p>
     * Based on VehicleSimulator code
     * 
     * @param fadein The amount of time the HiredWorker will fade in
     * @param originalPos The original position of the HiredWorker
     *
     */
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