package kata

import com.code_kata.kata.SinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SimpleListsTest {

    @Test
    fun testSinglyLinkedList1() {
        val list = SinglyLinkedList()

        assertNull(list.find("fred"))
        list.add("fred")
        assertEquals("fred", list.find("fred")?.value)

        assertNull(list.find("wilma"))
        list.add("wilma")

        assertEquals("fred",  list.find("fred")?.value)
        assertEquals("wilma", list.find("wilma")?.value)
        assertEquals(listOf("fred", "wilma"), list.values())
    }

    @Test
    fun testSinglyLinkedList2() {
        val list = SinglyLinkedList()

        list.add("fred")
        list.add("wilma")
        list.add("betty")
        list.add("barney")
        assertEquals(listOf("fred", "wilma", "betty", "barney"), list.values())

        list.delete(list.find("wilma")!!)
        assertEquals(listOf("fred", "betty", "barney"), list.values())

        list.delete(list.find("barney")!!)
        assertEquals(listOf("fred", "betty"), list.values())

        list.delete(list.find("fred")!!)
        assertEquals(listOf("betty"), list.values())

        list.delete(list.find("betty")!!)
        assertEquals(listOf(), list.values())
    }
}