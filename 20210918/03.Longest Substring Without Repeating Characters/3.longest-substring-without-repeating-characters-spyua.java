/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
 
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPosIndexMap =   new HashMap<Character, Integer>();
        int maxLength=0;
        int end=0, start=0;
        
        for(end=0; end<s.length() ; end++){

            char ch = s.charAt(end);
            
            if(charPosIndexMap.containsKey(ch))
                start = Math.max(charPosIndexMap.get(ch), start);

            maxLength = Math.max(maxLength, end-start + 1);
            charPosIndexMap.put(ch, end+1);
        }
        return maxLength;
    }
}



// @lc code=end

