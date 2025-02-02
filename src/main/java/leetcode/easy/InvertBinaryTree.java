package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/invert-binary-tree/">InvertBinaryTree</a></p>
 * <p>
 * Binary Tree 에 대한 루트 노드가 주어질 때, Tree 를 좌우를 반전시켜 루트 노드를 반환하는 문제입니다.<br>
 * </p>
 * <p>#tree, #dfs</p>
 */
public class InvertBinaryTree {
  /**
   * <p>DFS</p>
   * <p>
   * 깊이 탐색을 활용해 자식 노드를 좌우반전시켜줍니다.
   * 결과적으로 전체 트리는 좌우 반전된 형태로 변환됩니다.
   * </p>
   */
  static class Solution {

    public TreeNode invertTree(TreeNode root) {
      dfs(root);
      return root;
    }

    private void dfs(TreeNode node) {
      if (node == null) {
        return;
      }
      TreeNode tmp = node.left;
      node.left = node.right;
      node.right = tmp;
      dfs(node.left);
      dfs(node.right);
    }
  }

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
