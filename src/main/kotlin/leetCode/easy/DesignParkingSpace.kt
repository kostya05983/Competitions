package leetCode.easy

class ParkingSystem(val big: Int, val medium: Int, val small: Int) {
    private var bigCount = 0
    private var mediumCount = 0
    private var smallCount = 0

    fun addCar(carType: Int): Boolean {
        return when {
            carType == 1 && bigCount < big -> {
                bigCount++
                true
            }

            carType == 2 && mediumCount < medium -> {
                mediumCount++
                true
            }

            carType == 3 && smallCount < small -> {
                smallCount++
                true
            }

            else -> false
        }
    }
}