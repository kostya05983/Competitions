package leetCode.easy

class PathCrossing {
    fun isPathCrossing(path: String): Boolean {
        var x = 0
        var y = 0

        val points = HashSet<Pair<Int, Int>>()
        points.add(0 to 0)

        for (ch in path) {
            when (ch) {
                'N' -> {
                    y++
                }

                'S' -> {
                    y--
                }

                'E' -> {
                    x++
                }

                'W' -> {
                    x--
                }
            }

            val point = x to y
            if (points.contains(point)) return true
            points.add(point)
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = PathCrossing()
    println(solution.isPathCrossing("NNSWWEWSSESSWENNW"))
}