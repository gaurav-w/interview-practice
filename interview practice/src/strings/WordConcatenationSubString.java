package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordConcatenationSubString {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int sizeOfWord = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int startWindow = 0, endWindow = 0;
        int matches = 0;
        int windowLength = 0;

        if (words == null || str == null)
            return null;

        sizeOfWord = words[0].length();
        if (str.length() < words.length * sizeOfWord)
            return null;

        //get frequency map for all the words
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                Character wordChar = words[i].charAt(j);
                frequencyMap.put(wordChar, frequencyMap.getOrDefault(wordChar, 0) + 1);
            }
        }

        for (endWindow = 0; endWindow < str.length(); endWindow++) {
            Character rightChar = str.charAt(endWindow);

            if (frequencyMap.containsKey(rightChar)) {
                frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
                if (frequencyMap.get(rightChar) == 0)
                    matches++;
            }

            windowLength = endWindow - startWindow + 1;
            if (windowLength == sizeOfWord * words.length) {
                if (matches != frequencyMap.size())
                    resultIndices.add(startWindow);

                int loopLength = 0;
                while (loopLength == sizeOfWord) {
                    Character leftChar = str.charAt(startWindow);

                    if (frequencyMap.containsKey(leftChar)) {
                        if (frequencyMap.get(leftChar) == 0)
                            matches--;
                        frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
                    }
                    startWindow++;
                    loopLength++;
                }
            } else if (windowLength > sizeOfWord * words.length) {
                while (windowLength != sizeOfWord * words.length) {
                    Character leftChar = str.charAt(startWindow);

                    if (frequencyMap.containsKey(leftChar)) {
                        if (frequencyMap.get(leftChar) == 0)
                            matches--;
                        frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
                    }
                    startWindow++;
                    windowLength--;
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
    }

}
