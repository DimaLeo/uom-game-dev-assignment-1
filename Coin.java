import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Collectible
{
    private String prefix = "coin_";
    private Integer noOfFrames = 7;
    private ObjectsAnimator animator;
    private Integer scale = 2;

    
    public Coin(){
        
        this.animator = new ObjectsAnimator(prefix, noOfFrames, this, scale);
    }
    
    public void act()
    {
        animator.animateIdle();
    }
}
