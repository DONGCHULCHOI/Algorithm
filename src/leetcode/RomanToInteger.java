package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // T.C: O(1) because there is a finite set of roman numerals, the maximum number possible number can be 3999
    // S.C: O(1) because only M/D/C/L/X/V/I values in the map
    // Roman numerals are usually written largest to smallest from left to right // *****
    // I can be placed before V (5) and X (10) to make 4 and 9
    // X can be placed before L (50) and C (100) to make 40 and 90
    // C can be placed before D (500) and M (1000) to make 400 and 900
    // => smaller value comes before larger value // *****
    // each symbol adds its own value, except for when a smaller valued symbol is before a larger valued symbol
    // In those cases, need to subtract the large from the small, adding that instead.
    static Map<String, Integer> values = new HashMap<>();
    static { // static block
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while(i < s.length()){
            int currentValue = values.get(s.substring(i,i+1));
            int nextValue = 0;
            if(i+1 < s.length()) // *****
                nextValue = values.get(s.substring(i+1,i+2));

            if(currentValue < nextValue){ // *****
                sum += nextValue - currentValue; // *****
                i += 2; // *****
            }
            else{ // *****
                sum += currentValue; // *****
                i += 1; // *****
            }
        }
        return sum;
    }
}
