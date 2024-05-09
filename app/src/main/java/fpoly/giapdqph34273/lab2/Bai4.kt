package fpoly.giapdqph34273.lab2

import kotlin.system.exitProcess

fun main() {

    val sv1: SinhVienModel = SinhVienModel("Nguyen Van Long", "PH34344", 9.5f)

    val sv2: SinhVienModel = SinhVienModel("Do Quang Giap", "PH34273", 10f)

    sv2.daTotNghiep = false
    sv2.tuoi = 22

    val sv3: SinhVienModel = SinhVienModel("Tran Thu Thao", "PH11111", 5f, false, 18)

    val listSV = mutableListOf<SinhVienModel>()
    listSV.add(sv1)
    listSV.add(sv2)
    listSV.add(sv3)

    inRaDanhSach(listSV)

    quanLy(nhapChucNang(), listSV)
}
fun quanLy(chucNang: String?, listSV: MutableList<SinhVienModel>) {
    when (chucNang) {
        "1" -> xoa(listSV)

        "2" -> them(listSV)

        "3" -> sua(listSV)

        else -> println("Không có chức năng này")
    }
}
fun inRaDanhSach(listSV: MutableList<SinhVienModel>) {
    println("---------------------Danh sách sinh viên---------------------------------------------------------")
    // cách duyệt theo index
    for (i in listSV.indices) {
        println("Phần tử thứ ${i + 1}: ${listSV.get(i).getThongTin()}")
    }

    println("-------------------------------------------------------------------------------------------------")
}
fun nhapChucNang(): String {
    println("---------------------Chức năng-------------------------------------------------------------------")
    println("1. Xóa 1 phần tử trong danh sách")
    println("2. Thêm 1 phần tử vào danh sách")
    println("3. Sửa 1 phần tử trong danh sách")

    println("-------------------------------------------------------------------------------------------------")
    // validate và chọn chức năng
    var chucNang: String
    while (true) {
        print("Bạn muốn chọn chức năng gì: ")
        chucNang = readLine()!!
        if (chucNang.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        if (chucNang !in "1".."3") {
            println("Vui lòng chỉ chọn từ 1 -> 3")
            continue
        }
        break
    }
    return chucNang
}
fun tiepTuc(listSV: MutableList<SinhVienModel>) {
    inRaDanhSach(listSV)
    print("Bạn có muốn tiếp tục không (có: 1): ")
    var tiep = readLine()!!
    if (tiep != "1") {
        // thoat chuong trinh
        exitProcess(0)
    }
    quanLy(nhapChucNang(), listSV)
}
fun xoa(listSV: MutableList<SinhVienModel>){
    if (listSV.isEmpty()) {
        println("Danh sách rỗng")
        tiepTuc(listSV)
    }
    var xoa: Int

    while (true) {
        try {
            print("Bạn muốn xóa phần tử thứ mấy: ")
            xoa = readLine()!!.toInt()
            if (xoa < 1 || xoa > listSV.size) {
                println("Vui lòng nhập số từ 1 -> ${listSV.size}")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    listSV.removeAt(xoa - 1)
    tiepTuc(listSV)
}
fun them(listSV: MutableList<SinhVienModel>){

    println("Thêm sinh viên:")

    // validate và nhập tên
    var ten: String
    while (true) {
        print("Tên sinh viên: ")
        ten = readLine()!!
        if (ten.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập mã sinh viên
    var mssv: String
    while (true) {
        print("Mã sinh viên: ")
        mssv = readLine()!!
        if (mssv.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập điểm trung bình
    var dtb: Float
    while (true) {
        try {
            print("Điểm trung bình: ")
            dtb = readLine()!!.toFloat()
            if (dtb < 0 || dtb > 10) {
                println("Vui lòng lòng nhập điểm trong khoảng 1 -> 10")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập điểm là số")
        }
    }

    // validate và nhập trạng thái tốt nghiệp
    var trangThai: Int
    while (true) {
        try {
            print("Đã tốt nghiệp hay chưa (rồi: 1/chưa: 0): ")
            trangThai = readLine()!!.toInt()
            if (trangThai != 1 && trangThai != 0) {
                println("Vui lòng lòng chỉ nhập 1 hoặc 0")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    var totNghiep: Boolean
    if (trangThai == 1) {
        totNghiep = true
    } else {
        totNghiep = false
    }

    // validate và nhập tuổi
    var tuoi: Int
    while (true) {
        try {
            print("Tuổi: ")
            tuoi = readLine()!!.toInt()
            if (tuoi < 0) {
                println("Vui lòng nhập tuổi từ 0 trở lên")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    // tạo đối tượng mới
    val svMoi = SinhVienModel(ten, mssv, dtb, totNghiep, tuoi)

    // thêm vào danh sách
    listSV.add(svMoi)

    tiepTuc(listSV)

}
fun sua(listSV: MutableList<SinhVienModel>){
    var sua: Int

    while (true) {
        try {
            print("Bạn muốn sửa phần tử thứ mấy: ")

            sua = readLine()!!.toInt()
            if (sua < 1 || sua > listSV.size) {
                println("Vui lòng nhập số từ 1 -> ${listSV.size}")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    var index = sua - 1


    // validate và nhập tên
    var ten: String
    while (true) {
        print("Tên sinh viên: ")
        ten = readLine()!!
        if (ten.isEmpty()) {
            ten = listSV[index].tenSV
        }
        break
    }

    // validate và nhập mã sinh viên
    var mssv: String
    while (true) {
        print("Mã sinh viên: ")
        mssv = readLine()!!
        if (mssv.isEmpty()) {
            mssv = listSV[index].mssv
        }
        break
    }

    // validate và nhập điểm trung bình
    var dtb: Float
    while (true) {
        try {
            print("Điểm trung bình: ")
            var dtbInput = readLine()!!

            if (dtbInput.isEmpty()) {
                dtb = listSV[index].diemTB
                break
            }

            dtb = dtbInput.toFloat()
            if (dtb < 0 || dtb > 10) {
                println("Vui lòng lòng nhập điểm trong khoảng 1 -> 10")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập điểm là số")
            println(e)
        }
    }

    // validate và nhập trạng thái tốt nghiệp
    var trangThai: Int
    var totNghiep: Boolean
    while (true) {
        try {
            print("Đã tốt nghiệp hay chưa (rồi: 1/chưa: 0): ")
            var trangThaiInput = readLine()!!
            if (trangThaiInput.isEmpty()) {
                totNghiep = listSV[index].daTotNghiep!!
                break
            }

            trangThai = trangThaiInput.toInt()
            if (trangThai != 1 && trangThai != 0) {
                println("Vui lòng lòng chỉ nhập 1 hoặc 0")
                continue
            }

            if (trangThai == 1) {
                totNghiep = true
            } else {
                totNghiep = false
            }

            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }


    // validate và nhập tuổi
    var tuoi: Int
    while (true) {
        try {
            print("Tuổi: ")
            var tuoiInput = readLine()!!
            if (tuoiInput.isEmpty()) {
                tuoi = listSV[index].tuoi!!
                break
            }
            tuoi = tuoiInput.toInt()
            if (tuoi < 0) {
                println("Vui lòng nhập tuổi từ 0 trở lên")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    // index cần sửa

    // sửa thông tin sinh viên
    listSV[index].tenSV = ten
    listSV[index].mssv = mssv
    listSV[index].diemTB = dtb
    listSV[index].daTotNghiep = totNghiep
    listSV[index].tuoi = tuoi

    tiepTuc(listSV)


}