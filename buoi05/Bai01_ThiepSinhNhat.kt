data class ThiepSinhNhat(
    val nguoiNhan: String,
    val nguoiGui: String,
    val loiChuc: String
)

fun main() {
    val thiep = ThiepSinhNhat(
        nguoiNhan = "Minh Anh",
        nguoiGui = "Bui Quang Sang",
        loiChuc = "Chuc ban sinh nhat vui ve!"
    )

    println("THIEP SINH NHAT")
    println("Gui den: ${thiep.nguoiNhan}")
    println(thiep.loiChuc)
    println("Nguoi gui: ${thiep.nguoiGui}")
}
