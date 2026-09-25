fun tinhBinhPhuongDayDu(so: Int): Int {
    return so * so
}

fun tinhBinhPhuong(so: Int) = so * so

fun tinhChuViHinhVuongDayDu(canh: Double): Double {
    return canh * 4
}

fun tinhChuViHinhVuong(canh: Double) = canh * 4

fun kiemTraChanDayDu(so: Int): Boolean {
    return so % 2 == 0
}

fun kiemTraChan(so: Int) = so % 2 == 0

fun main() {
    println("Binh phuong day du: ${tinhBinhPhuongDayDu(5)}")
    println("Binh phuong rut gon: ${tinhBinhPhuong(5)}")

    println("Chu vi day du: ${tinhChuViHinhVuongDayDu(4.0)}")
    println("Chu vi rut gon: ${tinhChuViHinhVuong(4.0)}")

    println("Kiem tra chan day du: ${kiemTraChanDayDu(6)}")
    println("Kiem tra chan rut gon: ${kiemTraChan(6)}")
}
