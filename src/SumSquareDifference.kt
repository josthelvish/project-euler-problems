import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.test.assertEquals

/**
 * Problem 6
 * The sum of the squares of the first ten natural numbers is,
 * 1^2+2^2+...+10^2=385
 * The square of the sum of the first ten natural numbers is,
 * (1+2+...+10)^2=552=3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025−385=2640.Find the difference between the sum of the squares of the first one hundred natural numbers and the
 * square of the sum.
 */

fun calculateSumSquareDifference(limit: Int): Int {
    val naturalNumbers = (1..limit).toList()
    return naturalNumbers.sum().toDouble().pow(2).minus(naturalNumbers.sumBy { it -> it * it }).toInt()
}

internal class TestSumSquareDifference {
    @Test
    fun calculateSumSquareDifferenceTest() {

        assertEquals(calculateSumSquareDifference(10), 2640)
        assertEquals(calculateSumSquareDifference(100), 25164150)
    }
}