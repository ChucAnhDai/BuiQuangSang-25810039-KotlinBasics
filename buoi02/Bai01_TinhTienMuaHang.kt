fun main() {
    val quantity: Int = 3
    val unitPrice: Double = 50_000.0

    val moneyBeforeTax = quantity.toDouble() * unitPrice
    val tax = moneyBeforeTax * 0.08
    val totalMoney = moneyBeforeTax + tax

    println("Tong tien phai tra: $totalMoney VND")
}
