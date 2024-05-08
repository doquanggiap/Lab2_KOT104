package fpoly.giapdqph34273.lab2

fun main() {

    println("Nhập tháng để xác định quý của tháng đó")
    var month: Int

    // validate và nhập tháng
    while (true){
        try {
            print("Nhập tháng: ")
            month = readLine()!!.toInt()
            if(month !in 1..12){
                println("Vui lòng nhập tháng từ 1 -> 12")
                continue
            }
            break
        }catch (e: Exception){
            println("Vui lòng nhập tháng từ 1 -> 12")
        }
    }

    // in ra kết quả
    println("Tháng $month thuộc ${quy(month)}")

}

fun quy(month: Int): String {
    var ketQua: String = ""
    when(month){
        in 1..3 -> ketQua = "Quý 1"
        in 4..6 -> ketQua = "Quý 2"
        in 7..9 -> ketQua = "Quý 3"
        in 10..12 -> ketQua = "Quý 4"
        else -> ketQua = "Không xác định"
    }
    return ketQua
}