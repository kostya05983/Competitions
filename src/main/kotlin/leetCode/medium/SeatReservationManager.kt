package leetCode.medium

import java.util.PriorityQueue

class SeatReservationManager(
    n: Int
) {
    private val freeSeats = PriorityQueue<Int>(n)

    init {
        for (i in 1..n) {
            freeSeats.add(i)
        }
    }

    fun reserve(): Int {
        return freeSeats.poll()
    }

    fun unreserve(seatNumber: Int) {
        freeSeats.add(seatNumber)
    }
}