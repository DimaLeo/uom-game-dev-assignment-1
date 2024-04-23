import greenfoot.*;
import java.util.ArrayList;

public class Animator  
{
    Player player;
    
    private ArrayList<GreenfootImage> idleImagesRight = new ArrayList();
    private ArrayList<GreenfootImage> idleImagesLeft = new ArrayList();
    private Integer idleImageNumber = 0;
    private Integer idleImageTimer = 6;
    private ArrayList<GreenfootImage> runningImagesRight = new ArrayList();
    private ArrayList<GreenfootImage> runningImagesLeft = new ArrayList();
    private Integer runningImageNumber = 0;
    private Integer runningImageTimer = 10;
    private GreenfootImage jumpImageRight;
    private GreenfootImage fallImageRight;
    private GreenfootImage jumpImageLeft;
    private GreenfootImage fallImageLeft;

    /**
     * Constructor for objects of class Animator
     */
    public Animator(Player player){
        this.player = player;
        
        this.jumpImageRight = new GreenfootImage("Jump.png");
        this.fallImageRight = new GreenfootImage("Fall.png");
        this.jumpImageLeft = new GreenfootImage("Jump.png");
        this.jumpImageLeft.mirrorHorizontally();
        this.fallImageLeft = new GreenfootImage("Fall.png");
        this.fallImageLeft.mirrorHorizontally();
        
        for( int i=0; i<11; i++ ) {
            idleImagesRight.add(new GreenfootImage("mc_idle_0" + i + ".png"));
        }
        
        for( int i=0; i<11; i++ ) {
            GreenfootImage img = new GreenfootImage("mc_idle_0" + i + ".png");
            img.mirrorHorizontally();
            idleImagesLeft.add(img);
            
        }
        
        for( int i=0; i<12; i++ ) {
            runningImagesRight.add(new GreenfootImage("mc_run_" + i + ".png"));
        }
        
        for( int i=0; i<11; i++ ) {
            GreenfootImage img = new GreenfootImage("mc_run_" + i + ".png");
            img.mirrorHorizontally();
            runningImagesLeft.add(img);
            
        }
    }
    
    public void animate() {
        
        switch(player.getState()){
            case 0:
                animateIdle();
                break;
            case 1:
                animateJump();
                break;
            case 2:
                animateFall();
                break;
            case 3:
                animateRun();
                break;
        }
    }
    
    public void animateJump() {
        handleSingleImageAnimation(player.getDirection() == 1? this.jumpImageRight: this.jumpImageLeft);
    }
    
    public void animateFall() {
        handleSingleImageAnimation(player.getDirection() == 1? this.fallImageRight: this.fallImageLeft);
    }
    
    public void animateRun() {
        if(this.runningImageTimer > 0){
            this.runningImageTimer--;

        }  
        else{
            if(this.runningImageNumber == runningImagesRight.size() -1){
                runningImageNumber = 0;
            }
            
            if(player.getDirection() == 1){
                player.setImage(this.runningImagesRight.get(runningImageNumber));
            }
            else{
                player.setImage(this.runningImagesLeft.get(runningImageNumber));
            }
            
            this.runningImageNumber++;

            this.runningImageTimer = 6;
                    
        }
    }
    
     public void animateIdle() { 
        if(this.idleImageTimer > 0){
            this.idleImageTimer--;

        }  
        else{
            if(this.idleImageNumber == idleImagesRight.size() -1){
                idleImageNumber = 0;
            }
            
            if(player.getDirection() == 1){
                player.setImage(idleImagesRight.get(idleImageNumber));
            }
            else{
                player.setImage(idleImagesLeft.get(idleImageNumber));
            }
            
            this.idleImageNumber++;

            this.idleImageTimer = 6;
                    
        }
        
    }
    
    public void handleSingleImageAnimation(GreenfootImage image){
        player.setImage(image);
    }
}
