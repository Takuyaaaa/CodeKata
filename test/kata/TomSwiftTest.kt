package kata

import com.code_kata.kata.Trigram
import org.junit.Test
import java.io.File

class TomSwiftTest {
    @Test
    fun testTrigram1() {
        val trigram = Trigram("I wish I may I wish I might")

        trigram.execute(6)
    }

    @Test
    fun testTrigram2() {
        val story = File("resources/TomSwift.txt").readText()
        val trigram = Trigram(story)

        trigram.execute(1000)
    }
}