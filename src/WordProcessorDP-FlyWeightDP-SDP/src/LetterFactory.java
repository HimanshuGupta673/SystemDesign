import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private static Map<Character,ILetter> characterCache = new HashMap<Character,ILetter>();

    public static ILetter createLetter(char letter){
        if(characterCache.containsKey(letter)){
            return characterCache.get(letter);
        }else {
            DocumentCharacter characterObj = new DocumentCharacter(letter,"Arial",10);
            characterCache.put(letter,characterObj);
            return characterObj;
        }
    }
}
