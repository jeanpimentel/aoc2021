import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day03Test {

    private val challenge = Day03(readInput("Day03_test"))

    @Test
    fun part1() {
        assertEquals(198, challenge.part1())
    }

    @Test
    fun part2() {
        assertEquals(230, challenge.part2())
    }
}