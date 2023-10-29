package leetCode.hard

class PoorPigs {

    //todo solve again
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        var pigs = 0

        while (Math.pow((minutesToTest / minutesToDie + 1).toDouble(), pigs.toDouble()) < buckets) {
            pigs++
        }

        return pigs
    }
}

fun main(args: Array<String>) {
    val solution = PoorPigs()
    println(solution.poorPigs(4, 15, 15))
    println(solution.poorPigs(4, 15, 30))
}