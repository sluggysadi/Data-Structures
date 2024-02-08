/**
 * Given a 0-indexed n x n integer matrix grid,
 * return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 10^5
 * @see <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">LeetCode</a>
 */
fun equalPairs(grid: Array<IntArray>): Int {
    val rowMap = mutableMapOf<List<Int>, Int>()
    val columnMap = mutableMapOf<List<Int>, Int>()
    for (rowNumber in grid.indices) {
        val rowList = mutableListOf<Int>()
        for (columnNumber in grid[rowNumber].indices) {
            rowList.add(grid[rowNumber][columnNumber])
        }
        rowMap[rowList] = 1 + rowMap.getOrDefault(rowList, 0)
    }
    for (columnNumber in grid[0].indices) {
        val columnList = mutableListOf<Int>()
        for (rowNumber in grid.indices) {
            columnList.add(grid[rowNumber][columnNumber])
        }
        columnMap[columnList] = 1 + columnMap.getOrDefault(columnList, 0)
    }
    var result = 0
    rowMap.forEach { row, rowFrequency ->
        result += rowFrequency * columnMap.getOrDefault(row, 0)
    }
    return result
}
