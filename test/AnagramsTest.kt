import com.code_kata.Anagrams.Companion.printAllAnagrams
import org.junit.Test
import java.io.File

class AnagramsTest {
    @Test
    fun testAnagrams() {
        File("resources/wordlist_for_anagrams.txt")
                .printAllAnagrams()
    }
}