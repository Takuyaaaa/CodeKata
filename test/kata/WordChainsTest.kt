package kata

import com.code_kata.kata.WordChains
import org.junit.Test
import kotlin.test.assertEquals

class WordChainsTest {
    @Test
    fun testWordChains1() {
        val wordChains = WordChains("cat", "dog")
        wordChains.executeWordChains()

        assertEquals("cat", wordChains.wordResult.first())
        assertEquals("dog", wordChains.wordResult.last())

        println(wordChains.wordResult)
    }

    @Test
    fun testWordChains2() {
        val wordChains = WordChains("lead", "gold")
        wordChains.executeWordChains()

        assertEquals("lead", wordChains.wordResult.first())
        assertEquals("gold", wordChains.wordResult.last())

        println(wordChains.wordResult)
    }

    @Test
    fun testWordChains3() {
        val wordChains = WordChains("ruby", "code")
        wordChains.executeWordChains()

        assertEquals("ruby", wordChains.wordResult.first())
        assertEquals("code", wordChains.wordResult.last())

        println(wordChains.wordResult)
    }
}