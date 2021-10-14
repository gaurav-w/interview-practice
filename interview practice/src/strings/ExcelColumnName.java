package strings;

public class ExcelColumnName {
    public static void main(String[] args) {
        printString(26);
        printString(51);
        printString(52);
        printString(80);
        printString(676);
        printString(702);
        printString(705);
    }

    /*
    Get excel column name as String
    The idea is similar to reverse a number
    Here,
    1. Find remainder of number mod 26.
    2. Convert this remainder into A - Z.
    3. Divide the number by 26
    4. If the number > 0 then repeat 1-3
     */
    private static void printString(int num) {

        if (num <= 0)
            System.out.println("Invalid Input");

        int remainder = 0;

        StringBuffer sb = new StringBuffer();

        while (num > 0) {
            remainder = num % 26;
            char c = findColumnName(remainder);
            sb.append(c);


            if (remainder == 0) //boundry case for Z
                num = num / 26 - 1;
            else
                num = num / 26;
        }
        System.out.println(sb.reverse().toString());

    }

    private static char findColumnName(int no) {

        if (no == 0)
            return 'Z';
        else
            return (char) ('A' + (no - 1));
    }
}

