package kata

import com.code_kata.kata.Dependencies
import org.junit.Test

class DependenciesTest {
    @Test
    fun testDependencies() {
        val dep = Dependencies()
        dep.addDirect("A", listOf("B", "C"))
        dep.addDirect("B", listOf("C", "E"))
        dep.addDirect("C", listOf("G"))
        dep.addDirect("D", listOf("A", "F") )
        dep.addDirect("E", listOf("F"))
        dep.addDirect("F", listOf("H"))

//        println(dep.dependencyMap)
        dep.checkDependencies()
    }
}