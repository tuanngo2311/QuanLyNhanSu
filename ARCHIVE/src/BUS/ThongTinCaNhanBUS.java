package BUS;

import DAO.ThongTinCaNhanDAO;
import javax.swing.JComboBox;

public class ThongTinCaNhanBUS {

    public static void getCBbox(JComboBox maNV) {
        ThongTinCaNhanDAO.getCBbox(maNV);
    }

    public static void getCBboxTb(JComboBox maNV) {
        ThongTinCaNhanDAO.getCBboxTb(maNV);
    }

    public static void Them(String maNhanVien, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich,
            String tiengNgonNgu, String trinhDoNgonNgu, String hocVan, String hocHam, String ngayVaoDoan, String tenDoanThe, String chucVuDoan, String ghiChu) {
        ThongTinCaNhanDAO.Them(maNhanVien, noiSinh, nguyenQuan, diaChiThuongTru, diaChiTamTru, soDienThoai, danToc, tonGiao, quocTich, tiengNgonNgu, trinhDoNgonNgu, hocVan, hocHam, ngayVaoDoan, tenDoanThe, chucVuDoan, ghiChu);
    }

    public static void Xoa(String maNhanVien) {
        ThongTinCaNhanDAO.Xoa(maNhanVien);
    }

    public static void Sua(String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich,
            String tiengNgonNgu, String trinhDoNgonNgu, String hocVan, String hocHam, String ngayVaoDoan, String tenDoanThe, String chucVuDoan, String ghiChu, String maNhanVien) {
        ThongTinCaNhanDAO.Sua(noiSinh, nguyenQuan, diaChiThuongTru, diaChiTamTru, soDienThoai, danToc, tonGiao, quocTich, tiengNgonNgu, trinhDoNgonNgu, hocVan, hocHam, ngayVaoDoan, tenDoanThe, chucVuDoan, ghiChu, maNhanVien);
    }
}
