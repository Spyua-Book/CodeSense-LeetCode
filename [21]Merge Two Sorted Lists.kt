package leetcode.editor.en._merge_two_sorted_lists

import leetcode.editor.en.common.ListNode


// [21]Merge Two Sorted Lists

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

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2

        val dummy = ListNode(-1)
        var current: ListNode? = dummy

        while (node1 != null && node2 != null) {
            if (node1.`val` < node2.`val`) {
                current?.next = node1
                node1 = node1.next
            } else {
                current?.next = node2
                node2 = node2.next
            }

            current = current?.next
        }
        current?.next = node1 ?: node2

        return dummy.next
    }

//    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//        printIndent(count++)
//        if (l1 == null) return l2
//        if (l2 == null) return l1
//
//        if (l1.`val` < l2.`val`) {
//            l1.next = mergeTwoLists(l1.next, l2)
//            printIndent(--count)
//            println("l1:l1 = ${l1.`val`}, l2 = ${l2.`val`}")
//            return l1
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next)
//            printIndent(--count)
//            println("l2:l1 = ${l1.`val`}, l2 = ${l2.`val`}")
//            return l2
//        }
//    }

    // 全局变量，记录递归函数的递归层数
    var count = 0

    // 输入 n，打印 n 个 tab 缩进
    fun printIndent(n: Int) {
        for (i in 0 until n) {
            print("   ")
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
