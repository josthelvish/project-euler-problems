/**
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
 * 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.fail

/**
 * Calculate the largest palindrome with n given digits. N digits must be greater than 1.
 */
fun largestPalindrome(nDigits: Int): Int {
    if (nDigits < 2) {
        throw IllegalArgumentException(
            "The algorithm calculates for only two or more digits. Start with different " +
                    "value than: $nDigits"
        )
    }

    val highestValue = highestValue(nDigits)
    val lowestValue = lowestValue(highestValue)

    var maxProduct = 0
    var multiplicand = 0
    var multiplier = 0
    for (i in highestValue downTo lowestValue) {
        for (j in i downTo lowestValue) {
            var product = i * j
            if (product < maxProduct) {
                break
            }
            if (isPalindrome(product)) {
                maxProduct = product
                multiplicand = i
                multiplier = j
            }
        }
    }
    println(
        "Largest palindrome made from the product of two $nDigits-digit numbers is $maxProduct = $multiplicand ×" +
                " $multiplier."
    )
    return maxProduct
}

/**
 * Calculate the highest value with n given digits
 */
fun highestValue(nDigits: Int): Int {
    var highestValue = 0
    for (i in 1..nDigits) {
        highestValue *= 10
        highestValue += 9
    }
    return highestValue
}

/**
 * Calculate the lowest value with the same digits as the given highest input
 */
fun lowestValue(highestValue: Int): Int {
    return 1 + highestValue / 10
}

/**
 * Check if a given number is a palindrome
 */
fun isPalindrome(number: Int): Boolean {
    var transformedNumber = number
    var reversedNumber = 0

    while (transformedNumber != 0) {
        reversedNumber *= 10
        reversedNumber += transformedNumber.rem(10)
        transformedNumber /= 10
    }

    return number == reversedNumber
}


/**
 * Inner class to run unit tests
 */
internal class TestProblem4 {
    @Test
    fun lowestValueTest() {
        assertEquals(lowestValue(9999), 1000)
        assertEquals(lowestValue(999), 100)
        assertEquals(lowestValue(99), 10)
        assertEquals(lowestValue(9), 1)
    }

    @Test
    fun highestValueTest() {
        assertEquals(highestValue(4), 9999)
        assertEquals(highestValue(3), 999)
        assertEquals(highestValue(2), 99)
    }

    @Test
    fun testGetLargestFactorOf() {
        try {
            largestPalindrome(1)
            fail("An exception should be thrown")
        } catch (exception: IllegalArgumentException) {
            val expectedMessage =
                "The algorithm calculates for only two or more digits. Start with different value than: 1"
            assertEquals(expectedMessage, exception.message)
        }

        assertEquals(largestPalindrome(2), 9009)
        assertEquals(largestPalindrome(3), 906609)
        assertEquals(largestPalindrome(4), 99000099)
    }

    @Test
    fun testIsPalindrome() {
        assertEquals(isPalindrome(9), true)
        assertEquals(isPalindrome(901), false)
        assertEquals(isPalindrome(11911), true)
    }
}

/**
 * NOTES
 * Check this site for info: https://oeis.org/A002385
 * Every palindrome with an even number of digits is divisible by 11;
 */
