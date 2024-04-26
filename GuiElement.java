import greenfoot.GreenfootImage;
import java.util.Map;
import java.util.HashMap;
import greenfoot.Actor;

/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuiElement extends Actor
{
    // instance variables - replace the example below with your own
    private GreenfootImage characterImage;

    /**
     * Constructor for objects of class GUI
     */
    public GuiElement(String letter)
    {
        this.characterImage = new GreenfootImage(letter+".png");
        this.characterImage.scale(characterImage.getWidth()*2, characterImage.getHeight()*2);
        setImage(characterImage);
    }
}
