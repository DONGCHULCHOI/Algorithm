package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // T.C: O(N)
        // S.C: O(1) when digits contains at least one not nine digit, otherwise O(N)
        // move along the input array starting from the end // ***
        // set all the nines at the end of array to zero // ***
        // when get to the rightmost not nine, the digit++ // ***

        // move along the input array starting from the end
        for(int i=digits.length-1; i>=0; i--){
            // set all the nines at the end of array to zero
            if(digits[i] == 9){
                digits[i] = 0;
            }
            // when get to the rightmost not nine
            else{
                digits[i]++; // ***
                return digits;
            }
        }
        // get to here when all the digits are nines
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}