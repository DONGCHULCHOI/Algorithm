package leetcode.amazon_google_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    // Topological sort
    // T.C: O(N)
    // S.C: O(N) because the space utilized by the recursion stack (not the stack we used to maintain the topologically sorted order)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // init
        init(numCourses);

        // build the graph using adjacent list // *****
        for(int i=0; i<prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> adjListTmp = adjList.getOrDefault(src, new ArrayList<Integer>());
            adjListTmp.add(dest);
            adjList.put(src, adjListTmp);
        }
        // topological sort // *****
        for(int i=0; i<numCourses; i++){
            if(color.get(i) == WHITE) // to prevent the case of re-call e.g. 3, [[1,0]], if the line none, output [1,0,1], expected [2,0,1]
                topologicalSort(i);
        }
        // make output
        int[] order;
        if(isPossible){
            order = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                order[i] = topologicalOrder.get(numCourses - i - 1); // stack.pop() // make reverse order // *****
            }
        }
        else{
            order = new int[0]; // return empty array
        }
        return order;

    }

    private static int WHITE = 1; // not visited
    private static int GRAY = 2; // visited
    private static int BLACK = 3; // when recursion done

    private boolean isPossible; // for the case of not DAG
    private Map<Integer, Integer> color; // for visited
    private Map<Integer, List<Integer>> adjList; // adjacent lists for the graph
    private List<Integer> topologicalOrder; // the roll of a stack

    public void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();

        for(int i=0; i<numCourses; i++)
            this.color.put(i, WHITE);
    }

    private void topologicalSort(int node){ // *****
        if(!isPossible) return; // when not DAG

        color.put(node, GRAY);

        for(Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())){ // the case of partially isolated graph, e.g. 3, [[1,0]]
            if(color.get(neighbor) == WHITE){
                topologicalSort(neighbor);
            }
            else if(color.get(neighbor) == GRAY){
                isPossible = false; // the case of not DAG // visited again
            }
        }
        color.put(node, BLACK); // because of the line to prevent not DAG
        topologicalOrder.add(node); // stack.push()
    }
}
