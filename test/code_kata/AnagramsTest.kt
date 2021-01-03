package code_kata

import com.code_kata.code_kata.Anagrams.Companion.extractAllAnagrams
import org.junit.Test
import java.io.File
import kotlin.test.assertTrue

class AnagramsTest {
    @Test
    fun testAnagrams() {
        val anagrams = File("resources/wordlist_for_anagrams.txt")
                .extractAllAnagrams()

        anagrams.forEach {
            assertTrue(it.size > 1)
            println(it)
        }
    }
}