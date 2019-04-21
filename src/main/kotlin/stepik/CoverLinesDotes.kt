package stepik

import java.util.*
import kotlin.collections.ArrayList

data class Line(val data: Int, val number: Int, val side: Char)


fun findDotes(arr: List<Line>): ArrayList<Int> {
    val sortedWith = arr.sortedWith(kotlin.Comparator { o1, o2 ->
        if (o1.data == o2.data) {
            if (o1.side == 'L') return@Comparator -1 else return@Comparator 1
        } else {
            return@Comparator o1.data.compareTo(o2.data)
        }
    })

    val current = ArrayList<Int>()

    val result = ArrayList<Int>()

    for (i in 0 until sortedWith.size) {
        if (sortedWith[i].side == 'L')
            current.add(sortedWith[i].number)
        else if (current.contains(sortedWith[i].number)) {
            result.add(sortedWith[i].data)
            current.clear()
        }
    }

    return result
}

fun main() {
    val s = Scanner(System.`in`)

    val n = s.nextLine().toInt()

    val arr = LinkedList<Line>()
    for (i in 0 until n) {
        val split = s.nextLine().split(" ")
        arr.add(Line(split[0].toInt(), i, 'L'))
        arr.add(Line(split[1].toInt(), i, 'R'))
    }

    val result = findDotes(arr)

    println(result.size)
    for (i in result) {
        print("$i ")
    }
}