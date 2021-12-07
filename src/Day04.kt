class Day04(input: List<String>) : Challenge() {
    private val numbers: List<Int>
    private val boards: List<Board>

    init {
        this.numbers = input
            .first()
            .split(",")
            .map { it.toInt() }

        this.boards = input
            .drop(1)
            .windowed(6, step = 6)
            .map { Board.fromString(it.joinToString(" ")) }
    }

    override fun part1(): Int {
        var winner: Board? = null

        main@ for (number in numbers) {
            for (board in boards) {
                val won = board.mark(number)
                if (won) {
                    winner = board
                    break@main
                }
            }
        }

        return winner?.getScore()!!
    }

    override fun part2(): Int {
        val winners: MutableList<Board> = mutableListOf()

        for (number in numbers) {
            for (board in boards) {
                if (board in winners) {
                    continue
                }

                val won = board.mark(number)
                if (won) {
                    winners.add(board)
                }
            }
        }

        return winners.last().getScore()
    }

    class Board(private val numbers: List<Int>) {
        private var marked = MutableList(numbers.size) { false }
        private var last: Int? = null

        fun mark(number: Int): Boolean {
            val position = numbers.indexOf(number)
            if (position > -1) {
                marked[position] = true
                last = number
                return isWinner()
            }
            return false
        }

        private fun isWinner(): Boolean {
            val horizontal = marked
                .windowed(5, step = 5)
                .map { rows -> rows.all { it } } // row is completed
                .any { it }

            if (horizontal) {
                return true
            }

            for (i in 0 until marked.size / 5) {
                val vertical =
                    listOf(marked[i], marked[i + 5], marked[i + 10], marked[i + 15], marked[i + 20]).all { it }
                if (vertical) {
                    return true
                }
            }

            return false
        }

        fun getScore(): Int {
            var sum = 0
            numbers.forEachIndexed { index, number ->
                if (!marked[index]) sum += number
            }
            return sum * last!!
        }

        override fun toString(): String {
            return "Board(numbers=${numbers.windowed(5, 5)})"
        }

        companion object {
            fun fromString(input: String) = Board(
                input
                    .trim()
                    .split("\\s+".toRegex())
                    .map { it.toInt() }
            )
        }
    }
}

fun main() = Day04(readInput("Day04")).run()