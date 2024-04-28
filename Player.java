import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Integer state;
    private Integer direction;
    private Controller controller;
    private PlayerAnimator animator;
    private Integer score;
    private Integer lastCheckpointPosition;
    private Integer health;
    
    
    public Player(){
        super();
        this.state = 0;
        this.direction = 1;
        this.controller = new Controller(this);
        this.animator = new PlayerAnimator(this);
        this.score = 0;
        this.lastCheckpointPosition = 32;
        this.health = 3;
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        reachedCheckpoint();
        controller.control();
        animator.animate();
        touchedCoin();
        hitByEnemy();
        
    }
    
    public Actor onTopOf(){
        return getOneObjectAtOffset(0, 16, GroundTile.class);
    }

    
    public boolean landed(){
        Actor under = onTopOf();
        return (state == 1 || state == 2) && under != null;
    }

    public boolean landedOnEnemy(){
        Actor enemy = getOneObjectAtOffset(0, 16, NonPlayerCharacter.class);
        getWorld().removeObject(enemy);
        return enemy!=null;
    }
    
    public void hitByEnemy() {
        Actor enemy = getOneObjectAtOffset(0, 0, NonPlayerCharacter.class);
        if(enemy != null){
            ScrollingWorld world = (ScrollingWorld) getWorld();
            setLocation(lastCheckpointPosition - world.getScroller().getScrolledX() +100, getY());
            this.health --;
        }
    }
    
    public boolean grounded() {
        Actor under = onTopOf();
        
        return under instanceof GroundTile;
    }
    
    public boolean isFrontallyColliding() {
        Actor inFront = getOneObjectAtOffset(16*direction, 0, GroundTile.class);
        return inFront != null;
    }
    
    public boolean headIsColliding() {
        Actor onTop = getOneObjectAtOffset(0, -16, GroundTile.class);
        return onTop != null;
    }

    public void setOnGround(){
        Actor under = onTopOf();
        
        if(under != null){
            setLocation(
                getX(), 
                under.getY() - getImage().getHeight()/2 - under.getImage().getHeight()/2+1);
        }
    }
    
    private void touchedCoin(){
        Actor touching = getOneIntersectingObject(Coin.class);
        
        if(touching!=null){
            score++;
            getWorld().removeObject(touching);
        }
        
        
    }
    
    private void reachedCheckpoint() {
        Actor checkpoint = getOneIntersectingObject(Checkpoint.class);
        
        ScrollingWorld world = (ScrollingWorld) getWorld();
        
        if(checkpoint != null 
            && lastCheckpointPosition != world.getScroller().getScrolledX() 
            && lastCheckpointPosition<world.getScroller().getScrolledX()) {
            lastCheckpointPosition = world.getScroller().getScrolledX();
        }
    }
    
    public void updatePlayerLocation(Integer x, Integer y){
        setLocation(x,y);
    }
    
    public Integer getState(){
        return this.state;
    }
    
    public void setState(Integer state){
        this.state = state;
    }
    
    public Integer getDirection(){
        return this.direction;
    }
    
    public void setDirection(Integer newDirection) {
        this.direction = newDirection;
    }
    
    public Integer getScore(){
        return this.score;
    }
    
    public Integer getHealth(){
        return this.health;
    }
    
}
