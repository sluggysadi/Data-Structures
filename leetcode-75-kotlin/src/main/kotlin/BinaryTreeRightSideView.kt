import commonclasses.TreeNode

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">LeetCode</a>
 */
fun rightSideView(root: TreeNode?): List<Int> {
    val resultList = mutableListOf<Int>()
    rightMostElement(root, 0, resultList)
    return resultList
}

private fun rightMostElement(node: TreeNode?, depth: Int, resultList: MutableList<Int>) {
    if (node != null) {
        if (depth == resultList.size) {
            resultList.add(node.`val`)
        }
        rightMostElement(node.right, depth + 1, resultList)
        rightMostElement(node.left, depth + 1, resultList)
    }
}
