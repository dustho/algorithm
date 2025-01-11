package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/valid-palindrome/">ValidPalindrome</a></p>
 * <p>
 * 알파벳, 숫자를 제외한 나머지 문자를 제거하고, 모든 문자를 소문자로 변경했을 때,<br>
 * 앞으로 읽어도 뒤로 읽어도 같은 문자를 찾는 문제입니다.<br>
 * </p>
 * <p>#string, #two-pointer</p>
 */
public class ValidPalindrome {

  /**
   * <p>Two Pointer</p>
   * <p>
   * 2개의 포인터를 이용해 한번의 루프를 돌면서 Palindrome 여부를 검사할 수 있습니다.
   * </p>
   */
  static class Solution {
    public boolean isPalindrome(String s) {
      int p1 = 0;
      int p2 = s.length() - 1;
      s = s.toLowerCase();
      while(p1 < p2) {
        char c1 = s.charAt(p1);
        char c2 = s.charAt(p2);

        if (!Character.isAlphabetic(c1) && !Character.isDigit(c1)) {
          p1++;
          continue;
        } else if (!Character.isAlphabetic(c2) && !Character.isDigit(c2)) {
          p2--;
          continue;
        }

        if (c1 == c2) {
          p1++;
          p2--;
        } else {
          return false;
        }
      }
      return true;
    }
  }
}
