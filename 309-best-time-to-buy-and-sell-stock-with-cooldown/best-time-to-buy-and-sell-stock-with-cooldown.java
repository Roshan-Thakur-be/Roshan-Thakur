class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // State variables
        int held = -prices[0]; // Max profit when holding a stock
        int sold = 0;          // Max profit right after selling a stock (triggers cooldown next)
        int reset = 0;         // Max profit in a rest/cooldown state without stock

        for (int i = 1; i < prices.length; i++) {
            int prevHeld = held;
            int prevSold = sold;
            int prevReset = reset;

            // 1. To hold a stock today, either keep holding or buy today after a reset day
            held = Math.max(prevHeld, prevReset - prices[i]);

            // 2. To sell today, we must have been holding a stock previously
            sold = prevHeld + prices[i];

            // 3. To be in reset/cooldown today, take the best of resting or coming off a sale
            reset = Math.max(prevReset, prevSold);
        }

        // The max profit will be either in the sold or reset state (not holding any stock)
        return Math.max(sold, reset);
    }
}