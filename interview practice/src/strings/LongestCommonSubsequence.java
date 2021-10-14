package strings;

public class LongestCommonSubsequence {


    public static void main(String args[]) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";

        int result = lcs.lcsDynamic(str1, str2);
        System.out.print(result);
    }

    private int lcsDynamic(String str1, String str2) {

        if (str1 == null || str1 == null || str1.length() < 1 || str2.length() < 1)
            return 0;

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();


        int lcsMatrix[][] = new int[charArr1.length + 1][charArr2.length + 1];

        for (int i = 1; i < charArr1.length + 1; i++) {
            for (int j = 1; j < charArr2.length + 1; j++) {
                if (charArr1[i - 1] == charArr2[j - 1])
                    lcsMatrix[i][j] = lcsMatrix[i][j - 1] + 1;
                else
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
            }
        }

        return lcsMatrix[lcsMatrix.length - 1][lcsMatrix[0].length - 1];
    }

}
