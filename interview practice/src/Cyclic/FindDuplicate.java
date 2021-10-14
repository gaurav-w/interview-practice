package Cyclic;

class FindDuplicate {

    public static int findNumber(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // find cycle length
        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while (current != arr[slow]);

        return findStart(arr, cycleLength);
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        // move pointer2 ahead 'cycleLength' steps
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }


//    public static int findNumber(int[] nums) {
//
//        int count = 0;
//        int n = nums.length;
//
//        while (count < n) {
//            //int actual_loc = nums[ count ] + 1
//
//            if (count < n && nums[count] != nums[nums[count] - 1]) {
//                swap(nums, count, nums[count] - 1);
//            } else {
//                count++;
//            }
//        }
//
//        for (int i = 0; i < n - 1; i++) { //duplicate
//            if (nums[i] == nums[i + 1] ||  nums[i] > nums[i + 1] )
//                return nums[i+1];
//        }
//
//        return -1;
//    }
//    public static int findNumber(int[] nums) {
//        int i = 0;
//        while (i < nums.length) {
//            if (nums[i] != i + 1) {
//                if (nums[i] != nums[nums[i] - 1])
//                    swap(nums, i, nums[i] - 1);
//                else // we have found the duplicate
//                    return nums[i];
//            } else {
//                i++;
//            }
//        }
//
//        return -1;
//    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[]{1, 4, 4, 3, 2}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 4, 1, 4, 4}));
    }
}
