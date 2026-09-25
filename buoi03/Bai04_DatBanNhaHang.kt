fun datBan(
    tenKhachHang: String,
    soLuongKhach: Int,
    loaiBan: String = "Ban thuong"
) {
    println("$tenKhachHang dat $loaiBan cho $soLuongKhach khach.")
}

fun main() {
    datBan("An", 2)
    datBan("Binh", 4, "Ban VIP")
    datBan(
        tenKhachHang = "Chi",
        soLuongKhach = 6,
        loaiBan = "Ban gia dinh"
    )
}
