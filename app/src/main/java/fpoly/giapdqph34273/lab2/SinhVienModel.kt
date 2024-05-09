package fpoly.giapdqph34273.lab2

class SinhVienModel(var tenSV: String, var mssv: String, var diemTB: Float) {
    var daTotNghiep: Boolean? = null
    var tuoi: Int? = null

    constructor(tenSV: String, mssv: String, diemTB: Float, daTotNghiep: Boolean, tuoi: Int) : this(
        tenSV,
        mssv,
        diemTB
    ) {
        this.daTotNghiep = daTotNghiep
        this.tuoi = tuoi
    }

    fun getThongTin(): String {
        var thongTin: String
        if (daTotNghiep != null && tuoi != null) {
            thongTin =
                "Tên: $tenSV, mssv: $mssv, Điểm TB: $diemTB, Đã tốt nghiệp: ${if (daTotNghiep == true) "đã tốt nghiệp" else "chưa"}, tuoi: $tuoi"
        } else {
            thongTin = "Tên: $tenSV, mssv: $mssv, Điểm TB: $diemTB"
        }
        return thongTin

    }
}