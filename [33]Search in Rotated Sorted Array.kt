package leetcode.editor._search_in_rotated_sorted_array

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size - 1

        while (startIndex <= endIndex) {
            val mediumIndex = (startIndex + endIndex) / 2
            if (nums[mediumIndex] == target) return mediumIndex

            if (nums[startIndex] <= nums[mediumIndex]) {// left side order continually
                if (target >= nums[startIndex] && target < nums[mediumIndex]) {// in the left
                    endIndex = mediumIndex - 1
                } else { // in the right
                    startIndex = mediumIndex + 1
                }
            } else { // Right side order continually
                if (target > nums[mediumIndex] && target <= nums[endIndex]) {// in the left
                    startIndex = mediumIndex + 1
                } else { // in the right
                    endIndex = mediumIndex - 1
                }
            }
        }
        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
