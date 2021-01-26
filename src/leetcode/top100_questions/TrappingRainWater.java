package leetcode.top100_questions;

public class TrappingRainWater {
    public int trap(int[] height) {
        // T.C: O(n)
        // S.C: O(1)
        // Based on Container with most water
        // Basically Move two pointers inward // *****
        // The Trapping water formed on the line will be limited by the height of the shorter line // *****
        // after decide direction, calculate the area only when height decreases inward, if not just update max height to skip the calculation // *****
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
