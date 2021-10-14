package dp;

public class InterleavingStrings {

    public static void main(String[] args) {
        System.out.println(isInterleave("BCA", "ABC", "ABCBCA"));
    }

    public static int isInterleave(String A, String B, String C) {

        boolean tab[][] = new boolean[A.length() + 1][B.length() + 1];

        //initialize
        tab[0][0] = true;

        if ((A.length() + B.length()) != C.length())
            return 0;

        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                //initialize
                if (j == 0 && i > 0 && C.charAt(i - 1) == A.charAt(i - 1)) {
                    tab[i][j] = tab[i - 1][j];
                } else if (i == 0 && j > 0 && C.charAt(j - 1) == B.charAt(j - 1)) {
                    tab[i][j] = tab[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    if (C.charAt(i + j - 1) == A.charAt(i - 1) &&
                            C.charAt(i + j - 1) == B.charAt(j - 1))
                        tab[i][j] = tab[i - 1][j] || tab[i][j - 1];
                    else if (C.charAt(i + j - 1) == A.charAt(i - 1))
                        tab[i][j] = tab[i - 1][j];
                    else if (C.charAt(i + j - 1) == B.charAt(j - 1))
                        tab[i][j] = tab[i][j - 1];
                }
            }
        }

        return tab[A.length()][B.length()] ? 1 : 0;

    }
}
