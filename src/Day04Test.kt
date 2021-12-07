import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day04Test {

    private val challenge = Day04(readInput("Day04_test"))

    @Test
    fun part1() {
        assertEquals(4512, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(1924, challenge.part2())
    }
}