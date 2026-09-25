fun main() {
    val tuoiKhachHang = 65

    val loaiVe = if (tuoiKhachHang < 12) {
        "Ve tre em"
    } else if (tuoiKhachHang < 60) {
        "Ve nguoi lon"
    } else {
        "Ve cao tuoi"
    }

    println("Loai ve: $loaiVe")
}
