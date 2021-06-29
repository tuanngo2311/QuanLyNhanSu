package BUS;

import DAO.VanDeTangLuongDAO;
import javax.swing.JComboBox;

public class VanDeTangLuongBUS {

    public static void getCBboxMaNV(JComboBox maNV) {
        VanDeTangLuongDAO.getCBboxMaNV(maNV);
    }

    public static void getCBboxMaNVTb(JComboBox maNV) {
        VanDeTangLuongDAO.getCBboxMaNVTb(maNV);
    }

    public static void Them(String maNhanVien, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBanCu, String luongCoBanMoi, String phuCapCVCu, String phuCapCVMoi, String ngayTang, String lyDo) {
        VanDeTangLuongDAO.Them(maNhanVien, hoTen, gioiTinh, chucVu, chucDanh, luongCoBanCu, luongCoBanMoi, phuCapCVCu, phuCapCVMoi, ngayTang, lyDo);
    }

    public static void Xoa(String maNhanVien) {
        VanDeTangLuongDAO.Xoa(maNhanVien);
    }

    public static void Sua(String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBanCu, String luongCoBanMoi, String phuCapCVCu, String phuCapCVMoi, String ngayTang, String lyDo, String maNhanVien) {
        VanDeTangLuongDAO.Sua(hoTen, gioiTinh, chucVu, chucDanh, luongCoBanCu, luongCoBanMoi, phuCapCVCu, phuCapCVMoi, ngayTang, lyDo, maNhanVien);
    }
}
