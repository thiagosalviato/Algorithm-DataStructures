import java.util.*;

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

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
    
        for (int i = 0; i < first.length; i++) {
          if (first[i] != last[i]){
            break;
          }else{
            result.append(first[i]);
          }
        }
    
        return result.toString();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result_arr = new LinkedList();

        for (int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                int lowerValue = i+1;
                int higherValue = nums.length-1;
                int sum = 0-nums[i];

                while (lowerValue < higherValue){
                    if(nums[lowerValue] + nums[higherValue] == sum){
                        result_arr.add(Arrays.asList(nums[i], nums[lowerValue], nums[higherValue]));
                        while (lowerValue < higherValue && nums[lowerValue] == nums[lowerValue+1]) lowerValue++;
                        while (lowerValue < higherValue && nums[higherValue] == nums[higherValue+1]) higherValue--;
                        lowerValue++;
                        higherValue--;
                    }else if(nums[lowerValue] + nums[higherValue] > sum){
                        higherValue--;
                    }else{
                        lowerValue++;
                    }
                }
            }
        }
        return result_arr;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target){
                    right -= 1;
                }else{
                    left += 1;
                }

                if(Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum;
                }
            }
        }
        return result;
    }

    List<String> result = null;
    String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length()==0) return result;
        generatePossibilities(0,digits,new StringBuilder());
        return result;
    }

    void generatePossibilities(int length, String digits, StringBuilder currentPossibility){
        if(length == digits.length()){
            result.add(currentPossibility.toString());
            return;
        }
        char ch = digits.charAt(length);
        String str = mapping[ch-'0'];
        for (char c:str.toCharArray()){
            currentPossibility.append(c);
            generatePossibilities(length+1,digits,currentPossibility);
            currentPossibility.deleteCharAt(currentPossibility.length()-1);
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = new ListNode(0);
        list.next = head;

        ListNode slow = list;
        ListNode fast = list;

        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return list.next;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}