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
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private GuiElement coinImage;
    private Integer score = 0;
    private ArrayList<GuiElement> scoreDigits = new ArrayList<>();
    
    Scroller scroller;
    Player scrollActor;
    
    public ScrollingWorld() 
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false);
        GreenfootImage background = new GreenfootImage("images.jpeg");
        Integer backgroundHeight = background.getHeight();
        Integer backgroundWidth = background.getWidth();
        scroller = new Scroller(this, background, 3200, 400);
        scrollActor = new Player();
        addObject(scrollActor, 32, HEIGHT - 4*16);
        coinImage = new GuiElement("coin_1");
        scoreDigits.add(new GuiElement(""+score));
        
        
        addObject(coinImage, 100, 30);
        addObject(scoreDigits.get(0), 150, 30);
        
        scroll();
    }
    
    public void act(){
        if( scrollActor != null) scroll();
        
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
                addObject(digitElement, 50+i*10+5, 30);
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
            scoreDigits.get(i).setLocation(50+i*10+5, scoreDigits.get(i).getY());
        }
        
        
        scroller.scroll(dsx, 0);
    }
}
