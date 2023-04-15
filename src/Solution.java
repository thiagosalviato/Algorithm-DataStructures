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

    public List<String> generateParenthesis(int n) {
        List<String> parenthesisArray = new ArrayList<>();
        getTogether(n, n, parenthesisArray, "");
        return parenthesisArray;
    }

    private void getTogether(int left, int right, List<String> parenthesisArray, String s) {
        if (left == 0 && right == 0) parenthesisArray.add(s);
        else {
            if (left > 0) getTogether(left - 1, right, parenthesisArray, s + "(");
            if (right > left) getTogether(left, right - 1, parenthesisArray, s + ")");
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while(point.next != null && point.next.next != null){
            ListNode n1 = point.next;
            ListNode n2 = point.next.next;
            point.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            point = n1;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;

            curr = curr.next.next;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        int iterations = (size / k) - 1;

        ListNode middleNode = new ListNode(-1, head);
        ListNode currentHead = middleNode;
        ListNode result = null;
        int i = 0;
        while(i <= iterations) {
            currentHead = currentHead.next;
            for (int j = 1; j < k; j++) {
                ListNode temp = currentHead.next;
                currentHead.next = temp.next;
                temp.next = middleNode.next;;
                middleNode.next = temp;
            }
            if (i == 0)
                result = middleNode.next;
            middleNode = currentHead;
            i++;
        }

        return result;
    }

    public int countOdds(int low, int high) {
        int numbers=high-low+1;
        if(low % 2 !=0 && high % 2 != 0){
            return numbers/2 + 1;
        }else {
            return numbers/2;
        }
    }

    public double average(int[] salary) {
        double salarySum=0;
        double maximumSalary=0;
        double minimumSalary=Integer.MAX_VALUE;

        for(int i=0;i<salary.length;i++){
            salarySum+=salary[i];
            if(maximumSalary<salary[i]){
                maximumSalary=salary[i];
            }
            if(minimumSalary>salary[i]){
                minimumSalary=salary[i];
            }
        }

        return (double)((salarySum-minimumSalary-maximumSalary)/(double)(salary.length-2.0));
    }

    public int subtractProductAndSum(int n){
        int sum = 0;
        int product = 1;

        while(n > 0){
            sum += (n % 10);
            product *= (n % 10);
            n /= 10;
        }

        return product - sum;
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i>1; i--){
            if(nums[i] < nums[i-1] + nums[i-2]){
                return  nums[i] + nums[i-1]+ nums[i-2];
            }
        }
        return 0;
    }

    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                negativeCount++;
            }
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }

    int signFunc(int n) {
        return n == 0 ? 0 : n < 0 ? -1 : 1;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            while (n > 0) {
                int numberDigit = n % 10;
                sum += numberDigit * numberDigit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public int[] nextGreaterElement(int[] numsToFind, int[] nums) {
        int[] greaterMap = new int[10001];
        int[] stack = new int[10001];
        int top = 0;
        stack[top++] = Integer.MAX_VALUE;
        for(int currentNum: nums){
            while(stack[top-1] < currentNum) {
                greaterMap[stack[--top]] = currentNum;
            }
            stack[top++] = currentNum;
        }
        for(int i=0; i<numsToFind.length; i++) {
            numsToFind[i] = (greaterMap[numsToFind[i]] == 0) ? -1 : greaterMap[numsToFind[i]];
        }
        return numsToFind;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int deltaY = coordinates[1][1] - coordinates[0][1];
        int deltaX = coordinates[1][0] - coordinates[0][0];

        for(int i = 2; i < coordinates.length; i++) {
            int deltaY2 = coordinates[i][1] - coordinates[i - 1][1];
            int deltaX2 = coordinates[i][0] - coordinates[i - 1][0];

            if(deltaY * deltaX2 != deltaX * deltaY2) {
                return false;
            }
        }
        return true;
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public int sumOddLengthSubarrays(int[] nums) {
        int sum = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int subarrayCount = ((i + 1) * (length - i) + 1) / 2;
            int subarraySum = nums[i] * subarrayCount;
            sum += subarraySum;
        }
        return sum;
    }

}