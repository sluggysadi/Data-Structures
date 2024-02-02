/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * @see <a href="https://leetcode.com/problems/can-place-flowers/">LeetCode</a>
 */
fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var remainingFlowers = n

    for (index in 0 until flowerbed.size) {
        if (remainingFlowers == 0) return true
        if (flowerbed[index] == 0
            && (index == 0 || flowerbed[index - 1] == 0)
            && (index == flowerbed.lastIndex || flowerbed[index + 1] == 0)
        ) {
            flowerbed[index] = 1
            remainingFlowers--
        }
    }

    return remainingFlowers == 0
}
