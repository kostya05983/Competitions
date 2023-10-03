package leetCode.easy

class ConvertTemperature {
    fun convertTemperature(celsius: Double): DoubleArray {
        val result = DoubleArray(2)
        result[0] = celsius + 273.15
        result[1] = celsius * 1.8 + 32

        return result
    }
}