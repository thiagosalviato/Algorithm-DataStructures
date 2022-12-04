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

const lengthOfLongestSubstring = (s) => {
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
    var length = concat.length;

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



































