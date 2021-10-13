package leetcode.editor.en._container_with_most_water

// [11]Container With Most Water

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxArea(height: IntArray): Int {
        var start = 0
        var end = height.size - 1
        var maxArea = 0
        while (start < end) {
            val interval = end - start
            val area = interval * Math.min(height[end], height[start])
            maxArea = Math.max(area, maxArea)

            if (height[end] > height[start]) {
                start++
            } else {
                end--
            }
        }
        return maxArea
    }
}
//leetcode submit region end(Prohibit modification and deletion)
