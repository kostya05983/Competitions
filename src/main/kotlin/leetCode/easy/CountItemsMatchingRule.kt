package leetCode.easy

class CountItemsMatchingRule {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val keyIndex = when (ruleKey) {
            "type" -> 0
            "color" -> 1
            "name" -> 2
            else -> throw IllegalArgumentException()
        }

        var count = 0
        items.forEach {
            if (it[keyIndex] == ruleValue) count++
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = CountItemsMatchingRule()
    val test1 = solution.countMatches(
        listOf(
            listOf("phone", "blue", "pixel"), listOf("computer", "silver", "lenovo"),
            listOf("phone", "gold", "iphone")
        ), "color", "silver"
    )
    require(test1 == 1)
}