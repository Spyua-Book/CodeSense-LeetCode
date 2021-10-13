package leetcode.editor.en._remove_nth_node_from_end_of_list

import leetcode.editor.en.common.ListNode

// [19]Remove Nth Node From End of List

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val start = ListNode(0) //Add this dummy start node
        var slowPointer: ListNode? = start
        var fastPointer: ListNode? = start
        start.next = head

        repeat(n + 1) { // Notice this range
            fastPointer = fastPointer?.next
        }

        while (fastPointer != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next
        }

        slowPointer?.next = slowPointer?.next?.next
        return start.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)


