import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Problem 10
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
fun findTheSum(upTo: Int): Long {
    var sum = 0L

    for (i in 1 until upTo) {
        if (isPrime(i)) {
            sum += i
        }
    }
    return sum
}

/**
 * Tests for problem 10
 */
internal class TestProblem10 {
    @Test
    fun findTheSumTest() {
        assertEquals(findTheSum(10), 17)
        assertEquals(findTheSum(2000000), 142913828922)
    }
}