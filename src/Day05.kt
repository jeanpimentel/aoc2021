import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

typealias Point = Pair<Int, Int>
typealias Line = Pair<Point, Point>

class Day05(input: List<String>) : Challenge() {
    private val lines: List<Line>

    init {
        this.lines = input
            .map { it ->
                it
                    .replace(" -> ", ",")
                    .split(",")
                    .map { it.toInt() }
                    .let { (x1, y1, x2, y2) -> Pair(Pair(x1, y1), Pair(x2, y2)) }
            }
    }

    override fun part1(): Int {
        val points = mutableMapOf<Point, Int>()

        lines.forEach { (start, end) ->
            getPoints(start, end, allowDiagonal = false).forEach { p ->
                points[p] = if (p in points) points[p]!! + 1 else 1
            }
        }

        return points.filter { it.value > 1 }.size
    }

    override fun part2(): Any {
        val points = mutableMapOf<Point, Int>()

        lines.forEach { (start, end) ->
            getPoints(start, end, allowDiagonal = true).forEach { p ->
                points[p] = if (p in points) points[p]!! + 1 else 1
            }
        }

        return points.filter { it.value > 1 }.size
    }


    private fun getPoints(
        start: Point,
        end: Point,
        allowDiagonal: Boolean = false,
    ): List<Point> {
        val dx = end.first - start.first
        val dy = end.second - start.second

        val result = mutableListOf<Point>()
        if (start.first == end.first) { // vertical
            for (y in min(start.second, end.second)..max(start.second, end.second)) {
                result.add(Pair(start.first, y))
            }
        } else if (start.second == end.second) { // horizontal
            for (x in min(start.first, end.first)..max(start.first, end.first)) {
                result.add(Pair(x, start.second))
            }
        } else if (dx.absoluteValue == dy.absoluteValue && allowDiagonal) { // diagonal
            result.addAll(
                (1..dx.absoluteValue)
                    .runningFold(start) { firstPair, _ ->
                        Pair(firstPair.first + dx.sign, firstPair.second + dy.sign)
                    }
            )
        }

        return result
    }
}

fun main() = Day05(readInput("Day05")).run()