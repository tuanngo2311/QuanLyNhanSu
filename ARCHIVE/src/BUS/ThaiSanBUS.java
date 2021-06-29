package BUS;

import DAO.ThaiSanDAO;
import javax.swing.JComboBox;

public class ThaiSanBUS {

    public static void getCBboxMaNV(JComboBox maNV) {
        ThaiSanDAO.getCBboxMaNV(maNV);
    }

    public static void getCBboxBP(JComboBox maBoPhan) {
        ThaiSanDAO.getCBboxBP(maBoPhan);
    }

    public static void getCBboxPB(JComboBox maPhong) {
        ThaiSanDAO.getCBboxPB(maPhong);
    }

    public static void Them(String maBoPhan, String maPhong, String maNhanVien, String hoTen, String ngaySinh, String ngayVeSom, String ngayNghiSinh, String ngayLamTroLai, String troCapCongTy, String ghiChu) {
        ThaiSanDAO.Them(maBoPhan, maPhong, maNhanVien, hoTen, ngaySinh, ngayVeSom, ngayNghiSinh, ngayLamTroLai, troCapCongTy, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        ThaiSanDAO.Xoa(maNhanVien);
    }

    public static void Sua(String maBoPhan, String maPhong, String hoTen, String ngaySinh, String ngayVeSom, String ngayNghiSinh, String ngayLamTroLai, String troCapCongTy, String ghiChu, String maNhanVien) {
        ThaiSanDAO.Sua(maBoPhan, maPhong, hoTen, ngaySinh, ngayVeSom, ngayNghiSinh, ngayLamTroLai, troCapCongTy, ghiChu, maNhanVien);
    }
}
