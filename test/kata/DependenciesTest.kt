package kata

import com.code_kata.kata.Dependencies
import org.junit.Test
import kotlin.test.assertEquals

class DependenciesTest {
    @Test
    fun testDependencies() {
        val dep = Dependencies()
        dep.addDirect("A", mutableListOf("B", "C"))
        dep.addDirect("B", mutableListOf("C", "E"))
        dep.addDirect("C", mutableListOf("G"))
        dep.addDirect("D", mutableListOf("A", "F") )
        dep.addDirect("E", mutableListOf("F"))
        dep.addDirect("F", mutableListOf("H"))

        assertEquals(mutableListOf("B", "C", "E", "F", "G", "H"), dep.dependenciesFor("A"))
        assertEquals(mutableListOf("C", "E", "F", "G", "H"), dep.dependenciesFor("B"))
        assertEquals(mutableListOf("G"), dep.dependenciesFor("C"))
        assertEquals(mutableListOf("A", "B", "C", "E", "F", "G", "H"), dep.dependenciesFor("D"))
        assertEquals(mutableListOf("F", "H"), dep.dependenciesFor("E"))
        assertEquals(mutableListOf("H"), dep.dependenciesFor("F"))
    }

    @Test
    fun testCircularDependencies() {
        val dep = Dependencies()
        dep.addDirect("A", mutableListOf("B"))
        dep.addDirect("B", mutableListOf("C"))
        dep.addDirect("C", mutableListOf("A"))

        assertEquals(mutableListOf("A", "B", "C"), dep.dependenciesFor("A"))
        assertEquals(mutableListOf("A", "B", "C"), dep.dependenciesFor("B"))
        assertEquals(mutableListOf("A", "B", "C"), dep.dependenciesFor("C"))
    }
}