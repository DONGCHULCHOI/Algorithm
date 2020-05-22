package leetcode;

public class StringToInteger {
    public int myAtoi(String str) {
        // T.C: O(N) where N is the length of the str
        // S.C: O(1)
        int i = 0, sign = 1, total = 0;
        // no such sequence exists: empty
        if(str.length() == 0){
            return 0;
        }

        // White space
        while(i<str.length() && str.charAt(i) == ' '){ // sequence ***
            i++;
        }

        // no such sequence exists: contains only whitespace characters
        // should be dealt before +/- // ***
        if(i == str.length()){
            return 0;
        }

        // +/-
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            i ++;
        }

        // convert number checking overflow
        while(i < str.length()){
            int digit = str.charAt(i) - '0'; // ***
            if(digit < 0 || digit > 9){ // if not 0 <= digit <= 9 -> not digit
                break;
            }

            //check overflow // *****
            if(Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit; // *****

            i ++;
        }

        return sign * total;
    }
}
