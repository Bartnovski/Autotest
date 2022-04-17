import org.junit.Test

import org.junit.Assert.*

class AppKtTest {

    @Test
    fun testCalculateTransfer() {
        val cards = arrayOf("MasterCard","Maestro","Visa","МИР","VK Pay","Some text")
        var totalTransferAmount = 75_000_00U
        var transferAmount = 52_350_00U
        var result : UInt

        /* Check cards */
        for(i in 0..3) {
            result = calculateTransfer(cards[i],transferAmount,totalTransferAmount)
            assertNotEquals(0U,result)
        }
        for(i in 4..5) {
            result = calculateTransfer(cards[i],transferAmount,totalTransferAmount)
            assertEquals(0U,result)
        }

        /* Check rest branches */
        totalTransferAmount = 70_000_00U

        for(i in 0..1) {
            result = calculateTransfer(cards[i],transferAmount,totalTransferAmount)
            assertEquals(0U,result)
        }

        transferAmount = 100_00U
        for(i in 2..3) {
            result = calculateTransfer(cards[i],transferAmount,totalTransferAmount)
            assertEquals(35_00U,result)
        }

    }
}