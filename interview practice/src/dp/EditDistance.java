package dp;

public class EditDistance {

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance2(
                "horse",
                "hr"));

    }

    public int minDistance2(String A, String B) {

        int tab[][] = new int[2][B.length() + 1];


        for (int i = 0; i <= B.length(); i++)
            tab[0][i] = i;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {

                if (j == 0)
                    tab[i % 2][j] = i;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    tab[i % 2][j] = tab[(i - 1) % 2][j - 1];
                else {
                    tab[i % 2][j] = 1 + Math.min(tab[(i - 1) % 2][j - 1], //replace
                            Math.min(tab[i % 2][j - 1], //insert
                                    tab[(i - 1) % 2][j])); //remove
                }

            }
        }

        return tab[A.length() % 2][B.length()];
    }


    public int minDistance(String word1, String word2) {
        int a[][] = new int[2][word2.length() + 1];

        //initialize
        for (int i = 0; i < a[0].length; i++) {
            a[0][i] = i;
        }


        for (int j = 0; j < word1.length(); j++) {
            for (int i = 0; i < word2.length() + 1; i++) {

                if (i == 0) {
                    a[1][i] = j;

                } else if (word2.charAt(i - 1) == word1.charAt(j))
                    a[1][i] = a[0][i - 1];
                else {
                    a[1][i] = 1 + Math.min(a[0][i - 1], Math.min(a[0][i], a[1][i]));
                }
            }

            if (j != word1.length() - 1) {
                for (int i = 0; i < a[0].length; i++) {
                    a[0][i] = a[1][i];
                }
            }
        }


        return a[1][word2.length() - 1];
    }
}
