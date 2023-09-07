package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSet = HashSet<Char>()
        val columnSet = HashSet<Char>()

        for (i in board.indices) {
            for (j in board.indices) {
                val rowCh = board[i][j]
                if (rowSet.contains(rowCh)) return false

                if (rowCh != '.') {
                    rowSet.add(rowCh)
                }

                val columnCh = board[j][i]
                if (columnSet.contains(columnCh)) return false

                if (columnCh != '.') {
                    columnSet.add(columnCh)
                }
            }
            rowSet.clear()
            columnSet.clear()
        }

        var row = 0
        var column = 0

        val squareSet = HashSet<Char>()
        while (row < 9) {
            val ch = board[row][column]

            if (squareSet.contains(ch)) return false

            if (ch != '.') squareSet.add(ch)

            if ((row + 1).rem(3) == 0 && (column + 1).rem(3) == 0 && column != 8) {
                row -= 2
                column++

                squareSet.clear()
                continue
            }

            if (column == 8 && (row + 1).rem(3) == 0) {
                column = 0
                row++

                squareSet.clear()
                continue
            }

            if ((column + 1).rem(3) != 0) {
                column++
            } else {
                row++
                column -= 2
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val solution = ValidSudoku()
    val example1 = solution.isValidSudoku(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )

    assertEquals(true, example1)
}