package dp;

import java.util.*;

public class WordBreak2 {

    public static void main(String[] args) {
        WordBreak2 w = new WordBreak2();

        String ar[] = {"aabbbaaa", "aaba", "a", "b", "a", "babbbabb", "baaaab"};
        List<String> arlist = Arrays.asList(ar);
        String a = "aaabaaaaab";
        w.wordBreak(a, new ArrayList<>(arlist));
    }


    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> res = wordBreakHelper(A, B, map);
        Collections.sort(res);
        return res;
    }

    public ArrayList<String> wordBreakHelper(String A, ArrayList<String> B,
                                             HashMap<String, ArrayList<String>> map) {

        if (map.get(A) != null)
            return map.get(A);

        ArrayList<String> list = new ArrayList<String>();

        if (A.length() == 0) {
            list.add("");
            return list;
        }


        for (int i = 0; i < B.size(); i++) {
            String testStr = B.get(i);

            if (A.startsWith(testStr)) {
                String testSubStr = A.substring(testStr.length());
                ArrayList<String> substringList = wordBreakHelper(testSubStr, B, map);


                for (int j = 0; j < substringList.size(); j++) {
                    String optionalSpace = substringList.get(j).isEmpty() ? "" : " ";
                    list.add(testStr + optionalSpace + substringList.get(j));
                }

            }

        }

        map.put(A, list);

        return list;
    }
}
