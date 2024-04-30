import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends MusicWorld
{
    private GroundTileDrawer drawer;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400);
        drawer = new GroundTileDrawer(this);
        prepareElements();
    }

    private void prepareElements(){
        drawer.drawGround(10,5,220,getHeight()-150);
        Coin coin = new Coin();
        addObject(coin,300,175);
        
        new TextElement("Press space to", this, 210, getHeight()-270);
        new TextElement("START", this, 270, getHeight()-190);
    }

    
    public void act(){
        
        String keyPressed = Greenfoot.getKey();
        
        if(keyPressed != null){
            if(keyPressed.equals("space")){
                Greenfoot.setWorld(new Level1());        
            }
        }
    }
    
}
