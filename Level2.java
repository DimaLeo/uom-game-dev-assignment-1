import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends ScrollingWorld
{
    private GroundTileDrawer drawer;
    
    private final Integer tile22Px = 22;
    private final Integer tile16Px = 16;
    private final Integer tile32Px = 32;
    private final Integer playerTileWidth = 32;
    private final Integer groundHeight = tile16Px*3;
    

    public Level2()
    {
        super("b5.png");
        drawer = new GroundTileDrawer(this);
        prepare();

    }
    
    private void prepare(){
        Integer lastPos;
        Integer prevPos;
        lastPos = drawer.drawGround(10,3,8,getHeight() - groundHeight+8);
        Player player = new Player();
        addObject(player, 16, super.getHeight()-groundHeight-playerTileWidth/2);
        super.setScrollActor(player);

        prevPos = lastPos;
        lastPos = drawer.makeTrap(lastPos, 10);
        drawer.lineOfBoxes(2, prevPos + (lastPos - prevPos)/2 - tile22Px, getHeight() - groundHeight + tile22Px/2);        
        
        lastPos = drawer.drawGround(20,3,lastPos,getHeight() - groundHeight+8);
        
        Platform platform1 = new Platform(150, getHeight() - groundHeight + tile22Px/2);
        addObject(platform1, lastPos + platform1.getImage().getWidth()/2, getHeight() - groundHeight + tile22Px/2); 
        
        Integer initialX = platform1.getX() + platform1.getImage().getWidth()/2 + tile22Px/2;
        
        drawer.lineOfBoxes(5, initialX, 150);  
        initialX += 5*tile22Px; 
        drawer.lineOfBoxes(3, initialX + 50, 190); 
        initialX += 3*tile22Px+50; 
        drawer.lineOfBoxes(3, initialX + 50, 230); 
        initialX += 3*tile22Px+50;
        addObject(new Box(), initialX+35, 300);
        Enemy2 enemy2 = new Enemy2(0);
        addObject(enemy2, initialX+35, 300-tile22Px/2 - enemy2.getImage().getHeight()/2 );
        initialX += tile22Px+35;
        drawer.lineOfBoxes(6, initialX + 35, 330); 


        Enemy1 enemy1 = new Enemy1(250);
        addObject(enemy1,362,getHeight()-groundHeight-enemy1.getImage().getHeight()/2);

        
        lastPos = drawer.makeTrap(lastPos, 50);

        
        
        
    }
}
