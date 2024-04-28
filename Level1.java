import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends ScrollingWorld
{

    private final Integer tile22Px = 22;
    private final Integer tile16Px = 16;
    private final Integer tile32Px = 32;
    private final Integer playerTileWidth = 32;
    private final Integer groundHeight = tile16Px*3;
    
    public Level1()
    {
        super("images.jpeg");
        prepare();
    }
    
    private void groundTileConstructor(Integer position, Integer type){
        
        
        Integer x = tile16Px*position+tile16Px/2;
        
        if(type == 0) {
            
            BottomLeftCornerGround blc = new BottomLeftCornerGround();
            addObject(blc,x, super.getHeight()-tile16Px/2);
            LeftEdgeGround le = new LeftEdgeGround();
            addObject(le, x, super.getHeight()-tile16Px-tile16Px/2);
            LeftCornerGrass lcg = new LeftCornerGrass();
            addObject(lcg, x, super.getHeight()-2*tile16Px-tile16Px/2);
            
        }
        if(type == 1){
            
            InnerBottomEdgeGround inegnd = new InnerBottomEdgeGround();
            addObject(inegnd,x, super.getHeight()-tile16Px/2);
            InnerGround ingnd = new InnerGround();
            addObject(ingnd, x, super.getHeight()-tile16Px-tile16Px/2);
            InnerGrass ingr = new InnerGrass();
            addObject(ingr, x, super.getHeight()-2*tile16Px-tile16Px/2);
        }
        if(type == 2){
            BottomRightCornerGround brcg = new BottomRightCornerGround();
            addObject(brcg,x, super.getHeight()-tile16Px/2);
            RightEdgeGround reg = new RightEdgeGround();
            addObject(reg, x, super.getHeight()-tile16Px-tile16Px/2);
            InnerBottomEdgeGround inbegnd = new InnerBottomEdgeGround();
            addObject(inbegnd, x, super.getHeight()-2*tile16Px-tile16Px/2);
        }
        
        
    }
    
    private void lineOfBoxes(Integer numberOfBoxes, Integer startingX, Integer y){
        
        for(int i=0; i<numberOfBoxes; i++){
            addObject(new Box(), startingX+i*tile22Px, y);
        }
        
    }
    
    private void stackOfBoxes(Integer numberOfBoxes, Integer x, Integer startingY){
        
        for(int i=0; i<numberOfBoxes; i++){
            addObject(new Box(), x, startingY-i*tile22Px);
        }
        
    }
    
    private void boxesRectangle(Integer cols, Integer rows, Integer startingX, Integer startingY){
        
        for(int i = 0; i<cols; i++){
            
            for(int j = 0; j<rows; j++){
                addObject(new Box(), startingX+i*tile22Px, startingY-j*tile22Px);
            }
        }
        
    }
    
    private void coinsInArow(Integer numberOfCoins, Integer spaceBetween, Integer startingX, Integer y){
        for(int i=0; i<numberOfCoins; i++){
            addObject(new Coin(), startingX+i*spaceBetween +tile32Px, y);
        }
    }
    
    private void stackOfCoins(Integer numberOfCoins, Integer spaceBetween, Integer startingY, Integer x){
        for(int i=0; i<numberOfCoins; i++){
            addObject(new Coin(), x, startingY - i*spaceBetween -tile32Px);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        Integer numberOfTiles = 3200/16;
        
        groundTileConstructor(0, 0);

        for(int i = 1; i<=numberOfTiles; i++){
            groundTileConstructor(i,1);
        }
            
        addObject(player, 16, super.getHeight()-groundHeight-playerTileWidth/2);
        super.setScrollActor(player);
                
        new TextElement("A: move left\n"+
                "D: move right\n", this, 32);
                
        new TextElement("W or Space: jump\n", this, 450);
        
        new TextElement("W or Space Twice: double jump\n", this, 800);
        
        new TextElement("Collect coins\n"+
                "to increase your score", this, 1300);
                
        new TextElement("Do not touch enemies head on\n"+
                "Jump on them to deal damage", this, 1700);
    
                    
                
        boxesRectangle(3, 1, 400, super.getHeight()-groundHeight-tile22Px/2);
        boxesRectangle(3,3, 500, super.getHeight()-groundHeight-tile22Px/2);
        boxesRectangle(3,5, 600, super.getHeight()-groundHeight-tile22Px/2);
        
        
        stackOfBoxes(4, 850, super.getHeight()-groundHeight-tile22Px/2);
        stackOfBoxes(4, 1000, super.getHeight()-groundHeight-tile22Px/2);
        stackOfBoxes(4, 1150, super.getHeight()-groundHeight-tile22Px/2);
        
        
        coinsInArow(8, 40, 1360,  super.getHeight() - groundHeight - tile32Px/2 - 6);
        lineOfBoxes(15, 1378, super.getHeight() - groundHeight - 80);
        coinsInArow(8, 40, 1360,  super.getHeight() - groundHeight - tile32Px/2 - 96);
        
        addObject(new Checkpoint(), 1750, super.getHeight() - groundHeight -24);
        
        
        addObject(new Enemy1(400), 1800, super.getHeight() - groundHeight - 23);
        
        lineOfBoxes(15, 2200, 100);
        coinsInArow(8, 40, 2180,  70);
         
        addObject(new Platform(100, getHeight()-groundHeight-11), 2200-46, super.getHeight() - groundHeight - 11 );
        stackOfCoins(5, 40, super.getHeight() -groundHeight - 30, 2200-46);
        
        
        lineOfBoxes(3, 2600, 160);
        coinsInArow(2, 40, 2570, 130);
        
        lineOfBoxes(3, 2500, 220);
        coinsInArow(2, 40, 2470, 190);
        
        lineOfBoxes(3, 2400, 260);
        coinsInArow(2, 40, 2370, 230);
        
        lineOfBoxes(3, 2300, 300);
        coinsInArow(2, 40, 2270, 270);
        
        addObject(new Enemy2(400), 2650, super.getHeight() - groundHeight - 16);
        
        addObject(new NextLevelCheckpoint(), 3200-32, getHeight() - groundHeight - 24);
    }
}
