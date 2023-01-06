package leetCode.easy

interface VersionControl {
    fun isBadVersion(version: Int): Boolean = false
}

class FirstBadVersion : VersionControl {

    fun firstBadVersion(n: Int): Int {
        if (isBadVersion(1)) return 1

        return binarySearch(1, n)
    }

    private tailrec fun binarySearch(left: Int, right: Int): Int {
        if (left > right) return 0

        val mid = left + (right - left) / 2
        val isBadVersion = isBadVersion(mid)
        if (mid == 0 && isBadVersion) return 0

        val isPreviousBadVersion = isBadVersion(mid - 1)

        return if (!isPreviousBadVersion && isBadVersion) {
            mid
        } else if (isBadVersion && isPreviousBadVersion) {
            binarySearch(0, mid - 1)
        } else {
            binarySearch(mid + 1, right)
        }
    }
}