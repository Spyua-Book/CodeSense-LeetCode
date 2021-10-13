package leetcode.editor.en._two_sum

// [1]Two Sum

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 因為是要回傳 index，不能用 sort 完，回傳 index
//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        nums.sort()
//        var start = 0
//        var end = nums.size - 1
//        while (start < end) {
//            val sum = nums[start] + nums[end]
//            if (sum < target) {
//                start++
//            } else if (sum > target) {
//                end--
//            } else if (sum == target) {
//                return intArrayOf(start, end)
//            }
//        }
//
//        return intArrayOf()
//    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numForIndex = mutableMapOf<Int, Int>()
        for (index in nums.indices) {
            val potentialNum = target - nums[index]
            if (numForIndex.containsKey(potentialNum)) {
                return intArrayOf(index, numForIndex[potentialNum]!!)
            } else {
                numForIndex[nums[index]] = index
            }
        }
        return intArrayOf()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
