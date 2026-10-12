class ManHinh(val tenManHinh: String) {
    fun onCreate() {
        println("$tenManHinh - onCreate")
    }

    fun onStart() {
        println("$tenManHinh - onStart")
    }

    fun onResume() {
        println("$tenManHinh - onResume")
    }

    fun onPause() {
        println("$tenManHinh - onPause")
    }

    fun onStop() {
        println("$tenManHinh - onStop")
    }

    fun onRestart() {
        println("$tenManHinh - onRestart")
    }

    fun onDestroy() {
        println("$tenManHinh - onDestroy")
    }
}

fun main() {
    val manHinh = ManHinh("Man hinh chinh")

    manHinh.onCreate()
    manHinh.onStart()
    manHinh.onResume()
    manHinh.onPause()
    manHinh.onStop()
    manHinh.onRestart()
    manHinh.onStart()
    manHinh.onResume()
    manHinh.onDestroy()
}
