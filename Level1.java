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
    
    private ArrayList<ArrayList<GroundTile>> groundTiles = 
        new ArrayList();
    
    public Level1()
    {
        super();
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
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Player player = new Player();
        Integer numberOfTiles = 3200/16;
        
        groundTileConstructor(0, 0);

        for(int i = 1; i<=numberOfTiles; i++){
            groundTileConstructor(i,1);
        }
            
        //addObject(player, 16, super.getHeight()-3*tile16Px-playerTileWidth/2);
        
        new Tip("A: move left\n"+
                "D: move right\n", this, 32);
                
        new Tip("W or Space: jump\n", this, 450);
        
        new Tip("W or Space Twice: double jump\n", this, 830);
        
        new Tip("Collect coins\n"+
                "to increase your score", this, 1300);
                
        new Tip("Do not touch enemies head on\n"+
                "Jump on them to deal damage", this, 1800);
                    
        addObject(new Box(), 500-tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 500, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 500+tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 500+tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 500+tile22Px, super.getHeight()-3*tile16Px-2*tile22Px-tile22Px/2);
        addObject(new Box(), 500+tile22Px, super.getHeight()-3*tile16Px-3*tile22Px-tile22Px/2);
        addObject(new Box(), 500+2*tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 500+2*tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 500+2*tile22Px, super.getHeight()-3*tile16Px-2*tile22Px-tile22Px/2);
        addObject(new Box(), 500+2*tile22Px, super.getHeight()-3*tile16Px-3*tile22Px-tile22Px/2);
        
        addObject(new Box(), 550+tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 550+tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 550+2*tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 550+2*tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 550+3*tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 550+3*tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        
        addObject(new Box(), 850+tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 850+tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 850+tile22Px, super.getHeight()-3*tile16Px-2*tile22Px-tile22Px/2);
        addObject(new Box(), 850+tile22Px, super.getHeight()-3*tile16Px-3*tile22Px-tile22Px/2);
        
        addObject(new Box(), 1000+tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 1000+tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 1000+tile22Px, super.getHeight()-3*tile16Px-2*tile22Px-tile22Px/2);
        addObject(new Box(), 1000+tile22Px, super.getHeight()-3*tile16Px-3*tile22Px-tile22Px/2);
        
        addObject(new Box(), 1150+tile22Px, super.getHeight()-3*tile16Px-tile22Px/2);
        addObject(new Box(), 1150+tile22Px, super.getHeight()-3*tile16Px-tile22Px-tile22Px/2);
        addObject(new Box(), 1150+tile22Px, super.getHeight()-3*tile16Px-2*tile22Px-tile22Px/2);
        addObject(new Box(), 1150+tile22Px, super.getHeight()-3*tile16Px-3*tile22Px-tile22Px/2);
        
        addObject(new Coin(), 1400, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        addObject(new Coin(), 1450, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        addObject(new Coin(), 1500, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        addObject(new Coin(), 1550, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        addObject(new Coin(), 1600, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        addObject(new Coin(), 1650, super.getHeight() - 3*tile16Px - tile32Px/2 - 6);
        
        addObject(new Box(), 1400-tile22Px, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*2, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*3, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*4, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*5, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*6, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*7, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*8, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*9, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*10, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*11, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*12, super.getHeight() - 3*tile16Px - 100);
        addObject(new Box(), 1400 + tile22Px*13, super.getHeight() - 3*tile16Px - 100);
        
        addObject(new Coin(), 1400, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);
        addObject(new Coin(), 1450, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);
        addObject(new Coin(), 1500, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);
        addObject(new Coin(), 1550, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);
        addObject(new Coin(), 1600, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);
        addObject(new Coin(), 1650, super.getHeight() - 3*tile16Px - tile32Px/2 - 116);

        
        
    }
}
