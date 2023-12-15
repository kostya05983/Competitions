package leetCode.easy

class DestinationCity {

    fun destCity(paths: List<List<String>>): String {
        val directions = HashMap<String, String>()

        for (path in paths) {
            val (from, to) = path
            directions[from] = to
        }

        for (path in paths) {
            val (_, to) = path

            if (directions[to] == null) return to
        }

        return ""
    }
}

fun main(args: Array<String>) {
    val solution = DestinationCity()
    println(solution.destCity(listOf(listOf("London"))))
}