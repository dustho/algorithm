package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/diameter-of-binary-tree/">DiameterOfBinaryTree</a></p>
 * <p>
 * DiameterOfBinaryTree 문제는 이진 트리가 주어질 때,<br>
 * 경로의 최장 길이를 찾는 문제입니다.<br>
 * </p>
 * <p>#dfs, #binary-tree</p>
 */
public class DiameterOfBinaryTree {
  /**
   * <p>DFS</p>
   * <p>
   * 우선 dfs 를 통해 최하단 노드로 진입하고, 노드를 타고 올라오면서
   * 서브 트리의 최장 경로(왼쪽 최고 길이 + 오른쪽 최고 길이)를 업데이트합니다.
   * 노드를 타고 올라올 때마다 왼쪽, 오른쪽 경로 중 (최고 길이 + 1) 을 반환합니다.
   * </p>
   */
  static class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      dfs(root);
      return max;
    }

    private int dfs(TreeNode node) {
      if (node == null) {
        return 0;
      }
      int leftDepth = dfs(node.left);
      int rightDepth = dfs(node.right);
      max = Math.max(max, leftDepth + rightDepth);

      return Math.max(leftDepth, rightDepth) + 1;
    }
  }

  public class TreeNode {
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
