package strings;

// Java program to print all permutations of a
// given string.
public class Permutations {
    public static void main(String[] args) {
        String str = "GAURAV";
        int n = str.length();
        Permutations permutation = new Permutations();
        // permutation.permute2(str, 0, n - 1);
        permutation.permute3(str.toCharArray(), new StringBuffer(), new Character('0'));
    }

    private void permute3(char ar[], StringBuffer sb, char temp) {
        if (ar.length == sb.length())
            System.out.println(sb.toString());
        else {
            for (int i = 0; i < ar.length; i++) {
                if (ar[i] > 0) {
                    sb.append(ar[i]);
                    temp = ar[i];
                    ar[i] = 0;
                    permute3(ar, sb, temp);
                    ar[i] = temp;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }


    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                // str = swap(str, l, i);
            }
        }
    }

    private void permute2(String str, int left, int right) {
        if (left == right)
            System.out.println(str);
        else {
            for (int i = left; i <= right; i++) {
                String swapped = swap(str, left, i);
                permute2(swapped, left + 1, right);
                //swapped = swap(swapped, left, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}

// This code is contributed by Mihir Joshi
