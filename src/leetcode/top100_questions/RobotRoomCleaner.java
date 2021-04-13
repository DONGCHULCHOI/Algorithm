package leetcode.top100_questions;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotRoomCleaner {
    // DFS:
    // robot has direction: // *****
    /*
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****
        for (int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4; // *****
            int newRow = row + dirs[newDir][0]; // *****
            int newCol = col + dirs[newDir][1]; // *****

            if(consistent) { ``` }

            robot.turnRight();
        }
    */
    // have to iterate the neighbor from which the robot are headed first, and then visit clockwise from the neighbor // *****
    // e.g: robot is at (1,1), and it's headed to the north, the possible domains are [[0,1](Up),[1,2](Right),[2,1](Down),[1,0](Left)]
    //      if we iterate [1,0] first, then the robot goes from (1,1) to (1,0) but it's headed to the north, which is not make-sense
    //      if we iterate [0,1] first, then the robot goes from (1,1) to (0,1) and it's still headed to the north, which is make-sense
    // after iterate one neighbor, before the end of the iteration, we have to turn the robot to right using turnRight() // *****

    private int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    private Set<Pair<Integer, Integer>> visited = new HashSet(); // we cannot use matrix
    private Robot robot;

    // orig ver.
    public void dfs(int row, int col, int dir) {
        // no base case: because the case [[1]], 0, 0, it is rejected by the base case

        robot.clean();
        visited.add(new Pair<>(row, col));

        for(int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4;
            int newRow = row + dirs[newDir][0];
            int newCol = col + dirs[newDir][1];

            if(!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                dfs(newRow, newCol, newDir);
                goBack();
            }
            robot.turnRight();
        }

        //visited.remove(new Pair<>(row, col)); // cuz clean all possible area once, not like Word Search // *****
    }

    // new ver. : in this case, don't use new ver, because the case [[1]], 0, 0, it is rejected by the base case
    public boolean dfs2(int row, int col, int dir) {
        if(visited.contains(new Pair<>(row, col)) || !robot.move())
            return false;

        robot.clean();
        visited.add(new Pair<>(row, col));

        for(int i = 0; i < 4; i++) {
            int newDir = (dir + i) % 4;
            int newRow = row + dirs[newDir][0];
            int newCol = col + dirs[newDir][1];

            if(dfs2(newRow, newCol, newDir))
                goBack();

            robot.turnRight();
        }
        return true;
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        dfs(0,0,0);
    }

    public void goBack() { // go back to the original direction and location where it is called before
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}