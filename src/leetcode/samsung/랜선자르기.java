package leetcode.samsung;

import java.util.Scanner;

public class 랜선자르기 {
    // private
    static int K, N;
    static int[] lens;
    static int maxLen;

    static long solve() { // binary search: decide the optimal value of the chopped line
        long low = 1; // the lower bound of the possible chopped line // 랜선의 길이는 231-1보다 작거나 같은 자연수이다.
        long high = maxLen; // the upper bound of the possible chopped line

        while(low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for(int i = 0; i < K; i++) {
                count += lens[i] / mid;
            }

            if(count >= N) { // make it bigger
                low = mid + 1;
            } else {
                high = mid - 1; // make it smaller
            }
        }

        return high; // *****
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        lens = new int[K];

        for(int i = 0; i < K; i++) {
            lens[i] = sc.nextInt();
            maxLen = Math.max(maxLen, lens[i]);
        }

        System.out.println(solve());

    }

    // function


}








