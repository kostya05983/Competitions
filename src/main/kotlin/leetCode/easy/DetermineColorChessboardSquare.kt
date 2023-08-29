package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class DetermineColorChessboardSquare {
    fun squareIsWhite(coordinates: String): Boolean {
        val columnIndex = coordinates[0] - 'a' + 1
        val rowIndex = coordinates[1].toInt()

        return (columnIndex + rowIndex).rem(2) == 1
    }
}

fun main(args: Array<String>) {
    val solution = DetermineColorChessboardSquare()

    val example1 = solution.squareIsWhite("a1")
    assertEquals(false, example1)

    val example2 = solution.squareIsWhite("h3")
    assertEquals(true, example2)

    val example3 = solution.squareIsWhite("c7")
    assertEquals(false, example3)
}