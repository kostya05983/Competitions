package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class DetermineIfACellReachable {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        var timePassed = 0

        var startPointX = sx
        var startPointY = sy
        var endPointX = fx
        var endPointY = fy
        if (fx <= sx && fy <= sy) {
            startPointX = fx
            startPointY = fy
            endPointX = sx
            endPointY = sy
        } else if (sx <= fx && sy <= fy) {
            startPointX = sx
            startPointY = sy
            endPointX = fx
            endPointY = fy
        } else if (sx <= fx && fy <= sy) {
            startPointX = sx
            startPointY = sy
            endPointX = fx
            endPointY = fy
        } else {
            startPointX = fx
            startPointY = fy
            endPointX = sx
            endPointY = sy
        }
        //Движение по диагонали это 2 движения в одном
        //Есть разница по горизонтали и разница по вертикали
        //Минимум движений по 1 из оси, это будет кол-во доступных движений по диагонали

        if (sx == fx && sy == fy) {
            return t != 1
        }

        var diagonalMove = 0
        var shift = 0
        while (timePassed < t) {
            if (startPointX < endPointX && startPointY < endPointY) {
                val min = minOf(endPointX - startPointX, endPointY - startPointY)

                startPointX += min
                startPointY += min
                diagonalMove += min
                timePassed += min
                continue
            } else if (startPointX < endPointX && startPointY > endPointY) {
                val min = minOf(endPointX - startPointX, startPointY - endPointY)

                startPointY -= min
                startPointX += min
                diagonalMove += min
                timePassed += min
                continue
            } else if (startPointX < endPointX) {
                val diff = endPointX - startPointX
                startPointX += diff
                shift += diff
                timePassed += diff
                continue
            } else if (startPointY < endPointY) {
                val diff = endPointY - startPointY

                startPointY += diff
                shift += diff
                timePassed += diff
                continue
            } else if (startPointY > endPointY) {
                val diff = startPointY - endPointY

                startPointY -= diff
                shift += diff
                timePassed += diff
                continue
            } else if (t - timePassed >= 3) {
                val devided = (t - timePassed) / 3
                timePassed += 3 * devided //спокойно вычитаем 3
                continue
            } else if (t - timePassed >= 2) {
                val devided = (t - timePassed) / 2
                timePassed += 2 * devided //влево, вправо
                continue
            } else if (diagonalMove > 0) {
                val diff = minOf(t - timePassed, diagonalMove)
                timePassed += diff
                diagonalMove -= diff
                continue
            } else if (shift > 0) {
                val diff = minOf(t - timePassed, shift)
                timePassed += diff
                shift -= diff
                continue
            }
        }

        if (startPointX == endPointX && startPointY == endPointY && timePassed == t) {
            return true
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = DetermineIfACellReachable()
    val example1 = solution.isReachableAtTime(2, 4, 7, 7, 6)
    assertEquals(true, example1)

    val example2 = solution.isReachableAtTime(3, 1, 7, 3, 3)
    assertEquals(false, example2)

    val example3 = solution.isReachableAtTime(7, 7, 2, 4, 6)
    assertEquals(true, example3)

    val example4 = solution.isReachableAtTime(2, 2, 3, 3, 1)
    assertEquals(true, example4)

    val example5 = solution.isReachableAtTime(1, 2, 1, 2, 1)
    assertEquals(false, example5)

    val example6 = solution.isReachableAtTime(1, 1, 1, 1, 3)
    assertEquals(true, example6)

    val example7 = solution.isReachableAtTime(1, 1, 2, 1, 2)
    assertEquals(true, example7)

    val example8 = solution.isReachableAtTime(1, 2, 1, 3, 6)
    assertEquals(true, example8)

    val example9 = solution.isReachableAtTime(1, 2, 3, 1, 2)
    assertEquals(true, example9)

    val example10 = solution.isReachableAtTime(2, 5, 2, 5, 7)
    assertEquals(true, example10)
//
    val example11 = solution.isReachableAtTime(
        293596575,
        940493727,
        662279371,
        855472538,
        911145334
    )
    assertEquals(true, example11)
}

