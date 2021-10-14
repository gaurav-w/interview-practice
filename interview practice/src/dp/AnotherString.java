package dp;

public class AnotherString {
    public static void main(String[] args) {
        AnotherString a = new AnotherString();

        System.out.println(a.solve("xyzxzzyyxyyxyzzxzxzzyzzxxzzxxy", "xxyyzyxyyyzzzxxyzyzxzyzzzxyyzx", 2));
    }

    public int solve(String A, String B, int C) {

        StringBuffer bRev = new StringBuffer(B);
        String bReverse = bRev.reverse().toString();

        int count = commonStringFromLast(A, B);
        // System.out.println("lcs=" + lcs );
        int total1 = A.length() - count;

        int lcsRev = LCSubstring(A, bReverse);
        //System.out.println("lcsRev=" + lcsRev );
        int total2 = A.length() - lcsRev + C;

        int ans = Math.min(total1, total2);

        return ans;
    }


    public int commonStringFromLast(String A, String B) {
        int count = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == B.charAt(i))
                count++;


        }

        return count;
    }

    public int LCSubstring(String A, String B) {

        int mat[][] = new int[A.length() + 1][B.length() + 1];
        int max = 0;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1))
                    mat[i][j] = mat[i - 1][j - 1] + 1;

                max = Math.max(max, mat[i][j]);
                // else
                //     mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
            }
        }

        return max;
    }
}
