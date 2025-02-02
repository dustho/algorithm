package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p><a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a></p>
 * <p>
 * Valid Anagram 이란 개수까지 동일한 문자 집합으로 구성된 서로 다른 문자열을 의미합니다.<br>
 * 두 문자열이 주어질 때 Valid Anagram 인지 판단하는 문제입니다.<br>
 * </p>
 * <p>#hash-table, #sort</p>
 */
public class ValidAnagram {
  /**
   * <p>Hash Table</p>
   * <p>
   * s 문자열을 순회하면서 Hash Table 에 문자에 대한 개수를 증가시킵니다.
   * t 문자열을 순회하면서 Hash Table 에 문자에 대한 개수를 감소시킵니다.
   * 모든 문자에 대한 개수가 0이라면 true 를 반환합니다.
   * </p>
   */
  static class Solution1 {
    public boolean isAnagram(String s, String t) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c: s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      for (char c: t.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) - 1);
      }
      for (Integer val: map.values()) {
        if (val != 0) {
          return false;
        }
      }
      return true;
    }
  }

  /**
   * <p>Sort</p>
   * <p>
   * 두 문자열을 정렬하고, 두 문자열을 동시에 순회하면서 문자가 서로 다르면 false 를 반환합니다.
   * </p>
   */
  static class Solution2 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) return false;

      char[] sChars = s.toCharArray();
      char[] tChars = t.toCharArray();

      Arrays.sort(sChars);
      Arrays.sort(tChars);

      for (int i = 0; i < s.length(); i++) {
        if (sChars[i] != tChars[i]) return false;
      }

      return true;
    }
  }
}
