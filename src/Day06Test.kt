import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day06Test {

    private val challenge = Day06(readInput("Day06_test"))

    @Test
    fun part1() {
        assertEquals(5934, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(26984457539, challenge.part2())
    }
}