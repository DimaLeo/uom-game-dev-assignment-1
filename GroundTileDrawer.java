import greenfoot.World;

/**
 * Write a description of class GroundTileDrawer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundTileDrawer  
{
    private World world;
    private static final Integer groundTileDimension = 16;
    
    public GroundTileDrawer(World world)
    {
        this.world = world;
    }
    
    public void drawGround(Integer cols, Integer rows, Integer startingX, Integer startingY){
        
        
        world.addObject(new LeftCornerGrass(), startingX, startingY);
        world.addObject(new BottomLeftCornerGround(), startingX, startingY+groundTileDimension*(rows-1));
        world.addObject(new RightCornerGrass(), startingX+cols*groundTileDimension, startingY);
        world.addObject(new BottomRightCornerGround(), startingX+cols*groundTileDimension, startingY+groundTileDimension*(rows-1));
        for(int i = 1; i<cols ; i++){
            world.addObject(new InnerGrass(), startingX+i*groundTileDimension, startingY);
            world.addObject(new InnerBottomEdgeGround(), startingX+i*groundTileDimension, startingY+groundTileDimension*(rows-1));
        }
        
        if(rows>2){
            
            for(int i=1; i<rows-1; i++){
                for(int j=0; j<=cols; j++){
                    if(j==0){
                        world.addObject(new LeftEdgeGround(), startingX, startingY+groundTileDimension*i);
                    }
                    else if(j==cols){
                        world.addObject(new RightEdgeGround(), startingX+j*groundTileDimension, startingY+groundTileDimension*i);
                    }
                    else world.addObject(new InnerGround(), startingX+j*groundTileDimension, startingY+groundTileDimension*i);
                }
            }
            
        }
        
        
    }

}
