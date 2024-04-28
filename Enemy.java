import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends NonPlayerCharacter
{
    private MovableActorAnimator animator;
    
    public Enemy(String prefix, Integer moveAmount){
        super(moveAmount);
        this.animator = new MovableActorAnimator(this, prefix, false);

    }
    
    public void act()
    {
        super.randomMove();
        animator.animate();
    }
    
    public Integer getDirection(){
        return super.getDirection();
    }
    
    public Integer getState(){
        return super.getState();
    }
    
    public void setState(Integer state){
        super.setState(state);
    }
    
    public void setDirection(Integer direction){
        super.setDirection(direction);
    }
}
