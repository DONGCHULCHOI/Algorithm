package leetcode.amazon_google_questions;

public class TrappingRainWater {
    public int trap(int[] height) {
        // T.C: O(n)
        // S.C: O(1)
        // Based on Container with most water
        // The Trapping water formed on the line will be limited by the height of the shorter line // *****
        // e.g. [3,2,1,5]
        // So, basically move the shorter pointer inwards // *****
        // Extra: Keep the values, lMax and rMax on the shorter each line to calculate the trapping water // *****
        int ans = 0, l = 0, r = height.length-1;
        int lMax = 0, rMax = 0;
        while(l < r){
            if(height[l] < height[r]){ // *****
                if(height[l] >= lMax){ // *****
                    lMax = height[l]; // *****
                }
                else{
                    ans += lMax - height[l]; // *****
                }
                l++;
            }
            else{
                if (height[r] >= rMax) { // *****
                    rMax = height[r]; // *****
                } else {
                    ans += rMax - height[r]; // *****
                }
                r--;
            }
        }
        return ans;
    }
}
