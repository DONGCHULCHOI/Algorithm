package leetcode.kakao;

public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // https://www.youtube.com/watch?v=leXszEFCKWM

        // floyd-warshall algorithm
        // find shortest paths in a directed weighted graph with positive or negative edge weights (but with no negative cycles)
        // https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
        // let dist be a |V| × |V| array of minimum distances initialized to ∞ (infinity)
        // for each vertex v, do dist[v][v] ← 0
        int[][] dist = new int[n][n]; // 지점갯수 n은 3 이상 200 이하인 자연수입니다.
        int INF = Integer.MAX_VALUE / 3; // sum of S to sharing, sharing to A, sharing to B -> can be overflow
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        /*
        for each edge (u, v) do
        dist[u][v] ← w(u, v)  // The weight of the edge (u, v)
         */
        for(int i = 0; i < fares.length; i++) {
            dist[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
            dist[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2]; // make the graph directed
        }

        /*
        for k from 1 to |V|
            for i from 1 to |V|
                for j from 1 to |V|
                    if dist[i][j] > dist[i][k] + dist[k][j]
                        dist[i][j] ← dist[i][k] + dist[k][j]
                    end if
         */
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // cuz we start from index 0
        s--;
        a--;
        b--;

        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) { // i is the end of the sharing
            if(minCost > dist[s][i] + dist[i][a] + dist[i][b]) {
                minCost = Math.min(minCost, dist[s][i] + dist[i][a] + dist[i][b]);
            }
        }


        return minCost;
    }
}
