package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        // T.C: O(1) because try up to 24 * 6024∗60 possible times until we find the correct time
        // S.C: O(1)
        // Simulate the clock going forward by one minute // *****
        // Each time it moves forward // *****
        // if all the digits are allowed, then return the current time // *****
        // represent the time is as an integer t(min) in the range 0 <= t < 24 * 60 // *****
        // Then the hours are t / 60, the minutes are t % 60
        // Each digit is t / 60 / 10, t / 60 % 10, t % 60 / 10, t % 60 % 10
        int curr = 60 * Integer.parseInt(time.substring(0, 2)); // *****
        curr += Integer.parseInt(time.substring(3,5)); // *****
        Set<Integer> allowed = new HashSet<>();
        for(char c : time.toCharArray()){
            if(c != ':')
                allowed.add(c - '0'); // ***
        }

        while(true){ // simulate the clock increasing by one minutes, and check the digits
            curr = (curr + 1) % (24 * 60); // ***** // e.g. 23:59

            int[] digits = new int[]{curr / 60 / 10, curr / 60 % 10, curr % 60 / 10, curr % 60 % 10}; // *****
            search : {
                for(int elem : digits)
                    if(!allowed.contains(elem))
                        break search;
                return String.format("%02d:%02d", curr / 60, curr % 60);
            }
        }
    }
}