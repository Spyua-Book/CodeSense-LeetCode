package leetcode.editor.en.common

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


object ProvideTreeNode {
    //   1
    //  2  3
    // 4 5 6 7
    fun provideBinaryTree(): TreeNode {
        val head = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)
        val node7 = TreeNode(7)

        head.left = node2
        head.right = node3

        node2.left = node4
        node2.right = node5

        node3.left = node6
        node3.right = node7
        return head
    }
}