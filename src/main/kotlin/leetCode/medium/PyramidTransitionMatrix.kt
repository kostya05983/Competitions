package leetCode.medium

class PyramidTransitionMatrix {

    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        if (bottom.length == 1) return true

        return bottomCombination(bottom, 0, allowed, java.lang.StringBuilder())
    }

    private fun bottomCombination(bottom: String, index: Int, allowed: List<String>, sb: StringBuilder): Boolean {
        if (sb.length == bottom.length - 1) return pyramidTransition(sb.toString(), allowed)

        val chunkedBottom = bottom.substring(index, index + 2)

        val filteredAllow = allowed.filter { it.startsWith(chunkedBottom) }

        for (allow in filteredAllow) {
            sb.append(allow[2])
            if (bottomCombination(bottom, index + 1, allowed, sb)) return true
            sb.setLength(sb.length - 1)
        }
        return false
    }


    fun pyramidTransition2(bottom: String, allowed: List<String>): Boolean {
        if (bottom.length == 1) return true

        val map = mutableMapOf<String, Set<String>>()
        for (allow in allowed) {
            map.compute(allow.substring(0, 2)) { key, value ->
                (value ?: setOf()).plus(allow[2].toString())
            }
        }

        return internalPyramidTransition(bottom, map)
    }

    private fun internalPyramidTransition(bottom: String, map: MutableMap<String, Set<String>>): Boolean {
        if (bottom.length == 1) return true

        val pyramidTransitionCombination = pyramidTransitionCombination(bottom, map)

        return pyramidTransitionCombination.any {
            internalPyramidTransition(it, map)
        }
    }

    private fun pyramidTransitionCombination(
        bottom: String,
        map: MutableMap<String, Set<String>>
    ): Set<String> {
        if (map.containsKey(bottom)) {
            return map[bottom]!!
        }
        if (bottom.length <= 2) {
            return emptySet()
        }

        val leftBottom = bottom.substring(0, bottom.length - 1)
        val leftButtonResult = pyramidTransitionCombination(leftBottom, map)
        if (leftButtonResult.isEmpty()) return emptySet()

        val rightBottom = bottom.substring(1, bottom.length)
        val rightButtonResult = pyramidTransitionCombination(rightBottom, map)
        if (rightButtonResult.isEmpty()) return emptySet()

        val result = HashSet<String>()
        for (left in leftButtonResult) {
            for (right in rightButtonResult) {
                if (left.regionMatches(1, right, 0, left.length - 1)) {
                    result.add(left + right.last())
                }
            }
        }
        map[bottom] = result

        return result
    }
}

fun main(args: Array<String>) {
    val solution = PyramidTransitionMatrix()

    val example1 = solution.pyramidTransition2("BCD", listOf("BCC", "CDE", "CEA", "FFF"))
    require(example1) { "Wrong!" }
//
    val example2 = solution.pyramidTransition2("AAAA", listOf("AAB", "AAC", "BCD", "BBE", "DEF"))
    require(!example2) { "Wrong2!" }

//    val example3 = solution.pyramidTransition(
//        "AFFFFA",
//        listOf(
//            "ADA",
//            "ADC",
//            "ADB",
//            "AEA",
//            "AEC",
//            "AEB",
//            "AFA",
//            "AFC",
//            "AFB",
//            "CDA",
//            "CDC",
//            "CDB",
//            "CEA",
//            "CEC",
//            "CEB",
//            "CFA",
//            "CFC",
//            "CFB",
//            "BDA",
//            "BDC",
//            "BDB",
//            "BEA",
//            "BEC",
//            "BEB",
//            "BFA",
//            "BFC",
//            "BFB",
//            "DAA",
//            "DAC",
//            "DAB",
//            "DCA",
//            "DCC",
//            "DCB",
//            "DBA",
//            "DBC",
//            "DBB",
//            "EAA",
//            "EAC",
//            "EAB",
//            "ECA",
//            "ECC",
//            "ECB",
//            "EBA",
//            "EBC",
//            "EBB",
//            "FAA",
//            "FAC",
//            "FAB",
//            "FCA",
//            "FCC",
//            "FCB",
//            "FBA",
//            "FBC",
//            "FBB",
//            "DDA",
//            "DDC",
//            "DDB",
//            "DEA",
//            "DEC",
//            "DEB",
//            "DFA",
//            "DFC",
//            "DFB",
//            "EDA",
//            "EDC",
//            "EDB",
//            "EEA",
//            "EEC",
//            "EEB",
//            "EFA",
//            "EFC",
//            "EFB",
//            "FDA",
//            "FDC",
//            "FDB",
//            "FEA",
//            "FEC",
//            "FEB",
//            "FFA",
//            "FFC",
//            "FFB",
//            "DDD",
//            "DDE",
//            "DDF",
//            "DED",
//            "DEE",
//            "DEF",
//            "DFD",
//            "DFE",
//            "DFF",
//            "EDD",
//            "EDE",
//            "EDF",
//            "EED",
//            "EEE",
//            "EEF",
//            "EFD",
//            "EFE",
//            "EFF",
//            "FDD",
//            "FDE",
//            "FDF",
//            "FED",
//            "FEE",
//            "FEF",
//            "FFD",
//            "FFE",
//            "FFF"
//        )
//    )
//    println(solution.map.toString().split(",").joinToString("\n"))


//    require(!example3) { "Wrong" }
}