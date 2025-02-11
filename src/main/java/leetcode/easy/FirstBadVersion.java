package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/first-bad-version/">FirstBadVersion</a></p>
 * <p>
 * FirstBadVersion 문제는 숫자 n이 주어질 때, <br>
 * 1 부터 n 까지의 버전 배열에서 처음으로 잘못된 버전을 찾는 문제입니다.<br>
 * </p>
 * <p>#binary-search, #interactive</p>
 */
public class FirstBadVersion {
  /**
   * <p>Binary Search</p>
   * <p>
   * 중간 버전의 상태를 확인하고, 배열을 반으로 잘라나가는
   * Divide And Conquer 형태로 문제를 풀 수 있습니다.
   * 주의할 점은 left + right 의 합이 int 범위를 넘을 수 있으므로
   * 범위를 넘지 않도록 처리해줘야 합니다.
   * </p>
   */
  static class Solution {
    public int firstBadVersion(int n) {
      if (n == 1) return 1;

      int left = 1;
      int right = n;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return left;
    }
  }

  private static boolean isBadVersion(int num) {
    return false;
  }

}
