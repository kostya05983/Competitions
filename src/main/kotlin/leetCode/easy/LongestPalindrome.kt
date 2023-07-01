package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val frequencies = IntArray(59)
        var length = 0

        for (ch in s) {
            val index = ch - 'A'
            frequencies[index] = frequencies[index] + 1

            if (frequencies[index].rem(2) == 0)
                length += 2
        }
        val hasOneLetter = frequencies.any { it.rem(2) == 1 }

        return if (hasOneLetter) length + 1 else length
    }
}

fun main(args: Array<String>) {
    val solution = LongestPalindrome()
    val example1 = solution.longestPalindrome("abccccdd")
    assertEquals(7, example1)

    val example2 = solution.longestPalindrome("a")
    assertEquals(1, example2)

    val example3 = solution.longestPalindrome("ccccdd")
    assertEquals(6, example3)

    val example4 = solution.longestPalindrome("ccd")
    assertEquals(3, example4)

    val example5 = solution.longestPalindrome("AAAAAA")
    assertEquals(6, example5)

    val example6 = solution.longestPalindrome("ZZZZ")
    assertEquals(4, example6)

    val example7 = solution.longestPalindrome("zzzz")
    assertEquals(4, example7)

    val example8 =
        solution.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd")
    assertEquals(865, example8)
}