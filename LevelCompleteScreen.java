import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCompleteScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCompleteScreen extends World
{
    private GroundTileDrawer drawer;
    /**
     * Constructor for objects of class LevelCompleteScreen.
     * 
     */
    public LevelCompleteScreen(Integer coinsCollected, Integer maxCoins, Integer timesDefeated)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        drawer = new GroundTileDrawer(this);
        prepareElements(coinsCollected, maxCoins, timesDefeated);
    }

    private void prepareElements(Integer coinsCollected, Integer maxCoins, Integer timesDefeated){
        //drawer.drawGround(10,5,220,getHeight()-150);
        //Coin coin = new Coin();
        //addObject(coin,300,175);
        
        new TextElement("Coins collected : "+ coinsCollected + " of "+ maxCoins, this, 50, 50);
        new TextElement("Times defeated : -"+ timesDefeated+ " x10", this, 50, 100);
        new TextElement("Level score: " + (coinsCollected - timesDefeated*10), this, 50, 150);
        new TextElement("Press SPACE to", this, 210, getHeight()-190);
        new TextElement("start the next level", this, 170, getHeight()-160);

    }

    
    public void act(){
        
        String keyPressed = Greenfoot.getKey();
        
        if(keyPressed != null){
            if(keyPressed.equals("space")){
                Greenfoot.setWorld(new Level2());        
            }
        }
    }
}
