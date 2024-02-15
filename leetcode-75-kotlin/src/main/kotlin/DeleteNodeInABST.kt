import commonclasses.TreeNode

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -10^5 <= key <= 10^5
 *
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
 *
 *
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-bst/">LeetCode</a>
 */
fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    root?.let { rootNode ->
        when {
            key < rootNode.`val` -> rootNode.left = deleteNode(rootNode.left, key)
            key > rootNode.`val` -> rootNode.right = deleteNode(rootNode.right, key)
            else -> {
                if (rootNode.left == null) {
                    return rootNode.right
                } else {
                    rootNode.right?.let { rightNode ->
                        rootNode.`val` = minNode(rightNode).`val`
                        rootNode.right = deleteNode(rightNode, rootNode.`val`)
                    } ?: return rootNode.left
                }
            }
        }
    }
    return root
}

private fun minNode(node: TreeNode): TreeNode {
    return node.left?.let {
        minNode(it)
    } ?: node
}
