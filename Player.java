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
    private Animator animator;
    
    public Player(){
        super();
        this.state = 0;
        this.direction = 1;
        this.controller = new Controller(this);
        this.animator = new Animator(this);
        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        System.out.println(direction);
        controller.control();
        animator.animate();
    }
    
    public Actor onTopOf(){
        return getOneObjectAtOffset(0, 16, GroundTile.class);
    }
    
    public boolean landed(){
        Actor under = onTopOf();
        return (state == 1 || state == 2) && under != null;
    }
    
    public boolean grounded() {
        Actor under = onTopOf();
        
        return under instanceof GroundTile;
    }

     public void setOnGround(){
        Actor under = onTopOf();
        if(under != null){
            setLocation(
                getX(), 
                under.getY() - getImage().getWidth()/2 - under.getImage().getWidth()/2);
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
    
}
