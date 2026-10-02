open class DongVat(val ten: String) {
    open fun keu(): String {
        return "Dong vat keu"
    }
}

class Cho(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Gau gau"
    }
}

class Meo(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Meo meo"
    }
}

fun main() {
    val danhSachDongVat = listOf<DongVat>(
        Cho("Milu"),
        Meo("Miu")
    )

    for (dongVat in danhSachDongVat) {
        println("${dongVat.ten}: ${dongVat.keu()}")
    }
}
