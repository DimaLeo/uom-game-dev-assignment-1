import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CopyOfPlayer extends Actor
{
    private Integer state;
    
    private Boolean isMoving = false;
    private Boolean aIsPressed = false;
    private Boolean dIsPressed = false;
    
    //physics variables
    private Integer jumpForce = -10;
    private Integer ySpeed = 0;
    private Integer g = 1;
    private Integer xSpeed = 4;
    
    //animation variables
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
    
    
    
    private Integer lastDirectionFaced = 1;
    
    public CopyOfPlayer(){
        
        super();
        
        this.state = 0;
        
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
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        control();
        physics();
        animation();
    }
    
    public void animation(){
        
        switch(this.state){
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
        if(this.lastDirectionFaced == 1) this.setImage(this.jumpImageRight);
        else this.setImage(this.jumpImageLeft);
    }
    
    public void animateFall() {
        if(this.lastDirectionFaced == 1) this.setImage(this.fallImageRight);
        else this.setImage(this.fallImageLeft);
    }
    
    public void animateRun() {
        if(this.runningImageTimer > 0){
            this.runningImageTimer--;

        }  
        else{
            if(this.runningImageNumber == runningImagesRight.size() -1){
                runningImageNumber = 0;
            }
            
            if(this.lastDirectionFaced == 1){
                this.setImage(runningImagesRight.get(runningImageNumber));
            }
            else{
                this.setImage(runningImagesLeft.get(runningImageNumber));
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
            
            if(this.lastDirectionFaced == 1){
                this.setImage(idleImagesRight.get(idleImageNumber));
            }
            else{
                this.setImage(idleImagesLeft.get(idleImageNumber));
            }
            
            this.idleImageNumber++;

            this.idleImageTimer = 6;
                    
        }
        
    }
    
    private void control(){
        if((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) && onGround()){
            this.state = 1;
            jump();
        }
        
        if (Greenfoot.isKeyDown("d")){
            this.dIsPressed = true;
            this.state = onGround()? 3 : state;
            isMoving = true;
            run(1);
            this.lastDirectionFaced = 1;
        }
        
        if(!Greenfoot.isKeyDown("d")){
            this.dIsPressed = false;
            isMoving = false;
        }
        
        if (Greenfoot.isKeyDown("a")){
            this.aIsPressed = true;
            this.state = onGround()? 3 : state;
            isMoving = true;
            run(-1);
            this.lastDirectionFaced = -1;
        }
        
        if(!Greenfoot.isKeyDown("a") && this.aIsPressed){
            this.aIsPressed = false;
            isMoving = false;
        }
    }
    
    private void physics(){
        fall();
    }
    
    private void run(Integer direction){
        setLocation(getX() + xSpeed*direction, getY());
    }
    
    private void fall(){
        if(!onGround()){
            this.ySpeed += g;
            if(this.ySpeed == 0){
                this.state = 2;
            }
        }
        else{
            this.ySpeed = 0;
            this.state = isMoving? 3: 0;
        }
        
        setLocation(getX(), getY() + ySpeed);
    }
    
    private void jump() {
        this.ySpeed = this.jumpForce;
    }
    
    private void landOn(Actor a) {
        System.out.println(a.getY()+8);
        setLocation(getX(), a.getY() + 8);
    }
    
    private Boolean onGround(){
        if(state == 1){
            return false;
        }
        
        Actor under = getOneObjectAtOffset(0, 16, GroundTile.class);
        return under != null;
        
    }
}
