package data_munging

import com.code_kata.data_munging.DataMunging.Companion.calculateSmallestSpread
import org.junit.Test
import java.io.File

class DataMungingTest {
    @Test
    fun testPrintTheSmallestSpread() {
        val smallestSpread = File("resources/weather.dat")
                .calculateSmallestSpread()

        println(smallestSpread)
    }
}