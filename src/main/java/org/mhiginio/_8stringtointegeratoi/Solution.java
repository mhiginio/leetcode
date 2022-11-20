package org.mhiginio._8stringtointegeratoi;

import static java.lang.Character.isDigit;

public class Solution {
    private char[] chars;
    private int pos;

    public int myAtoi(String s) {
        chars = s.toCharArray();
        skipTrailingSpaces();
        return computeValue(readSign());
    }

    private int computeValue(boolean positive) {
        long value = 0;
        while (pos < chars.length && isDigit(chars[pos])) {
            value *= 10;
            value += (chars[pos] - '0');
            if (value > Integer.MAX_VALUE) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            pos++;
        }
        return positive ? (int) value : (int) -value;
    }


    private void skipTrailingSpaces() {
        while (pos < chars.length && chars[pos] == ' ') {
            pos++;
        }
    }

    private boolean readSign() {
        if (pos == chars.length) {
            return true;
        }
        boolean positive = '-' != chars[pos];
        if (chars[pos] == '-' || chars[pos] == '+') {
            pos++;
        }
        return positive;
    }

}