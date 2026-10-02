class SanPham(
    val tenSanPham: String,
    val gia: Double,
    val soLuongTonKho: Int = 0
)

fun main() {
    val sanPham1 = SanPham("But bi", 5000.0, 20)
    val sanPham2 = SanPham(tenSanPham = "Vo", gia = 10000.0)

    println("${sanPham1.tenSanPham} - ${sanPham1.gia} - ${sanPham1.soLuongTonKho}")
    println("${sanPham2.tenSanPham} - ${sanPham2.gia} - ${sanPham2.soLuongTonKho}")
}
