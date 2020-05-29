package leetcode;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // T.C: O(N), where N is the number of pixels in the image
        // S.C: O(N)
        int color = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        // No need to mark visited // *****
        // because when visited, the color becomes new color, and the new color means visited
        if (image[r][c] != color) {
            return;
        }
        // visit
        image[r][c] = newColor;
        // if not visited, do recursion for neighbors
        if (r-1 >= 0 && image[r-1][c] != newColor) dfs(image, r-1, c, color, newColor); // order & index bound // *****
        if (c-1 >= 0 && image[r][c-1] != newColor)  dfs(image, r, c-1, color, newColor); // *****
        if (r+1 < image.length && image[r+1][c] != newColor) dfs(image, r+1, c, color, newColor); // *****
        if (c+1 < image[0].length && image[r][c+1] != newColor) dfs(image, r, c+1, color, newColor); // *****
    }
}
