// Bui Quang Sang - MSSV: 25810039

val kiemTraDoDai: (String) -> Boolean = { matKhau ->
    matKhau.length >= 8
}

fun main() {
    val matKhau1 = "abc123"
    val matKhau2 = "kotlin123"
    val matKhau3 = "matkhau2026"

    println("$matKhau1 hop le: ${kiemTraDoDai(matKhau1)}")
    println("$matKhau2 hop le: ${kiemTraDoDai(matKhau2)}")
    println("$matKhau3 hop le: ${kiemTraDoDai(matKhau3)}")
}
