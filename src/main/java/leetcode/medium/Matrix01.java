package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p><a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a></p>
 * <p>
 * 2차원 배열이 주어질 때, 각 셀의 0으로부터 최소거리를 구해 2차원 배열로 반환하는 문제입니다.
 * </p>
 * <p>#array, #dp, #bfs</p>
 */
public class Matrix01 {
  /**
   * <p>BFS</p>
   * <p>
   * 먼저 0인 셀들 Queue 에 넣어줍니다.
   * BFS 를 진행하며, 0으로부터 거리를 업데이트해줍니다.
   * </p>
   */
  static class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {-1, 0, 1, 0};

    public int[][] updateMatrix(int[][] mat) {
      int rows = mat.length;
      int cols = mat[0].length;
      Queue<int[]> queue = new ArrayDeque<>();

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (mat[i][j] == 0) {
            queue.add(new int[]{i, j});
          } else {
            mat[i][j] = Integer.MAX_VALUE;
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] pos = queue.poll();
        int r = pos[0];
        int c = pos[1];

        for (int i = 0; i < 4; i++) {
          int newR = r + dr[i];
          int newC = c + dc[i];
          int newDist = mat[r][c] + 1;

          if (isInbound(newR, newC, rows, cols) && newDist < mat[newR][newC]) {
            mat[newR][newC] = newDist;
            queue.add(new int[]{newR, newC});
          }
        }
      }

      return mat;
    }

    private boolean isInbound(int newR, int newC, int rows, int cols) {
      return newR >= 0 && newR < rows && newC >= 0 && newC < cols;
    }
  }
}
