package BUS;

import DAO.BangCongKhoiVanChuyenDAO;
import javax.swing.JComboBox;

public class BangCongKhoiVanChuyenBUS {

    public static void getCBboxMaNV(JComboBox maNhanVien) {
        BangCongKhoiVanChuyenDAO.getCBboxMaNV(maNhanVien);
    }

    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        BangCongKhoiVanChuyenDAO.getCBboxMaNVTb(maNhanVien);
    }

    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu) {
        BangCongKhoiVanChuyenDAO.Them(maNhanVien, luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        BangCongKhoiVanChuyenDAO.Xoa(maNhanVien);
    }

    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maNhanVien) {
        BangCongKhoiVanChuyenDAO.Sua(luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maNhanVien);
    }
}
