#!/usr/bin/env python3
import re
import sys
from pathlib import Path

day = input("Enter day ([01-31]): ")

if not re.match(r"^(0[1-9])|([1-2][0-9])|(3[0-1])$", day):
    sys.exit(f"Invalid day: {day}")

path = Path(f"./src/Day{day}.kt")
if path.is_file():
    sys.exit(f"File for day {day} already exists")

implementation = """class Day%DAY%(private val input: List<Any>) : Challenge() {
    override fun part1(): Any {
        TODO("Not yet implemented")
    }

    override fun part2(): Any {
        TODO("Not yet implemented")
    }
}

fun main() = Day%DAY%(readInput("Day%DAY%")).run()"""

test = """import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day%DAY%Test {

    private val challenge = Day%DAY%(readInput("Day%DAY%_test"))

    @Test
    fun part1() {
//        assertEquals(, challenge.part1())
    }

    @Test
    fun part2() {
//        assertEquals(, challenge.part2())
    }
}"""

with open(f"./src/Day{day}.kt", "w") as file:
    file.write(implementation.replace("%DAY%", day))

with open(f"./src/Day{day}Test.kt", "w") as file:
    file.write(test.replace("%DAY%", day))

print(f"Files for day {day} created")