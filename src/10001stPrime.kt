/**
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Checks if the given number is prime
 */
fun isPrime(value: Int): Boolean {
    if (value < 2) {
        return false
    }
    var i = 2
    while (i * i <= value) {
        if (value.rem(i) == 0) {
            return false
        }
        i += 1
    }
    return true
}

/**
 * Returns the prime value in the given position
 */
fun nThPrime(position: Int): Int {
    var i = 2
    var n = position
    while (position > 0) {
        if (isPrime(i)) {
            n -= 1
            if (n == 0) {
                return i
            }
        }
        i += 1
    }
    return -1
}

/**
 * Tests for problem 7
 */
internal class TestProblem7 {
    @Test
    fun isPrimeTest() {
        assertEquals(isPrime(2), true)
        assertEquals(isPrime(3), true)
        assertEquals(isPrime(5), true)
        assertEquals(isPrime(7), true)
        assertEquals(isPrime(11), true)
        assertEquals(isPrime(13), true)

        assertEquals(isPrime(1), false)
        assertEquals(isPrime(4), false)
        assertEquals(isPrime(6), false)
        assertEquals(isPrime(8), false)
        assertEquals(isPrime(9), false)
        assertEquals(isPrime(10), false)
    }

    @Test
    fun nThPrimeTest() {
        assertEquals(nThPrime(3), 5)
        assertEquals(nThPrime(5), 11)
        assertEquals(nThPrime(6), 13)
        assertEquals(nThPrime(10001), 104743)
    }
}

