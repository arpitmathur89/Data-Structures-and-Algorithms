package string;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(12));
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i=0;i<values.length;i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
