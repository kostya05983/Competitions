package stepik.algorithm.structure.course

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled

@Disabled
internal class BracketsArrangementTest {

    @Test
    fun solve() {
        val bracketsArrangement = BracketsArrangement()
        assertEquals("Success", bracketsArrangement.solve("([](){([])})"))
    }

    @Test
    fun solve1() {
        val bracketsArrangement = BracketsArrangement()
        assertEquals("5", bracketsArrangement.solve("()[]}"))
    }

    @Test
    fun solve2() {
        val bracketsArrangement = BracketsArrangement()
        assertEquals("7", bracketsArrangement.solve("{{[()]]"))
    }

    @Test
    fun solve3() {
        val bracketsArrangement = BracketsArrangement()
        assertEquals("0", bracketsArrangement.solve("([](){([])})"))
        assertEquals("5", bracketsArrangement.solve("()[]}"))
        assertEquals("7", bracketsArrangement.solve("{{[()]]"))
    }
}