class Day06(input: List<String>) : Challenge() {
    private val input: List<Int>

    init {
        this.input = input
            .first()
            .split(",")
            .map { it.toInt() }
            .toMutableList()
    }

    override fun part1(): Any {
        val days = 80
        val fishes = input.toMutableList()

        for (i in 1..days) {
            var toAdd = 0;

            fishes.forEachIndexed { index, value ->
                if (value == 0) {
                    toAdd++;
                    fishes[index] = 6
                } else {
                    fishes[index] = (value - 1)
                }
            }

            fishes.addAll(MutableList(toAdd) { 8 })
        }

        return fishes.size
    }

    override fun part2(): Any {
        val days = 256

        val counter: MutableMap<Int, Long> = mutableMapOf(
            0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0, 8 to 0,
        )

        // Initial population
        input.forEach { i -> counter[i] = counter[i]!! + 1 }

        for (i in 1..days) {
            val newFishes = counter[0]!!

            (1..8).forEach { counter[it - 1] = counter[it]!! }

            // 0's that have changed to 6
            counter[6] = counter[6]!! + newFishes;

            counter[8] = newFishes;
        }

        return counter.values.sum()
    }
}

fun main() = Day06(readInput("Day06")).run()