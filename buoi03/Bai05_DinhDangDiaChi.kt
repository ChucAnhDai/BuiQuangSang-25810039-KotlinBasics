// Bui Quang Sang - MSSV: 25810039

fun dinhDangDiaChi(
    soNha: String,
    tenDuong: String,
    phuong: String = "Phuong 1",
    quan: String = "Quan 1",
    thanhPho: String = "TP HCM"
): String {
    return "$soNha, $tenDuong, $phuong, $quan, $thanhPho"
}

fun main() {
    val diaChi = dinhDangDiaChi(
        soNha = "12",
        tenDuong = "Nguyen Hue",
        phuong = "Ben Nghe",
        quan = "Quan 1",
        thanhPho = "TP HCM"
    )

    println("Dia chi giao hang: $diaChi")
}
