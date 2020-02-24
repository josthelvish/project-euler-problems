/**
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
import org.junit.jupiter.api.Test
import java.util.Arrays
import kotlin.test.assertEquals

/**
 * Calculate the greatest common divisor of the two given numbers.
 */
private fun calculateGCD(x: Int, y: Int): Int {
    return if (y == 0) {
        x
    } else {
        calculateGCD(y, x % y)
    }
}

/**
 * Calculate the greatest common divisor of the given numbers.
 */
fun calculateGCD(vararg numbers: Int): Int {
    return Arrays.stream(numbers).reduce(0) { x, y -> calculateGCD(x, y) }
}

/**
 * Calculate the Least common multiple for the given numbers
 */
fun calculateLCM(vararg numbers: Int): Int {
    Arrays.stream(numbers).reduce(1) { x, y -> x * (y / calculateGCD(x, y)) }
    return Arrays.stream(numbers).reduce(1) { x, y -> x * (y / calculateGCD(x, y)) }
}

/**
 * Calculate the Least common multiple for the natural numbers from 1 to the given limit
 */
fun calculateLCM(limit: Int): Int {
    return calculateLCM(*IntArray(limit) { i -> i + 1 })
}

/**
 * Tests for problem 5
 */
internal class TestProblem5 {
    @Test
    fun calculateLCMTest() {
        assertEquals(calculateLCM(*IntArray(10) { i -> i + 1 }), 2520)
        assertEquals(calculateLCM(*IntArray(19) { i -> i + 1 }), 232792560)
    }

    @Test
    fun calculateGCDVarargTest() {
        assertEquals(calculateGCD(24, 14, 15, 18), 1)
        assertEquals(calculateGCD(30, 15, 9), 3)
    }

    @Test
    fun calculateGCDTest() {
        assertEquals(calculateGCD(1, 5), 1)
        assertEquals(calculateGCD(15, 18), 3)
        assertEquals(calculateGCD(2, 3), 1)
        assertEquals(calculateGCD(5, 3), 1)
    }

    @Test
    fun calculateLCMWithLimitTest() {
        assertEquals(calculateLCM(20), 232792560)
        assertEquals(calculateLCM(10), 2520)
    }
}

