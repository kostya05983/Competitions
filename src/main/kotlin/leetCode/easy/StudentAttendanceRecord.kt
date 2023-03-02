package leetCode.easy

class StudentAttendanceRecord {
    fun checkRecord(s: String): Boolean {
        var absentCount = 0
        var lateCount = 0

        for (ch in s) {
            if (lateCount >= 3) return false
            when (ch) {
                'A' -> {
                    absentCount++
                    lateCount = 0
                }

                'P' -> {
                    lateCount = 0
                }

                'L' -> {
                    lateCount++
                }
            }
        }

        return absentCount < 2 && lateCount < 3
    }
}

fun main(args: Array<String>) {
    val solution = StudentAttendanceRecord()
    val test1 = solution.checkRecord("PPALLP")
    require(test1)

    val test2 = solution.checkRecord("PPALLL")
    require(!test2)

    val test3 = solution.checkRecord("LALL")
    require(test3)

    val test4 = solution.checkRecord("LLLALL")
    require(!test4)
}