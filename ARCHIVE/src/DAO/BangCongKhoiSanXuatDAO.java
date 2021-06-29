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
public class BangCongKhoiSanXuatDAO {
    private static Connection conn;
    
    public static ArrayList<BangCongKhoiSanXuat> sxList() {
        ArrayList<BangCongKhoiSanXuat> sxList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblCongKhoiSanXuat");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiSanXuat sx;
            while (rs.next()) {
                sx = new BangCongKhoiSanXuat(
                    rs.getString("MaNV"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("GhiChu"),
                    rs.getString("MaPhong")
                );
                sxList.add(sx);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return sxList;
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
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV FROM TblTTNVCoBan GROUP BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNhanVien.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getCBboxMaPhong(JComboBox maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT MaPhong FROM TblPhongBan ORDER BY MaPhong");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maPhong.addItem(rs.getString("MaPhong"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<BangCongKhoiSanXuat> sxtcList() {
        ArrayList<BangCongKhoiSanXuat> sxList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT TblCongKhoiSanXuat.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, TblCongKhoiSanXuat.MaPhong FROM TblCongKhoiSanXuat, TblTTNVCoBan WHERE TblCongKhoiSanXuat.MaNV = TblTTNVCoBan.MaNV ");
            ResultSet rs = ps.executeQuery();
            BangCongKhoiSanXuat sx;
            while (rs.next()) {
                sx = new BangCongKhoiSanXuat(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("MaPhong")
                );
                sxList.add(sx);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return sxList;
    }
    
    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblCongKhoiSanXuat(MaNV, LCB, PhuCapCVu, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, GhiChu, MaPhong) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, luongCoBan);
            ps.setString(3, phuCap);           
            ps.setString(4, thang);
            ps.setString(5, nam);
            ps.setString(6, soNgayCong);
            ps.setString(7, soNgayNghi);
            ps.setString(8, soGioLam);
            ps.setString(9, ghiChu);
            ps.setString(10, maPhong);
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
            String sql = "DELETE FROM TblCongKhoiSanXuat WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maPhong, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblCongKhoiSanXuat SET LCB=?, PhuCapCVu=?, Thang=?, "
            + "Nam=?, SoNgayCongThang=?, SoNgayNghi=?, SoGioLamThem=?, GhiChu=?, MaPhong=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, luongCoBan);
            ps.setString(2, phuCap);        
            ps.setString(3, thang);
            ps.setString(4, nam);
            ps.setString(5, soNgayCong);
            ps.setString(6, soNgayNghi);
            ps.setString(7, soGioLam);
            ps.setString(8, ghiChu);
            ps.setString(9, maPhong);
            ps.setString(10, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
