package leetcode;

public class MaximizeDistanceToClosestPerson {
    // Consider understanding this solution fully again later
    public int maxDistToClosest(int[] seats) {
        // As iterate, update the closest person sitting to our left, and closest person sitting to our right
        // Then at seat i, the closest person is min(i - left, right - i)
        // with one exception. i - left should be considered infinite if there is no person to the left of seat i,
        // right - i is infinite if there is no one to the right of seat i
        // => choose min(left closest, right closest) at i -> keep updating max
        // T.C: O(N) where N is the length of seats
        // S.C: O(1)
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
