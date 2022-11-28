package org.mhiginio._12integertoroman;

public class Solution {
    public String intToRoman(int num) {
        String result = format(num / 1000, '?', '?', 'M');
        num %= 1000;
        result += format(num / 100, 'M', 'D', 'C');
        num %= 100;
        result += format(num / 10, 'C', 'L', 'X');
        result += format(num % 10, 'X', 'V', 'I');
        return result;
    }

    private String format(int number, char ten, char five, char one) {
        StringBuilder sb = new StringBuilder(4);
        switch (number) {
            case 0:
                break;
            case 3:
                sb.append(one);
            case 2:
                sb.append(one);
            case 1:
                sb.append(one);
                break;
            case 4:
                sb.append(one);
            case 5:
                sb.append(five);
                break;
            case 6:
                sb.append(five).append(one);
                break;
            case 7:
                sb.append(five).append(one).append(one);
                break;
            case 8:
                sb.append(five).append(one).append(one).append(one);
                break;
            case 9:
                sb.append(one).append(ten);
                break;
        }
        return sb.toString();
    }
}