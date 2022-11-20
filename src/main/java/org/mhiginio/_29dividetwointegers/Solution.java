package org.mhiginio._29dividetwointegers;

public class Solution {
    public int divide(int dividend, int divisor) {

        long totalSum = 0;
        long count = 0;
        long increase = 1;

        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        while (totalSum <= dividendL) {

            totalSum += divisorL;
            count += increase;
            if (totalSum < dividendL) {
                // Increase rate
                increase = increase << 1;
                divisorL = divisorL << 1;
            } else if (totalSum > dividendL && increase > 1) {
                // Restore rate
                totalSum -= divisorL;
                count -= increase;
                divisorL = Math.abs((long) divisor);
                increase = 1;
            }
        }
        return getResult(count, dividend < 0 ? divisor < 0 : divisor > 0);
    }

    private static int getResult(long count, boolean resultPositive) {
        long result = resultPositive ? count - 1 : 1 - count;
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE :
                result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) result;
    }

}