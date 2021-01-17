package kata

import com.code_kata.kata.SinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SimpleListsTest {

    @Test
    fun test() {
        val list = SinglyLinkedList()

        assertNull(list.find("fred"))
        list.add("fred")
        assertEquals("fred", list.find("fred")?.value())

        assertNull(list.find("wilma"))
        list.add("wilma")

        assertEquals("fred",  list.find("fred")?.value())
        assertEquals("wilma", list.find("wilma")?.value())
        assertEquals(listOf("fred", "wilma"), list.values())
    }
}