package leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        // T.C: O(n)
        // S.C: O(1)
        // based on Container With Most Water
        int ans = 0, l = 0, r = height.length-1;
        int lMax = 0, rMax = 0;
        while(l < r){
            if(height[l] < height[r]){
                if(height[l] >= lMax){ // ***
                    lMax = height[l]; // ***
                }
                else{
                    ans += lMax - height[l]; // ***
                }
                l++;
            }
            else{
                if (height[r] >= rMax) { // ***
                    rMax = height[r]; // ***
                } else {
                    ans += rMax - height[r]; // ***
                }
                r--;
            }
        }
        return ans;
    }
}
