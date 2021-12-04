class Day02(input: List<String>) : Challenge() {
    private val input: List<Pair<String, Int>>

    init {
        this.input = input.map { it -> it.split(" ").let { Pair(it[0], it[1].toInt()) } }
    }

    override fun part1(): Int {
        var horizontal = 0
        var depth = 0

        for ((command, units) in input) {
            when (command) {
                "forward" -> horizontal += units
                "up" -> depth -= units
                "down" -> depth += units
            }
        }

        return horizontal * depth
    }

    override fun part2(): Any {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for ((command, units) in input) {
            when (command) {
                "forward" -> {
                    horizontal += units
                    depth += aim * units
                }
                "up" -> aim -= units
                "down" -> aim += units
            }
        }

        return horizontal * depth
    }
}

fun main() = Day02(readInput("Day02")).run()