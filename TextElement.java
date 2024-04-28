import greenfoot.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class TextElement extends Actor{
    private static final Color textColor = Color.BLACK;
    private final Map<String , String> symbolsMap = new HashMap<>();
    
    public TextElement(String text, World world, Integer startingPoint)
    {
        symbolsMap.put("!", "exclamation_mark");
        symbolsMap.put("?", "question_mark");
        symbolsMap.put("=", "equals");
        symbolsMap.put("-", "minus");
        symbolsMap.put("+", "plus");
        symbolsMap.put(".", "dot");
        symbolsMap.put(",", "comma");
        symbolsMap.put(":", "colon");
        symbolsMap.put("(", "parenthesis_left");
        symbolsMap.put(")", "parenthesis_right");
        symbolsMap.put(" ", "space");
     
        ArrayList<String> parts =new ArrayList<>(Arrays.asList(text.split("\n")));
        
        for(String part: parts){
            for(int i=0; i<part.length(); i++){
                String character;
                if(symbolsMap.containsKey(Character.toString(part.charAt(i)))) 
                    character = symbolsMap.get(Character.toString(part.charAt(i)));
                else {
                    character = Character.toString(part.charAt(i)).toUpperCase();
                }
            
                
                GuiElement e = new GuiElement(character);
                world.addObject(e, startingPoint + i*14 + 4, 100 + parts.indexOf(part)*22);
            
            }
        }
        
    }
    
    public TextElement(String text, World world, Integer startingPoint, Integer startingHeight)
    {
        symbolsMap.put("!", "exclamation_mark");
        symbolsMap.put("?", "question_mark");
        symbolsMap.put("=", "equals");
        symbolsMap.put("-", "minus");
        symbolsMap.put("+", "plus");
        symbolsMap.put(".", "dot");
        symbolsMap.put(",", "comma");
        symbolsMap.put(":", "colon");
        symbolsMap.put("(", "parenthesis_left");
        symbolsMap.put(")", "parenthesis_right");
        symbolsMap.put(" ", "space");
     
        ArrayList<String> parts =new ArrayList<>(Arrays.asList(text.split("\n")));
        
        for(String part: parts){
            for(int i=0; i<part.length(); i++){
                String character;
                if(symbolsMap.containsKey(Character.toString(part.charAt(i)))) 
                    character = symbolsMap.get(Character.toString(part.charAt(i)));
                else {
                    character = Character.toString(part.charAt(i)).toUpperCase();
                }
            
                
                GuiElement e = new GuiElement(character);
                world.addObject(e, startingPoint + i*14 + 4, startingHeight + parts.indexOf(part)*22);
            
            }
        }
        
    }
}