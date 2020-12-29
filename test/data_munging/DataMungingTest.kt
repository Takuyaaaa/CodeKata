package data_munging

import com.code_kata.data_munging.DataMunging.Companion.calculateScoreSpread
import com.code_kata.data_munging.DataMunging.Companion.calculateTemperatureSpread
import org.junit.Test
import java.io.File

class DataMungingTest {
    @Test
    fun testPrintTheSmallestTemperatureSpread() {
        val smallestTemperatureSpread = File("resources/weather.dat")
                .calculateTemperatureSpread()

        println(smallestTemperatureSpread)
    }

    @Test
    fun testPrintTheSmallestScoreSpread() {
        val smallestScoreSpread = File("resources/football.dat")
                .calculateScoreSpread()

        println(smallestScoreSpread)
    }
}