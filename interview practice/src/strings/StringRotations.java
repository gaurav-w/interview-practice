package strings;

//Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?

public class StringRotations {

    // Driver method
    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";

        if (areRotations(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");
    }

    private static boolean areRotations(String str1, String str2) {
        String str = str2 + str2;

        //  return str1.length()==str2.length() && str.contains(str1);
        return str1.length() == str2.length() && str.indexOf(str1) > -1;
    }


}
