import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GroundTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundTile extends Actor{
    protected final int xScale = 1;
    protected final int yScale = 1;
    
    public GroundTile() {
        
        GreenfootImage image = getImage();
        
        image.scale(
            image.getWidth()*this.xScale, 
            image.getHeight()*this.yScale);
        setImage(image);
    }
    
    
    public void act()
    {
        // Add your action code here.
    }
}
