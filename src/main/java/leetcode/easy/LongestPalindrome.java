package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p><a href="https://leetcode.com/problems/longest-palindrome/">LongestPalindrome</a></p>
 * <p>
 * LongestPalindrome 문제는 무작위의 문자열이 주어질 때,<br>
 * 해당 문자열을 조합해 만들 수 있는 palindrome 의 최대 길이를 구하는 문제입니다.<br>
 * </p>
 * <p>#hash-table, #string, #greedy</p>
 */
public class LongestPalindrome {
  /**
   * <p>Hash Map</p>
   * <p>
   * Palindrome 은 대칭 형태의 문자입니다.
   * 따라서 중앙에만 홀수개인 문자가 올 수 있고, 나머지는 모두 짝수개여야 합니다.
   * 문자의 짝홀을 판단하기 위해 문자에 대한 개수를 Map 에 저장합니다.
   * 전체 문자열의 길이에서 홀수개인 문자들의 수를 세어 1씩 감소시킵니다.
   * 홀수개인 문자가 있다면 1만큼 증가시켜줍니다.
   * </p>
   */
  static class Solution {
    public int longestPalindrome(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c: s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }

      int oddFreq = 0;
      for (int num: map.values()) {
        if (num % 2 == 1) {
          oddFreq++;
        }
      }

      return oddFreq > 0 ? s.length() - oddFreq + 1 : s.length();
    }
  }

}
