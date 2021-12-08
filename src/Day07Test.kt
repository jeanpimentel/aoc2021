import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day07Test {

    private val challenge = Day07(readInput("Day07_test"))

    @Test
    fun part1() {
        assertEquals(37, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(168L, challenge.part2())
    }
}