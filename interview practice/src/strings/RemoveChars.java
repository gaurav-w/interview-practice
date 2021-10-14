package strings;

// Java program to remove duplicates
// str.replace works with char and string but with char
// it cant replace with '' but it can be done with Strings
public class RemoveChars {

    // Driver Method
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String mask_str = "mask";
        System.out.println(removeDirtyChars(str, mask_str));
    }

    private static String removeDirtyChars(String str, String mask_str) {
        for (char chr : mask_str.toCharArray()) {
            str = str.replace(String.valueOf(chr), "");
        }
        return str;
    }

}
