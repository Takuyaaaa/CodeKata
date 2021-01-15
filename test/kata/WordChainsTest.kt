package kata

import com.code_kata.kata.WordChains
import org.junit.Test

class WordChainsTest {
    @Test
    fun testWordChains1() {
        val wordChains = WordChains("cat", "dog")
        wordChains.executeWordChains()
    }

    @Test
    fun testWordChains2() {
        val wordChains = WordChains("lead", "gold")
        wordChains.executeWordChains()
    }

    @Test
    fun testWordChains3() {
        val wordChains = WordChains("ruby", "code")
        wordChains.executeWordChains()
    }
}