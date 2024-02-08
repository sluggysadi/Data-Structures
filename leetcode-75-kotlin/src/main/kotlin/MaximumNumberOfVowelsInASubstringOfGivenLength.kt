/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 * @see <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">LeetCode</a>
 */
fun maxVowels(s: String, k: Int): Int {
    val setOfVowels = setOf('a', 'e', 'i', 'o', 'u')
    var currentVowelCount = 0
    var startIndex = 0
    var endIndex = k
    for (index in 0 until endIndex) {
        if (s[index] in setOfVowels) {
            currentVowelCount++
        }
    }
    var maxVowelCount = currentVowelCount
    while (endIndex < s.length) {
        if (s[endIndex++] in setOfVowels) currentVowelCount++
        if (s[startIndex++] in setOfVowels) currentVowelCount--
        maxVowelCount = maxOf(maxVowelCount, currentVowelCount)
    }
    return maxVowelCount
}
