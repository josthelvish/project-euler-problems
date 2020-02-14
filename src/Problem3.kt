/**
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Determines the primes of a given number and returns the largest among them
 */
fun getLargestPrimeFactorOf(number: Long): Long {
    var value = number
    var div = 2L
    var maxFact = 0L

    while (value != 0L) {
        if (value.rem(div) != 0L) {
            div += 1
        } else {
            maxFact = value
            value /= div
            if (value == 1L) {
                break
            }
        }
    }
    return maxFact
}

/**
 * Inner class to run unit tests
 */
internal class TestProblem3 {
    @Test
    fun testGetLargestFactorOf() {
        assertEquals(getLargestPrimeFactorOf(13195), 29)
        assertEquals(getLargestPrimeFactorOf(600851475143), 6857)
    }
}

