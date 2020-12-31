import org.junit.Test
import java.io.File

class AnagramsTest {
    @Test
    fun testAnagrams() {
        val list = File("resources/wordlist_for_anagrams.txt")
                .readLines()
                .map {
                    val chars = it.toLowerCase().toSortedSet()
                    Pair(chars, it)
                }
                .groupBy { it.first }
                .toList()
                .sortedByDescending { it.second.count() }

        println(list[0])
    }
}