package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // T.C: O(n)
        // S.C: O(1)
        // The area formed between the lines will always be limited by the height of the shorter line // *****
        // try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line // *****
        // Moving the shorter line's pointer could turn out to be beneficial, despite the reduction in the width // *****
        int maxArea = 0, l = 0, r = height.length-1;
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l)); // *****
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}
