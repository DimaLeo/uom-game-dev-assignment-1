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
    private GreenfootImage elementImage;

    /**
     * Constructor for objects of class GUI
     */
    public GuiElement(String prefix)
    {
        this.elementImage = new GreenfootImage(prefix+".png");
        this.elementImage.scale(elementImage.getWidth()*2, elementImage.getHeight()*2);
        
        setImage(elementImage);
    }
}
