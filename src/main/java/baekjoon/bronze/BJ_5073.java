package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p><a href="https://www.acmicpc.net/problem/5073">삼각형과 세 변</a></p>
 * <p>
 * 세 변의 길이가 주어질 때, 길이에 따른 삼각형 종류를 출력하는 문제입니다.
 * </p>
 * <p>#math</p>
 */
public class BJ_5073 {

  public static void main(String[] args) throws Exception {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ) {
      int[][] inputs = br.lines().map(line -> {
        String[] nums = line.split(" ");
        return new int[]{Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2])};
      }).toArray(int[][]::new);
      for (int i = 0; i < inputs.length - 1; i++) {
        String result = BJ_5073.solution(
            inputs[i][0],
            inputs[i][1],
            inputs[i][2]
        );
        bw.write(result);
        bw.newLine();
      }
    }
  }

  private static String solution(int a, int b, int c) {
    return new Triangle(a, b, c).def();
  }

  static class Triangle {

    Queue<Integer> pq = new PriorityQueue<>((a, b) -> a < b ? 1 : -1);

    public Triangle(int a, int b, int c) {
      pq.add(a);
      pq.add(b);
      pq.add(c);
    }

    public String def() {
      int num1 = pq.remove();
      int num2 = pq.remove();
      int num3 = pq.remove();

      if (num1 >= num2 + num3) {
        return "Invalid";
      }

      if (num1 == num2 && num2 == num3) {
        return "Equilateral";
      } else if (num1 != num2 && num2 != num3 && num3 != num1) {
        return "Scalene";
      } else {
        return "Isosceles";
      }
    }
  }
}
