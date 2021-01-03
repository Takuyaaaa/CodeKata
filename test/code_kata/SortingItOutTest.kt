package code_kata

import com.code_kata.code_kata.Rack
import com.code_kata.code_kata.Sentence
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
        rack.add(15)
        assertEquals(mutableListOf(10, 15, 20), rack.balls)
        rack.add(30)
        assertEquals(mutableListOf(10, 15, 20, 30), rack.balls)
        rack.add(21)
        assertEquals(mutableListOf(10, 15,20,21 ,30), rack.balls)
    }

    @Test
    fun testChars() {
        val sentence = Sentence(
                "When not studying nuclear physics, Bambi likes to play beach volleyball."
        )
        val sortedChars = sentence.extractSortedChars()

        assertEquals(
                "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy",
                sortedChars)
    }
}