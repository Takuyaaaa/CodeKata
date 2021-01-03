package code_kata

import com.code_kata.code_kata.Rack
import org.junit.Test
import kotlin.test.assertEquals

class SortingItOutTest {
    @Test
    fun testRuck() {
        val rack = Rack()
        assertEquals(mutableListOf(), rack.balls)
        rack.add(20)
        assertEquals(mutableListOf(20), rack.balls)
        rack.add(10)
        assertEquals(mutableListOf(10, 20), rack.balls)
        rack.add(30)
        assertEquals(mutableListOf(10, 20, 30), rack.balls)
    }
}