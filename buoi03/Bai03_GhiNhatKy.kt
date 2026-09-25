// Bui Quang Sang - MSSV: 25810039

fun ghiNhatKyCoUnit(hoatDong: String): Unit {
    println("[Nhat ky] $hoatDong")
}

fun ghiNhatKyKhongUnit(hoatDong: String) {
    println("[Nhat ky] $hoatDong")
}

// Kotlin tu suy ra Unit cho ham khong tra ve gia tri huu ich.
fun main() {
    ghiNhatKyCoUnit("Dang mo ung dung")
    ghiNhatKyKhongUnit("Dang dong ung dung")
}
