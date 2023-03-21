const twoSum = (nums, target) => {
    let storage = {};

    for(let [index,num] of nums.entries()){
        if(storage[num] !== undefined) return [storage[num],index];
        storage[target-num] = index;
    }
};

const addTwoNumbers = (l1, l2) => {
    let p1 = l1,
        p2 = l2,
        num1 = 0,
        num2 = 0,
        carry = 0,
        solution = new ListNode(0),
        current = solution;

    while(p1 || p2){
        num1 = (p1) ? p1.val : 0;
        num2 = (p2) ? p2.val : 0;

        if(num1 + num2 + carry > 9){
            current.next = new ListNode(num1 + num2 + carry - 10);
            current = current.next;
            carry = 1;
        }else{
            carry = 0;
        }

        if(p1) p1 = p1.next;
        if(p2) p2 = p2.next;
    }
    if(carry) current.next = new ListNode(carry);
    return solution.next;
};

const lengthOfLongestSubstring = (s) => {
    let map = {};
    let maxLength = 0;
    let start = 0;

    for (let end = 0; end < s.length; end++) {
        let lastChar = s[end];
        if(map[lastChar] === undefined){
            map[lastChar] = 0;
        }
        map[lastChar] += 1;
        while (map[lastChar] > 1){
            let firstChar = s[start];
            map[firstChar] -= 1;
            start += 1;
        }
        maxLength = Math.max(maxLength, end - start + 1)
    }
    return maxLength;
};

const lengthOfLongestSubstring2 = (s) => {
    let haveCharMap = {};
    let maxLength = 0;
    let start = 0;

    for (let end = 0; end < s.length; end++) {
        let lastChar = s[end];
        if(lastChar in haveCharMap){
            start = Math.max(start,haveCharMap[lastChar] + 1);
        }
        haveCharMap[lastChar] = end;
        maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
};

const findMedianSortedArrays = (nums1, nums2) => {
    let concat = nums1.concat(nums2);
    concat = concat.sort(function (a,b){return a-b});
    const length = concat.length;

    if(length%2 === 1){
        return concat[(length/2)-.5];
    }else{
        return (concat[(length/2)]+concat[(length/2)-1])/2;
    }
};

const longestPalindrome = (s) => {
    if(s.length < 1 || s === null) return "";

    let longest = "";

    for (let i = 0; i < s.length; i++) {
        let addPalindrome = expandFromCenter(s,i,i);
        let evenPalindrome = expandFromCenter(s,i-1,i);

        if(addPalindrome.length > longest.length){
            longest = addPalindrome;
        }
        if (evenPalindrome.length > longest.length){
            longest = evenPalindrome;
        }
    }
    return longest;
};

function expandFromCenter(s,left,right){
    let i = 0;
    while (s[left - i] && s[left - i] === s[right + i]){
        i ++;
    }
    i--;

    return s.slice(left - i, right + i + 1);
};

const convert = (s, numRows) => {
    if(numRows === 1 || s.length < numRows) return s;

    let direction = false;
    let count = 0;
    let arr = new Array(numRows).fill("");

    for (let i = 0; i < s.length; i++) {

        let curr = s[i];

        arr[count] += curr;
        if(count === 0 || count >= numRows -1) direction = !direction
        direction ? count ++ : count --;
    }
    return arr.join("");
};

const reverse = x => {
    let y = Math.abs(x);
    let result = 0;
    while(y !== 0){
        result = result * 10 + y % 10;
        y = parseInt(y / 10);
    }
    x > 0 ? result = result : result = -result;
    if(result > 2147483648 || result < -2147483649) return 0;
    return result;
};

const myAtoi = s => {
    let result = 0
    let sign = 1
    let isNonWhiteSpaceMet = false
    let isNumberPhase = false

    for (let i = 0; i < s.length; i++) {
        const char = s[i]
        if (char === ' ') {
            if (!isNonWhiteSpaceMet) {
                continue
            } else {
                break
            }
        }
        isNonWhiteSpaceMet = true

        if (char >= '0' && char <= '9') {
            isNumberPhase = true
            result = result * 10 + (char - '0')
            continue
        }

        if (char === '+' && !isNumberPhase) {
            isNumberPhase = true
            continue
        }

        if (char === '-' && !isNumberPhase) {
            isNumberPhase = true
            sign *= -1
            continue
        }

        break
    }
    result *= sign
    return Math.min(Math.max(-(2 ** 31), result), 2**31 - 1)
};

const isPalindrome = x => {
    let reversed = x.toString().split('').reverse().join('');
    return (x.toString() === reversed);
};

const isPalindrome2 = x => {
    let reversedStr = '';
    let xStr = x.toString();

    for (let i of xStr) {
        reversedStr = i + reversedStr;
    }
    return(reversedStr === xStr)
};

const isMatch = (s, p) =>{
    const check = (s, p, i, j) => {
        if (j > p.length - 1) {
          return i > s.length - 1;
        }
        
        const isNextQuantiyModifier = p[j + 1] === '*';
        
        if (!isNextQuantiyModifier) {
          if ([s[i], '.'].includes(p[j])) {
            return i < s.length && check(s, p, i + 1, j + 1);
          } else {
            return false;
          }
        } else {
          if ([s[i], '.'].includes(p[j])) {
            return check(s, p, i, j + 2) || (i < s.length && check(s, p, i + 1, j));
          } else {
            return check(s, p, i, j + 2);
          }
        }
        
      }
      
      return check(s, p, 0, 0);
};

const maxArea2 = height =>{
    let firstMax = 0;
    let secondMax = 0;
    let firstMaxPosition;
    let secondMaxPosition;

    for (let i = 0; i < height.length; i++) {
        if(firstMax < height[i]){
            firstMax = height[i];
        }
        if(height.length == i + 1){
            firstMaxPosition = height.indexOf(firstMax);
            for (let i = 0; i < height.length; i++) {
                if(secondMax < height[i] && i != firstMaxPosition){
                    secondMax = height[i];
                }
                if(height.length == i + 1){
                    secondMaxPosition = height.indexOf(secondMax);
                    if(secondMaxPosition > firstMaxPosition){
                        let maxAreaBetween = secondMaxPosition * (secondMaxPosition - firstMaxPosition);
                        return maxAreaBetween;
                    }else if(secondMaxPosition > firstMaxPosition){
                        let maxAreaBetween = firstMaxPosition * (secondMaxPosition - firstMaxPosition);
                        return maxAreaBetween;
                    }
                }
            }
        } 
    }
};

const maxArea = (height) => {
    let firstMax = 0;
    let secondMax = height.length - 1;
    let maxAreaBetween = 0;

    while(firstMax < secondMax) {
        maxAreaBetween = Math.max(maxAreaBetween, 
                                   Math.min(height[secondMax], height [firstMax]) * (secondMax - firstMax) );
        if(height[firstMax] < height[secondMax]) {
            firstMax++;
        } else {
            secondMax--;
        }
    }
    return maxAreaBetween;
}

const intToRoman = (num) =>{
    let values = [1000,900,500,400,100,90,50,40,10,9,5,4,1];
    let roman = ["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"];
    let romanVersion = "";

    for (let i = 0; num; i++)
        while (num >= values[i]) romanVersion += roman[i], num -= values[i]
    return romanVersion;  
};

const romanToInt = (s) =>{
    romanSymbols = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    };

    value = 0;
    for(let i = 0; i < s.length; i+=1){
        romanSymbols[s[i]] < romanSymbols[s[i+1]] ? value -= romanSymbols[s[i]]: value += romanSymbols[s[i]];
    }
    return value;
};

const longestCommonPrefix = (strs) =>{
    let prefix = '';
    if (strs.length === 1) return strs[0];
    for (let i = 0; i < strs[0].length; i++) {
        let char = strs[0][i];
        if (char && strs.every((s) => s[i] == char)) {
            prefix += char;
        } else {
            return prefix;
        }
    }
    return prefix;
};

const threeSum2 = (nums) => {
    nums.sort((a,b)=>a-b);
    const values = [];
    for (let i = 0; i < nums.length; i++) {
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }
        for (let ic = i + 1; ic < nums.length; ic++) {
            if(ic>i+1 && nums[ic] == nums[ic-1]){
                continue;
            }
            for (let j = ic + 1; j < nums.length; j++) {
                if(j>ic+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if(nums[i] + nums[ic] + nums[j] == 0){
                    values.push([nums[i],nums[ic],nums[j]])
                }
            }
        }
    }
    return values;
};

const threeSum = (nums) => {
    nums.sort((a,b)=>a-b);
    const values = [];
    for (let i = 0; i < nums.length; i++) {
        if(i>0 && nums[i] === nums[i-1]) continue;
        const targetValue = 0 - nums[i];
        let leftValue = i + 1;
        let rightValue = nums.length - 1;
        while (rightValue > leftValue){
            const sum = nums[leftValue] + nums[rightValue];
            if(sum > targetValue){
                rightValue--;
            }else if(sum < targetValue){
                leftValue++;
            }else{
                values.push([nums[i],nums[leftValue],nums[rightValue]]);
                while (nums[leftValue] === nums[leftValue + 1]) leftValue++;
                while (nums[rightValue] === nums[rightValue - 1]) rightValue--;
                leftValue++;
                rightValue--;
            }
        }
    }
    return values;
};

const threeSumClosest = (nums, target) => {
    nums = nums.sort((a, b) => a - b);
    let result = Infinity;

    for (let i = 0; i < nums.length-2; i++) {
        let left = i+1;
        let right = nums.length-1;
        while (left < right){
            let sum = nums[i] + nums[left] + nums[right];
            if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            if (sum > target){
                right--;
            }else{
                left++;
            }
        }
    }
    return result;
};

const letterCombinations2 = (digits) => {
    if (!digits) return [];
    let letters = [0,1,['a','b','c'],['d','e','f'],['g','h','i'],['j','k','l'],['m','n','o'],['p','q','r','s'],['t','u','x'],['w','x','y','z']];
    let possibilities = [''];

    for(let digit of digits){
        let currentPossibility = [];
        for (let letter of letters[+digit]){
            currentPossibility = currentPossibility.concat(possibilities.map(word => word + letter));
        }
        possibilities = currentPossibility;
    }
    return possibilities;
};


const letterCombinations = (digits) => {
    if (!digits) return [];

    const alphabet = {
        2: ['a', 'b', 'c'],
        3: ['d', 'e', 'f'],
        4: ['g', 'h', 'i'],
        5: ['j', 'k', 'l'],
        6: ['m', 'n', 'o'],
        7: ['p', 'q', 'r', 's'],
        8: ['t', 'u', 'v'],
        9: ['w', 'x', 'y', 'z']
    };
    const result = [];
    const combination = (str, digitsInUse) => {
        if (digitsInUse == digits.length) {
            result.push(str);
            return;
        }
        const letters = alphabet[digits[digitsInUse]];
        for (const letter of letters) {
            combination(str + letter, digitsInUse + 1);
        }
    }

    combination('', 0);
    return result;
};

const fourSum = (nums, target) => {
    nums.sort((a, b) => a - b);
    const result = []

    for(let i = 0; i < nums.length - 3; i++) {
        for(let j = i + 1; j < nums.length - 2; j++) {
            let lower = j + 1;
            let higher = nums.length - 1;

            while(lower < higher) {
                const sum = nums[i] + nums[j] + nums[lower] + nums[higher];
                if(sum === target) {
                    result.push([nums[i], nums[j], nums[lower], nums[higher]])
                    while(nums[lower] === nums[lower + 1]) lower++;
                    while(nums[higher] === nums[higher - 1]) higher--;
                    lower++;
                    higher--;
                } else if(sum < target) {
                    lower++;
                } else {
                    higher--;
                }
            }
            while(nums[j] === nums[j + 1]) j++;
        }
        while(nums[i] === nums[i + 1]) i++;
    }
    return result
};

const removeNthFromEnd = (head, n) => {
    let list = new ListNode(0);
    list.next = head;
    let slow = list;
    let fast = list;

    for (let i = 0; i <= n; i++) {
        fast = fast.next;
    }

    while (fast) {
        slow = slow.next;
        fast = fast.next;
    }

    slow.next = slow.next.next;
    return list.next;
};

const mergeTwoLists = (list1, list2) => {
    if(!list1 || !list2) return list1 || list2;
    if(list1.val < list2.val){
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
    list2.next = mergeTwoLists(list1, list2.next);
    return list2;
};

const generateParenthesis = (n) => {
    let parenthesisArray = [];
    getTogether(n, n, '');

    function getTogether(left, right, str) {
        if (!left && !right && str.length) return parenthesisArray.push(str);
        if (left) getTogether(left - 1, right, str + '(');
        if (right > left) getTogether(left, right - 1, str + ')');
    }
    return parenthesisArray;
};

const mergeKLists = (lists) => {
    const k = lists.length;
    let minimum = lists[0], minimumIndex = 0;

    for (let i = 0; i < k; i++) {
        if (!minimum || (lists[i] && minimum.val > lists[i].val)) {
            minimum = lists[i];
            minimumIndex = i;
        }
    }

    if (!lists[minimumIndex]) {
        return null;
    }

    lists[minimumIndex] = lists[minimumIndex].next;
    minimum.next = mergeKLists(lists);
    return minimum;
};

const swapPairs = (head) => {
    if(!head || !head.next){
        return head;
    }
    let n1 = head, n2 = head.next, n3 = n2.next;
    n2.next = n1;
    n1.next = swapPairs(n3);
    return n2;
};

const swapPairs2 = (head) => {
    if (!head || !head.next) {
        return head;
    }
    let curr = head;
    while (curr && curr.next) {
        let nextVal = curr.next.val;

        curr.next.val = curr.val;
        curr.val = nextVal;

        curr = curr.next.next;
    }
    return head;
};

const countOdds = (low, high) => {
    let oddNumbers = Math.round((high-low) / 2);//
    return low % 2 === 1 && high % 2 === 1 ? oddNumbers+1 : oddNumbers;
};

const average = (salary) => {
    let maximumSalary = Math.max(...salary);
    let minimumSalary = Math.min(...salary);
    let totalSalary = salary.reduce((a,b) => a + b);

    totalSalary -= maximumSalary;
    totalSalary -= minimumSalary;

    return totalSalary / (salary.length - 2);
};

const hammingWeight = (n) => {
    let numberBits = 0;
    for (const c of n) {
        numberBits  += 1;
    }
    return numberBits;
};