class KhachHang(var ho: String, var ten: String) {
    var hoTen: String
        get() = "$ho $ten"
        set(value) {
            val phanHoTen = value.trim().split(Regex("\\s+"), limit = 2)
            ho = phanHoTen[0]
            ten = phanHoTen.getOrElse(1) { "" }
        }
}

fun main() {
    val khachHang = KhachHang("Bui", "Sang")
    println(khachHang.hoTen)

    khachHang.ten = "Quang Sang"
    println(khachHang.hoTen)

    khachHang.hoTen = "Nguyen Van An"
    println("Ho: ${khachHang.ho}")
    println("Ten: ${khachHang.ten}")
}
