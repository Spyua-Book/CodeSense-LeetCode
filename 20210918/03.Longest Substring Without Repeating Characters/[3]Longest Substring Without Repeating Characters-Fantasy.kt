package leetcode.editor.en._longest_substring_without_repeating_characters

// [3]Longest Substring Without Repeating Characters

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var max = 0
        var hashSet = mutableSetOf<Char>()
        while (end < s.length) {
            if (!hashSet.contains(s[end])) {
                hashSet.add(s[end++])
                max = Math.max(max, hashSet.size)
            } else {
                hashSet.remove(s[start++])
            }
        }
        return max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
