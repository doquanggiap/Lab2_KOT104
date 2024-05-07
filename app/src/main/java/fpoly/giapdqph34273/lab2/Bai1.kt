package fpoly.giapdqph34273.lab2

fun main() {
    var a: Int
    var b: Int


    while (true) {
        try {
            print("Nhập a: ")
            a = readLine()!!.toInt()
            break
        } catch (e: Exception) {
            println("Nhập sai, vui lòng nhập lại")
        }
    }

    while (true) {
        try {
            print("Nhập b: ")
            b = readLine()!!.toInt()
            break
        } catch (e: Exception) {
            println("Nhập sai, vui lòng nhập lại")
        }
    }




    println(giaiPTBac1(a, b))
}

fun giaiPTBac1(a: Int, b: Int): String {
    var ketQua: String = ""
    if (a != 0) {
        ketQua = "x = ${-b / a}"
        return ketQua
    }

    if (b != 0) {
        return "Vô nghiệm"
    } else {
        return "Vô số nghiệm"
    }
}