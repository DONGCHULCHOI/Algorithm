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
    // 1st. calculate domains at given point
    // 2nd. if it is consistent
    // 3rd. assign the value to assignment, and move the point corresponding to the value
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****
    private Set<Pair<Integer, Integer>> visited = new HashSet();

    public void main(String[] args, int[][] grid) {
        List<List<Pair<Integer, Integer>>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(new Pair(1, 3)), grid, 1, 3); // the recursion tree starts with start point
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
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Set<Pair<Integer, Integer>> visited = new HashSet();
    private Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0); // we don't know where the robot starts, but it does not matter where we start from
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair<>(row, col));
        robot.clean();

        for (int i = 0; i < 4; ++i) { // 1st. calculate domains at given point
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) { // 2nd. if it is consistent
                backtrack(newRow, newCol, newD); // 3rd. assign the value to assignment, and move the point corresponding to the value
                goBack();
                //visited.remove(new Pair<>(row, col)); // cuz clean duplicated zone -> time complexity increased.
            }

            robot.turnRight();
        }
    }

    public void goBack() { // go back to the original direction and location where it is called before
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    */
}