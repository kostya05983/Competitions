package leetCode.medium

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var longestPalindrome = ""

        if (s.length == 1) {
            return s
        }

        for(i in 1 until s.length) {
            var right = i
            var left = i-1
            var tempResult = ""
            while(left != -1 && right != s.length && s[left] == s[right]) {
                tempResult=s[left]+tempResult+s[right];
                left--;
                right++;
            }
            if (tempResult.length>longestPalindrome.length) {
                longestPalindrome = tempResult
            }


            tempResult = "${s[i]}"
            right = i+1
            left=i-1
            while(left != -1 && right != s.length && s[left] == s[right]) {
                tempResult=s[left]+tempResult+s[right];
                left--;
                right++;
            }
            if (tempResult.length>longestPalindrome.length) {
                longestPalindrome = tempResult
            }
        }

        return longestPalindrome
    }
}