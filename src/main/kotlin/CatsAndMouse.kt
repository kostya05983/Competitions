import java.util.*

// Complete the catAndMouse function below.
fun catAndMouse(x: Int, y: Int, z: Int): String {
    val distancCatA = Math.abs(x-z)
    val distancCatB = Math.abs(y-z)
    return when {
        distancCatA>distancCatB -> "Cat B"
        distancCatA< distancCatB -> "Cat A"
        else -> "Mouse C"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }
}
