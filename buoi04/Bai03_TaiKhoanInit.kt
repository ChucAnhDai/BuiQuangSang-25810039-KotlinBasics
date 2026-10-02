class TaiKhoanNganHang(val soTaiKhoan: String, val soDuBanDau: Double) {
    var soDu = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong: $soDuBanDau")
        }
    }
}

fun main() {
    TaiKhoanNganHang("TK001", 1000000.0)
    TaiKhoanNganHang("TK002", -500000.0)
}
