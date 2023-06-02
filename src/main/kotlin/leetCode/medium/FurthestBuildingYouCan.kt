package leetCode.medium

class FurthestBuildingYouCan {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        return furthestBuilding(heights, bricks, ladders, 0)
    }

    private fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int, index: Int): Int {
        if (bricks < 0 || ladders < 0) {
            return maxOf(0, index - 1)
        }
        if (index == heights.lastIndex) {
            return index
        }
        val diff = heights[index + 1] - heights[index]

        if (diff <= 0) {
            return furthestBuilding(heights, bricks, ladders, index + 1)
        }

        if (bricks == 0 && ladders == 0) {
            return index
        }

        return maxOf(
            furthestBuilding(heights, bricks - diff, ladders, index + 1),
            furthestBuilding(heights, bricks, ladders - 1, index + 1)
        )
    }
}

fun main(args: Array<String>) {
    val solution = FurthestBuildingYouCan()
    val example1 = solution.furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1)
    require(example1 == 4)
    val example2 = solution.furthestBuilding(intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2)
    require(example2 == 7) { "$example2" }
    val example3 = solution.furthestBuilding(intArrayOf(14, 3, 19, 3), 17, 0)
    require(example3 == 3) { "$example3" }

    val example4 = solution.furthestBuilding(intArrayOf(1, 5, 1, 2, 3, 4, 10000), 4, 1)
    require(example4 == 5)
}