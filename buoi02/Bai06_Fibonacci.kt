fun main() {
    var firstNumber = 0
    var secondNumber = 1

    for (position in 0..20) {
        if (firstNumber >= 100) {
            break
        }

        println("Vi tri $position: $firstNumber")

        val nextNumber = firstNumber + secondNumber
        firstNumber = secondNumber
        secondNumber = nextNumber
    }
}
