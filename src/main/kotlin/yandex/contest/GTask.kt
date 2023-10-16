package yandex.contest

import kotlin.math.abs

fun main(args: Array<String>) {
    val n = readLine()?.toInt()!!

    val citiesSet = mutableSetOf<Int>()
    val cities = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        val line = readLine()!!.split(" ")

        val module = (line[0].toInt() + line[1].toInt())

        if (citiesSet.add(module)) {
            cities.add(Pair(i, module))
        }

    }
    cities.sortBy { it.second }

    val length = readLine()?.toInt()!!
    val path = readLine()?.split(" ")!!

    val firstCityIndex = path[0].toInt() - 1
    val secondCityIndex = path[1].toInt() - 1


    var firstCity = cities.indexOfFirst { it.first == firstCityIndex }
    var secondCity = cities.indexOfFirst { it.first == secondCityIndex }

    val temp = minOf(firstCity, secondCity)
    secondCity = maxOf(secondCity, firstCity)
    firstCity = temp

    val result = secondCity - firstCity

    //нужно выкинуть пути между, если например существует путь между 1 и 2 городом, но можно заехать в 3, то хочется его выкинуть из пути
    while (firstCity != secondCity) {
        val aElement = cities[firstCity].second
        val nextElement = cities.getOrNull(firstCity + 1)?.second ?: break
        if (abs(nextElement - aElement) > length) {
            println(-1)
            return
        }
        firstCity++
    }

    println(result)
}