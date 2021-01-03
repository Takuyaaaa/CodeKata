package code_kata

import com.code_kata.code_kata.BloomFilters
import org.junit.Test
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BloomFiltersTest {
    @Test
    fun testBloomFilters() {
        val bloomFilter = BloomFilters(16, File("resources/wordlist_for_bloomfilters.txt"))

        // words written in wordlist_for_bloomfilters.txt
        assertTrue{ bloomFilter.includes("trying") }
        assertTrue{ bloomFilter.includes("engineer!") }

        // words not written in wordlist_for_bloomfilters.txt
        assertFalse{ bloomFilter.includes("noway") }
        assertFalse{ bloomFilter.includes("irrelevant") }
    }
}