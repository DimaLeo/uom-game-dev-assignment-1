import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class NonPlayerCharacter extends Actor
{
    private Integer direction = 1;
    private Integer state = 0;
    private Integer patrolTimer = 400;
    private Integer patrolSpeed = 1;
    private Integer attackSpeed = 3;
    private Integer initialPosition = 0;
    private Integer randomDirectionChangeTimer = 30;
    private Integer idleOnDirectionChangeTimer = 100;
    
    public Integer getDirection(){
        return this.direction;
    }
    
    public Integer getState(){
        return this.state;
    }
    
    public void setState(Integer state){
        this.state = state;
    }
    
    public void setDirection(Integer direction){
        this.direction = direction;
    }
    
    public void randomMove(){
        
        Integer moveSpeed = patrolSpeed;
        if(idleOnDirectionChangeTimer>0){
            state = 0;
            moveSpeed = 0;
            idleOnDirectionChangeTimer--;
        }
        else{
            if(patrolTimer == 0){
                patrolTimer = 400;
                direction *= -1;
                idleOnDirectionChangeTimer = 100;
                
            }
            else patrolTimer --;
            
            state = 3;
            
            /*
            if(randomDirectionChangeTimer == 0){
                
                int randomDirection = (int)Math.round(Math.random());
                
                if(randomDirection == 1) direction = 1;
                else direction = -1;
                idleOnDirectionChangeTimer = 30;
                randomDirectionChangeTimer = 100;
            
            }
            */
        }
        
        setLocation(getX() + direction*moveSpeed, getY());
        
    }
    
}
