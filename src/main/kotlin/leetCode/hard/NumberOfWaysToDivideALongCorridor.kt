package leetCode.hard

import differentAlgorithm.findSubArray

class NumberOfWaysToDivideALongCorridor {
    fun numberOfWays(corridor: String): Int {
        val mod = 1000000007

        val dp = Array(corridor.length + 1) { IntArray(3) }
        dp[corridor.length][0] = 0
        dp[corridor.length][1] = 0
        dp[corridor.length][2] = 1

        for (i in corridor.length - 1 downTo 0) {
            if (corridor[i] == 'S') {
                dp[i][0] = dp[i + 1][1]
                dp[i][1] = dp[i + 1][2]
                dp[i][2] = dp[i + 1][1]
            } else {
                dp[i][0] = dp[i + 1][0]
                dp[i][1] = dp[i + 1][1]
                dp[i][2] = (dp[i + 1][0] + dp[i + 1][2]).rem(mod)
            }
        }

        return dp[0][0]
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfWaysToDivideALongCorridor()
    println(solution.numberOfWays("SSPPSPS"))
    println(solution.numberOfWays("PPSPSP"))
    println(solution.numberOfWays("S"))
    println(solution.numberOfWays("SPPPPPPPSPPPSPSSSPPPPPPPPPPPPPPPPPSPPPPPPPPPPPPPPPPSPPPPPSPSPPPPPPSPSPPSPSPPPSPSPPSSPPPPPSPPSSPP"))
}