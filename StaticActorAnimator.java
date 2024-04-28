import java.util.ArrayList;
import greenfoot.GreenfootImage;
import greenfoot.Actor;

/**
 * Write a description of class ObjectsAnimator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StaticActorAnimator  
{
    private ArrayList<GreenfootImage> images;
    private Integer idleImageTimer = 6;
    private Integer idleImageNumber = 0;
    private Integer frames;
    private Actor item;
    private Integer scale;
    
    public StaticActorAnimator(String prefix, Integer noOfFrames, Actor item, Integer scale){
        
        this.item = item;
        this.frames = noOfFrames;
        this.images = new ArrayList();
        this.scale = scale;
        
        for(int i=0; i<noOfFrames; i++) {
            
            GreenfootImage img = new GreenfootImage(prefix+i+".png");
            img.scale(img.getWidth()*scale, img.getHeight()*scale);
            images.add(img);
            
        }
        
    
        
    }
    
    
    public void animateIdle() { 
        if(this.idleImageTimer > 0){
            this.idleImageTimer--;

        }  
        else{
            if(this.idleImageNumber == frames -1){
                idleImageNumber = 0;
            }
            
            item.setImage(images.get(idleImageNumber));
            
            this.idleImageNumber++;

            this.idleImageTimer = 6;
                    
        }
        
    }
}
