import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transport extends People
{

    private int goX, goY;
    private int goingX, goingY, timer = 0;
    private boolean pointT = false, pointC = true, moving = true;
    private String side;
    private GreenfootImage image, imageA;

    public Transport(int goX, int goY, String side){
        this.goX = goX;
        this.goY = goY;
        this.side = side;

        image = new GreenfootImage("Char.png");
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
        
        imageA = new GreenfootImage("CharBox.png");
        imageA.scale(imageA.getWidth()/4, imageA.getHeight()/4);

        

    }

    public void addedToWorld(World w){
        super.addedToWorld(w);
        
    }

    /**
     * Act - do whatever the Transport wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        //constantly go to 2 coords
        
        timer++;
        
        if (pointC && !pointT){

            goingX = goX;
            goingY = goY;

        }

        if (!pointC && pointT){

            if (side == "left"){
                goingX = 50;
                goingY = 100;
            } else {
                goingX = 570;
                goingY = 100;
            }
        }

        super.act();
        
        if (timer >= Greenfoot.getRandomNumber(200)+40){
            moving = true;
        }
        
        if (moving){
            goToLocation(goingX, goingY);
        }
        
        if (pointC){
            setImage(imageA);
        } else {
            setImage(image);
        }
        

        if (goingX == getX() && goingY == getY()){
            pointC = !pointC;
            pointT = !pointT;
            
            moving = false;

            timer = 0;
        }

    }
}
