package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/subtree-of-another-tree/">SubtreeOfAnotherTree</a></p>
 * <p>
 * SubtreeOfAnotherTree 문제는 2개의 트리가 주어질 때,<br>
 * 하나의 트리가 서브 트리가 될 수 있는지 반환하는 문제입니다.
 * </p>
 * <p>#dfs</p>
 */
public class SubtreeOfAnotherTree {
  /**
   * <p>DFS</p>
   * <p>
   * root 트리를 subRoot 트리와 동일한지 비교합니다.
   * 동일하지 않다면, 깊이 탐색을 진행합니다.
   * 동일하다면 true 를 반환합니다.
   * </p>
   */
  static class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      return subTree(root, subRoot);
    }

    private boolean subTree(TreeNode cur, TreeNode sub) {
      boolean isSame = false;
      if (cur == null) {
        return false;
      } else if (!isSame && cur.val == sub.val) {
        isSame = isSame(cur, sub);
      }
      if (isSame) return true;
      else return subTree(cur.left, sub) || subTree(cur.right, sub);
    }

    private boolean isSame(TreeNode cur, TreeNode sub) {
      if (cur == null && sub == null) {
        return true;
      } else if ((cur == null && sub != null)
          || (cur != null && sub == null)
          || (cur.val != sub.val)
      ) {
        return false;
      }

      return isSame(cur.left, sub.left) && isSame(cur.right, sub.right);
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
