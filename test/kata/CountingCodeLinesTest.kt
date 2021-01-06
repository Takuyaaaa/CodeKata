package kata

import com.code_kata.kata.CountingCodeLines.Companion.countCodeLines
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class CountingCodeLinesTest {
    @Test
    fun testCount1() {
        val count = File("resources/CountTarget1.kt")
                .countCodeLines()
        assertEquals(3, count)
    }

    @Test
    fun testCount2() {
        val count = File("resources/CountTarget2.kt")
                .countCodeLines()
        assertEquals(5, count)
    }

    @Test
    fun testCount3() {
        val count = File("src/code_kata/CountingCodeLines.kt")
                .countCodeLines()
        assertEquals(44, count)
    }
}