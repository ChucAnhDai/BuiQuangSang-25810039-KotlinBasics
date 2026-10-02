class TaiKhoanNganHang(val soTaiKhoan: String, var soDu: Double) {
    fun napTien(soTien: Double) {
        soDu += soTien
    }

    fun rutTien(soTien: Double): Boolean {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien
            return true
        }
        return false
    }
}

fun main() {
    val taiKhoan = TaiKhoanNganHang("TK003", 1000000.0)
    println("So du: ${taiKhoan.soDu}")

    taiKhoan.napTien(500000.0)
    println("Sau khi nap: ${taiKhoan.soDu}")

    println("Rut tien thanh cong: ${taiKhoan.rutTien(300000.0)}")
    println("Sau khi rut: ${taiKhoan.soDu}")

    println("Rut tien thanh cong: ${taiKhoan.rutTien(2000000.0)}")
    println("So du cuoi: ${taiKhoan.soDu}")
}
