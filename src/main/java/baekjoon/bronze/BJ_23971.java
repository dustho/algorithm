package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <p><a href="https://www.acmicpc.net/problem/23971">ZOAC 4</a></p>
 * <p>
 * H행 W열의 좌석이 주어질 때, 다음 조건을 만족하는 앉은 사람의 최대 수를 구하는 문제입니다.
 * - 참가자 간의 간격 > 세로 N
 * - 참가자 간의 간격 > 가로 M
 * </p>
 * <p>#math</p>
 */
public class BJ_23971 {

  static public class Main {
    public static void main(String[] args) throws Exception {
      try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      ) {
        String[] input = br.readLine().split(" ");
        int solution = Main.solution(
            Integer.parseInt(input[0]),
            Integer.parseInt(input[1]),
            Integer.parseInt(input[2]),
            Integer.parseInt(input[3])
        );
        bw.write(String.valueOf(solution));
        bw.flush();
      }
    }

    private static int solution(int row, int col, int height, int width) {
      return (int) (Math.ceil((double) col / (width + 1)) * Math.ceil((double) (row) / (height + 1)));
    }
  }

}