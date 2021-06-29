package BUS;

import DAO.BangCongKhoiSanXuatDAO;
import javax.swing.JComboBox;

public class BangCongKhoiSanXuatBUS {

    public static void getCBboxMaNV(JComboBox maNhanVien) {
        BangCongKhoiSanXuatDAO.getCBboxMaNV(maNhanVien);
    }

    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        BangCongKhoiSanXuatDAO.getCBboxMaNVTb(maNhanVien);
    }

    public static void getCBboxMaPhong(JComboBox maPhong) {
        BangCongKhoiSanXuatDAO.getCBboxMaPhong(maPhong);
    }

    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maPhong) {
        BangCongKhoiSanXuatDAO.Them(maNhanVien, luongCoBan, phuCap, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maPhong);
    }

    public static void Xoa(String maNhanVien) {
        BangCongKhoiSanXuatDAO.Xoa(maNhanVien);
    }

    public static void Sua(String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maPhong, String maNhanVien) {
        BangCongKhoiSanXuatDAO.Sua(luongCoBan, phuCap, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maPhong, maNhanVien);
    }
}
