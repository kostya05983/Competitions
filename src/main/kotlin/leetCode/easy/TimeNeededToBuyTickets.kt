package leetCode.easy

class TimeNeededToBuyTickets {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var time = 0

        while (tickets[k] != 0) {
            for (i in tickets.indices) {
                if (tickets[i] != 0) {
                    tickets[i]--
                    time++
                }
                if (i == k && tickets[i] == 0) break
            }
        }

        return time
    }
}