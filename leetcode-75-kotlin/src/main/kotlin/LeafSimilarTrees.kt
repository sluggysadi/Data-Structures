import commonclasses.TreeNode

/**
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 * @see <a href="https://leetcode.com/problems/leaf-similar-trees/">LeetCode</a>
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leafNodes1 = mutableListOf<Int>()
    val leafNodes2 = mutableListOf<Int>()
    extractLeaves(root1, leafNodes1)
    extractLeaves(root2, leafNodes2)

    return leafNodes1 == leafNodes2
}

private fun extractLeaves(node: TreeNode?, leafNodes: MutableList<Int>) {
    if (node == null) {
        return
    } else if (node.left == null && node.right == null) {
        leafNodes.add(node.`val`)
    } else {
        extractLeaves(node.left, leafNodes)
        extractLeaves(node.right, leafNodes)
    }
}
