import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Items extends SmoothMover
{
    protected static double prodSpeedA;
    protected static double prodSpeedB;
    protected String side;  
    protected int vcLeftX; 
    protected int vcRightX; 
    protected boolean onVertConveyor; 
    protected GreenfootImage image;
    protected static double itemValue; 
    public void act()
    {
        // Add your action code here.
    }
}