data class ChuDeHocTap(
    val tenChuDe: String,
    val soBaiHoc: Int
)

fun inMotHang(chuDeTrongHang: List<ChuDeHocTap>) {
    println(
        chuDeTrongHang.joinToString(" | ") {
            "${it.tenChuDe} (${it.soBaiHoc} bai)"
        }
    )
}

fun main() {
    val danhSachChuDe = listOf(
        ChuDeHocTap("Kotlin", 12),
        ChuDeHocTap("Android", 8),
        ChuDeHocTap("Giao dien", 6),
        ChuDeHocTap("Du lieu", 5),
        ChuDeHocTap("Kiem thu", 4),
        ChuDeHocTap("Phat hanh", 3)
    )

    println("LUOI CHU DE HOC TAP")
    danhSachChuDe.chunked(2).forEach { hang ->
        inMotHang(hang)
    }
}
