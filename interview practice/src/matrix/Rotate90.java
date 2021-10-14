package matrix;

// JAVA Code for left Rotation of a
// matrix by 90 degree without using
// any extra space
//https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/?ref=lbp
//https://www.youtube.com/watch?v=SA867FvqHrM
//it covers both clockwise and anticlockwise

class Rotate90 {

    // After transpose we swap elements of
    // column one by one for finding left
    // rotation of matrix by 90 degree
    static void reverseColumns(int arr[][]) {
        for (int i = 0; i < arr[0].length; i++)
            for (int j = 0, k = arr[0].length - 1;
                 j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
    }

    /*
    It will reverse column in place so its anticlockwise
     */
    static void reverseColumns2(int arr[][]) {
        for (int c = 0; c < arr.length; c++) {
            for (int r = 0; r < arr.length / 2; r++) {
                int temp = arr[r][c];
                arr[r][c] = arr[arr.length - 1 - r][c];
                arr[arr.length - 1 - r][c] = temp;
            }
        }
    }

    //reverse the row to get clockwise rotation
    static void reverseRow(int arr[][]) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length / 2; c++) {
                int temp = arr[r][c];
                arr[r][c] = arr[r][arr.length - c - 1];
                arr[r][arr.length - c - 1] = temp;
            }
        }
    }


    // Function for do transpose of matrix
    static void transpose(int arr[][]) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length;
                 j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
    }

    // Function for print matrix
    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length;
                 j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }

    // Function to anticlockwise rotate
    // matrix by 90 degree
    static void rotate90(int arr[][]) {
        //int arr2[][] = arr.clone();
        transpose(arr);
        //reverseColumns(arr);
        //reverseColumns2(arr);
        reverseRow(arr);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        rotate90(arr);
        printMatrix(arr);

    }
}