package leetcode.samsung;

import com.company.Pair;
import java.util.*;

public class 이차원배열과연산 {
    // private
    private static int[][] arr = new int[100][100]; // 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
    private static int r;
    private static int c;
    private static int k;

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt() - 1; // given r is th
        c = sc.nextInt() - 1; // given c is th
        k = sc.nextInt();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve());
    }

    // function
    public static int solve() {
        int rSize = 3;
        int cSize = 3;

        for(int t = 0; t <= 100; t++) {
            if(arr[r][c] == k)
                return t;
            if(t == 100)
                break;

            if(rSize >= cSize) { // operation R
                for(int i = 0; i < rSize; i++) { // *****
                    int[] count = new int[101]; // 1<= k <= 100
                    List<Pair<Integer, Integer>> nums = new ArrayList<>();
                    for(int j =0; j < cSize; j++) { // *****
                        count[arr[i][j]]++;
                    }
                    for(int k = 1; k <= 100; k++) {
                        if(count[k] > 0) {
                            nums.add(new Pair<>(k, count[k])); // basically, nums is sorted by num in asc because we insert it from 1 to 100
                        }
                    }
                    Collections.sort(nums, (a, b) -> a.getValue() - b.getValue()); // sort by count in asc

                    int idx = 0;
                    for(Pair<Integer, Integer> num : nums) {
                        if(idx >= 99) // nums can be more than 100 // 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
                            break; // till idx 98, 99, it's okay
                        arr[i][idx++] = num.getKey();
                        arr[i][idx++] = num.getValue();
                    }

                    cSize = Math.max(cSize, idx); // the pos of the code is important

                    for(; idx < 100; idx++) {
                        arr[i][idx] = 0;
                    }
                }
            } else { // operation C
                for(int j = 0; j < cSize; j++) { // *****
                    int[] count = new int[101]; // 1<= k <= 100
                    List<Pair<Integer, Integer>> nums = new ArrayList<>();
                    for(int i =0; i < rSize; i++) { // *****
                        count[arr[i][j]]++;
                    }
                    for(int k = 1; k <= 100; k++) {
                        if(count[k] > 0) {
                            nums.add(new Pair<>(k, count[k])); // basically, nums is sorted by num in asc because we insert it from 1 to 100
                        }
                    }
                    Collections.sort(nums, (a, b) -> a.getValue() - b.getValue()); // sort by count in asc

                    int idx = 0;
                    for(Pair<Integer, Integer> num : nums) {
                        if(idx >= 99) // nums can be more than 100 // 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
                            break; // till idx 98, 99, it's okay
                        arr[idx++][j] = num.getKey();
                        arr[idx++][j] = num.getValue();
                    }

                    rSize = Math.max(rSize, idx); // the pos of the code is important

                    for(; idx < 100; idx++) {
                        arr[idx][j] = 0;
                    }
                }
            }
        }

        return -1;
    }

}








