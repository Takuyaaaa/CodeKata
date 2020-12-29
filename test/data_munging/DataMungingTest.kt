package data_munging

import com.code_kata.data_munging.DataMunging.Companion.calculateScoreSpread
import com.code_kata.data_munging.DataMunging.Companion.calculateTemperatureSpread
import com.code_kata.data_munging.DataMunging.Companion.readFileAndProcessDataWith
import org.junit.Test
import java.io.File

class DataMungingTest {
    @Test
    fun testPrintTheSmallestTemperatureSpread() {
        val smallestTemperatureSpread = File("resources/weather.dat")
                .readFileAndProcessDataWith(::calculateTemperatureSpread)

        println(smallestTemperatureSpread)
    }

    @Test
    fun testPrintTheSmallestScoreSpread() {
        val smallestScoreSpread = File("resources/football.dat")
                .readFileAndProcessDataWith(::calculateScoreSpread)

        print(smallestScoreSpread)
    }
}