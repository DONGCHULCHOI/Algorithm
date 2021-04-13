package leetcode.samsung;

import java.util.*;

class Point {
    int row, col, dist;
    Point(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist; // sec to spread viruses to all the empty places
    }
}

public class 연구소3 {
    // private
    static int n, m;
    static int[][] arr = new int[50][50];
    static Point[] viruses = new Point[10];
    static int virusCnt;
    static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****

    static int countBits(int n) {
        int cnt = 0;
        while(n > 0) {
            if((n & 1) == 1)
                cnt++;
            n = n >> 1; // right shitf
        }
        return cnt;
    }

    static int solve() {
        int res = Integer.MAX_VALUE;
        // M개 바이러스를 고르는 모든 경우의 수 -> 수열(X), 부분집합(O) & 부분집합 내 원소 개수 = M
        // var. subset represents a subset of the viruses 0 ... num - 1
        // can represent the virus using bit and each possible combination is each subset
        // left shift by the num of elements -> all the possible subsets
        for(int subset = 0; subset < 1 << virusCnt; subset++) {
            if(countBits(subset) == m) {
                boolean[][] visited = new boolean[50][50];
                int dist = 0;
                Queue<Point> queue = new LinkedList<>();
                for(int i = 0; i < virusCnt; i++) { // can start bfs from several start points
                    if((subset & 1 << i) != 0) { // *****
                        // we know the subset(the combination)
                        // and each index identifies each virus(and the index is less than virusCnt)
                        // left shift by i, then the id, index i is on the i th bit
                        // & operation, then if it's 1, then the i th virus belongs to the subset
                        visited[viruses[i].row][viruses[i].col] = true;
                        queue.add(viruses[i]);
                    }
                }

                while(!queue.isEmpty()) {
                    Point curr = queue.remove();
                    if(arr[curr.row][curr.col] != 2)
                        dist = Math.max(dist, curr.dist);

                    for(int i = 0; i < 4; i++) {
                        int newRow = curr.row + directions[i][0];
                        int newCol = curr.col + directions[i][1];
                        if(newRow < 0 || newRow > n -1 || newCol < 0 || newCol > n - 1)
                            continue;
                        if(visited[newRow][newCol] || arr[newRow][newCol] == 1)
                            continue;

                        visited[newRow][newCol] = true;
                        queue.add(new Point(newRow, newCol, curr.dist + 1));
                    }
                }

                // the case: cannot reach
                boolean flag = true;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(arr[i][j] == 0 && visited[i][j] == false)
                            flag = false;
                    }
                }
                if(flag) {
                    res = Math.min(res, dist);
                }
            }
        }
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 2) {
                    viruses[virusCnt++] = new Point(i, j, 0); // virusCnt is both count and index for each virus
                }
            }
        }

        System.out.println(solve());
    }

    // function


}








