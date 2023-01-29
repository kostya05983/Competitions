package leetCode.easy

class LicenseKeyFormatting {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val sb = StringBuilder()
        var i = s.length - 1
        var count = 0
        while (i >= 0) {
            val ch = s[i]

            if (ch != '-') {
                sb.append(ch.toUpperCase())
                count++
                if (count == k && i != 0) {
                    sb.append("-")
                    count = 0
                }
            }
            i--
        }

        sb.reverse()
        return if (sb.isNotEmpty() && sb[0] == '-') sb.toString().drop(1)
        else sb.toString()
    }
}

fun main(args: Array<String>) {
    println(LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4))
    println(LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2))
    println(LicenseKeyFormatting().licenseKeyFormatting("2-4A0r7-4k", 4))
    println(LicenseKeyFormatting().licenseKeyFormatting("--a-a-a-a--", 2))
}