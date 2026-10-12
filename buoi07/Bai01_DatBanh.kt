data class DonBanh(
    val huongVi: String,
    val soLuong: Int,
    val donGia: Double
)

fun taoDonBanh(huongVi: String, soLuong: Int): DonBanh {
    return DonBanh(
        huongVi = huongVi,
        soLuong = soLuong,
        donGia = 25000.0
    )
}

fun main() {
    val donBanh = taoDonBanh("Dau", 4)
    val tongTien = donBanh.soLuong * donBanh.donGia

    println("Buoc 1 - Chon banh: ${donBanh.huongVi}")
    println("Buoc 2 - So luong: ${donBanh.soLuong}")
    println("Buoc 3 - Tong tien: $tongTien VND")
    println("Dat banh thanh cong")
}
