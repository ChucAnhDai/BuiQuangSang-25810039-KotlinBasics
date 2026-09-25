fun main() {
    val averageScore: Double = 8.8

    val classification = when (averageScore) {
        in 8.5..10.0 -> "Xuat sac"
        in 8.0..8.49 -> "Gioi"
        in 6.5..7.99 -> "Kha"
        in 5.0..6.49 -> "Trung binh"
        in 0.0..4.99 -> "Yeu"
        else -> "Diem khong hop le"
    }

    println("Diem trung binh: $averageScore")
    println("Xep loai: $classification")
}
