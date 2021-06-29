package BUS;

import DAO.BaoHiemDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class BaoHiemBUS {

    public static void getCBboxMaNV(JComboBox maNV) {
        BaoHiemDAO.getCBboxMaNV(maNV);
    }

    public static void getCBboxMaNVTb(JComboBox maNV) {
        BaoHiemDAO.getCBboxMaNVTb(maNV);
    }

    public static void getCBboxMaLuong(JComboBox maLuong) {
        BaoHiemDAO.getCBboxMaLuong(maLuong);
    }

    public static void Moi(JComboBox maNhanVien, JComboBox maLuong, JTextField maSoBaoHiem, JDateChooser ngayCapSo, JTextField noiCapSo, JTextField ghiChu) {
        BaoHiemDAO.Moi(maNhanVien, maLuong, maSoBaoHiem, ngayCapSo, noiCapSo, ghiChu);
    }

    public static void Them(String maNhanVien, String maLuong, String maSoBaoHiem, String ngayCapSo, String noiCapSo, String ghiChu) {
        BaoHiemDAO.Them(maNhanVien, maLuong, maSoBaoHiem, ngayCapSo, noiCapSo, ghiChu);
    }

    public static void Xoa(String maSoBaoHiem) {
        BaoHiemDAO.Xoa(maSoBaoHiem);
    }

    public static void Sua(String maNhanVien, String maLuong, String ngayCapSo, String noiCapSo, String ghiChu, String maSoBaoHiem) {
        BaoHiemDAO.Sua(maNhanVien, maLuong, ngayCapSo, noiCapSo, ghiChu, maSoBaoHiem);
    }
}
