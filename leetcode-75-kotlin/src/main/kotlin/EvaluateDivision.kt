/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries,
 * where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid.
 * You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined,
 * so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]],
 * values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]],
 * values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 * @see <a href="https://leetcode.com/problems/evaluate-division/">LeetCode</a>
 */
fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val equationGraph = buildEquationGraph(equations, values)

    return queries.mapNotNull { query ->
        evaluateQuery(query[0], query[1], equationGraph, HashSet())
    }.toDoubleArray()
}

/**
 * This function builds a graph representation of the equations.
 * Each node represents a variable, and each edge represents an equation.
 */
private fun buildEquationGraph(
    equations: List<List<String>>,
    values: DoubleArray,
): Map<String, MutableMap<String, Double>> {
    return equations.withIndex().fold(mutableMapOf()) { graph, (index, equation) ->
        val (dividend, divisor) = equation
        graph.apply {
            this.getOrPut(dividend) { mutableMapOf() }[divisor] = values[index]
            this.getOrPut(divisor) { mutableMapOf() }[dividend] = 1.0 / values[index]
        }
    }
}

/**
 * This function evaluates a query using depth-first search on the equation graph.
 */
private fun evaluateQuery(
    startVariable: String,
    endVariable: String,
    equationGraph: Map<String, MutableMap<String, Double>>,
    visitedVariables: MutableSet<String>,
): Double {
    // If the start variable is not in the graph, return -1.0
    if (!equationGraph.containsKey(startVariable)) return -1.0

    // If the start variable is the same as the end variable, return 1.0
    if (startVariable == endVariable) return 1.0

    visitedVariables.add(startVariable)

    equationGraph[startVariable]?.let { neighbors ->
        for ((neighbor, value) in neighbors) {
            if (!visitedVariables.contains(neighbor)) {
                val product = evaluateQuery(neighbor, endVariable, equationGraph, visitedVariables)
                if (product != -1.0) {
                    return value * product
                }
            }
        }
    }

    return -1.0
}
