import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicWorld extends World
{

    private GreenfootSound music;
    /**
     * Constructor for objects of class MusicWorld.
     * 
     */
    public MusicWorld(Integer WIDTH, Integer HEIGHT)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1, false); 
        this.music = new GreenfootSound("main.mp3");
    }
    
    public void started()
    {
        music.playLoop();
    }
    
    public void stopped()
    {
        music.stop();
    }
}
