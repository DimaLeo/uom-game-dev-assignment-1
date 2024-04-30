import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingWorld extends World
{
    private static final int WIDTH = 3200;
    private static final int HEIGHT = 400;
    private Integer health = 3;
    private GuiElement coinImage;
    private Integer score = 0;
    private ArrayList<GuiElement> scoreDigits = new ArrayList<>();
    private ArrayList<GuiElement> healthIndicators = new ArrayList<>();
    private Integer numberOfCoins = 0;
    
    Scroller scroller;
    Player scrollActor;
    
    public ScrollingWorld(String background_image) 
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false);
        GreenfootImage background = new GreenfootImage(background_image);
        Integer backgroundHeight = background.getHeight();
        Integer backgroundWidth = background.getWidth();
        scroller = new Scroller(this, background, 3200, 400);
        //scrollActor = new Player();
        //addObject(scrollActor, 32, HEIGHT - 4*16);
        coinImage = new GuiElement("coin_0");

        for(int i = 0; i<3; i++){
            healthIndicators.add(new GuiElement("health_indicator"));
            addObject(healthIndicators.get(i), getWidth() - 50 - i*(32 + 4), 30);  
        }
        scoreDigits.add(new GuiElement(""+score));
        
        
        
        addObject(coinImage, 50, 30);
        addObject(scoreDigits.get(0), 100, 32);
    }
    
    public void act(){
        
        if( scrollActor != null){
            if(scrollActor.getState() != -1) scroll();
            checkForHealthReduction();
        }
        handleScrollChange();
        
        
        
        
    }
    
    private void checkForHealthReduction(){
        
        if(scrollActor.getHealth() != health) {
            health = scrollActor.getHealth();
            for(GuiElement e: healthIndicators){
                removeObject(e);
            }
            healthIndicators.set(health, new GuiElement("health_indicator_empty"));
            
            for(int i = 0; i<3; i++){
                healthIndicators.get(i);
                addObject(healthIndicators.get(i), getWidth() - 50 - i*(32 + 4), 30);  
            }
             
            
        }
        
    }
    
    private void handleScrollChange(){
        
        if(score != scrollActor.getScore()){
            score = scrollActor.getScore();
            int scoreToDigits = score;
            ArrayList<Integer> digits = new ArrayList<>();
            
            while (scoreToDigits > 0) {
                digits.add(scoreToDigits % 10);
                scoreToDigits = scoreToDigits / 10;
            }
            
            Collections.reverse(digits);
            for(GuiElement element: scoreDigits){
                removeObject(element);
            }
            scoreDigits.clear();
            
            for(int i=0; i<digits.size(); i++){
                GuiElement digitElement = new GuiElement(""+digits.get(i));
                addObject(digitElement, 50+i*13+6, 32);
                scoreDigits.add(digitElement);
                
            }
            
        }
    }
    
    private void scroll(){
        
        int loX = WIDTH/2 - 150;
        int hiX = WIDTH - WIDTH/2 - 150;
        int dsx = 0;
        
        if(scrollActor.getX() < loX) dsx = scrollActor.getX() - loX;
        if(scrollActor.getX() > hiX) dsx = scrollActor.getX() - hiX;
        
        coinImage.setLocation(30, this.coinImage.getY());
        
        for(int i=0; i<scoreDigits.size(); i++){
            scoreDigits.get(i).setLocation(50+i*13+6, scoreDigits.get(i).getY());
        }
        
        for(int i=0; i<healthIndicators.size(); i++){
            healthIndicators.get(i).setLocation(getWidth() - 50 - i*(32 + 4), healthIndicators.get(i).getY());
        }
        
        
        scroller.scroll(dsx, 0);
    }
    
    
    public void setScrollActor(Player player){
        this.scrollActor = player;
    }
    
    public Scroller getScroller(){
        return this.scroller;
    }
    
    public Integer getNumberOfCoins(){
        return this.numberOfCoins;
    }
    
    public void setNumberOfCoins(int numberOfCoins){
        this.numberOfCoins = numberOfCoins;
    }
}
