package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a></p>
 * <p>
 * 2차원 배열에서 좌우상하 인접한 원소들의 색깔이 같으면, 해당 원소들을 새로운 색으로 변경하는 문제입니다.<br>
 * </p>
 * <p>#array, #bfs, #dfs</p>
 */
public class FloodFill {
  /**
   * <p>BFS</p>
   * <p>
   * BFS 를 활용해 시작 원소부터 순회하면서 시작 원소와 색이 동일한 원소의 색을 변경해줍니다.
   * </p>
   */
  class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      boolean[][] isVisited = new boolean[image.length][image[0].length];
      int initialColor = image[sr][sc];
      bfs(sr, sc, initialColor, color, image, isVisited);
      return image;
    }

    private void bfs(int row, int col, int initialColor, int color, int[][] image, boolean[][] isVisited) {
      if (image[row][col] == initialColor) {
        image[row][col] = color;
        for (int i = 0; i < 4; i++) {
          int newRow = row + dr[i];
          int newCol = col + dc[i];
          if (isInBound(newRow, newCol, image.length, image[0].length) && !isVisited[newRow][newCol]) {
            bfs(newRow, newCol, initialColor, color, image, isVisited);
          }
        }
      }
    }

    private boolean isInBound(int row, int col, int maxRow, int maxCol) {
      return 0 <= row && row < maxRow && 0 <= col && col < maxCol;
    }
  }
}
