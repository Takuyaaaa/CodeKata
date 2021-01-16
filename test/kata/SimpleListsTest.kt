package kata

import com.code_kata.kata.SinglyLinkedList
import org.junit.Test

class SimpleListsTest {

    @Test
    fun test() {
        val list = SinglyLinkedList()

        list.add("takuya")
        list.add("Yasuko")
        list.add("Tom")
        list.add("Tom2")

        println(list.values())

    }
}