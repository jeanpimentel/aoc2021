abstract class Challenge {

    abstract fun part1(): Any

    abstract fun part2(): Any

    fun run() {
        println("\n>>> PART 1")
        println(this.part1())
        println("\n>>> PART 2")
        println(this.part2())
    }
}