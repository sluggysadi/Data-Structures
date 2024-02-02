/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 10^5
 * s consist of printable ASCII characters.
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">LeetCode</a>
 */
fun reverseVowels(s: String): String {
    val stringAsArray = s.toCharArray()
    val setOfVowels = hashSetOf<Char>('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var startPointer = 0
    var endPointer = stringAsArray.lastIndex
    while (startPointer < endPointer) {
        while (startPointer <= stringAsArray.lastIndex && !setOfVowels.contains(stringAsArray[startPointer])) {
            startPointer++
        }
        while (endPointer >= 0 && !setOfVowels.contains(stringAsArray[endPointer])) {
            endPointer--
        }
        if (startPointer < endPointer) {
            val temp = stringAsArray[startPointer]
            stringAsArray[startPointer] = stringAsArray[endPointer]
            stringAsArray[endPointer] = temp
            startPointer++
            endPointer--
        }
    }
    return stringAsArray.concatToString()
}
