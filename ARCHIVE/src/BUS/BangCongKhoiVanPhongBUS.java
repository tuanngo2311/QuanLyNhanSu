package BUS;

import DAO.BangCongKhoiVanPhongDAO;
import javax.swing.JComboBox;

public class BangCongKhoiVanPhongBUS {

    public static void getCBboxMaNV(JComboBox maNhanVien) {
        BangCongKhoiVanPhongDAO.getCBboxMaNV(maNhanVien);
    }

    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        BangCongKhoiVanPhongDAO.getCBboxMaNVTb(maNhanVien);
    }

    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu) {
        BangCongKhoiVanPhongDAO.Them(maNhanVien, luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        BangCongKhoiVanPhongDAO.Xoa(maNhanVien);
    }

    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maNhanVien) {
        BangCongKhoiVanPhongDAO.Sua(luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maNhanVien);
    }
}
