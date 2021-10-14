package leetcode;

class DeciBinary {
    public int minPartitions(String n) {

        int number = Integer.valueOf(n);
        int count = 0;

        while (number > 0) {

            int deciBinary = getDeciBinary(number);
            System.out.println("number = " + number);
            System.out.println("deciBinary = " + deciBinary);
            System.out.println("-------------- count ----------" + count);
            number = number - deciBinary;
            count++;
        }


        return count;

    }


    int getDeciBinary(int n) {
        String no = String.valueOf(n);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < no.length(); i++) {
            if (no.charAt(i) != '0') {
                sb.append("1");
            } else
                sb.append("0");
        }


        return Integer.valueOf(sb.toString());


    }


    public static void main(String[] args) {


        int b = 123123123;
        float f = b;
        System.out.println(f);

        DeciBinary db = new DeciBinary();
        System.out.println(db.minPartitions("82734"));
    }
}