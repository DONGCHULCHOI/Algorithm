package leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
        // T.C: O(1)
        // S.C: O(1)
        // Input is guaranteed to be within the range from 1 to 3999
        // thousands_digit = integer / 1000
        // hundreds_digit = (integer % 1000) / 100
        // tens_digit = (integer % 100) / 10
        // ones_digit = integer % 10
        String[] thousands = {"", "M", "MM", "MMM"}; // *****
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // *****
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // *****
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // *****

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10]; // *****
    }
}
