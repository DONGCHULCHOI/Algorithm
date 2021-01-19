package leetcode.amazon_google_questions;

public class RobotRoomCleaner {
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
/*
    public void cleanRoom(Robot robot) {
        // T.C : O(4^(N-M) where N is a number of cells in the room and M is a number of obstacles,
        // because for each cell the algorithm checks 4 directions.
        // S.C : O(N-M), where N is a number of cells in the room and M is a number of obstacles, to track visited cells.
        // Direction and Movement are important concept // *****
        // (!) place the robot / chess on the room / the board, and remove previous decision is same // *****
        // Place() and Remove() Based on movement of robot // *****
        // vs in case of N-queens, remove() and place() based on the effect of the place
        // direction clockwise
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();
    Robot robot;

    public void goBack() { // when it located, turns into the original direction and location when it is called before // *****
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col)); // place // based on a movement // *****
        robot.clean();

        for (int i = 0; i < 4; i++) { // for
            // going clockwise based on the direction when it called // *****
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) { // is_valid // based on a movement // *****
                backtrack(newRow, newCol, newD); // backtrack
                goBack(); // remove
            }
            robot.turnRight(); // turn the robot following chosen direction because clockwise before tring next candidate // *****
        }  // after each for statement, the robot turns into the original direction when it called
    }
*/
}