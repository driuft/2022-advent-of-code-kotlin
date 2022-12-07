import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        val inputList = input.map { it.toIntOrNull() }

        var currMax = 0
        var result = 0
        for (calories in inputList) {
            if (calories == null) {
                currMax = 0
            } else {
                currMax += calories
                result = max(currMax, result)
            }
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val inputList = input.map { it.toIntOrNull() }
        val calorieList = mutableMapOf<Int, Int>()

        var currGroup = 1
        var currMax = 0
        for (idx in inputList.indices) {
            if (inputList[idx] == null) {
                currGroup += 1
                currMax = 0
            } else {
                currMax += inputList[idx]!!
                calorieList[currGroup] = currMax
            }
        }

        val topThree = calorieList.values.sortedDescending().take(3)
        return topThree.sum()
    }

    val input = readInput("Day01")
    println(part2(input))
}
