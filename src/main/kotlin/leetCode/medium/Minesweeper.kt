package leetCode.medium

class Minesweeper {
    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val (y, x) = click

        when (board[y][x]) {
            'M' -> {
                board[y][x] = 'X'
                return board
            }

            'E' -> {
                bfs(y, x, board)
            }
        }

        return board
    }

    private fun bfs(i: Int, j: Int, board: Array<CharArray>) {
        if (i >= board.size || i < 0) return
        if (j >= board[0].size || j < 0) return
        if (board[i][j] != 'E') return

        val count = listOfNotNull(
            board.getOrNull(i - 1)?.getOrNull(j + 1),
            board[i].getOrNull(j + 1),
            board.getOrNull(i + 1)?.getOrNull(j + 1),
            board.getOrNull(i + 1)?.get(j),
            board.getOrNull(i + 1)?.getOrNull(j - 1),
            board[i].getOrNull(j - 1),
            board.getOrNull(i - 1)?.getOrNull(j - 1),
            board.getOrNull(i - 1)?.get(j)
        ).filter { it == 'M' }.size

        board[i][j] = if (count != 0) "$count"[0] else 'B'

        if (count == 0) {
            bfs(i - 1, j + 1, board)
            bfs(i, j + 1, board)
            bfs(i + 1, j + 1, board)
            bfs(i + 1, j, board)
            bfs(i + 1, j - 1, board)
            bfs(i, j - 1, board)
            bfs(i - 1, j - 1, board)
            bfs(i - 1, j, board)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Minesweeper()
    println(
        solution.updateBoard(
            arrayOf(
                charArrayOf('E', 'E', 'E', 'E', 'E'),
                charArrayOf('E', 'E', 'M', 'E', 'E'),
                charArrayOf('E', 'E', 'E', 'E', 'E'),
                charArrayOf('E', 'E', 'E', 'E', 'E')
            ),
            intArrayOf(3, 0)
        ).map { it.toList() }
    )
}