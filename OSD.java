import greenfoot.*;

public class OSD extends Actor{
    private static final Color textColor = Color.BLACK;
    
    /**
     * Create a new FPS reading.
     */
    public OSD(String text)
    {
        setImage(new GreenfootImage(150, 150));
        GreenfootImage image = getImage();
        updateImage(text);
    }
    
    
    public void act(){
        
    }
    
    private final void updateImage(String value)
    {
        getImage().clear();
        GreenfootImage txt = new GreenfootImage(value, 16, textColor, null);
        getImage().drawImage(txt, 1, 1);
    }
}