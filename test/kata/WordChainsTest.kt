package kata

import com.code_kata.kata.WordChains
import org.junit.Test

class WordChainsTest {
    @Test
    fun testWordChains() {
        val wordChains = WordChains("cat", "dog")

        wordChains.process()
    }
}