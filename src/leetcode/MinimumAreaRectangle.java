package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {
    // T.C: O(N^2) where N is the length of points
    // S.C: O(N)
    // if p1 and p2 can be diagonal,
    // then, see if rectangle can be formed, that is, p3 and p4 exists as below:
    // p1 -- p3
    //  |    |
    // p4 -- p2
    //
    // p3 and p4 needs to satisfy:
    //      p3.x = p2.x, p3.y = p1.y
    //      p4.x = p1.x, p4.y = p2.y
    public int minAreaRect(int[][] points) {
        // Group the points by x coordinates, so that we have columns of points. // *****
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points){
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }

        int min = Integer.MAX_VALUE;
        for(int[] p1 : points){
            for(int[] p2 : points){
                if(p1[0] != p2[0] && p1[1] != p2[1]) // if p1 and p2 can be diagonal // *****
                    if(map.get(p2[0]).contains(p1[1]) // if p3 exists, should meet p3.x = p2.x, p3.y = p1.y // *****
                            && map.get(p1[0]).contains(p2[1])) // if p4 exists, should meet p4.x = p1.x, p4.y = p2.y // *****
                        min = Math.min(min, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
