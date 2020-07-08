package leetcode;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        // T.C: O(N) where N is the length of the str
        // S.C: O(1)
        // Find the first non-white space characters' sequence // *****
        // if the first sequence of non-whitespace characters in str is not a valid integral number, e.g. "words and 987"
        // if no such sequence exists because either str is empty or it contains only whitespace characters
        // then, return 0
        int i = 0, sign = 1, total = 0;

        // no such sequence exists: empty
        if(str.length() == 0){
            return 0;
        }

        // Find the non-white space character's sequence // *****
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }

        // no such sequence exists: contains only whitespace characters
        if(i == str.length()){
            return 0;
        }

        // +/- // order is important // e.g. "+" // *****
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            i ++;
        }

        // no such sequence exists: not a valid integral number
        if(i < str.length() && !Character.isDigit(str.charAt(i)))
            return 0;

        // convert number checking overflow
        while(i < str.length()){
            if(!Character.isDigit(str.charAt(i))) // to avoid addition characters' sequence // *****
                break; // *****

            //check overflow // *****
            int digit = str.charAt(i) - '0';
            if(Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)){ // *****
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;

            i ++;
        }

        return sign * total;
    }
}
