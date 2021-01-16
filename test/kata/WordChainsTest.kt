package kata

import com.code_kata.kata.WordChains
import org.junit.Test

class WordChainsTest {
    @Test
    fun testWordChains1() {
        val wordChains = WordChains("cat", "dog")
        wordChains.executeWordChains()
        println(wordChains.wordResult)
    }

    @Test
    fun testWordChains2() {
        val wordChains = WordChains("lead", "gold")
        wordChains.executeWordChains()
        println(wordChains.wordResult)
    }

    @Test
    fun testWordChains3() {
        val wordChains = WordChains("ruby", "code")
        wordChains.executeWordChains()
        println(wordChains.wordResult)
    }
}