package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestCommonSubString {

    public static void main(String[] args) {
        ShortestCommonSubString s = new ShortestCommonSubString();
        String ar[] = {"abc", "bcd"};
        List<String> arlist = Arrays.asList(ar);
        s.solve(new ArrayList<>(arlist));
    }

    public int solve(ArrayList<String> A) {

        StringBuilder sb = new StringBuilder();
        sb.append(A.get(0));

        for (int i = 1; i < A.size(); i++) {

            String current = sb.toString();

            String test = A.get(i);
            int n = test.length();
            int max = 0;

            for (int j = 0; j < n; j++) {

                if (current.length() - i - 1 >= 0) {
                    String temp1 = current.substring(current.length() - j - 1);
                    String temp2 = test.substring(0, j + 1);

                    if (temp1.equals(temp2)) {
                        max++;
                    } else
                        break;

                } else
                    break;
            }

            sb.append(test.substring(max));

        }


        return sb.length();
    }
}
