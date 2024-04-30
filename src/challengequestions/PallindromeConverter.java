package challengequestions;

import java.util.HashMap;
import java.util.Map;

public class PallindromeConverter {

    public String toPallindrome(String input) {
        // If there is two of each letter aside from one letter with just one occurence, pallindrome possible
        // If we made a map with Letter, Occurence, how could we then rearrange that into pallindrome
        Map<Character, Integer> occurenceMap = new HashMap<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            if (occurenceMap.containsKey(ch)) {
                int val = occurenceMap.get(ch);
                occurenceMap.put(ch, ++val);
            } else {
                occurenceMap.put(ch, 1);
            }
        }
        int size = occurenceMap.size();
        char[] pallindromeChars = new char[size];
        if (size % 2 == 1) {
//            pallindromeChars[size/2 - 1];
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
