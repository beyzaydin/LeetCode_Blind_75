package bestprofit;

/**
 * https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
 */
public class BestProfit {

    public static void Main(String[] args) {
        //[7,1,5,3,6,4]
    }

    //time limit exceed
    public int maxProfitFirst(int[] prices) {//failed
        int min = Integer.MAX_VALUE;
        int max = 0;
        int cursor = 0;
        int index = 0;

        for (var num : prices) {
            if (num < min) {
                min = num;
                index = cursor;
            }
            cursor++;
        }

        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    //not working
    public int maxProfitSecond(int[] prices) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (max < (prices[j] - prices[i]) && prices[j] - prices[i] >= 0)
                    max = prices[j] - prices[i];
            }
        }

        return max;
    }

    public int maxProfitGreedy(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= buy)
                buy = prices[i];

            if (prices[i] - buy > maxProfit)
                maxProfit = prices[i] - buy;
        }

        return maxProfit;
    }
}
