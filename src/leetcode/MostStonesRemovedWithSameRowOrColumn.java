package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    // Consider the most vote solution which is the official solution here later
    // the below is intuitive but so slow
    public int removeStones(int[][] stones) {
        // T.C : O(N^2) where N is # of stones
        // S.C: O(N)
        // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/209369/Java-recursive-DFS-Short-and-easy-to-understand
        // Ans = # of stones – # of islands // *****
        // stone with same row or column. group them into island // *****
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
                dfs(s1, visited, stones); // also has to send
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        // visit
        visited.add(s1);
        // do dfs to adjacent neighor if not visited
        // in number of islands, we do dfs to adjacent neigbour based on matrix around the sent row, col
        // in here, just use input stones array // *****
        // in iteration, the direction is from 1st row to last row, and in a row, from 1st col to last col // *****
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                // stone with same row or column. group them into island // *****
                if (s1[0] == s2[0] || s1[1] == s2[1]) // same row or same column
                    dfs(s2, visited, stones);
            }
        }
    }
}