package kata

import org.junit.Test

class TomSwiftTest {
    @Test
    fun testTrigram() {
        val originalSentence = "I wish I may I wish I might".split(" ")

        val wordDictionary = originalSentence
                .dropLast(2)
                .mapIndexed { index, it -> listOf(it, originalSentence[index + 1], originalSentence[index + 2]) }
                .groupBy ({ "${it[0]} ${it[1]}" }, {it[2]})

        var story = listOf(originalSentence[0], originalSentence[1])

        var count = 0
        while (count < 10) {
            val lastTwo = "${story[story.lastIndex - 1]} ${story[story.lastIndex]}"

            val nextWord = wordDictionary[lastTwo]?.elementAt(0)

            story = story.plus("$nextWord")

            count++
        }
        println(story.joinToString(" "))
    }
}