/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ENTITY.BangCongKhoiDieuHanh;
import ENTITY.BangCongKhoiSanXuat;
import ENTITY.BangCongKhoiVanChuyen;
import ENTITY.BangCongKhoiVanPhong;
import javax.swing.JComboBox;
/**
 *
 * @author DangKhoa
 */
public class BangCongKhoiDieuHanhDAO {
    private static Connection conn;
    
    public static ArrayList<BangCongKhoiDieuHanh> dhList() {
        ArrayList<BangCongKhoiDieuHanh> dhList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblCongKhoiDieuHanh");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiDieuHanh dh;
            while (rs.next()) {
                dh = new BangCongKhoiDieuHanh(
                    rs.getString("MaNV"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("GhiChu")
                );
                dhList.add(dh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return dhList;
    }
    
    public static void getCBboxMaNV(JComboBox maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV \n" +
"  FROM TblTTNVCoBan\n" +
"  WHERE MaNV IN ( SELECT MaNV \n" +
"					FROM TblTTNVCoBan\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongKhoiDieuHanh\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongKhoiSanXuat\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongKhoiVanChuyen\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongKhoiVanPHong\n" +
"					)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNhanVien.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT MaNV FROM TblTTNVCoBan GROUP BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNhanVien.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<BangCongKhoiDieuHanh> dhtcList() {
        ArrayList<BangCongKhoiDieuHanh> dhList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT TblCongKhoiDieuHanh.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem FROM TblCongKhoiDieuHanh, TblTTNVCoBan WHERE TblCongKhoiDieuHanh.MaNV = TblTTNVCoBan.MaNV ");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiDieuHanh dh;
            while (rs.next()) {
                dh = new BangCongKhoiDieuHanh(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem")
                );
                dhList.add(dh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return dhList;
    }
    
    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblCongKhoiDieuHanh(MaNV, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, luongCoBan);
            ps.setString(3, phuCap);
            ps.setString(4, phuCapKhac);
            ps.setString(5, thang);
            ps.setString(6, nam);
            ps.setString(7, soNgayCong);
            ps.setString(8, soNgayNghi);
            ps.setString(9, soGioLam);
            ps.setString(10, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblCongKhoiDieuHanh WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblCongKhoiDieuHanh SET LCB=?, PhuCapCVu=?, PhuCapKhac=?, Thang=?, "
            + "Nam=?, SoNgayCongThang=?, SoNgayNghi=?, SoGioLamThem=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, luongCoBan);
            ps.setString(2, phuCap);
            ps.setString(3, phuCapKhac);
            ps.setString(4, thang);
            ps.setString(5, nam);
            ps.setString(6, soNgayCong);
            ps.setString(7, soNgayNghi);
            ps.setString(8, soGioLam);
            ps.setString(9, ghiChu);
            ps.setString(10, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
