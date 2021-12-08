import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.floor

class Day07(input: List<String>) : Challenge() {
    private val input: List<Int>

    init {
        this.input = input
            .first()
            .split(",")
            .map { it.toInt() }
            .sorted()
    }

    override fun part1(): Any {
        val median = if (input.size % 2 == 1) {
            input[input.size / 2]
        } else {
            (input[input.size / 2] + input[(input.size - 1) / 2]) / 2
        }

        val toMove = input.groupingBy { it }.eachCount().toMutableMap()
        toMove.remove(median)

        var fuel = 0;
        toMove.forEach { (position, crabs) ->
            fuel += (median - position).absoluteValue * crabs
        }

        return fuel
    }

    override fun part2(): Any {
        val fuels = mutableListOf<Long>()

        mutableListOf(
            floor(input.average()).toInt(),
            ceil(input.average()).toInt(),
        ).forEach { average ->

            val toMove = input.groupingBy { it }.eachCount().toMutableMap()
            toMove.remove(average)

            var fuel = 0L;
            toMove.forEach { (position, crabs) ->
                val movements = (average - position).absoluteValue
                val fuelPerCrab = (movements * (movements + 1)) / 2 // sum of integers
                fuel += fuelPerCrab * crabs
            }

            fuels.add(fuel)
        }

        return fuels.minOf { it }
    }
}

fun main() = Day07(readInput("Day07")).run()