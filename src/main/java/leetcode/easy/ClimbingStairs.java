package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/climbing-stairs/">ClimbingStairs</a></p>
 * <p>
 * ClimbingStairs 문제는 한 번에 1개 혹은 2개의 계단만을 오를 수 있을 때,<br>
 * n개의 계단을 올라가는 방법의 개수를 구하는 문제입니다.<br>
 * </p>
 * <p>#dynamic-programming, #memoization</p>
 */
public class ClimbingStairs {
  /**
   * <p>DP With Memoization</p>
   * <p>
   * 한 번에 1개 혹은 2개의 계단만을 오를 수 있기 때문에,
   * n개의 계단을 오르는 방법의 수는 n-1개의 계단을 오르는 방법의 수와 n-2개의 계단을 오르는 방법의 수와 같습니다.
   * f(n) = f(n-1) + f(n-2) 라는 재귀함수 형태로 나타낼 수 있고,
   * Memoization 을 함께 활용해 시간 효율을 극대화할 수 있습니다.
   * </p>
   */
  static class Solution {
    int[] memo;

    public int climbStairs(int n) {
      memo = new int[n + 1];
      memo[0] = 1;
      memo[1] = 1;
      recursion(n);
      return memo[n];
    }

    public int recursion(int n) {
      if (n < 0) {
        return 0;
      } else if (memo[n] != 0) {
        return memo[n];
      }

      memo[n] = recursion(n - 1) + recursion(n - 2);
      return memo[n];
    }
  }
}
