package BUS;

import DAO.BangLuongCongTyDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class BangLuongCongTyBUS {

    public static void Moi(JTextField maLuong, JComboBox chucVu, JTextField chucDanh, JTextField luongCoBan, JTextField phuCapChucVu, JDateChooser ngayNhap, JTextField luongCoBanMoi, JDateChooser ngaySua, JTextField lyDo, JTextField phuCapCVuMoi, JDateChooser ngaySuaPhuCap, JTextField ghiChu) {
        BangLuongCongTyDAO.Moi(maLuong, chucVu, chucDanh, luongCoBan, phuCapChucVu, ngayNhap, luongCoBanMoi, ngaySua, lyDo, phuCapCVuMoi, ngaySuaPhuCap, ghiChu);
    }

    public static void Them(String maLuong, String chucVu, String chucDanh, String luongCoBan, String phuCapChucVu, String ngayNhap, String luongCoBanMoi, String ngaySua, String lyDo, String phuCapCVuMoi, String ngaySuaPhuCap, String ghiChu) {
        BangLuongCongTyDAO.Them(maLuong, chucVu, chucDanh, luongCoBan, phuCapChucVu, ngayNhap, luongCoBanMoi, ngaySua, lyDo, phuCapCVuMoi, ngaySuaPhuCap, ghiChu);
    }

    public static void Xoa(String maLuong) {
        BangLuongCongTyDAO.Xoa(maLuong);
    }

    public static void Sua(String chucVu, String chucDanh, String luongCoBan, String phuCapChucVu, String ngayNhap, String luongCoBanMoi, String ngaySua, String lyDo, String phuCapCVuMoi, String ngaySuaPhuCap, String ghiChu, String maLuong) {
        BangLuongCongTyDAO.Sua(chucVu, chucDanh, luongCoBan, phuCapChucVu, ngayNhap, luongCoBanMoi, ngaySua, lyDo, phuCapCVuMoi, ngaySuaPhuCap, ghiChu, maLuong);
    }
}
