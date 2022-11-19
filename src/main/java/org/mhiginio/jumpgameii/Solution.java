package org.mhiginio.jumpgameii;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        int[] solution = new int[nums.length];
        Arrays.fill(solution, Integer.MAX_VALUE);
        solution[0] = 0;

        for (int i = 0; i < solution.length - 1; i++) {
            setSolutionsFrom(i, nums, solution);
        }
        return solution[nums.length - 1];
    }

    private void setSolutionsFrom(int fromIndex, int[] nums, int[] solution) {
        int maxJumpLength = nums[fromIndex];
        for (int jumpSize = 1; jumpSize <= maxJumpLength && jumpSize + fromIndex < nums.length; jumpSize++) {
            solution[fromIndex + jumpSize] = Math.min(solution[fromIndex + jumpSize], solution[fromIndex] + 1);
        }
    }
}