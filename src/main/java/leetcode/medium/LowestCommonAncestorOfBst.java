package leetcode.medium;

/**
 * <p><a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">LowestCommonAncestorOfBst</a></p>
 * <p>
 * LowestCommonAncestorOfBst 문제는 이진 탐색 트리의 루트 노드와 2개의 노드가 주어질 때,<br>
 * 2개의 노드의 공통 조상 중 최하단 노드(LCA)를 구하는 문제입니다.<br>
 * </p>
 * <p>#dfs, #binary-search-tree</p>
 */
public class LowestCommonAncestorOfBst {
  /**
   * <p>DFS</p>
   * <p>
   * 이진 탐색 트리는 부모보다 작은 값은 왼쪽, 부모보다 큰 값은 오른쪽에 저장합니다.
   * 따라서 2개의 노드가 모두 작거나, 모두 크지 않은 경우 해당 노드는 LCA 가 됩니다.
   * 반면, 모두 작거나 클 경우 깊이 탐색을 통해 LCA 를 찾을 수 있습니다.
   * </p>
   */
  static class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      return search(root, p, q);
    }

    public TreeNode search(TreeNode cur, TreeNode p, TreeNode q) {
      if (cur.left != null && cur.val > p.val && cur.val > q.val) {
        return search(cur.left, p, q);
      } else if (cur.right != null && cur.val < p.val && cur.val < q.val) {
        return search(cur.right, p, q);
      }

      return cur;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
}
