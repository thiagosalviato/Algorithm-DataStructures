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