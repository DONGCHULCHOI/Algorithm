package leetcode.top100_questions;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfOriginal(int[] nums) {
        // T.C: O(N)
        // S.C: O(N)
        // constraint: without division
        // make use of the product of all the numbers to the left and all the numbers to the right of the index. // *****
        // Then, Multiply these two individual products // *****
        int[] l = new int[nums.length]; // each value means the product of the left part of the index
        int[] r = new int[nums.length]; // each value means the product of the right part of the index
        int[] ans = new int[nums.length]; // each value means the prodcut of l[i] * r[i]

        l[0] = 1; // *****
        for(int i=1; i<nums.length; i++){ // *****
            l[i] = l[i-1] * nums[i-1];
        }

        r[nums.length-1] = 1; // *****
        for(int i=nums.length-2; i>=0; i--){ // *****
            r[i] = r[i+1] * nums[i+1]; // *****
        }

        for(int i=0; i<nums.length; i++){
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

    public int[] productExceptSelf(int[] nums) {
        // T.C: O(N)
        // S.C: O(1)
        // problem says that using the answer array doesn't add to the space complexity.
        // Improved space complexity
        // Do the above intuitive approach in place
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int r = 1; // *****
        for(int i=nums.length-1; i>=0; i--){ // *****
            ans[i] = ans[i] * r; // *****
            r = r * nums[i]; // *****
        }
        return ans;
    }
}

