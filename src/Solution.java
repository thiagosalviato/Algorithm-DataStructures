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

    public boolean isPalindrome(int x) {
        if( x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int r = 0;

        while (x > r){
            r = r * 10 + x % 10;
            x = x / 10;
        }

        return r == x || r / 10 == x;
    }

    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int sLen = sArr.length, pLen = pArr.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(int i = 1; i <= pLen; i++){
            if(pArr[i - 1] == '*')
                dp[0][i] |= (i - 2 >= 0 ? dp[0][i - 2]: false);
        }
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                if(match(sArr[i - 1], pArr[j - 1])) dp[i][j] |= dp[i - 1][j - 1];
                else if(pArr[j - 1] == '*'){
                    dp[i][j] |= (j - 2 >= 0 ? dp[i][j - 2]: false);
                    if(j > 1 && match(sArr[i - 1], pArr[j - 2]))
                        dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }
    private boolean match(char a, char b){
        return a == b || b == '.';
    }

    public int maxArea(int[] height) {
        int maxAreaBetween = 0;
        int firstPointer = 0;
        int secondPointer = height.length-1;

        while (firstPointer < secondPointer) {
            if(height[firstPointer] < height[secondPointer]){
                maxAreaBetween = Math.max(maxAreaBetween, height[firstPointer] * (secondPointer-firstPointer));
                firstPointer += 1;
            }else{
                maxAreaBetween = Math.max(maxAreaBetween, height[secondPointer] * (secondPointer-firstPointer));
                secondPointer -= 1;
            }
        }
        return maxAreaBetween;
    }

    public String intToRoman(int num) {
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder romanVersion = new StringBuilder();

        for (int i = values.length;i>=0 && num > 0;i--){
            while(num >= values[i]){
                num -= values[i];
                romanVersion.append(roman[i]);
            }
        }
        return romanVersion.toString();
    }

    public int romanToInt(String s) {
        int result = 0;
        String[] roman = {"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            map.put(roman[i], values[i]);
        }
        int len = s.length();
        int i = 0;
        while(i < len){
            Integer temp = null;
            if(i+2 <= len){
                temp = map.get(s.substring(i, i+2));
                if(null != temp){
                    result += temp;
                    i += 2;
                    continue;
                }else{
                    result += map.get(s.substring(i, i+1));
                    i++;
                    continue;
                }
            }else{
                result += map.get(s.substring(i, i+1));
                i ++;
                continue;
            }
        }
        return result;
    }
}
