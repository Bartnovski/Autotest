import org.junit.Test

import org.junit.Assert.*

class AppKtTest {
    val cards = arrayOf("MasterCard","Maestro","VK Pay","Visa","МИР")
    var totalTransferAmount = 70_000_00U
    var transferAmount = 52_350_00U
    var result : UInt = 0U

    @Test
    fun checkCardsTest() {

        for (i in 0..2) {
            result = calculateTransfer(cards[i], transferAmount, totalTransferAmount)
            assertEquals(0U, result)
        }
        for (i in 3..4) {
            result = calculateTransfer(cards[i], transferAmount, totalTransferAmount)
            assertNotEquals(0U, result)
        }
    }

    @Test
    fun checkTotalAmountTest() {

        totalTransferAmount = 75_000_00U

        for (i in 0..1) {
            result = calculateTransfer(cards[i], transferAmount, totalTransferAmount)
            assertNotEquals(0U, result)
        }
    }

    @Test
    fun checkTransferAmount() {
        transferAmount = 100_00U
        for(i in 3..4) {
            result = calculateTransfer(cards[i],transferAmount,totalTransferAmount)
            assertEquals(35_00U,result)
        }
    }

    @Test
    fun checkIncorrectCard() {
        result = calculateTransfer("Some text",transferAmount,totalTransferAmount)
        assertEquals(0U,result)
    }
}