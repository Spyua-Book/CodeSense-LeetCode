package leetcode.editor.en.three_sum

// [15]3Sum

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val triplet = mutableListOf<List<Int>>()
        nums.sort()

        if (nums.isNotEmpty() && nums[0] > 0) return triplet

        for (index in nums.indices) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue
            }
            var lo = index + 1
            var hi = nums.size - 1

            while (lo < hi) {
                val left = nums[lo]
                val right = nums[hi]
                val sum = nums[index] + left + right
                if (sum < 0) {
                    while (lo < hi && nums[lo] == left) lo++
                } else if (sum > 0) {
                    while (lo < hi && nums[hi] == right) hi--
                } else if (sum == 0) {
                    triplet.add(listOf(nums[index], left, right))
                    while (lo < hi && nums[lo] == left) lo++
                    while (lo < hi && nums[hi] == right) hi--
                }
            }
        }
        return triplet
    }


//    fun threeSum(nums: IntArray): List<List<Int>> {
//        val triplets = mutableListOf<List<Int>>()
//        nums.sort()
//
//        if (nums.isNotEmpty() && nums[0] > 0) return triplets
//
//        for (index in nums.indices) {
//            if (index > 0 && nums[index] == nums[index - 1]) {// skip same result
//                continue
//            }
//            var lo = index + 1
//            var hi = nums.size - 1
//            while (lo < hi) {
//                val sum = nums[index] + nums[lo] + nums[hi]
//                val left = nums[lo]
//                val right = nums[hi]
//                if (sum == 0) {
//                    triplets.add(listOf(nums[index], nums[lo], nums[hi]))
//                    while (lo < hi && nums[lo] == left) lo++
//                    while (lo < hi && nums[hi] == right) hi--
//                } else if (sum > 0) {
//                    while (lo < hi && nums[hi] == right) hi--
//                } else if (sum < 0) {
//                    while (lo < hi && nums[lo] == left) lo++
//                }
//            }
//
//        }
//        return triplets
//    }


//    fun threeSum(nums: IntArray): List<List<Int>> {
//        val triplets = mutableListOf<MutableList<Int>>()
//        nums.sort()
//
////        if (nums.isNotEmpty() && nums[0] > 0) return triplets
//        for (i in nums.indices) {
//            if (i > 0 && nums[i] == nums[i - 1]) {// skip same result
//                continue
//            }
//            var start = i + 1
//            var end = nums.size - 1
//
//            while (start < end) {
//                val tempSum = nums[i] + nums[start] + nums[end]
//                when {
//                    tempSum == 0 -> {
//                        triplets.add(mutableListOf(nums[i], nums[start], nums[end]))
//                        start++
//                        end--
//                        while (start < end && nums[start] == nums[start - 1]) start++;  // skip same result
//                        while (start < end && nums[end] == nums[end + 1]) end--;  // skip same result
//                    }
//                    tempSum < 0 -> {
//                        start++
//                    }
//                    else -> {
//                        end--
//                    }
//                }
//            }
//        }
//
//        return triplets
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
