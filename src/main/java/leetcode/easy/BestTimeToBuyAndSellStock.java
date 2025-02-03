package leetcode.easy;

/**
 * <p><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">BestTimeToBuyAndSellStock</a></p>
 * <p>
 * BestTimeToBuyAndSellStock 문제는 prices 라는 일별 주식 가격이 주어질 때,<br>
 * 최저가로 사서 최고가로 판매하는 경우 즉, 최대 수익을 구하는 문제입니다.<br>
 * </p>
 * <p>#array, #dynamic-programming</p>
 */
public class BestTimeToBuyAndSellStock {
  /**
   * <p>Greedy</p>
   * <p>
   * 구매가를 최저가로 업데이트 해주면서,
   * 동시에 현재 구매가를 기준으로 최대 수익을 업데이트해주는 방식입니다.
   * </p>
   */
  static class Solution {
    public int maxProfit(int[] prices) {
      int boughtPrice = prices[0];
      int profit = 0;
      for (int i = 1; i < prices.length; i++) {
        if (boughtPrice > prices[i]) {
          boughtPrice = prices[i];
        } else {
          profit = Math.max(profit, prices[i] - boughtPrice);
        }
      }

      return profit;
    }
  }

}
