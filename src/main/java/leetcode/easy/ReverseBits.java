package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/sum-of-two-integers/">ReverseBits</a></p>
 * <p>
 * ReverseBits 문제는 이진수 n을 좌우 반전시켜 반환하는 문제입니다.
 * </p>
 * <p>#divide-and-conquer, #bit-manipulation</p>
 */
public class ReverseBits {
  /**
   * <p>Loop</p>
   * <p>
   * n을 이진수 문자열로 변환시켜 해당 문자열을 반대로 순회하면서
   * 좌우 반전된 문자열을 이진수로 파싱해 반환합니다.
   * </p>
   * */
  static class Solution1 {
    public int reverseBits(int n) {
      char[] bits = Integer.toBinaryString(n).toCharArray();

      StringBuilder sb = new StringBuilder();
      for (int i = bits.length - 1; i >= 0; i--) {
        sb.append(bits[i]);
      }
      for (int i = 0; i < 32 - bits.length; i++) {
        sb.append(0);
      }

      return (int) Long.parseLong(sb.toString(), 2);
    }
  }

  /**
   * <p>Bit Manipulation</p>
   * <p>
   * - n: 00111001011110000010100101000000 <br>
   * - 0: 00000000000000000000000000000000 <br>
   * - 1: 00000000000000000000000000000001 <br>
   * reverseN을 왼쪽으로 1칸 이동시키고,
   * n의 0의 자리에 1이 있다면 reverseN에 추가합니다.
   * 그리고 n을 오른쪽으로 이동시킵니다.
   * 위 과정을 32번 반복하면 좌우반전된 n을 반환할 수 있습니다.
   * </p>
   **/
  static class Solution2 {
    public int reverseBits(int n) {
      int reverseN = 0;
      for (int i = 0; i < 32; i++) {
        reverseN <<= 1;
        reverseN |= (n & 1);
        n >>= 1;
      }
      return reverseN;
    }
  }
}
