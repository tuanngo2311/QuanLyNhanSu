package BUS;

import DAO.QLPhongBanDAO;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class QLPhongBanBUS {

    public static void getCBbox(JComboBox bophan) {
        QLPhongBanDAO.getCBbox(bophan);
    }

    public static void Moi(JComboBox maBoPhan, JTextField maPhong, JTextField tenPhong, JDateChooser ngayThanhLap, JTextField ghiChu) {
        QLPhongBanDAO.Moi(maBoPhan, maPhong, tenPhong, ngayThanhLap, ghiChu);
    }

    public static void Them(String maBoPhan, String maPhong, String tenPhong, String ngayThanhLap, String ghiChu) {
        QLPhongBanDAO.Them(maBoPhan, maPhong, tenPhong, ngayThanhLap, ghiChu);
    }

    public static void Xoa(String maPhong) {
        QLPhongBanDAO.Xoa(maPhong);
    }

    public static void Sua(String maBoPhan, String tenPhong, String ngayThanhLap, String ghiChu, String maPhong) {
        QLPhongBanDAO.Sua(maBoPhan, tenPhong, ngayThanhLap, ghiChu, maPhong);
    }
}
