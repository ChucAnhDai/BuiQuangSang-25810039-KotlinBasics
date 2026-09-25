// Bui Quang Sang - MSSV: 25810039

fun main() {
    val weight: Double = 60.0
    val height: Double = 1.65
    val bmi = weight / (height * height)

    val classification = if (bmi < 18.5) {
        "Gay"
    } else if (bmi < 25.0) {
        "Binh thuong"
    } else if (bmi < 30.0) {
        "Thua can"
    } else {
        "Beo phi"
    }

    println("BMI: $bmi")
    println("Phan loai: $classification")
}
