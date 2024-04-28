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
    private StaticActorAnimator animator;
    private Integer scale = 2;

    
    public Coin(){
        
        this.animator = new StaticActorAnimator(prefix, noOfFrames, this, scale);
    }
    
    public void act()
    {
        animator.animateIdle();
    }
}
