import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends GroundTile
{
    private Integer direction = -1;
    private Integer platformMoveSpeed = 1;
    private Integer delayOnDirectionChange = 0;
    private Integer maxHeight;
    private Integer minHeight;
    
    
    public Platform(Integer maxHeight, Integer minHeight){
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
    }
    
    public void act()
    {
        moveUpAndDown();
    }
    
    private void moveUpAndDown(){
        
        Integer movementSpeed = platformMoveSpeed;
        
        if(delayOnDirectionChange != 0){
            delayOnDirectionChange--;
        }
        else {
            setLocation(getX(), direction*movementSpeed + getY());
            
            if(maxHeight == getY()){
                direction = 1;
                delayOnDirectionChange = 100;
            }
            if(minHeight == getY()){
                direction = -1;
                delayOnDirectionChange = 100;
            }
            
            
        }
        
        
    }
    
}
