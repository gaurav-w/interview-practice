package strings;

import java.util.Iterator;
import java.util.LinkedHashSet;

//Remove Duplicates
public class RemoveDuplicate {


    // Driver code
    public static void main(String[] args) {
        char str[] = "geeksforgeeks".toCharArray();
        int n = str.length;
        System.out.println(removeDuplicate(str, n));
    }


    private static String removeDuplicate(char[] str, int n) {
        LinkedHashSet<Character> hs = new LinkedHashSet<>();
        for (int i = 0; i < str.length; i++) {
            hs.add(str[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (Iterator<Character> itr = hs.iterator(); itr.hasNext(); ) {
            sb.append(itr.next());
        }
        return sb.toString();
    }
}
