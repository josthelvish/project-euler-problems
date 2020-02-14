/**
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 * multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Function with solution implementation
 */
fun sumMultiplesOf3and5(maxValue: Int): Int {
    return (1..maxValue).sumBy {
        if (it.rem(3) == 0 || it.rem(5) == 0) {
            it
        } else {
            0
        }
    }
}

/**
 * Inner class to run unit tests
 */
internal class TestProblem1 {
    @Test
    fun testSumFunction() {
        assertEquals(sumMultiplesOf3and5(9), 23)
        assertEquals(sumMultiplesOf3and5(999), 233168)
    }
}