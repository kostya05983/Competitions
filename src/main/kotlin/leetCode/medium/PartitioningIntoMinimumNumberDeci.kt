package leetCode.medium

class PartitioningIntoMinimumNumberDeci {
    fun minPartitions(n: String): Int {
        var n = n.toInt()
        val sb = StringBuilder()

        while (n > 0) {
            sb.append(n.rem(10))
            n /= 10
        }

        println(sb)

        return 0
    }
}

fun main(args: Array<String>) {
    println(PartitioningIntoMinimumNumberDeci().minPartitions("32"))
}