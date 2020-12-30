package data_munging

import com.code_kata.data_munging.DataMunging.Companion.calculateScoreSpread
import com.code_kata.data_munging.DataMunging.Companion.calculateTemperatureSpread
import com.code_kata.data_munging.DataMunging.Companion.readFileAndProcessDataWith
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class DataMungingTest {
    @Test
    fun testCalculateTemperatureSpread() {
        val temperatureSpread = File("resources/weather.dat")
                .readFileAndProcessDataWith(::calculateTemperatureSpread)

        assertEquals("14", temperatureSpread["date"])
        assertEquals("2", temperatureSpread["spread"])
    }

    @Test
    fun testCalculateScoreSpread() {
        val scoreSpread = File("resources/football.dat")
                .readFileAndProcessDataWith(::calculateScoreSpread)

        assertEquals("Aston_Villa", scoreSpread["team"])
        assertEquals("1", scoreSpread["spread"])
    }
}