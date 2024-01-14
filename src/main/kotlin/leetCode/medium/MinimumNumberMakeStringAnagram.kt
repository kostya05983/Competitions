package leetCode.medium

class MinimumNumberMakeStringAnagram {
    fun minSteps(s: String, t: String): Int {
        val sFrequencies = getFrequenciesMap(s)
        val tFrequencies = getFrequenciesMap(t)

        var diff = 0

        for(entry in sFrequencies) {
            val tFrequency = tFrequencies.getOrDefault(entry.key, 0)

            if (tFrequency < entry.value) {
                diff += entry.value - tFrequency
            }
        }

        return diff
    }

    private fun getFrequenciesMap(value: String): Map<Char, Int> {
        val frequencies = HashMap<Char, Int>()
        for(ch in value) {
            frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
        }

        return frequencies
    }
}