import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day02Test {

    private val challenge = Day02(readInput("Day02_test"))

    @Test
    fun part1() {
        assertEquals(150, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(900, challenge.part2())
    }
}