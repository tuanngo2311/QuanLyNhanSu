package BUS;

import DAO.BangCongKhoiDieuHanhDAO;
import ENTITY.BangCongKhoiDieuHanh;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class BangCongKhoiDieuHanhBUS {

    public static void getCBboxMaNV(JComboBox maNhanVien) {
        BangCongKhoiDieuHanhDAO.getCBboxMaNV(maNhanVien);
    }

    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        BangCongKhoiDieuHanhDAO.getCBboxMaNVTb(maNhanVien);
    }

    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu) {
        BangCongKhoiDieuHanhDAO.Them(maNhanVien, luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        BangCongKhoiDieuHanhDAO.Xoa(maNhanVien);
    }

    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maNhanVien) {
        BangCongKhoiDieuHanhDAO.Sua(luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maNhanVien);
    }
}
