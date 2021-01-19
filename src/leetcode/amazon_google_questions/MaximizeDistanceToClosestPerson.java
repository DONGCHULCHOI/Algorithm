package leetcode.amazon_google_questions;

public class MaximizeDistanceToClosestPerson {
    // Consider understanding this solution fully again later
    public int maxDistToClosest(int[] seats) {
        // T.C: O(N) where N is the length of seats
        // S.C: O(1)
        // As iterate, update the closest person sitting to our left, and the closest person sitting to our right
        // Then at seat i, the closest person is min(i - left, right - i)
        // And update Max Distance
        // (!) With the exceptions. When i is at 0 or length-1, it means there is no person sitting to left/right
        //     in this case, should consider the distance of left/right infinite
        int N = seats.length;
        int left = -1, right = 0; // *****
        int res = 0;

        for(int i=0; i<N; i++){
            if(seats[i] == 1){
                left = i;
            }
            else{
                while(right < N && seats[right] == 0 || right < i){ // *****
                    right++;
                }
                int leftDist = (left == -1) ? N : i - left; // *****
                int rightDist = (right == N) ? N : right - i; // *****
                res = Math.max(res, Math.min(leftDist, rightDist)); // *****
            }
        }
        return res;
    }
}
