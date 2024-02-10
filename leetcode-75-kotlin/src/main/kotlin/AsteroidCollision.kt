import kotlin.math.absoluteValue

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size,
 * and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * @see <a href="https://leetcode.com/problems/asteroid-collision/">LeetCode</a>
 */
fun asteroidCollision(asteroids: IntArray): IntArray {
    val asteroidStack = mutableListOf<Int>()
    var index = 0
    while (index < asteroids.size) {
        asteroids[index].let { currentAsteroid ->
            if (asteroidStack.isEmpty() || currentAsteroid > 0 || asteroidStack.last() < 0) {
                asteroidStack.add(currentAsteroid)
                index++
            } else {
                val currentAsteroidSize = currentAsteroid.absoluteValue
                val lastAsteroidSize = asteroidStack.last()
                when {
                    currentAsteroidSize < lastAsteroidSize -> {
                        index++
                    }
                    currentAsteroidSize > lastAsteroidSize -> {
                        asteroidStack.removeLast()
                    }
                    else -> {
                        asteroidStack.removeLast()
                        index++
                    }
                }
            }
        }
    }
    return asteroidStack.toIntArray()
}
