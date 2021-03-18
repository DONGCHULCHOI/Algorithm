package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    // DFS:
    // Find a cycle using DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph using adjacent list
        // each course is node
        List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // trigger for unconnected graph
        for(int i = 0; i < numCourses; i++) {
            if (!dfs(i,courses, visited)) {
                return false;
            }
        }
        return true;
    }

    // find whether there is a cycle in the graph using DFS
    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        visited[course] = 1; // mark it being visited

        List<Integer> eligibleCourses = courses.get(course); // get its adjacent nodes
        for(int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i);

            if(visited[eligibleCourse] == 1) return false; // the node has been visited while visiting adjacent nodes ==> cycle // *****
            if(visited[eligibleCourse]  == 0) { // not visited
                if (!dfs(eligibleCourse,courses, visited)) return false;
            }
        }

        visited[course] = 2; // mark it done visiting // e.g 2, [[0,1]]

        return true;
    }
}
