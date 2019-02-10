import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val firstLine = readLine()?.split(" ")
    val b = firstLine?.get(0)
    val k = firstLine?.get(1)
    val a = readLine()?.split(" ")?.map { it.toInt() }


}

//fun transformToInteger(array: ) {
//
//}