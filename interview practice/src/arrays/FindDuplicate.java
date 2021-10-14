package arrays;

// Java code to find
// duplicates in O(n) time

//Mistake i did - use Math abs() wherever you are referring to the element to refer to its location

class FindDuplicate {
    // Driver program
    public static void main(String[] args) {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;

        duplicate.printRepeating(arr, arr_size);
    }

    private void printRepeating(int[] arr, int arr_size) {
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < arr_size; i++) {
            if (arr[Math.abs(arr[i])] < 0)
                System.out.print(Math.abs(arr[i]) + " ");
            else
                arr[Math.abs(arr[i])] = arr[Math.abs(arr[i])] * -1;
        }
    }


//    // Function to print duplicates
//    void printRepeating(int arr[], int size) {
//        int i;
//        System.out.println("The repeating elements are : ");
//
//        for (i = 0; i < size; i++) {
//            if (arr[Math.abs(arr[i])] >= 0)
//                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
//            else
//                System.out.print(Math.abs(arr[i]) + " ");
//        }
//    }
}

