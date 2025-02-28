package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/same-tree/">SameTree</a></p>
 * <p>
 * SameTree 문제는 2개의 Tree 가 동일한 Tree 인지 검증하는 문제입니다.
 * </p>
 * <p>#dfs, #bfs</p>
 */
public class SameTree {
  /**
   * <p>DFS</p>
   * <p>
   * 2개의 Tree 를 동일한 순서로 탐색하고, 서로 같지 않으면 false
   * 모든 원소가 서로 같으면 true 를 반환합니다.
   * </p>
   */
  class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      return dfs(p, q, true);
    }

    public boolean dfs(TreeNode p, TreeNode q, boolean isSame) {
      if (isNotSame(p, q)) {
        return false;
      } else if (p == null && q == null) {
        return true;
      }

      if (isSame) {
        isSame = dfs(p.left, q.left, isSame);
      }
      if (isSame) {
        isSame = dfs(p.right, q.right, isSame);
      }

      return isSame;
    }

    private boolean isNotSame(TreeNode p, TreeNode q) {
      return (p == null && q != null)
          || (p != null && q == null)
          || (p != null && q != null && p.val != q.val);
    }
  }

  /**
   * Definition for a binary tree node.
   */
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
