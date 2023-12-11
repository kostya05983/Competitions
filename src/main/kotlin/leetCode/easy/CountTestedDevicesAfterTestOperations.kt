package leetCode.easy

class CountTestedDevicesAfterTestOperations {
    fun countTestedDevices(batteryPercentages: IntArray): Int {
        var count = 0
        for (i in 0 until batteryPercentages.size) {
            val percentage = batteryPercentages[i]

            if (percentage > 0) {
                count++
                for (j in i + 1 until batteryPercentages.size) {
                    batteryPercentages[j] = maxOf(0, batteryPercentages[j] - 1)
                }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {

}