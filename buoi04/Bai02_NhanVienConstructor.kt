class NhanVien(maNhanVien: String, val ten: String, var luongThang: Double) {
    constructor(ten: String) : this("TAM", ten, 0.0)
}

fun main() {
    val nhanVien1 = NhanVien("NV01", "An", 10000000.0)
    val nhanVien2 = NhanVien("Binh")

    println("${nhanVien1.ten} - ${nhanVien1.luongThang}")
    println("${nhanVien2.ten} - ${nhanVien2.luongThang}")
}
