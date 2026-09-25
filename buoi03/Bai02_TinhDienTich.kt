fun tinhDienTich(chieuDai: Double, chieuRong: Double): Double {
    return chieuDai * chieuRong
}

val dienTichPhongKhach = tinhDienTich(5.0, 4.0)
val dienTichPhongNgu = tinhDienTich(3.0, 4.0)

fun main() {
    println("Dien tich phong khach: $dienTichPhongKhach m2")
    println("Dien tich phong ngu: $dienTichPhongNgu m2")
}
