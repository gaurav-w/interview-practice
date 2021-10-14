package dp;

public class MinSumMat {

    public static void main(String[] args) {
        MinSumMat m = new MinSumMat();
        int A[][] = {
                {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
        };
        m.minPathSum(A);
    }

    public int minPathSum(int[][] A) {

        int mat[][] = new int[A.length + 1][A[0].length + 1];

        for (int i = 1; i < mat.length; i++) {

            mat[i][1] = A[i - 1][0] + mat[i - 1][1];
        }

        for (int j = 1; j < mat[0].length; j++) {

            mat[1][j] = A[0][j - 1] + mat[1][j - 1];
        }

        for (int i = 2; i < mat.length; i++) {
            for (int j = 2; j < mat[0].length; j++) {
//                if( j == 1)
//                    mat[i][j] = A[i-1][j-1] + mat[i][j-1];
//                else if( i == 1)
//                mat[i][j] = A[i-1][j-1] + mat[i-1][j];
//               else
                mat[i][j] = A[i - 1][j - 1] + Math.min(mat[i - 1][j], mat[i][j - 1]);

            }
        }

        return mat[A.length][A[0].length];
    }

}
