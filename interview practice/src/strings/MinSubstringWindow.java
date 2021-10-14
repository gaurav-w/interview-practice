package strings;

public class MinSubstringWindow {

    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " +
                minWindow(str, pat));
    }

    public static String minWindow(String s, String t) {

        //Create Array for us to store the elements of pattern
        int charT[] = new int[256];

        //Create Array for us to store the elements of string
        int charS[] = new int[256];

        //store pattern
        for (Character patt : t.toCharArray()) {
            charT[patt]++;
        }


        //use double pointer approach - left and right

        int left = 0, right = 0, minLeft = 0, minRight = 0, minCount = Integer.MAX_VALUE;
        int count = t.length(); // so many chars to match

        while (right < s.length()) {
            //decrease count
            if (charT[s.charAt(right)] > 0) {
                count--;
            }

            //decrease the frequency
            charT[s.charAt(right)]--;


            while (count == 0 && left < s.length()) {

                if (minCount > (right - left)) {
                    minLeft = left;
                    minRight = right;
                    minCount = right - left;
                }


                //increase start

                if (charT[s.charAt(left)] >= 0) {
                    count++;
                }

                //decrease the frequency
                charT[s.charAt(left)]--;

                left++;


            }

            right++;

        }

//        while (left < s.length() && left < right + 1) {
//
//            if (right < s.length()) {
//                charS[s.charAt(right)]++;
//
//
//                if ( charT[s.charAt(right)] > 0 &&
//                charT[s.charAt(right)] >= charS[s.charAt(right)])
//                    count--;
//            }
//
//
//            while (left < s.length() && count == 0  ) {
//
//                if (minCount > (right - left)) {
//                    minLeft = left;
//                    minRight = right;
//                    minCount = right - left ;
//                }
//
//                charS[s.charAt(left)]--;
//
//                if (charT[s.charAt(left)] != charS[s.charAt(left)])
//                    count++;
//
//                left++;
//
//            }
//
//            if (right < s.length() -1)
//                right++;
//
//        }


        return s.substring(minLeft, minRight);


    }
}
