package kata

import com.code_kata.kata.SinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class SimpleListsTest {

    @Test
    fun test() {
        val list = SinglyLinkedList()

        list.add("fred")
        list.add("wilma")
        list.add("betty")
        list.add("barney")

        assertEquals(listOf("fred", "wilma", "betty", "barney"), list.values())

    }
}