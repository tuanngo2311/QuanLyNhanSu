/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;

/**
 *
 * @author Phong
 */
public class BangCongKhoiSanXuat implements Serializable{
    String maNhanVien, hoTen, ngaySinh, luongCoBan, phuCap, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maPhong;

    public BangCongKhoiSanXuat(String maNhanVien, String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maPhong) {
        this.maNhanVien = maNhanVien;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
        this.thang = thang;
        this.nam = nam;
        this.soNgayCong = soNgayCong;
        this.soNgayNghi = soNgayNghi;
        this.soGioLam = soGioLam;
        this.ghiChu = ghiChu;
        this.maPhong = maPhong;
    }

    public BangCongKhoiSanXuat(String maNhanVien, String hoTen, String ngaySinh, String luongCoBan, String phuCap, String thang, String nam, String soNgayCong, String soNgayNghi, String soGioLam, String maPhong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
        this.thang = thang;
        this.nam = nam;
        this.soNgayCong = soNgayCong;
        this.soNgayNghi = soNgayNghi;
        this.soGioLam = soGioLam;
        this.maPhong = maPhong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(String phuCap) {
        this.phuCap = phuCap;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(String soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public String getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(String soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public String getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(String soGioLam) {
        this.soGioLam = soGioLam;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
