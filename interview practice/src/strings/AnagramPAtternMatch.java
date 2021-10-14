package strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramPAtternMatch {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int startWindow = 0, endWindow = 0;
        int matches = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character currentChar = pattern.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
        }

        for (endWindow = 0; endWindow < str.length(); endWindow++) {
            Character currentChar = str.charAt(endWindow);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) == 0)
                    matches++;

            }


            int windowLength = endWindow - startWindow + 1;
            if (windowLength > pattern.length()) {
                Character startWindowChar = str.charAt(startWindow);
                startWindow++;
                if (map.containsKey(startWindowChar)) {
                    if (map.get(startWindowChar) == 0)
                        matches--;
                    map.put(startWindowChar, map.get(startWindowChar) + 1);
                }
            }

            if (matches == map.size()) {
                break;
            }

        }

        for (int i = startWindow; i < (startWindow + pattern.length()); i++)
            resultIndices.add(i);

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
    }

}
