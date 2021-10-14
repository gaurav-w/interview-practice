package strings;

import java.util.HashMap;

public class CheckPattern {
    public static boolean findPermutation(String str, String pattern) {


        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<Character, Integer> strMap = new HashMap<>();
        int startWindow = 0, endWindow = 0;

        if (str == null || pattern == null)
            return true;

        if (pattern.length() > str.length())
            return false;

        //build pattern frequency map
        for (int i = 0; i < pattern.length(); i++) {
            Character currentChar = pattern.charAt(i);
            patternMap.put(currentChar, patternMap.getOrDefault(currentChar, 0) + 1);
        }

        //start the same for str
        for (endWindow = 0; endWindow < str.length(); endWindow++) {
            Character currentChar = str.charAt(endWindow);
            strMap.put(currentChar, strMap.getOrDefault(currentChar, 0) + 1);

            int frqInPat = patternMap.getOrDefault(currentChar, 0);
            int frqInStr = strMap.get(currentChar);

            //if frequencies dont match then decrease the size of window till it matches
            if (frqInPat < frqInStr) {
                while (frqInPat != frqInStr && startWindow <= endWindow) {
                    Character startWindowChar = str.charAt(startWindow);

                    if (startWindowChar.equals(currentChar)) {
                        strMap.put(currentChar, strMap.get(currentChar) - 1);
                        frqInStr = strMap.get(currentChar);
                    }

                    startWindow++;
                }
            }

            if (endWindow - startWindow + 1 == pattern.length())
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
    }
}

