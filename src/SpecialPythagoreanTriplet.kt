/**
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

/**
 * Calculates the product of the given values
 */
fun productOf(vararg values: Int): Int {
    return values.reduce { acc, i -> acc * i }

}

/**
 * Checks if the given values are a Pythagorean triplet
 */
fun isPythagoreanTriplet(value: Triple<Int, Int, Int>): Boolean {
    return value.first * value.first + value.second * value.second == value.third * value.third
}

/**
 * Calculates the values for a,b and c where, a + b + c = 1000 and all the variables perform a Pythagorean triplet
 */
fun productOfPythagoreanTriplet(): Int {
    val sum = 1000
    for (a in 1..sum / 3) {
        for (b in a + 1..sum / 2) {
            val c = 1000 - a - b
            if (isPythagoreanTriplet(Triple(a, b, c))) {
                println("$a $b $c")
                return productOf(a, b, c)
            }
        }
    }
    return -1
}

/**
 * Tests for problem 9
 */
internal class TestProblem9 {
    @Test
    fun productOfTest() {
        assertEquals(productOf(3, 3, 3), 27)
        assertEquals(productOf(2, 3), 6)
    }

    @Test
    fun isValidTripletTest() {
        assertEquals(isPythagoreanTriplet(Triple(3, 3, 3)), false)
        assertEquals(isPythagoreanTriplet(Triple(3, 4, 5)), true)
        assertEquals(isPythagoreanTriplet(Triple(200, 375, 425)), true)
    }

    @Test
    fun testProduct() {
        assertEquals(productOfPythagoreanTriplet(), 31875000)
    }
}