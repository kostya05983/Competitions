package leetCode.medium

class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val unique = HashSet<String>()
        for (email in emails) {
            val sb = StringBuilder()
            var skipAll = false
            var isLocal = true

            for (ch in email) {
                if (ch == '@') isLocal = false

                if (isLocal && ch == '+') {
                    skipAll = true
                }

                if (isLocal && skipAll) {
                    continue
                }

                if (isLocal && ch == '.') {
                    continue
                }
                sb.append(ch)
            }
            unique.add(sb.toString())
        }

        return unique.size
    }
}

fun main(args: Array<String>) {
    val solution = UniqueEmailAddresses()
    val emails =
        arrayOf("test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com")
    println(solution.numUniqueEmails(emails))
    println(solution.numUniqueEmails(arrayOf("a@leetcode.com", "b@leetcode.com", "c@leetcode.com")))
    println(solution.numUniqueEmails(arrayOf("test.email+alex@leetcode.com", "test.email@leetcode.com")))
}