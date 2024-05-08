package fpoly.giapdqph34273.lab2

fun main() {
    println("Kiểm tra năm nhuận")
    var year: Int

    // validate và nhập năm
    while (true) {
        try {
            print("Nhập năm: ")
            year = readLine()!!.toInt()
            if (year < 0) {
                println("Vui lòng nhập năm lớn hơn 0")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập năm là số nguyên dương")
        }
    }

    // in ra kết quả
    println(namNhuan(year))
}

fun namNhuan(year: Int): String {
    var ketQua: String
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        ketQua = "Năm $year là năm nhuận"
    } else {
        ketQua = "Năm $year không phải là năm nhuận"
    }
    return ketQua
}

