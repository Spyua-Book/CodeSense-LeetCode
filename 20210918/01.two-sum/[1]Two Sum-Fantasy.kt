package leetcode.editor.en._two_sum

// [1]Two Sum

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = mutableMapOf<Int, Int>()
        for (index in nums.indices) {
            val potentialNum = target - nums[index]
            if (hashMap.containsKey(potentialNum)) {
                return intArrayOf(hashMap[potentialNum]!!, index)
            } else {
                hashMap[nums[index]] = index
            }
        }
        return intArrayOf()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
