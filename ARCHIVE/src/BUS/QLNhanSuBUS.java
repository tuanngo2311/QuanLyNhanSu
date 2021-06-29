package BUS;

import DAO.QLNhanSuDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class QLNhanSuBUS {

    public static void getCBboxBP(JComboBox bophan) {
        QLNhanSuDAO.getCBboxBP(bophan);
    }

    public static void getCBboxPB(JComboBox phongban) {
        QLNhanSuDAO.getCBboxPB(phongban);
    }

    public static void Moi(JComboBox maBoPhan, JComboBox maPhong, JTextField maNhanVien, JTextField hoTen, JDateChooser ngaySinh, JComboBox gioiTinh, JTextField CMND, JDateChooser ngayCap, JTextField noiCap, JComboBox chucVu,
            JTextField chucDanh, JTextField loaiHD, JDateChooser ngayKy, JDateChooser ngayHetHan, JTextField ghiChu) {
        QLNhanSuDAO.Moi(maBoPhan, maPhong, maNhanVien, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu);
    }

    public static void Them(String maBoPhan, String maPhong, String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu,
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu) {
        QLNhanSuDAO.Them(maBoPhan, maPhong, maNhanVien, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        QLNhanSuDAO.Xoa(maNhanVien);
    }

    public static void Sua(String maBoPhan, String maPhong, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu,
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu, String maNhanVien) {
        QLNhanSuDAO.Sua(maBoPhan, maPhong, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu, maNhanVien);
    }
}
