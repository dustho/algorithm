package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/balanced-binary-tree/">BalancedBinaryTree</a></p>
 * <p>
 * BalancedBinaryTree 문제는 height-balanced 트리인지 판별하는 문제입니다.</br>
 * height-balanced 트리란 서브 트리의 최대 깊이 차이가 1이하인 트리입니다.
 * </p>
 * <p>#dfs, #queue</p>
 */
public class BalancedBinaryTree {
  /**
   * <p>DFS</p>
   * <p>
   * 노드의 깊이를 탐색하면서 서브 트리의 최대 깊이 차이를 업데이트합니다.
   * 차이가 1보다 커지면 false 를 반환합니다.
   * </p>
   */
  static class Solution {
    int maxDiff = 0;

    public boolean isBalanced(TreeNode root) {
      dfs(root);
      return maxDiff <= 1;
    }

    private int dfs(TreeNode node) {
      if (node == null || maxDiff > 1) {
        return 0;
      }
      int leftDepth = dfs(node.left);
      int rightDepth = dfs(node.right);
      int diff = Math.abs(leftDepth - rightDepth);
      maxDiff = Math.max(maxDiff, diff);
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
