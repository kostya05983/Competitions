package leetCode.medium

import java.util.*

class FoodRatings(
    private val foods: Array<String>,
    private val cuisines: Array<String>,
    private val ratings: IntArray
) {
    private val foodIndex = mutableMapOf<String, Int>()
    private val highestRatings = mutableMapOf<String, TreeSet<Food>>()

    data class Food(
        val name: String,
        val rating: Int
    ) : Comparable<Food> {
        override fun compareTo(other: Food): Int {
            return when {
                other.rating > rating -> {
                    1
                }

                name == other.name && rating == other.rating -> {
                    0
                }

                rating == other.rating && other.name <= name -> {
                    1
                }

                else -> -1
            }
        }
    }

    init {
        for (i in foods.indices) {
            val food = foods[i]
            foodIndex[food] = i
        }
        for (i in foods.indices) {
            val food = foods[i]
            val rating = ratings[i]
            val cuisine = cuisines[i]
            val newFood = Food(food, rating)

            val tree = highestRatings[cuisine]
            if (tree == null) {
                val temp = TreeSet<Food>()
                temp.add(newFood)
                highestRatings[cuisine] = temp
            } else {
                tree.add(newFood)
            }
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val index = foodIndex[food] ?: throw IllegalArgumentException()
        val oldRating = ratings[index]
        ratings[index] = newRating

        val cuisine = cuisines[index]
        val tree = highestRatings[cuisine]
        val oldFood = Food(food, oldRating)
        val removed = tree?.remove(oldFood)
        require(removed != null && removed)

        val newFood = Food(food, newRating)
        tree.add(newFood)
    }

    fun highestRated(cuisine: String): String? {
        val tree = highestRatings[cuisine]

        return tree?.firstOrNull()?.name
    }
}

fun main(args: Array<String>) {
    val solution = FoodRatings(
        arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
        arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
        intArrayOf(9, 12, 8, 15, 14, 7)
    )
    println(solution.highestRated("korean"))
    println(solution.highestRated("japanese"))
    println(solution.changeRating("sushi", 16))
    println(solution.highestRated("japanese"))
    println(solution.changeRating("ramen", 16))
    println(solution.highestRated("japanese"))
}