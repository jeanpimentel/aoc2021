class Day01(private val input: List<Int>) : Challenge() {

    override fun part1(): Int {
        return input
            .zipWithNext()
            .count { it.second > it.first }
    }

    override fun part2(): Int {
        return input
            .windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.second > it.first }
    }
}

fun main() = Day01(readInputAsInts("Day01")).run()