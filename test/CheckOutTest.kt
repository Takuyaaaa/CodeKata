import com.code_kata.CheckOut
import org.junit.Test
import kotlin.test.assertEquals

class CheckOutTest {
    @Test
    /**
     *
    Item   Unit      Special
           Price     Price
    --------------------------
    A       50       3 for 130
    B       30       2 for 45
    C       20
    D       15
     */
    fun testPrice() {
        val co = CheckOut(mapOf("A" to 50, "B" to 30, "C" to 20, "D" to 15),
        listOf(Triple("A", 3, 130), Triple("B", 2, 45)))

        assertEquals(  0, co.price(""))
        assertEquals( 50, co.price("A"))
        assertEquals( 80, co.price("AB"))
        assertEquals(115, co.price("CDBA"))

        assertEquals(100, co.price("AA"))
        assertEquals(130, co.price("AAA"))
        assertEquals(180, co.price("AAAA"))
        assertEquals(230, co.price("AAAAA"))
        assertEquals(260, co.price("AAAAAA"))

        assertEquals(160, co.price("AAAB"))
        assertEquals(175, co.price("AAABB"))
        assertEquals(190, co.price("AAABBD"))
        assertEquals(190, co.price("DABABA"))
    }
}