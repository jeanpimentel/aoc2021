import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01Test {

    private val challenge = Day01(readInputAsInts("Day01_test"))

    @Test
    fun part1() {
        assertEquals(7, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(5, challenge.part2())
    }
}