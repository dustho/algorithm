package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">MaximumDepthOfBinaryTree</a></p>
 * <p>
 * MaximumDepthOfBinaryTree 문제는 이진 트리의 최대 깊이를 구하는 문제입니다.
 * </p>
 * <p>#dfs, #bfs</p>
 */
public class MaximumDepthOfBinaryTree {
  /**
   * <p>DFS</p>
   * <p>
   * 노드의 깊이를 탐색하면서 깊이가 최대인 경우를 반환합니다.
   * </p>
   */
  static class Solution {
    public int maxDepth(TreeNode root) {
      return dfs(root, 0);
    }

    private int dfs(TreeNode node, int depth) {
      if (node == null) return depth;
      return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
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
