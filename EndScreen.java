import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCompleteScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends MusicWorld
{
    private ScrollingWorld passedLevel;
    private Boolean failed = false;
    
    public EndScreen(ScrollingWorld world)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400); 
        this.failed = true;
        this.passedLevel = world;
        new TextElement("Game Over",this , 240, 150);
        new TextElement("Press ENTER to", this, 210, getHeight()-190);
        new TextElement("start over", this, 235, getHeight()-160);

    }
    
    public EndScreen(Integer coinsCollected, Integer maxCoins, Integer timesDefeated, ScrollingWorld passedLevel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400); 
        this.passedLevel = passedLevel;
        prepareElements(coinsCollected, maxCoins, timesDefeated);
    }

    private void prepareElements(Integer coinsCollected, Integer maxCoins, Integer timesDefeated){
        //drawer.drawGround(10,5,220,getHeight()-150);
        //Coin coin = new Coin();
        //addObject(coin,300,175);
        
        new TextElement("Coins collected : "+ coinsCollected + " of "+ maxCoins, this, 50, 50);
        new TextElement("Times defeated : -"+ timesDefeated+ " x10", this, 50, 100);
        new TextElement("Level score: " + (coinsCollected - timesDefeated*10), this, 50, 150);
        
        if(!(passedLevel instanceof Level2)){
            new TextElement("Press ENTER to", this, 210, getHeight()-190);
            new TextElement("start the next level", this, 170, getHeight()-160);
        }
        else{
            new TextElement("Congratulations!!", this, 210, getHeight()-190);
            new TextElement("You have completed the game", this, 130, getHeight()-160);
        }
        

    }

    
    public void act(){
        
        String keyPressed = Greenfoot.getKey();
        
        if(keyPressed != null){
            if(keyPressed.equals("enter")){
                if(failed) Greenfoot.setWorld(new Level1()); 
                else Greenfoot.setWorld(new Level2()); 
            }
        }
    }
}
