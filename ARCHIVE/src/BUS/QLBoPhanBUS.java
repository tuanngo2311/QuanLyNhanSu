package BUS;

import DAO.QLBoPhanDAO;
import ENTITY.QLPhongBan;
import java.util.ArrayList;
import javax.swing.JTextField;

public class QLBoPhanBUS {

    public static void Moi(JTextField maBoPhan, JTextField tenBoPhan, JTextField ghiChu) {
        QLBoPhanDAO.Moi(maBoPhan, tenBoPhan, ghiChu);
    }

    public static void Them(String maBoPhan, String tenBoPhan, String ghiChu) {
        QLBoPhanDAO.Them(maBoPhan, tenBoPhan, ghiChu);
    }

    public static void Xoa(String maBoPhan) {
        QLBoPhanDAO.Xoa(maBoPhan);
    }

    public static void Sua(String tenBoPhan, String ghiChu, String maBoPhan) {
        QLBoPhanDAO.Sua(tenBoPhan, ghiChu, maBoPhan);
    }
}
