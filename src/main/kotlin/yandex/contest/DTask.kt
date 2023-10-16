package yandex.contest

fun recursion(remainsLeft: Int, remainsRight: Int, current: String, sb: StringBuilder) {
    if (remainsRight <= 0 && remainsLeft <= 0) {
        sb.appendln(current)
        return
    }

    if (remainsLeft != 0) recursion(remainsLeft - 1, remainsRight, "$current(", sb)

    if (remainsLeft != remainsRight) {
        recursion(remainsLeft, remainsRight - 1, "$current)", sb)
    }
}

//4 - 8
//5 - 18
fun main(args: Array<String>) {
    val n = readLine()?.toInt()!!

    if (n == 0) return

    val result = mutableListOf<List<String>>()
    result.add(listOf(""))

    for (i in 1..n) {
        val list = mutableListOf<String>()

        for (j in 0 until i) {
            for (first in result[j]) {
                for (second in result[i - 1 - j]) {
                    list.add("($first)$second")
                }
            }

            result.add(list)
        }
    }


    val finalResult = result[result.size - 1]

    for (i in finalResult.size - 1 downTo 0) {
        println(finalResult[i])
    }
}