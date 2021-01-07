package kata

import com.code_kata.kata.Trigram
import com.code_kata.kata.Trigram.Companion.getLastTwoWords
import com.code_kata.kata.Trigram.Companion.getNextWord
import org.junit.Test

class TomSwiftTest {
    @Test
    fun testTrigram() {
        val trigram = Trigram("I wish I may I wish I might")

        val dict = trigram.generateWordMap()
        val generatedStory = trigram.getFirstTwoWords()

        var count = 0

        while (count < 10) {
            val lastTwoWords = generatedStory.getLastTwoWords()
            val nextWord = dict.getNextWord(lastTwoWords)
            generatedStory += nextWord
            count ++
        }
        println(generatedStory.joinToString(" "))
    }
}