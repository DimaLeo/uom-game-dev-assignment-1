import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    private ArrayList<ArrayList<GroundTile>> groundTiles = 
        new ArrayList();
    
    public Level1()
    {
        super(3200, 400, 1);
        prepare();
    }
    
    private void groundTileConstructor(Integer position, Integer type){
        
        Integer centerOffset = 8;
        Integer tileSize = 16;
        Integer x = tileSize*position+centerOffset;
        
        if(type == 0) {
            
            BottomLeftCornerGround blc = new BottomLeftCornerGround();
            super.addObject(blc,x, super.getHeight()-centerOffset);
            LeftEdgeGround le = new LeftEdgeGround();
            addObject(le, x, super.getHeight()-tileSize-centerOffset);
            LeftCornerGrass lcg = new LeftCornerGrass();
            addObject(lcg, x, super.getHeight()-2*tileSize-centerOffset);
            
        }
        if(type == 1){
            
            InnerBottomEdgeGround inegnd = new InnerBottomEdgeGround();
            addObject(inegnd,x, super.getHeight()-centerOffset);
            InnerGround ingnd = new InnerGround();
            addObject(ingnd, x, super.getHeight()-tileSize-centerOffset);
            InnerGrass ingr = new InnerGrass();
            addObject(ingr, x, super.getHeight()-2*tileSize-centerOffset);
        }
        if(type == 2){
            BottomRightCornerGround brcg = new BottomRightCornerGround();
            addObject(brcg,x, super.getHeight()-centerOffset);
            RightEdgeGround reg = new RightEdgeGround();
            addObject(reg, x, super.getHeight()-tileSize-centerOffset);
            InnerBottomEdgeGround inbegnd = new InnerBottomEdgeGround();
            addObject(inbegnd, x, super.getHeight()-2*tileSize-centerOffset);
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

        addObject(player, 16, super.getHeight()-2*16-8-24);
        
        addObject(
            new OSD("A: move left\n"+
                    "D: move right\n") , 150, 150);
                    
        addObject(new Box(), 500, super.getHeight()-2*16-8-18);
        addObject(new Box(), 500+20, super.getHeight()-2*16-8-18);
        addObject(new Box(), 500+20, super.getHeight()-2*16-8-18-20);
    }
}
