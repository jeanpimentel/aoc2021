class Day03(input: List<String>) : Challenge() {
    private val input: List<IntArray>

    init {
        this.input = input.map { it.map(Character::getNumericValue).toIntArray() }
    }

    override fun part1(): Any {
        val bitLength = input.first().size
        val bitCounter = List(bitLength) { mutableListOf(0, 0) } /* bit n -> (counter 0, counter 1) */
        val gamma = MutableList(bitLength) { 0 }
        val epsilon = MutableList(bitLength) { 0 }

        input.forEach { bits ->
            bits.indices.forEach { i -> bitCounter[i][bits[i]] += 1 }
        }

        bitCounter.forEachIndexed { index, counter ->
            gamma[index] = if (counter[0] > counter[1]) 0 else 1
            epsilon[index] = if (counter[0] < counter[1]) 0 else 1
        }

        val gammaAsInt = gamma
            .joinToString("")
            .toInt(2)

        val epsilonAsInt = epsilon
            .joinToString("")
            .toInt(2)

        return gammaAsInt * epsilonAsInt
    }

    override fun part2(): Any {
        val oxygenGeneratorRating = filter(input, FilterCriteria.MOST_COMMON)
            .joinToString("")
            .toInt(2)

        val co2ScrubberRating = filter(input, FilterCriteria.LEAST_COMMON)
            .joinToString("")
            .toInt(2)

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun filter(inputList: List<IntArray>, filterCriteria: FilterCriteria): IntArray {
        var filteredList = inputList
        var position = 0

        while (filteredList.size > 1) {
            val bitCounter = mutableListOf(0, 0)  /* (counter 0, counter 1) */
            filteredList.forEach { bits -> bitCounter[bits[position]] += 1 }

            val filterValue = when (filterCriteria) {
                FilterCriteria.MOST_COMMON -> if (bitCounter[1] >= bitCounter[0]) 1 else 0
                FilterCriteria.LEAST_COMMON -> if (bitCounter[0] > bitCounter[1]) 1 else 0
            }

            filteredList = filteredList.filter { it[position] == filterValue }
            position += 1
        }

        return filteredList.first()
    }

    private enum class FilterCriteria {
        MOST_COMMON, LEAST_COMMON
    }
}

fun main() = Day03(readInput("Day03")).run()