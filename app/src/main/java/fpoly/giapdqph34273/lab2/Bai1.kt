package fpoly.giapdqph34273.lab2

fun main() {
    println("Giải phương trình bậc nhất ax + b = 0")
    var a: Double
    var b: Double

    // validate và nhập a
    while (true) {
        try {
            print("Nhập a: ")
            a = readLine()!!.toDouble()
            break
        } catch (e: Exception) {
            println("Vui lòng chỉ nhập số")
        }
    }

    // validate và nhập b
    while (true) {
        try {
            print("Nhập b: ")
            b = readLine()!!.toDouble()
            break
        } catch (e: Exception) {
            println("Vui lòng chỉ nhập số")
        }
    }

    // in ra kết quả
    println(giaiPTBac1(a, b))
}

fun giaiPTBac1(a: Double, b: Double): String {
    var ketQua: String
    if (a != 0.0) {
        ketQua = "x = ${-b / a}"
        return ketQua
    }

    if (b != 0.0) {
        return "Vô nghiệm"
    } else {
        return "Vô số nghiệm"
    }
}