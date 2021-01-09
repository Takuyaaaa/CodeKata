package kata

import com.code_kata.kata.Trigram
import org.junit.Test
import java.io.File

class TomSwiftTest {
    @Test
    fun testTrigram1() {
        val trigram = Trigram("I wish I may I wish I might")

        trigram.execute(6)
        println(trigram.joinToStringBySpace())
    }

    @Test
    fun testTrigram2() {
        val story = File("resources/TomSwift.txt")
                .readText()

        val trigram = Trigram(story)

        trigram.execute(100)
        println(trigram.joinToStringBySpace())
    }
}