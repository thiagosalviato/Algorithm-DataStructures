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

const maxArea = height =>{
    
};