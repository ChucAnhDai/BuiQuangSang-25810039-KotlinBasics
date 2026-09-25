fun ghiNhatKyCoUnit(hoatDong: String): Unit {
    println("[Nhat ky] $hoatDong")
}

fun ghiNhatKyKhongUnit(hoatDong: String) {
    println("[Nhat ky] $hoatDong")
}

fun main() {
    ghiNhatKyCoUnit("Dang mo ung dung")
    ghiNhatKyKhongUnit("Dang dong ung dung")
}
