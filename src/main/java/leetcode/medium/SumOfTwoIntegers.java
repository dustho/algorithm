package leetcode.medium;

/**
 * <p><a href="https://leetcode.com/problems/sum-of-two-integers/">SumOfTwoIntegers</a></p>
 * <p>
 * SumOfTwoIntegers 문제는 +, - 연산자 없이 2개의 숫자를 더한 값을 반환하는 문제입니다.
 * </p>
 * <p>#math, #bit-manipulation</p>
 */
public class SumOfTwoIntegers {
  /**
   * <p>Integer</p>
   * <p>
   * Java 에서는 Integer 객체에서 sum 메서드를 제공합니다.
   * </p>
   */
  static class Solution {
    public int getSum(int a, int b) {
      return Integer.sum(a, b);
    }

    /**
     * <p>Bit Manipulation</p>
     * <p>
     * Bit 연산자를 이용해 문제를 풀 수 있습니다.
     * 먼저 AND 연산으로 Carry (자리 올림)를 구합니다.
     * 다음 XOR 연산으로 자리 올림 없는 합을 구합니다.
     * Carry (자리 올림)를 다음 단계로 이동합니다.
     * 위 과정을 자리 올림이 없을 때까지 반복합니다.
     * </p>
     */
    public static int getSumByBitManipulation(int a, int b) {
      while (b != 0) {
        int carry = (a & b) << 1;
        a = a ^ b;
        b = carry;
      }
      return a;
    }
  }
}
