package leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfOriginal(int[] nums) {
        // T.C: O(N)
        // S.C: O(N)
        // constraint: without division
        // make use of the product of all the numbers to the left and all the numbers to the right of the index. Multiply these two individual products
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] ans = new int[nums.length];

        l[0] = 1;
        for(int i=1; i<nums.length; i++){
            l[i] = l[i-1] * nums[i-1];
        }

        r[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            r[i] = r[i+1] * nums[i+1];
        }

        for(int i=0; i<nums.length; i++){
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

    public int[] productExceptSelf(int[] nums) {
        // T.C: O(N)
        // S.C: O(1)
        // problem says that using the answeranswer array doesn't add to the space complexity.
        // Improved space complexity
        // The only change in this approach is that we don't explicitly build the R array from before
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int r = 1;
        for(int i=nums.length-1; i>=0; i--){ // ***
            ans[i] = ans[i] * r; // ***
            r = r * nums[i]; // ***
        }
        return ans;
    }
}
