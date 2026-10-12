fun tenMatXucXac(soMat: Int): String {
    return when (soMat) {
        1 -> "Mot"
        2 -> "Hai"
        3 -> "Ba"
        4 -> "Bon"
        5 -> "Nam"
        6 -> "Sau"
        else -> "Khong hop le"
    }
}

fun main() {
    val soLanTung = 3

    repeat(soLanTung) { lanTung ->
        val ketQua = (1..6).random()
        println("Lan tung ${lanTung + 1}: ${tenMatXucXac(ketQua)}")
    }
}
