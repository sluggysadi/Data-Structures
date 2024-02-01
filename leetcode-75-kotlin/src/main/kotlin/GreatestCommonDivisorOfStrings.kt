/**
 * For two strings s and t,
 * we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 * @see <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">LeetCode</a>
 */
fun gcdOfStrings(str1: String, str2: String): String {
    if (str1 + str2 != str2 + str1) {
        return ""
    }
    return str1.substring(0, gcd(str1.length, str2.length))
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
