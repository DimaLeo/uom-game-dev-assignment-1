import greenfoot.*; 

public class Controller
{
    private static final Integer tileOffset = 8; //half of tile width
    // instance variables - replace the example below with your own
    private Player player;
    
    private Boolean dIsPressed;
    private Boolean aIsPressed;
    private Boolean isJumpHeld;
    
    //physics variables
    private Integer jumpForce;
    private Integer ySpeed;
    private Integer g;

    private Integer xSpeed;
    
    private Integer doubleJumpCounter;
    /**
     * Constructor for objects of class Controller
     */
    public Controller(Player player)
    {
        this.player = player;
        this.dIsPressed = false;
        this.aIsPressed = false;
        this.doubleJumpCounter = 2;
        
        this.jumpForce = -12;
        this.ySpeed = 0;
        this.g = 1;
        
        this.xSpeed = 4;
        
        
    }

    public void control(){
        controlPhysics();
        controlPlayerInputs();
    }
    
    private void controlPlayerInputs(){
        String keyPressed = Greenfoot.getKey();
        
        if(keyPressed != null){
            if(keyPressed.equals("space") || keyPressed.equals("w")){
                if(doubleJumpCounter>0) jump();        
            }
        }
        
        if (Greenfoot.isKeyDown("d")){
            this.dIsPressed = true;
            player.setState(player.grounded()? 3 : player.getState());
            player.setDirection(1);
            run();
        }
        
        if(!Greenfoot.isKeyDown("d") && this.aIsPressed){
            this.dIsPressed = false;
            player.setState(0);
        }
        
        if (Greenfoot.isKeyDown("a")){
            this.aIsPressed = true;
            player.setState(player.grounded()? 3 : player.getState());
            player.setDirection(-1);
            System.out.println(player.getDirection());
            run();
        }
        
        if(!Greenfoot.isKeyDown("a") && this.aIsPressed){
            this.aIsPressed = false;
            player.setState(0);
        }
    }
    
    private void controlPhysics(){
        gravity();
    }
    
    private void run(){
        player.updatePlayerLocation(player.getX() + xSpeed * player.getDirection(), player.getY());
    }
    
    private void jump() {
        doubleJumpCounter--;
        player.setState(1);
        this.ySpeed = this.jumpForce;
    }
    
    private void gravity() {
        if(ySpeed<0 || !player.grounded()){
            this.ySpeed += g;
            if(this.ySpeed == 0){
                //if the player was rising and reached the top spot of the jump ySpeed = 0, then he starts falling
                player.setState(2);
            }
            
            player.updatePlayerLocation(player.getX(), player.getY() + ySpeed);
        }
        else{
            //if player is on the ground ySpeed = 0;
            this.ySpeed = 0;
            this.doubleJumpCounter = 2;
            player.setOnGround();
            //will also need to check if is moving state isMoving? 3: 0
            player.setState(0);
        }
        
        
    }
    
   
    
    
}
