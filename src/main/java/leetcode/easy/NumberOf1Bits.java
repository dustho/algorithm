package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/number-of-1-bits/">NumberOf1Bits</a></p>
 * <p>
 * NumberOf1Bits 문제는 숫자를 이진수로 변환했을 때, 1의 개수를 구하는 문제입니다.
 * </p>
 * <p>#divide-and-conquer, #bit-manipulation</p>
 */
public class NumberOf1Bits {
  /**
   * <p>Bit Manipulation</p>
   * <p>
   * 숫자가 0이 될 때까지 2로 나눠주면서,
   * 나머지가 1일 때 count 를 1씩 더해줍니다.
   * </p>
   */
  static class Solution {
    public int hammingWeight(int n) {
      int count = 0;
      while (n > 0) {
        if (n % 2 == 1) {
          count++;
        }
        n /= 2;
      }
      return count;
    }
  }
}
