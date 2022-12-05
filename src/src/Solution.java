public class Solution {

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if(strLength < 2){
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s,start,start);
            expandRange(s,start,start + 1);
        }
        return s.substring(resultStart,resultStart+resultLength);
    }

    private void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)){
            begin --;
            end++;
        }
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        int row = 0, dir = 0;

        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            row += dir;
            sbs[row].append(c);

            if (row == 0 || row == numRows - 1) {
                dir = (dir == 0) ? 1 : -dir;
            }
        }

        return convert(sbs);
    }

    private String convert(StringBuilder[] sbs) {
        StringBuilder result = new StringBuilder();

        for (StringBuilder sb: sbs) {
            result.append(sb.toString());
        }

        return result.toString();
    }

    public int reverse(int x) {
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x *= -1;
        }

        long reversed = 0;
        while (x > 0){
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        if(reversed > Integer.MAX_VALUE){
            return 0;
        }
        return isNegative ? (int)(-1 * reversed) : (int)reversed;
    }
}
