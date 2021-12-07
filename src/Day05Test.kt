import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day05Test {

    private val challenge = Day05(readInput("Day05_test"))

    @Test
    fun part1() {
        assertEquals(5, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(12, challenge.part2())
    }
}