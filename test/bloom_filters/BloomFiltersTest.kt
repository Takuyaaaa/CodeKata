package bloom_filters

import com.code_kata.bloom_filters.BloomFilters
import org.junit.Test
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BloomFiltersTest {
    @Test
    fun test() {
        val bloomFilter = BloomFilters(16, File("resources/wordlist.txt"))

        // words written in wordlist.txt
        assertTrue{ bloomFilter.includes("trying") }
        assertTrue{ bloomFilter.includes("engineer!") }

        // words not written in wordlist.txt
        assertFalse{ bloomFilter.includes("noway") }
        assertFalse{ bloomFilter.includes("irrelevant") }
    }
}