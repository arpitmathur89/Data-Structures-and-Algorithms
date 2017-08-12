package string;

import com.sun.org.apache.xpath.internal.SourceTree;

public class PalindromeCounter {

    public static void main(String[] args) {
        String input = "daata";
        System.out.println(CountPalindrome(input));
    }

    public static int CountPalindrome(String a){
        int globalCount = a.length();
        for (int mid = 1; mid < a.length(); mid++) {
            int count = 0;

            int low = mid - 1;
            int high = mid + 1;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
            count = 0;

            low = mid - 1;
            high = mid;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
        }

        return globalCount;





    }
}
