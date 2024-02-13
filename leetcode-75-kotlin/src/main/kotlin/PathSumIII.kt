import commonclasses.TreeNode

/**
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
 * @see <a href="https://leetcode.com/problems/path-sum-iii/">LeetCode</a>
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
fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if (root == null) return 0
    return pathsFrom(root, targetSum.toLong()) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
}

private fun pathsFrom(node: TreeNode?, targetSum: Long): Int {
    if (node == null) return 0
    return (if (node.`val`.toLong() == targetSum) 1 else 0) +
        pathsFrom(node.left, targetSum - node.`val`) +
        pathsFrom(node.right, targetSum - node.`val`)
}
