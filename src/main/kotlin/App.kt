
fun main() {
    val cardType = "МИР"
    val totalTransferAmount = 75_000_00U
    val transferAmount = 52_350_00U

    val result = calculateTransfer(cardType,transferAmount,totalTransferAmount)
    println("Комиссия составит: ${result/100U}руб ${result % 100U}коп")
}

fun calculateTransfer(cardType: String, amount: UInt, totalTransferAmount: UInt): UInt {

    return when (cardType) {
        "MasterCard" -> if (totalTransferAmount >= 75_000_00U) ((amount.toDouble() * 0.006) + 20_00).toUInt()
        else 0U
        "Maestro" -> if (totalTransferAmount >= 75_000_00U) ((amount.toDouble() * 0.006) + 20_00).toUInt()
        else 0U
        "Visa" -> if (((amount.toDouble() * 0.0075) + 20_00).toUInt() < 35_00U) 35_00U else ((amount.toDouble() * 0.0075) + 20_00).toUInt()
        "МИР" -> if (((amount.toDouble() * 0.0075) + 20_00).toUInt() < 35_00U) 35_00U else ((amount.toDouble() * 0.0075) + 20_00).toUInt()
        else -> {
            println("Не корректный тип карты")
            0U
        }
    }
}
