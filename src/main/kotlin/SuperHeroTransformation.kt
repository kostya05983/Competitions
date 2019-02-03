import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val s = bufferedReader.readLine()
    val t = bufferedReader.readLine()

    val binaryS = transformToBinary(s)
    val binaryT = transformToBinary(t)

    println(if (binaryT == binaryS) "Yes" else "No")
}


fun transformToBinary(s: String) = s.toCharArray().map { if (arrayOf('a', 'e', 'i', 'o', 'u').contains(it)) 1 else 0 }