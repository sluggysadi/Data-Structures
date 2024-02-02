/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">LeetCode</a>
 */
fun reverseWords(s: String): String {
    val reversedChars = cleanAndReverseString(s)
    reverseAllWords(reversedChars)
    return reversedChars.joinToString("")
}

private fun cleanAndReverseString(s: String): MutableList<Char> {
    val reversedChars = mutableListOf<Char>()
    for (index in s.lastIndex downTo 0) {
        if (!s[index].isWhitespace()) {
            reversedChars.add(s[index])
        } else if (reversedChars.lastOrNull()?.isWhitespace() == false) {
            reversedChars.add(s[index])
        }
    }
    if (reversedChars.last().isWhitespace()) reversedChars.removeLast()
    return reversedChars
}

private fun reverseAllWords(charList: MutableList<Char>) {
    var wordStart = 0
    var wordEnd = 0
    while (wordEnd < charList.size) {
        while (wordEnd < charList.size && !charList[wordEnd].isWhitespace()) wordEnd++
        reverseWord(wordStart, wordEnd - 1, charList)
        wordEnd++
        wordStart = wordEnd
    }
}

private fun reverseWord(start: Int, end: Int, chars: MutableList<Char>) {
    var left = start
    var right = end
    while (left < right) {
        val temp = chars[left]
        chars[left] = chars[right]
        chars[right] = temp
        left++
        right--
    }
}
