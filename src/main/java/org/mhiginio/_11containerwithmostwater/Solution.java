package org.mhiginio._11containerwithmostwater;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int maxArea(int[] height) {
        TreeMap<Integer, Integer> fromIndex = indexFromBeginning(height);
        TreeMap<Integer, Integer> toIndex = indexToEnd(height);
        int maxArea = 0;
        for (int i = 1; i <= fromIndex.lastKey(); i++) {
            Map.Entry<Integer, Integer> fromEntry = fromIndex.ceilingEntry(i);
            Map.Entry<Integer, Integer> toEntry = toIndex.ceilingEntry(i);
            if (fromEntry == null || toEntry == null) {
                break;
            }
            int from = fromEntry.getValue();
            int to = toEntry.getValue();

            int area = (to - from) * i;
            if (area > maxArea) {
                maxArea = area;
            }

        }
        return maxArea;
    }

    /**
     * @return A TreeMap with key = height and value = index which responds to: which is the first index with height >= x?
     */
    private TreeMap<Integer, Integer> indexFromBeginning(int[] height) {
        TreeMap<Integer, Integer> response = new TreeMap<>();
        int max = -1;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > max) {
                max = height[i];
                response.put(max, i);
            }
        }
        return response;
    }

    /**
     * @return A TreeMap with key = height and value = index which responds to: which is the last index with height >= x?
     */
    private TreeMap<Integer, Integer> indexToEnd(int[] height) {
        TreeMap<Integer, Integer> response = new TreeMap<>();
        int max = 0;
        for (int i = height.length - 1; i >= 1; i--) {
            if (height[i] > max) {
                max = height[i];
                response.put(max, i);
            }
        }
        return response;
    }


}