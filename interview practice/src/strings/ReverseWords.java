package strings;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReverseWords {

    public static void main(String[] args) {
//        String s[] = "i like this program very much".split(" ");
//        String ans = "";
//        for (int i = s.length - 1; i >= 0; i--) {
//            ans += s[i] + " ";
//        }
//        System.out.println("Reversed String:");
//        System.out.println(ans.substring(0, ans.length() - 1));

        String str = "i like this program very much";
        StringTokenizer st = new StringTokenizer(str);
        ArrayList<String> al = new ArrayList<>();

        int getTokenSize = st.countTokens();
        for (int i = 0; i < getTokenSize; i++) {
            al.add(st.nextToken());
        }
        for (int i = al.size() - 1; i >= 0; i--) {
            System.out.print(al.get(i) + " ");
        }

    }
}
