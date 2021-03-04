package leetcode.top100_questions;

public class RobotRoomCleaner {
    // Backtracking:
    // time complexity
    // see mine first in comments
    // robot has direction: *****
    // so we have to iterate domain values from which the robot are headed, and the order we visit is clockwise
    // then, use move() which makes the robot go forward to where it is headed,
    // and at the same time, the direction is also right;
    //      e.g: robot is at (1,1), and it's headed to the north, the possible domains are [[0,1](Up),[1,2](Right),[2,1](Down),[1,0](Left)]
    //           if we iterate [1,0] first, then the robot goes from (1,1) to (1,0) but it's headed to the north, which is not make-sense
    //           if we iterate [0,1] first, then the robot goes from (1,1) to (0,1) and it's still headed to the north, which is make-sense
    // after iterate one domain value, we have to turn the robot to right using turnRight()
    // this can be done by the following:
    /*
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if(consistence) { ``` }

            robot.turnRight();
        }
    */
    // see mine first in comments
    /* mine
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****
    private Set<Pair<Integer, Integer>> visited = new HashSet();

    public void main(String[] args, int[][] grid) {
        List<List<Pair<Integer, Integer>>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(new Pair(1, 3)), grid, 1, 3);
    }
    public void backtracking(List<List<Pair>> list, List<Pair> assignment, int[][] grid, int row, int col) {
         int i = 0;
         for(; i < 4; i++) { // domain values differ from each given point, calculate the domains which is 4 adjacent points(up, right, down, left)
                             // the order we iterate domains is not concerned in my example
             int newRow = row + directions[i][0];
             int newCol = col + directions[i][1];

             // if consistent
             if(!visited.contains(new Pair(newRow, newCol)) // not visited
                && grid[newRow, newCol] != 0 // not obstacle
                && newRow >=0 && newRow < grid.length  // row, col in proper range
                && newCol >= 0 && newCol < grid[0].length) {
                 assignment.add(new Pair(newRow, newCol));
                 backtracking(list, assignment, grid, newRow, newCol);
                 assignment.remove(assignment.size() - 1);
             }
         }
         if(i == 4) { // when there is no way to go, then it means this is one of the ways we are looking for
            list.add(new List<>(assignment));
         }
     }
     */
    /*
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();
    Robot robot;

    public void goBack() { // go back to the original direction and location where it is called before
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    */
}