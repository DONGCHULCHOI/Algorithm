package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    // N-queens II first
    // Consider backtracking first, master it
    // Consider the time complexity of backtracing first
    // Consider other approaches later

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Backtracking
        // breadcrumb through the process(1->2->3), then because of it, can backtrack(3->2->1)
        // Each course is a node, the condition of prerequisites is a directed edge
        // Build the graph based on the given edge lists, which is represented by the adjacency lists
        // (convert edge list to adjacency lists)
        // If the graph is DAG, then the ans is true

        // ( K= a course(relation[1]), V= a list of next courses of the course(relation[0]s) )
        Map<Integer, List<Integer>> courseDict = new HashMap<>(); // input for isCyclic // ***

        // build the graph
        for(int[] relation : prerequisites){ // *****
            // relation[0] depends on relation[1]
            if(courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            }
            else{
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }
        boolean[] path = new boolean[numCourses]; // input for isCyclic // ***
        for(int currCourse=0; currCourse < numCourses; currCourse++){ // search all courses one by one
            if(isCyclic(currCourse, courseDict, path)){ // through the search, when find the case of cycle
                return false; // not DAG
            }
        }
        return true; // DAG // when all courses pass
    }
    // backtracking method to check that no cycle would be formed starting from currCourse
    public boolean isCyclic(Integer currCourse, Map<Integer, List<Integer>> courseDict, boolean[] path){ // *****
        if(path[currCourse]){ // come across a previously visited node, i.e. detect the cycle
            return true; // not DAG
        }
        if(!courseDict.containsKey(currCourse)){ // no following courses, no loop // base case
            return false;
        }
        path[currCourse] = true; // before backtracking, mark the node in the path // breadcrumb

        // backtracking
        boolean result = false;
        for(Integer nextCourse : courseDict.get(currCourse)){ // for the case of several next courses // i.e. not DAG // *1)
            result = isCyclic(nextCourse, courseDict, path);
            if(result){ // when find a cycle // don't need to see the case of several next course i.e. other cycle
                break;
            }
        }
        // after backtracking, reset the path[currCourse] for the next currCourse in the main function
        path[currCourse] = false;
        return result;
    }
    // 1) when there is more than one next course in a adjacency list, this means the graph has cycle
}
