/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character,
 * and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 10^5
 * word1 and word2 contain only lowercase English letters.
 * @see <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">LeetCode</a>
 */
fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val frequencyArray1 = IntArray(26)
    val frequencyArray2 = IntArray(26)
    word1.forEach { char ->
        frequencyArray1[char - 'a'] = 1 + frequencyArray1[char - 'a']
    }
    word2.forEach { char ->
        frequencyArray2[char - 'a'] = 1 + frequencyArray2[char - 'a']
    }

    val frequencyOfFrequencyMap1 = mutableMapOf<Int, Int>()
    val frequencyOfFrequencyMap2 = mutableMapOf<Int, Int>()

    for ((index, frequency1) in frequencyArray1.withIndex()) {
        if (frequency1 != 0 && frequencyArray2[index] == 0) {
            return false
        } else {
            val frequency2 = frequencyArray2[index]
            frequencyOfFrequencyMap1[frequency1] = 1 + frequencyOfFrequencyMap1.getOrDefault(frequency1, 0)
            frequencyOfFrequencyMap2[frequency2] = 1 + frequencyOfFrequencyMap2.getOrDefault(frequency2, 0)
        }
    }

    if (frequencyOfFrequencyMap1.size != frequencyOfFrequencyMap2.size) {
        return false
    }
    frequencyOfFrequencyMap1.entries.forEach { entry ->
        if (!frequencyOfFrequencyMap2.contains(entry.key) || entry.value != frequencyOfFrequencyMap2[entry.key]) {
            return false
        }
    }

    return true
}
