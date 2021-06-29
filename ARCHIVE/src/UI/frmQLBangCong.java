package UI;

import BUS.BangCongKhoiDieuHanhBUS;
import BUS.BangCongKhoiSanXuatBUS;
import BUS.BangCongKhoiVanChuyenBUS;
import BUS.BangCongKhoiVanPhongBUS;
import DAO.BangCongKhoiDieuHanhDAO;
import DAO.BangCongKhoiSanXuatDAO;
import DAO.BangCongKhoiVanChuyenDAO;
import DAO.BangCongKhoiVanPhongDAO;
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

public class frmQLBangCong extends javax.swing.JPanel {

    DateFormat dateFormat = new SimpleDateFormat("MM");
    DateFormat dateFormatY = new SimpleDateFormat("yyyy");

    Date dateDH = new Date();
    Date dateVP = new Date();
    Date dateSX = new Date();
    Date dateVC = new Date();
    Date dateTV = new Date();

    Calendar cal = Calendar.getInstance();
    DefaultTableModel modelDH;
    DefaultTableModel modelVP;
    DefaultTableModel modelSX;
    DefaultTableModel modelVC;
    DefaultTableModel modelTV;

    private Connection conn;

    /**
     * Creates new form frmQLBangCong
     */
    public frmQLBangCong() {
        initComponents();

        //getCBboxMaNVTV();
        BangCongKhoiDieuHanhBUS.getCBboxMaNV(cbxMaNhanVienDH);
        BangCongKhoiSanXuatBUS.getCBboxMaNV(cbxMaNhanVienSX);
        BangCongKhoiVanChuyenBUS.getCBboxMaNV(cbxMaNhanVienVC);
        BangCongKhoiVanPhongBUS.getCBboxMaNV(cbxMaNhanVienVP);
        BangCongKhoiSanXuatBUS.getCBboxMaPhong(cbxMaPhongSX);
//        getCBboxTenPhong();
//        getCBboxTenBoPhan();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        modelDH = (DefaultTableModel) tblDH.getModel();
        modelSX = (DefaultTableModel) tblSX.getModel();
        //modelTV = (DefaultTableModel) tblTV.getModel();
        modelVC = (DefaultTableModel) tblVC.getModel();
        modelVP = (DefaultTableModel) tblVP.getModel();

        txtThangDH.setText(" " + dateFormat.format(dateDH));
        txtThangSX.setText(" " + dateFormat.format(dateSX));
        txtThangVC.setText(" " + dateFormat.format(dateVC));
        txtThangVP.setText(" " + dateFormat.format(dateVP));
        //txtThangTV.setText(" " + dateFormat.format(dateTV));

        txtLuongDH.setText(" " + dateFormatY.format(dateDH));
        txtLuongSX.setText(" " + dateFormatY.format(dateSX));
        txtLuongVC.setText(" " + dateFormatY.format(dateVC));
        txtLuongVP.setText(" " + dateFormatY.format(dateVP));
        //txtLuongNgay.setText(" " + dateFormatY.format(dateTV));

        //showTV();
        showDH();
        showSX();
        showVC();
        showVP();
    }

    public void showDH() {
        ArrayList<BangCongKhoiDieuHanh> dh = BangCongKhoiDieuHanhDAO.dhList();
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        Object[] row = new Object[17];
        for (int i = 0; i < dh.size(); i++) {
            row[0] = dh.get(i).getMaNhanVien();
            row[1] = dh.get(i).getLuongCoBan();
            row[2] = dh.get(i).getPhuCap();
            row[3] = dh.get(i).getPhuCapKhac();
            row[4] = dh.get(i).getThang();
            row[5] = dh.get(i).getNam();
            row[6] = dh.get(i).getSoNgayCong();
            row[7] = dh.get(i).getSoNgayNghi();
            row[8] = dh.get(i).getSoGioLam();
            row[9] = dh.get(i).getGhiChu();
            model.addRow(row);
        };
    }

    public void showSX() {
        ArrayList<BangCongKhoiSanXuat> sx = BangCongKhoiSanXuatDAO.sxList();
        DefaultTableModel model = (DefaultTableModel) tblSX.getModel();
        Object[] row = new Object[17];
        for (int i = 0; i < sx.size(); i++) {
            row[0] = sx.get(i).getMaNhanVien();
            row[1] = sx.get(i).getLuongCoBan();
            row[2] = sx.get(i).getPhuCap();
            row[3] = sx.get(i).getThang();
            row[4] = sx.get(i).getNam();
            row[5] = sx.get(i).getSoNgayCong();
            row[6] = sx.get(i).getSoNgayNghi();
            row[7] = sx.get(i).getSoGioLam();
            row[8] = sx.get(i).getGhiChu();
            row[9] = sx.get(i).getMaPhong();
            model.addRow(row);
        };
    }

    public void showVC() {
        ArrayList<BangCongKhoiVanChuyen> vc = BangCongKhoiVanChuyenDAO.vcList();
        DefaultTableModel model = (DefaultTableModel) tblVC.getModel();
        Object[] row = new Object[17];
        for (int i = 0; i < vc.size(); i++) {
            row[0] = vc.get(i).getMaNhanVien();
            row[1] = vc.get(i).getLuongCoBan();
            row[2] = vc.get(i).getPhuCap();
            row[3] = vc.get(i).getPhuCapKhac();
            row[4] = vc.get(i).getThang();
            row[5] = vc.get(i).getNam();
            row[6] = vc.get(i).getSoNgayCong();
            row[7] = vc.get(i).getSoNgayNghi();
            row[8] = vc.get(i).getSoGioLam();
            row[9] = vc.get(i).getGhiChu();
            model.addRow(row);
        };
    }

    public void showVP() {
        ArrayList<BangCongKhoiVanPhong> vp = BangCongKhoiVanPhongDAO.vpList();
        DefaultTableModel model = (DefaultTableModel) tblVP.getModel();
        Object[] row = new Object[17];
        for (int i = 0; i < vp.size(); i++) {
            row[0] = vp.get(i).getMaNhanVien();
            row[1] = vp.get(i).getLuongCoBan();
            row[2] = vp.get(i).getPhuCap();
            row[3] = vp.get(i).getPhuCapKhac();
            row[4] = vp.get(i).getThang();
            row[5] = vp.get(i).getNam();
            row[6] = vp.get(i).getSoNgayCong();
            row[7] = vp.get(i).getSoNgayNghi();
            row[8] = vp.get(i).getSoGioLam();
            row[9] = vp.get(i).getGhiChu();
            model.addRow(row);
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnKhoiDieuHanh = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblHeader2 = new javax.swing.JLabel();
        lblMaNhanVienDH = new javax.swing.JLabel();
        cbxMaNhanVienDH = new javax.swing.JComboBox<>();
        lblGhiChuDH = new javax.swing.JLabel();
        txtGhiChuDH = new javax.swing.JTextField();
        lblPhuCapDH = new javax.swing.JLabel();
        txtPhuCapDH = new javax.swing.JTextField();
        lblLuongCoBanDH = new javax.swing.JLabel();
        txtLuongCoBanDH = new javax.swing.JTextField();
        lblNamDH = new javax.swing.JLabel();
        txtLuongDH = new javax.swing.JTextField();
        lblThangDH = new javax.swing.JLabel();
        txtThangDH = new javax.swing.JTextField();
        lblSoNgayCongDH = new javax.swing.JLabel();
        txtSoNgayCongDH = new javax.swing.JTextField();
        lblSoNgayLamThemDH = new javax.swing.JLabel();
        txtSoNgayLamThemDH = new javax.swing.JTextField();
        lblSoNgayNghiDH = new javax.swing.JLabel();
        txtSoNgayNghiDH = new javax.swing.JTextField();
        lblPhuCapKhacDH = new javax.swing.JLabel();
        txtPhuCapKhacDH = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lblHeader6 = new javax.swing.JLabel();
        btnThemDH = new javax.swing.JButton();
        btnSuaDH = new javax.swing.JButton();
        btnXoaDH = new javax.swing.JButton();
        btnMoiDH = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDH = new javax.swing.JTable();
        pnKhoiVanPhong = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblHeader5 = new javax.swing.JLabel();
        lblMaNhanVienVP = new javax.swing.JLabel();
        cbxMaNhanVienVP = new javax.swing.JComboBox<>();
        lblGhiChuVP = new javax.swing.JLabel();
        txtGhiChuVP = new javax.swing.JTextField();
        lblNamVP = new javax.swing.JLabel();
        txtLuongVP = new javax.swing.JTextField();
        lblThangVP = new javax.swing.JLabel();
        txtThangVP = new javax.swing.JTextField();
        lblSoNgayCongVP = new javax.swing.JLabel();
        txtSoNgayCongVP = new javax.swing.JTextField();
        lblSoNgayLamThemVP = new javax.swing.JLabel();
        txtSoNgayLamThemVP = new javax.swing.JTextField();
        lblSoNgayNghiVP = new javax.swing.JLabel();
        txtSoNgayNghiVP = new javax.swing.JTextField();
        lblPhuCapKhacVP = new javax.swing.JLabel();
        txtPhuCapKhacVP = new javax.swing.JTextField();
        lblLuongCoBanVP = new javax.swing.JLabel();
        txtLuongCoBanVP = new javax.swing.JTextField();
        txtPhuCapVP = new javax.swing.JTextField();
        lblPhuCapVP = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        lblHeader9 = new javax.swing.JLabel();
        btnThemVP = new javax.swing.JButton();
        btnSuaVP = new javax.swing.JButton();
        btnXoaVP = new javax.swing.JButton();
        btnMoiVP = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVP = new javax.swing.JTable();
        pnlPhuCapVC = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblHeader4 = new javax.swing.JLabel();
        lblMaNhanVienVC = new javax.swing.JLabel();
        cbxMaNhanVienVC = new javax.swing.JComboBox<>();
        lblGhiChuVC = new javax.swing.JLabel();
        txtGhiChuVC = new javax.swing.JTextField();
        lblNamVC = new javax.swing.JLabel();
        txtLuongVC = new javax.swing.JTextField();
        lblThangVC = new javax.swing.JLabel();
        txtThangVC = new javax.swing.JTextField();
        lblSoNgayCongVC = new javax.swing.JLabel();
        txtSoNgayCongVC = new javax.swing.JTextField();
        lblSoNgayLamThemVC = new javax.swing.JLabel();
        txtSoNgayLamThemVC = new javax.swing.JTextField();
        lblSoNgayNghiVC = new javax.swing.JLabel();
        txtSoNgayNghiVC = new javax.swing.JTextField();
        lblPhuCapKhacVC = new javax.swing.JLabel();
        txtPhuCapKhacVC = new javax.swing.JTextField();
        lblLuongCoBanVC = new javax.swing.JLabel();
        txtLuongCoBanVC = new javax.swing.JTextField();
        txtPhuCapVC = new javax.swing.JTextField();
        lblPhuCapDH3 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHeader8 = new javax.swing.JLabel();
        btnThemVC = new javax.swing.JButton();
        btnSuaVC = new javax.swing.JButton();
        btnXoaVC = new javax.swing.JButton();
        btnMoiVC = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVC = new javax.swing.JTable();
        pnKhoiSanXuat = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblHeader3 = new javax.swing.JLabel();
        lblMaNhanVienSX = new javax.swing.JLabel();
        cbxMaNhanVienSX = new javax.swing.JComboBox<>();
        lblGhiChuSX = new javax.swing.JLabel();
        txtGhiChuSX = new javax.swing.JTextField();
        lblNamSX = new javax.swing.JLabel();
        txtLuongSX = new javax.swing.JTextField();
        lblThangSX = new javax.swing.JLabel();
        txtThangSX = new javax.swing.JTextField();
        lblSoNgayCongSX = new javax.swing.JLabel();
        txtSoNgayCongSX = new javax.swing.JTextField();
        lblSoNgayLamThemSX = new javax.swing.JLabel();
        txtSoNgayLamThemSX = new javax.swing.JTextField();
        lblSoNgayNghiSX = new javax.swing.JLabel();
        txtSoNgayNghiSX = new javax.swing.JTextField();
        lblLuongCoBanSX = new javax.swing.JLabel();
        txtLuongCoBanSX = new javax.swing.JTextField();
        lblPhuCapSX = new javax.swing.JLabel();
        txtPhuCapSX = new javax.swing.JTextField();
        lblMaPhongSX = new javax.swing.JLabel();
        cbxMaPhongSX = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lblHeader7 = new javax.swing.JLabel();
        btnThemSX = new javax.swing.JButton();
        btnSuaSX = new javax.swing.JButton();
        btnXoaSX = new javax.swing.JButton();
        btnMoiSX = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSX = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(107, 195, 196));

        jPanel4.setBackground(new java.awt.Color(107, 195, 196));

        pnKhoiDieuHanh.setBackground(new java.awt.Color(254, 255, 250));
        pnKhoiDieuHanh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel10.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader2.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader2.setText("Thông tin về khối điều hành");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader2)
                .addContainerGap(713, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienDH.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienDH.setText("Mã nhân viên");

        cbxMaNhanVienDH.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienDH.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuDH.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuDH.setText("Ghi chú");

        txtGhiChuDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuDH.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuDH.setEnabled(false);
        txtGhiChuDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuDH.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuDHActionPerformed(evt);
            }
        });

        lblPhuCapDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapDH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapDH.setText("Phụ cấp*");

        txtPhuCapDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapDH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapDH.setEnabled(false);
        txtPhuCapDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapDHKeyPressed(evt);
            }
        });

        lblLuongCoBanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanDH.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanDH.setText("Lương cơ bản*");

        txtLuongCoBanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanDH.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanDH.setEnabled(false);
        txtLuongCoBanDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanDHKeyPressed(evt);
            }
        });

        lblNamDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamDH.setForeground(new java.awt.Color(3, 100, 117));
        lblNamDH.setText("Năm*");

        txtLuongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongDH.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongDH.setEnabled(false);
        txtLuongDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongDH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangDH.setForeground(new java.awt.Color(3, 100, 117));
        lblThangDH.setText("Tháng*");

        txtThangDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangDH.setForeground(new java.awt.Color(3, 100, 117));
        txtThangDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangDH.setEnabled(false);
        txtThangDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangDH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongDH.setText("Số ngày công*");

        txtSoNgayCongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongDH.setText("30");
        txtSoNgayCongDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongDH.setEnabled(false);
        txtSoNgayCongDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongDHKeyPressed(evt);
            }
        });

        lblSoNgayLamThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemDH.setText("Số giờ làm thêm*");

        txtSoNgayLamThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemDH.setEnabled(false);
        txtSoNgayLamThemDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemDHKeyPressed(evt);
            }
        });

        lblSoNgayNghiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiDH.setText("Số ngày nghỉ*");

        txtSoNgayNghiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiDH.setEnabled(false);
        txtSoNgayNghiDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiDHKeyPressed(evt);
            }
        });

        lblPhuCapKhacDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacDH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacDH.setText("Phụ cấp khác*");

        txtPhuCapKhacDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacDH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacDH.setEnabled(false);
        txtPhuCapKhacDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacDHKeyPressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel13.setBackground(new java.awt.Color(254, 255, 250));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel14.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader6.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader6.setText("Chức năng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader6)
                .addContainerGap(821, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemDH.setBackground(new java.awt.Color(3, 100, 117));
        btnThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemDH.setForeground(new java.awt.Color(107, 195, 196));
        btnThemDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemDH.setText("Thêm");
        btnThemDH.setBorder(null);
        btnThemDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemDH.setEnabled(false);
        btnThemDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDHActionPerformed(evt);
            }
        });

        btnSuaDH.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaDH.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaDH.setText("Sửa");
        btnSuaDH.setBorder(null);
        btnSuaDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaDH.setEnabled(false);
        btnSuaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDHActionPerformed(evt);
            }
        });

        btnXoaDH.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaDH.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaDH.setText("Xoá");
        btnXoaDH.setBorder(null);
        btnXoaDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaDH.setEnabled(false);
        btnXoaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDHActionPerformed(evt);
            }
        });

        btnMoiDH.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiDH.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiDH.setText("Mới");
        btnMoiDH.setBorder(null);
        btnMoiDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDH.setBackground(new java.awt.Color(254, 255, 250));
        tblDH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblDH.setForeground(new java.awt.Color(3, 100, 117));
        tblDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDH.setGridColor(new java.awt.Color(3, 100, 117));
        tblDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDH);

        javax.swing.GroupLayout pnKhoiDieuHanhLayout = new javax.swing.GroupLayout(pnKhoiDieuHanh);
        pnKhoiDieuHanh.setLayout(pnKhoiDieuHanhLayout);
        pnKhoiDieuHanhLayout.setHorizontalGroup(
            pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiDieuHanhLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                        .addComponent(lblGhiChuDH)
                        .addGap(20, 20, 20)
                        .addComponent(txtGhiChuDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnKhoiDieuHanhLayout.createSequentialGroup()
                                .addComponent(lblLuongCoBanDH)
                                .addGap(18, 18, 18)
                                .addComponent(txtLuongCoBanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                                .addComponent(lblMaNhanVienDH)
                                .addGap(32, 32, 32)
                                .addComponent(cbxMaNhanVienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                                .addComponent(lblPhuCapDH)
                                .addGap(60, 60, 60)
                                .addComponent(txtPhuCapDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhuCapKhacDH)
                            .addComponent(lblNamDH)
                            .addComponent(lblThangDH))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuCapKhacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemDH)
                                    .addComponent(lblSoNgayCongDH))
                                .addGap(18, 18, 18)
                                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiDH)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnKhoiDieuHanhLayout.setVerticalGroup(
            pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiDieuHanhLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhoiDieuHanhLayout.createSequentialGroup()
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThangDH)
                            .addComponent(txtSoNgayLamThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayLamThemDH))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamDH)
                            .addComponent(txtSoNgayCongDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayCongDH)
                            .addComponent(txtLuongCoBanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLuongCoBanDH)))
                    .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienDH)))
                .addGap(18, 18, 18)
                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhuCapDH)
                        .addComponent(txtPhuCapDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhuCapKhacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKhacDH)
                        .addComponent(lblSoNgayNghiDH))
                    .addComponent(txtSoNgayNghiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnKhoiDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChuDH)
                    .addComponent(txtGhiChuDH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khối điều hành", pnKhoiDieuHanh);

        pnKhoiVanPhong.setBackground(new java.awt.Color(254, 255, 250));
        pnKhoiVanPhong.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel12.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader5.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader5.setText("Thông tin về khối văn phòng");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienVP.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienVP.setText("Mã nhân viên");

        cbxMaNhanVienVP.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienVP.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuVP.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuVP.setText("Ghi chú");

        txtGhiChuVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuVP.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuVP.setEnabled(false);
        txtGhiChuVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuVP.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuVPActionPerformed(evt);
            }
        });

        lblNamVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamVP.setForeground(new java.awt.Color(3, 100, 117));
        lblNamVP.setText("Năm*");

        txtLuongVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongVP.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongVP.setEnabled(false);
        txtLuongVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongVP.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangVP.setForeground(new java.awt.Color(3, 100, 117));
        lblThangVP.setText("Tháng*");

        txtThangVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangVP.setForeground(new java.awt.Color(3, 100, 117));
        txtThangVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangVP.setEnabled(false);
        txtThangVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangVP.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongVP.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongVP.setText("Số ngày công*");

        txtSoNgayCongVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongVP.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongVP.setText("30");
        txtSoNgayCongVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongVP.setEnabled(false);
        txtSoNgayCongVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongVPKeyPressed(evt);
            }
        });

        lblSoNgayLamThemVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemVP.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemVP.setText("Số giờ làm thêm*");

        txtSoNgayLamThemVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemVP.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemVP.setEnabled(false);
        txtSoNgayLamThemVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemVPKeyPressed(evt);
            }
        });

        lblSoNgayNghiVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiVP.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiVP.setText("Số ngày nghỉ*");

        txtSoNgayNghiVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiVP.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiVP.setEnabled(false);
        txtSoNgayNghiVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiVPKeyPressed(evt);
            }
        });

        lblPhuCapKhacVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacVP.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacVP.setText("Phụ cấp khác*");

        txtPhuCapKhacVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacVP.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacVP.setEnabled(false);
        txtPhuCapKhacVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacVPKeyPressed(evt);
            }
        });

        lblLuongCoBanVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanVP.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanVP.setText("Lương cơ bản*");

        txtLuongCoBanVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanVP.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanVP.setEnabled(false);
        txtLuongCoBanVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanVPKeyPressed(evt);
            }
        });

        txtPhuCapVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapVP.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapVP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapVP.setEnabled(false);
        txtPhuCapVP.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapVP.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapVPKeyPressed(evt);
            }
        });

        lblPhuCapVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapVP.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapVP.setText("Phụ cấp*");

        jPanel19.setBackground(new java.awt.Color(254, 255, 250));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel20.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader9.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader9.setText("Chức năng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemVP.setBackground(new java.awt.Color(3, 100, 117));
        btnThemVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemVP.setForeground(new java.awt.Color(107, 195, 196));
        btnThemVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemVP.setText("Thêm");
        btnThemVP.setBorder(null);
        btnThemVP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemVP.setEnabled(false);
        btnThemVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVPActionPerformed(evt);
            }
        });

        btnSuaVP.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaVP.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaVP.setText("Sửa");
        btnSuaVP.setBorder(null);
        btnSuaVP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaVP.setEnabled(false);
        btnSuaVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVPActionPerformed(evt);
            }
        });

        btnXoaVP.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaVP.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaVP.setText("Xoá");
        btnXoaVP.setBorder(null);
        btnXoaVP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaVP.setEnabled(false);
        btnXoaVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVPActionPerformed(evt);
            }
        });

        btnMoiVP.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiVP.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiVP.setText("Mới");
        btnMoiVP.setBorder(null);
        btnMoiVP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiVPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiVP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemVP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaVP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaVP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaVP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiVP, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator5.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblVP.setBackground(new java.awt.Color(254, 255, 250));
        tblVP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblVP.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblVP.setForeground(new java.awt.Color(3, 100, 117));
        tblVP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVP.setGridColor(new java.awt.Color(3, 100, 117));
        tblVP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblVP);

        javax.swing.GroupLayout pnKhoiVanPhongLayout = new javax.swing.GroupLayout(pnKhoiVanPhong);
        pnKhoiVanPhong.setLayout(pnKhoiVanPhongLayout);
        pnKhoiVanPhongLayout.setHorizontalGroup(
            pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator5)
            .addGroup(pnKhoiVanPhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnKhoiVanPhongLayout.createSequentialGroup()
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLuongCoBanVP)
                            .addComponent(lblPhuCapVP)
                            .addComponent(lblMaNhanVienVP))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaNhanVienVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuCapVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongCoBanVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiVanPhongLayout.createSequentialGroup()
                                .addComponent(lblThangVP)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangVP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiVanPhongLayout.createSequentialGroup()
                                .addComponent(lblNamVP)
                                .addGap(79, 79, 79)
                                .addComponent(txtLuongVP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiVanPhongLayout.createSequentialGroup()
                                .addComponent(lblPhuCapKhacVP)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapKhacVP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnKhoiVanPhongLayout.createSequentialGroup()
                                .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemVP)
                                    .addComponent(lblSoNgayCongVP))
                                .addGap(18, 18, 18)
                                .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnKhoiVanPhongLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiVP)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiVP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnKhoiVanPhongLayout.createSequentialGroup()
                        .addComponent(lblGhiChuVP)
                        .addGap(20, 20, 20)
                        .addComponent(txtGhiChuVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnKhoiVanPhongLayout.setVerticalGroup(
            pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiVanPhongLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhoiVanPhongLayout.createSequentialGroup()
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThangVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoNgayLamThemVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayLamThemVP))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoNgayCongVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayCongVP)
                            .addComponent(txtLuongCoBanVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLuongCoBanVP)
                            .addComponent(lblNamVP))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNgayNghiVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPhuCapKhacVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhuCapKhacVP)
                                .addComponent(lblSoNgayNghiVP)
                                .addComponent(txtPhuCapVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhuCapVP)))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGhiChuVP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGhiChuVP)))
                    .addGroup(pnKhoiVanPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienVP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienVP)
                        .addComponent(lblThangVP)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khối văn phòng", pnKhoiVanPhong);

        pnlPhuCapVC.setBackground(new java.awt.Color(254, 255, 250));
        pnlPhuCapVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel11.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader4.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader4.setText("Thông tin về khối vận chuyển");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienVC.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienVC.setText("Mã nhân viên");

        cbxMaNhanVienVC.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienVC.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuVC.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuVC.setText("Ghi chú");

        txtGhiChuVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuVC.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuVC.setEnabled(false);
        txtGhiChuVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuVC.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuVCActionPerformed(evt);
            }
        });

        lblNamVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamVC.setForeground(new java.awt.Color(3, 100, 117));
        lblNamVC.setText("Năm*");

        txtLuongVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongVC.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongVC.setEnabled(false);
        txtLuongVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongVC.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangVC.setForeground(new java.awt.Color(3, 100, 117));
        lblThangVC.setText("Tháng*");

        txtThangVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangVC.setForeground(new java.awt.Color(3, 100, 117));
        txtThangVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangVC.setEnabled(false);
        txtThangVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangVC.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongVC.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongVC.setText("Số ngày công*");

        txtSoNgayCongVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongVC.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongVC.setText("30");
        txtSoNgayCongVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongVC.setEnabled(false);
        txtSoNgayCongVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongVCKeyPressed(evt);
            }
        });

        lblSoNgayLamThemVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemVC.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemVC.setText("Số giờ làm thêm*");

        txtSoNgayLamThemVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemVC.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemVC.setEnabled(false);
        txtSoNgayLamThemVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemVCKeyPressed(evt);
            }
        });

        lblSoNgayNghiVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiVC.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiVC.setText("Số ngày nghỉ*");

        txtSoNgayNghiVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiVC.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiVC.setEnabled(false);
        txtSoNgayNghiVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiVCKeyPressed(evt);
            }
        });

        lblPhuCapKhacVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacVC.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacVC.setText("Phụ cấp khác*");

        txtPhuCapKhacVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacVC.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacVC.setEnabled(false);
        txtPhuCapKhacVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacVCKeyPressed(evt);
            }
        });

        lblLuongCoBanVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanVC.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanVC.setText("Lương cơ bản*");

        txtLuongCoBanVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanVC.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanVC.setEnabled(false);
        txtLuongCoBanVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanVCKeyPressed(evt);
            }
        });

        txtPhuCapVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapVC.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapVC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapVC.setEnabled(false);
        txtPhuCapVC.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapVC.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapVCKeyPressed(evt);
            }
        });

        lblPhuCapDH3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapDH3.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapDH3.setText("Phụ cấp*");

        jPanel17.setBackground(new java.awt.Color(254, 255, 250));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));
        jPanel17.setEnabled(false);

        jPanel18.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader8.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader8.setText("Chức năng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemVC.setBackground(new java.awt.Color(3, 100, 117));
        btnThemVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemVC.setForeground(new java.awt.Color(107, 195, 196));
        btnThemVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemVC.setText("Thêm");
        btnThemVC.setBorder(null);
        btnThemVC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemVC.setEnabled(false);
        btnThemVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVCActionPerformed(evt);
            }
        });

        btnSuaVC.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaVC.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaVC.setText("Sửa");
        btnSuaVC.setBorder(null);
        btnSuaVC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaVC.setEnabled(false);
        btnSuaVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVCActionPerformed(evt);
            }
        });

        btnXoaVC.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaVC.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaVC.setText("Xoá");
        btnXoaVC.setBorder(null);
        btnXoaVC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaVC.setEnabled(false);
        btnXoaVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVCActionPerformed(evt);
            }
        });

        btnMoiVC.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiVC.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiVC.setText("Mới");
        btnMoiVC.setBorder(null);
        btnMoiVC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiVCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiVC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemVC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaVC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiVC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator4.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblVC.setBackground(new java.awt.Color(254, 255, 250));
        tblVC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblVC.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblVC.setForeground(new java.awt.Color(3, 100, 117));
        tblVC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVC.setGridColor(new java.awt.Color(3, 100, 117));
        tblVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVCMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblVC);

        javax.swing.GroupLayout pnlPhuCapVCLayout = new javax.swing.GroupLayout(pnlPhuCapVC);
        pnlPhuCapVC.setLayout(pnlPhuCapVCLayout);
        pnlPhuCapVCLayout.setHorizontalGroup(
            pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                        .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbxMaNhanVienVC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhuCapVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                                    .addComponent(lblLuongCoBanVC)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLuongCoBanVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblPhuCapDH3)
                                .addComponent(lblMaNhanVienVC)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhuCapVCLayout.createSequentialGroup()
                                .addComponent(lblThangVC)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhuCapVCLayout.createSequentialGroup()
                                .addComponent(lblNamVC)
                                .addGap(79, 79, 79)
                                .addComponent(txtLuongVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhuCapVCLayout.createSequentialGroup()
                                .addComponent(lblPhuCapKhacVC)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapKhacVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemVC)
                                    .addComponent(lblSoNgayCongVC))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemVC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongVC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiVC)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiVC, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlPhuCapVCLayout.createSequentialGroup()
                        .addComponent(lblGhiChuVC)
                        .addGap(20, 20, 20)
                        .addComponent(txtGhiChuVC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        pnlPhuCapVCLayout.setVerticalGroup(
            pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhuCapVCLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThangVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoNgayLamThemVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayLamThemVC))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblThangVC)
                        .addComponent(lblMaNhanVienVC)))
                .addGap(18, 18, 18)
                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoNgayCongVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuongVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoNgayCongVC)
                    .addComponent(txtLuongCoBanVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLuongCoBanVC)
                    .addComponent(lblNamVC))
                .addGap(18, 18, 18)
                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgayNghiVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhuCapKhacVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKhacVC)
                        .addComponent(lblSoNgayNghiVC)
                        .addComponent(txtPhuCapVC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapDH3)))
                .addGap(18, 18, 18)
                .addGroup(pnlPhuCapVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChuVC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChuVC))
                .addGap(29, 29, 29)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khối vận chuyển", pnlPhuCapVC);

        pnKhoiSanXuat.setBackground(new java.awt.Color(254, 255, 250));
        pnKhoiSanXuat.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel9.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader3.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader3.setText("Thông tin về khối sản xuất");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienSX.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienSX.setText("Mã nhân viên");

        cbxMaNhanVienSX.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienSX.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuSX.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuSX.setText("Ghi chú");

        txtGhiChuSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuSX.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuSX.setEnabled(false);
        txtGhiChuSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuSX.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuSXActionPerformed(evt);
            }
        });

        lblNamSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamSX.setForeground(new java.awt.Color(3, 100, 117));
        lblNamSX.setText("Năm*");

        txtLuongSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongSX.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongSX.setEnabled(false);
        txtLuongSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongSX.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangSX.setForeground(new java.awt.Color(3, 100, 117));
        lblThangSX.setText("Tháng*");

        txtThangSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangSX.setForeground(new java.awt.Color(3, 100, 117));
        txtThangSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangSX.setEnabled(false);
        txtThangSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangSX.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongSX.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongSX.setText("Số ngày công*");

        txtSoNgayCongSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongSX.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongSX.setText("30");
        txtSoNgayCongSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongSX.setEnabled(false);
        txtSoNgayCongSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongSX.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongSXKeyPressed(evt);
            }
        });

        lblSoNgayLamThemSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemSX.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemSX.setText("Số giờ làm thêm*");

        txtSoNgayLamThemSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemSX.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemSX.setEnabled(false);
        txtSoNgayLamThemSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemSX.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemSXKeyPressed(evt);
            }
        });

        lblSoNgayNghiSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiSX.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiSX.setText("Số ngày nghỉ*");

        txtSoNgayNghiSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiSX.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiSX.setEnabled(false);
        txtSoNgayNghiSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiSX.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiSXKeyPressed(evt);
            }
        });

        lblLuongCoBanSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanSX.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanSX.setText("Lương cơ bản*");

        txtLuongCoBanSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanSX.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanSX.setEnabled(false);
        txtLuongCoBanSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanSX.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanSXKeyPressed(evt);
            }
        });

        lblPhuCapSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapSX.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapSX.setText("Phụ cấp khác*");

        txtPhuCapSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapSX.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapSX.setEnabled(false);
        txtPhuCapSX.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapSX.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapSX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapSXKeyPressed(evt);
            }
        });

        lblMaPhongSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaPhongSX.setForeground(new java.awt.Color(3, 100, 117));
        lblMaPhongSX.setText("Mã phòng");

        cbxMaPhongSX.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaPhongSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaPhongSX.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaPhongSX.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel15.setBackground(new java.awt.Color(254, 255, 250));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel16.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader7.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader7.setText("Chức năng");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemSX.setBackground(new java.awt.Color(3, 100, 117));
        btnThemSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemSX.setForeground(new java.awt.Color(107, 195, 196));
        btnThemSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemSX.setText("Thêm");
        btnThemSX.setBorder(null);
        btnThemSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemSX.setEnabled(false);
        btnThemSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSXActionPerformed(evt);
            }
        });

        btnSuaSX.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaSX.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaSX.setText("Sửa");
        btnSuaSX.setBorder(null);
        btnSuaSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaSX.setEnabled(false);
        btnSuaSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSXActionPerformed(evt);
            }
        });

        btnXoaSX.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaSX.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaSX.setText("Xoá");
        btnXoaSX.setBorder(null);
        btnXoaSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaSX.setEnabled(false);
        btnXoaSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSXActionPerformed(evt);
            }
        });

        btnMoiSX.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiSX.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiSX.setText("Mới");
        btnMoiSX.setBorder(null);
        btnMoiSX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiSX, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemSX, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiSX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator3.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblSX.setBackground(new java.awt.Color(254, 255, 250));
        tblSX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblSX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblSX.setForeground(new java.awt.Color(3, 100, 117));
        tblSX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Ghi chú", "Mã phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSX.setGridColor(new java.awt.Color(3, 100, 117));
        tblSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSXMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSX);

        javax.swing.GroupLayout pnKhoiSanXuatLayout = new javax.swing.GroupLayout(pnKhoiSanXuat);
        pnKhoiSanXuat.setLayout(pnKhoiSanXuatLayout);
        pnKhoiSanXuatLayout.setHorizontalGroup(
            pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnKhoiSanXuatLayout.createSequentialGroup()
                        .addComponent(lblGhiChuSX)
                        .addGap(20, 20, 20)
                        .addComponent(txtGhiChuSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                        .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLuongCoBanSX)
                            .addComponent(lblMaPhongSX)
                            .addComponent(lblMaNhanVienSX))
                        .addGap(18, 18, 18)
                        .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxMaPhongSX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaNhanVienSX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongCoBanSX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnKhoiSanXuatLayout.createSequentialGroup()
                                .addComponent(lblThangSX)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                                .addComponent(lblNamSX)
                                .addGap(79, 79, 79)
                                .addComponent(txtLuongSX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                                .addComponent(lblPhuCapSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapSX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemSX)
                                    .addComponent(lblSoNgayCongSX))
                                .addGap(18, 18, 18)
                                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnKhoiSanXuatLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiSX)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiSX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnKhoiSanXuatLayout.setVerticalGroup(
            pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKhoiSanXuatLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoNgayLamThemSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayLamThemSX))
                    .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienSX)
                        .addComponent(lblThangSX)
                        .addComponent(txtThangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoNgayCongSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLuongSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayCongSX))
                    .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaPhongSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaPhongSX)
                        .addComponent(lblNamSX)))
                .addGap(18, 18, 18)
                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgayNghiSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoNgayNghiSX)
                        .addComponent(txtPhuCapSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapSX)
                        .addComponent(txtLuongCoBanSX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLuongCoBanSX)))
                .addGap(18, 18, 18)
                .addGroup(pnKhoiSanXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChuSX, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChuSX))
                .addGap(29, 29, 29)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khối sản xuất", pnKhoiSanXuat);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiChuSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuSXActionPerformed

    private void txtSoNgayCongSXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongSXKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayCongSX.setEditable(false);
        } else {
            txtSoNgayCongSX.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayCongSXKeyPressed

    private void txtSoNgayLamThemSXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemSXKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayLamThemSX.setEditable(false);
        } else {
            txtSoNgayLamThemSX.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayLamThemSXKeyPressed

    private void txtSoNgayNghiSXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiSXKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayNghiSX.setEditable(false);
        } else {
            txtSoNgayNghiSX.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayNghiSXKeyPressed

    private void txtLuongCoBanSXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanSXKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtLuongCoBanSX.setEditable(false);
        } else {
            txtLuongCoBanSX.setEditable(true);
        }
    }//GEN-LAST:event_txtLuongCoBanSXKeyPressed

    private void txtPhuCapSXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapSXKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapSX.setEditable(false);
        } else {
            txtPhuCapSX.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapSXKeyPressed

    private void btnThemSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSXActionPerformed
        // TODO add your handling code here:
        BangCongKhoiSanXuatBUS.Them(cbxMaNhanVienSX.getSelectedItem().toString(), txtLuongCoBanSX.getText(), txtPhuCapSX.getText(), txtThangSX.getText(), txtLuongSX.getText(),
                txtSoNgayCongSX.getText(), txtSoNgayNghiSX.getText(), txtSoNgayLamThemSX.getText(), txtGhiChuSX.getText(), cbxMaPhongSX.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblSX.getModel();
        model.setRowCount(0);
        showSX();
    }//GEN-LAST:event_btnThemSXActionPerformed

    private void btnSuaSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSXActionPerformed
        // TODO add your handling code here:
        BangCongKhoiSanXuatBUS.Sua(txtLuongCoBanSX.getText(), txtPhuCapSX.getText(), txtThangSX.getText(), txtLuongSX.getText(),
                txtSoNgayCongSX.getText(), txtSoNgayNghiSX.getText(), txtSoNgayLamThemSX.getText(), txtGhiChuSX.getText(), cbxMaPhongSX.getSelectedItem().toString(), cbxMaNhanVienSX.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblSX.getModel();
        model.setRowCount(0);
        showSX();
    }//GEN-LAST:event_btnSuaSXActionPerformed

    private void btnXoaSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSXActionPerformed
        // TODO add your handling code here:
        BangCongKhoiSanXuatBUS.Xoa(cbxMaNhanVienSX.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblSX.getModel();
        model.setRowCount(0);
        showSX();
    }//GEN-LAST:event_btnXoaSXActionPerformed

    private void btnMoiSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiSXActionPerformed
        // TODO add your handling code here:
        cbxMaNhanVienSX.removeAllItems();
        BangCongKhoiSanXuatBUS.getCBboxMaNV(cbxMaNhanVienSX);

        txtLuongCoBanSX.setEnabled(true);
        txtPhuCapSX.setEnabled(true);
        txtThangSX.setEnabled(true);
        txtLuongSX.setEnabled(true);
//        txtSoNgayCongSX.setEnabled(true);
        txtSoNgayNghiSX.setEnabled(true);
        txtSoNgayLamThemSX.setEnabled(true);
        txtGhiChuSX.setEnabled(true);
        //cbxMaPhongSX.setEnabled(true);
        btnThemSX.setEnabled(true);
        btnXoaSX.setEnabled(false);
        btnSuaSX.setEnabled(false);

        cbxMaNhanVienSX.setSelectedIndex(0);
        txtLuongCoBanSX.setText("");
        txtPhuCapSX.setText("");
        txtThangSX.setText(dateFormat.format(dateSX));
        txtLuongSX.setText(dateFormatY.format(dateSX));
//        txtSoNgayCongSX.setText("");
        txtSoNgayNghiSX.setText("");
        txtSoNgayLamThemSX.setText("");
        txtGhiChuSX.setText("");
        cbxMaPhongSX.setSelectedIndex(0);
    }//GEN-LAST:event_btnMoiSXActionPerformed

    private void tblSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSXMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienSX.removeAllItems();
        BangCongKhoiSanXuatBUS.getCBboxMaNVTb(cbxMaNhanVienSX);

        txtLuongCoBanSX.setEnabled(true);
        txtPhuCapSX.setEnabled(true);
        txtThangSX.setEnabled(true);
        txtLuongSX.setEnabled(true);
//        txtSoNgayCongSX.setEnabled(true);
        txtSoNgayNghiSX.setEnabled(true);
        txtSoNgayLamThemSX.setEnabled(true);
        txtGhiChuSX.setEnabled(true);
        //cbxMaPhongSX.setEnabled(true);
        btnThemSX.setEnabled(true);
        btnXoaSX.setEnabled(true);
        btnSuaSX.setEnabled(true);

        int i = tblSX.getSelectedRow();
        cbxMaNhanVienSX.setSelectedItem(modelSX.getValueAt(i, 0).toString());
        txtLuongCoBanSX.setText(modelSX.getValueAt(i, 1).toString());
        txtPhuCapSX.setText(modelSX.getValueAt(i, 2).toString());
        txtThangSX.setText(modelSX.getValueAt(i, 3).toString());
        txtLuongSX.setText(modelSX.getValueAt(i, 4).toString());
        txtSoNgayCongSX.setText(modelSX.getValueAt(i, 5).toString());
        txtSoNgayNghiSX.setText(modelSX.getValueAt(i, 6).toString());
        txtSoNgayLamThemSX.setText(modelSX.getValueAt(i, 7).toString());
        txtGhiChuSX.setText(modelSX.getValueAt(i, 8).toString());
        cbxMaPhongSX.setSelectedItem(modelSX.getValueAt(i, 9).toString());
    }//GEN-LAST:event_tblSXMouseClicked

    private void txtGhiChuDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuDHActionPerformed

    private void txtPhuCapDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapDH.setEditable(false);
        } else {
            txtPhuCapDH.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapDHKeyPressed

    private void txtLuongCoBanDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtLuongCoBanDH.setEditable(false);
        } else {
            txtLuongCoBanDH.setEditable(true);
        }
    }//GEN-LAST:event_txtLuongCoBanDHKeyPressed

    private void txtSoNgayCongDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayCongDH.setEditable(false);
        } else {
            txtSoNgayCongDH.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayCongDHKeyPressed

    private void txtSoNgayLamThemDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayLamThemDH.setEditable(false);
        } else {
            txtSoNgayLamThemDH.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayLamThemDHKeyPressed

    private void txtSoNgayNghiDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayNghiDH.setEditable(false);
        } else {
            txtSoNgayNghiDH.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayNghiDHKeyPressed

    private void txtPhuCapKhacDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapKhacDH.setEditable(false);
        } else {
            txtPhuCapKhacDH.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapKhacDHKeyPressed

    private void btnThemDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDHActionPerformed
        // TODO add your handling code here:
        BangCongKhoiDieuHanhBUS.Them(cbxMaNhanVienDH.getSelectedItem().toString(), txtLuongCoBanDH.getText(), txtPhuCapDH.getText(), txtPhuCapKhacDH.getText(), txtThangDH.getText(),
                txtLuongDH.getText(), txtSoNgayCongDH.getText(), txtSoNgayNghiDH.getText(), txtSoNgayLamThemDH.getText(), txtGhiChuDH.getText());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnThemDHActionPerformed

    private void btnSuaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDHActionPerformed
        // TODO add your handling code here:
        BangCongKhoiDieuHanhBUS.Sua(txtLuongCoBanDH.getText(), txtPhuCapDH.getText(), txtPhuCapKhacDH.getText(), txtThangDH.getText(),
                txtLuongDH.getText(), txtSoNgayCongDH.getText(), txtSoNgayNghiDH.getText(), txtSoNgayLamThemDH.getText(), txtGhiChuDH.getText(), cbxMaNhanVienDH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnSuaDHActionPerformed

    private void btnXoaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDHActionPerformed
        // TODO add your handling code here:
        BangCongKhoiDieuHanhBUS.Xoa(cbxMaNhanVienDH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnXoaDHActionPerformed

    private void btnMoiDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDHActionPerformed
        // TODO add your handling code here:
        cbxMaNhanVienDH.removeAllItems();
        BangCongKhoiDieuHanhBUS.getCBboxMaNV(cbxMaNhanVienDH);

        txtLuongCoBanDH.setEnabled(true);
        txtPhuCapDH.setEnabled(true);
        txtPhuCapKhacDH.setEnabled(true);
        txtThangDH.setEnabled(true);
        txtLuongDH.setEnabled(true);
//        txtSoNgayCongDH.setEnabled(true);
        txtSoNgayNghiDH.setEnabled(true);
        txtSoNgayLamThemDH.setEnabled(true);
        txtGhiChuDH.setEnabled(true);
        btnThemDH.setEnabled(true);
        btnXoaDH.setEnabled(false);
        btnSuaDH.setEnabled(false);

        cbxMaNhanVienDH.setSelectedIndex(0);
        txtLuongCoBanDH.setText("");
        txtPhuCapDH.setText("");
        txtPhuCapKhacDH.setText("");
        txtThangDH.setText(dateFormat.format(dateDH));
        txtLuongDH.setText(dateFormatY.format(dateDH));
//        txtSoNgayCongDH.setText("");
        txtSoNgayNghiDH.setText("");
        txtSoNgayLamThemDH.setText("");
        txtGhiChuDH.setText("");
    }//GEN-LAST:event_btnMoiDHActionPerformed

    private void tblDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDHMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienDH.removeAllItems();
        BangCongKhoiDieuHanhBUS.getCBboxMaNVTb(cbxMaNhanVienDH);

        txtLuongCoBanDH.setEnabled(true);
        txtPhuCapDH.setEnabled(true);
        txtPhuCapKhacDH.setEnabled(true);
        txtThangDH.setEnabled(true);
        txtLuongDH.setEnabled(true);
//        txtSoNgayCongDH.setEnabled(true);
        txtSoNgayNghiDH.setEnabled(true);
        txtSoNgayLamThemDH.setEnabled(true);
        txtGhiChuDH.setEnabled(true);
        btnThemDH.setEnabled(true);
        btnXoaDH.setEnabled(true);
        btnSuaDH.setEnabled(true);

        int i = tblDH.getSelectedRow();
        cbxMaNhanVienDH.setSelectedItem(modelDH.getValueAt(i, 0).toString());
        txtLuongCoBanDH.setText(modelDH.getValueAt(i, 1).toString());
        txtPhuCapDH.setText(modelDH.getValueAt(i, 2).toString());
        txtPhuCapKhacDH.setText(modelDH.getValueAt(i, 3).toString());
        txtThangDH.setText(modelDH.getValueAt(i, 4).toString());
        txtLuongDH.setText(modelDH.getValueAt(i, 5).toString());
        txtSoNgayCongDH.setText(modelDH.getValueAt(i, 6).toString());
        txtSoNgayNghiDH.setText(modelDH.getValueAt(i, 7).toString());
        txtSoNgayLamThemDH.setText(modelDH.getValueAt(i, 8).toString());
        txtGhiChuDH.setText(modelDH.getValueAt(i, 9).toString());
    }//GEN-LAST:event_tblDHMouseClicked

    private void txtGhiChuVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuVPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuVPActionPerformed

    private void txtSoNgayCongVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayCongVP.setEditable(false);
        } else {
            txtSoNgayCongVP.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayCongVPKeyPressed

    private void txtSoNgayLamThemVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayLamThemVP.setEditable(false);
        } else {
            txtSoNgayLamThemVP.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayLamThemVPKeyPressed

    private void txtSoNgayNghiVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayNghiVP.setEditable(false);
        } else {
            txtSoNgayNghiVP.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayNghiVPKeyPressed

    private void txtPhuCapKhacVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapKhacVP.setEditable(false);
        } else {
            txtPhuCapKhacVP.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapKhacVPKeyPressed

    private void txtLuongCoBanVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtLuongCoBanVP.setEditable(false);
        } else {
            txtLuongCoBanVP.setEditable(true);
        }
    }//GEN-LAST:event_txtLuongCoBanVPKeyPressed

    private void txtPhuCapVPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapVPKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapVP.setEditable(false);
        } else {
            txtPhuCapVP.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapVPKeyPressed

    private void btnThemVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVPActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanPhongBUS.Them(cbxMaNhanVienVP.getSelectedItem().toString(), txtLuongCoBanVP.getText(), txtPhuCapVP.getText(), txtPhuCapKhacVP.getText(), txtThangVP.getText(),
                txtLuongVP.getText(), txtSoNgayCongVP.getText(), txtSoNgayNghiVP.getText(), txtSoNgayLamThemVP.getText(), txtGhiChuVP.getText());
        DefaultTableModel model = (DefaultTableModel) tblVP.getModel();
        model.setRowCount(0);
        showVP();
    }//GEN-LAST:event_btnThemVPActionPerformed

    private void btnSuaVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVPActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanPhongBUS.Sua(txtLuongCoBanVP.getText(), txtPhuCapVP.getText(), txtPhuCapKhacVP.getText(), txtThangVP.getText(),
                txtLuongVP.getText(), txtSoNgayCongVP.getText(), txtSoNgayNghiVP.getText(), txtSoNgayLamThemVP.getText(), txtGhiChuVP.getText(), cbxMaNhanVienVP.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblVP.getModel();
        model.setRowCount(0);
        showVP();
    }//GEN-LAST:event_btnSuaVPActionPerformed

    private void btnXoaVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVPActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanPhongBUS.Xoa(cbxMaNhanVienVP.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblVP.getModel();
        model.setRowCount(0);
        showVP();
    }//GEN-LAST:event_btnXoaVPActionPerformed

    private void btnMoiVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiVPActionPerformed
        // TODO add your handling code here:
        cbxMaNhanVienVP.removeAllItems();
        BangCongKhoiVanPhongBUS.getCBboxMaNV(cbxMaNhanVienVP);

        txtLuongCoBanVP.setEnabled(true);
        txtPhuCapVP.setEnabled(true);
        txtPhuCapKhacVP.setEnabled(true);
        txtThangVP.setEnabled(true);
        txtLuongVP.setEnabled(true);
//        txtSoNgayCongVP.setEnabled(true);
        txtSoNgayNghiVP.setEnabled(true);
        txtSoNgayLamThemVP.setEnabled(true);
        txtGhiChuVP.setEnabled(true);
        btnThemVP.setEnabled(true);
        btnXoaVP.setEnabled(false);
        btnSuaVP.setEnabled(false);

        cbxMaNhanVienVP.setSelectedIndex(0);
        txtLuongCoBanVP.setText("");
        txtPhuCapVP.setText("");
        txtPhuCapKhacVP.setText("");
        txtThangVP.setText(dateFormat.format(dateVP));
        txtLuongVP.setText(dateFormatY.format(dateVP));
//        txtSoNgayCongVP.setText("");
        txtSoNgayNghiVP.setText("");
        txtSoNgayLamThemVP.setText("");
        txtGhiChuVP.setText("");
    }//GEN-LAST:event_btnMoiVPActionPerformed

    private void tblVPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVPMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienVP.removeAllItems();
        BangCongKhoiVanPhongBUS.getCBboxMaNVTb(cbxMaNhanVienVP);

        txtLuongCoBanVP.setEnabled(true);
        txtPhuCapVP.setEnabled(true);
        txtPhuCapKhacVP.setEnabled(true);
        txtThangVP.setEnabled(true);
        txtLuongVP.setEnabled(true);
//        txtSoNgayCongVP.setEnabled(true);
        txtSoNgayNghiVP.setEnabled(true);
        txtSoNgayLamThemVP.setEnabled(true);
        txtGhiChuVP.setEnabled(true);
        btnThemVP.setEnabled(true);
        btnXoaVP.setEnabled(true);
        btnSuaVP.setEnabled(true);

        int i = tblVP.getSelectedRow();
        cbxMaNhanVienVP.setSelectedItem(modelVP.getValueAt(i, 0).toString());
        txtLuongCoBanVP.setText(modelVP.getValueAt(i, 1).toString());
        txtPhuCapVP.setText(modelVP.getValueAt(i, 2).toString());
        txtPhuCapKhacVP.setText(modelVP.getValueAt(i, 3).toString());
        txtThangVP.setText(modelVP.getValueAt(i, 4).toString());
        txtLuongVP.setText(modelVP.getValueAt(i, 5).toString());
        txtSoNgayCongVP.setText(modelVP.getValueAt(i, 6).toString());
        txtSoNgayNghiVP.setText(modelVP.getValueAt(i, 7).toString());
        txtSoNgayLamThemVP.setText(modelVP.getValueAt(i, 8).toString());
        txtGhiChuVP.setText(modelVP.getValueAt(i, 9).toString());
    }//GEN-LAST:event_tblVPMouseClicked

    private void txtGhiChuVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuVCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuVCActionPerformed

    private void txtSoNgayCongVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayCongVC.setEditable(false);
        } else {
            txtSoNgayCongVC.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayCongVCKeyPressed

    private void txtSoNgayLamThemVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayLamThemVC.setEditable(false);
        } else {
            txtSoNgayLamThemVC.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayLamThemVCKeyPressed

    private void txtSoNgayNghiVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtSoNgayNghiVC.setEditable(false);
        } else {
            txtSoNgayNghiVC.setEditable(true);
        }
    }//GEN-LAST:event_txtSoNgayNghiVCKeyPressed

    private void txtPhuCapKhacVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapKhacVC.setEditable(false);
        } else {
            txtPhuCapKhacVC.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapKhacVCKeyPressed

    private void txtLuongCoBanVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtLuongCoBanVC.setEditable(false);
        } else {
            txtLuongCoBanVC.setEditable(true);
        }
    }//GEN-LAST:event_txtLuongCoBanVCKeyPressed

    private void txtPhuCapVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapVCKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtPhuCapVC.setEditable(false);
        } else {
            txtPhuCapVC.setEditable(true);
        }
    }//GEN-LAST:event_txtPhuCapVCKeyPressed

    private void btnThemVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVCActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanChuyenBUS.Them(cbxMaNhanVienVC.getSelectedItem().toString(), txtLuongCoBanVC.getText(), txtPhuCapVC.getText(), txtPhuCapKhacVC.getText(), txtThangVC.getText(),
                txtLuongVC.getText(), txtSoNgayCongVC.getText(), txtSoNgayNghiVC.getText(), txtSoNgayLamThemVC.getText(), txtGhiChuVC.getText());
        DefaultTableModel model = (DefaultTableModel) tblVC.getModel();
        model.setRowCount(0);
        showVC();
    }//GEN-LAST:event_btnThemVCActionPerformed

    private void btnSuaVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVCActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanChuyenBUS.Them(txtLuongCoBanVC.getText(), txtPhuCapVC.getText(), txtPhuCapKhacVC.getText(), txtThangVC.getText(),
                txtLuongVC.getText(), txtSoNgayCongVC.getText(), txtSoNgayNghiVC.getText(), txtSoNgayLamThemVC.getText(), txtGhiChuVC.getText(), cbxMaNhanVienVC.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblVC.getModel();
        model.setRowCount(0);
        showVC();
    }//GEN-LAST:event_btnSuaVCActionPerformed

    private void btnXoaVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVCActionPerformed
        // TODO add your handling code here:
        BangCongKhoiVanChuyenBUS.Xoa(cbxMaNhanVienVC.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblVC.getModel();
        model.setRowCount(0);
        showVC();
    }//GEN-LAST:event_btnXoaVCActionPerformed

    private void btnMoiVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiVCActionPerformed
        // TODO add your handling code here:
        cbxMaNhanVienVC.removeAllItems();
        BangCongKhoiVanChuyenBUS.getCBboxMaNV(cbxMaNhanVienVC);

        txtLuongCoBanVC.setEnabled(true);
        txtPhuCapVC.setEnabled(true);
        txtPhuCapKhacVC.setEnabled(true);
        txtThangVC.setEnabled(true);
        txtLuongVC.setEnabled(true);
//        txtSoNgayCongVC.setEnabled(true);
        txtSoNgayNghiVC.setEnabled(true);
        txtSoNgayLamThemVC.setEnabled(true);
        txtGhiChuVC.setEnabled(true);
        btnThemVC.setEnabled(true);
        btnXoaVC.setEnabled(false);
        btnSuaVC.setEnabled(false);

        cbxMaNhanVienVC.setSelectedIndex(0);
        txtLuongCoBanVC.setText("");
        txtPhuCapVC.setText("");
        txtPhuCapKhacVC.setText("");
        txtThangVC.setText(dateFormat.format(dateVC));
        txtLuongVC.setText(dateFormatY.format(dateVC));
//        txtSoNgayCongVC.setText("");
        txtSoNgayNghiVC.setText("");
        txtSoNgayLamThemVC.setText("");
        txtGhiChuVC.setText("");
    }//GEN-LAST:event_btnMoiVCActionPerformed

    private void tblVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVCMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienVC.removeAllItems();
        BangCongKhoiVanChuyenBUS.getCBboxMaNVTb(cbxMaNhanVienVC);

        txtLuongCoBanVC.setEnabled(true);
        txtPhuCapVC.setEnabled(true);
        txtPhuCapKhacVC.setEnabled(true);
        txtThangVC.setEnabled(true);
        txtLuongVC.setEnabled(true);
//        txtSoNgayCongVC.setEnabled(true);
        txtSoNgayNghiVC.setEnabled(true);
        txtSoNgayLamThemVC.setEnabled(true);
        txtGhiChuVC.setEnabled(true);
        btnThemVC.setEnabled(true);
        btnXoaVC.setEnabled(true);
        btnSuaVC.setEnabled(true);

        int i = tblVC.getSelectedRow();
        cbxMaNhanVienVC.setSelectedItem(modelVC.getValueAt(i, 0).toString());
        txtLuongCoBanVC.setText(modelVC.getValueAt(i, 1).toString());
        txtPhuCapVC.setText(modelVC.getValueAt(i, 2).toString());
        txtPhuCapKhacVC.setText(modelVC.getValueAt(i, 3).toString());
        txtThangVC.setText(modelVC.getValueAt(i, 4).toString());
        txtLuongVC.setText(modelVC.getValueAt(i, 5).toString());
        txtSoNgayCongVC.setText(modelVC.getValueAt(i, 6).toString());
        txtSoNgayNghiVC.setText(modelVC.getValueAt(i, 7).toString());
        txtSoNgayLamThemVC.setText(modelVC.getValueAt(i, 8).toString());
        txtGhiChuVC.setText(modelVC.getValueAt(i, 9).toString());
    }//GEN-LAST:event_tblVCMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoiDH;
    private javax.swing.JButton btnMoiSX;
    private javax.swing.JButton btnMoiVC;
    private javax.swing.JButton btnMoiVP;
    private javax.swing.JButton btnSuaDH;
    private javax.swing.JButton btnSuaSX;
    private javax.swing.JButton btnSuaVC;
    private javax.swing.JButton btnSuaVP;
    private javax.swing.JButton btnThemDH;
    private javax.swing.JButton btnThemSX;
    private javax.swing.JButton btnThemVC;
    private javax.swing.JButton btnThemVP;
    private javax.swing.JButton btnXoaDH;
    private javax.swing.JButton btnXoaSX;
    private javax.swing.JButton btnXoaVC;
    private javax.swing.JButton btnXoaVP;
    private javax.swing.JComboBox<String> cbxMaNhanVienDH;
    private javax.swing.JComboBox<String> cbxMaNhanVienSX;
    private javax.swing.JComboBox<String> cbxMaNhanVienVC;
    private javax.swing.JComboBox<String> cbxMaNhanVienVP;
    private javax.swing.JComboBox<String> cbxMaPhongSX;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblGhiChuDH;
    private javax.swing.JLabel lblGhiChuSX;
    private javax.swing.JLabel lblGhiChuVC;
    private javax.swing.JLabel lblGhiChuVP;
    private javax.swing.JLabel lblHeader2;
    private javax.swing.JLabel lblHeader3;
    private javax.swing.JLabel lblHeader4;
    private javax.swing.JLabel lblHeader5;
    private javax.swing.JLabel lblHeader6;
    private javax.swing.JLabel lblHeader7;
    private javax.swing.JLabel lblHeader8;
    private javax.swing.JLabel lblHeader9;
    private javax.swing.JLabel lblLuongCoBanDH;
    private javax.swing.JLabel lblLuongCoBanSX;
    private javax.swing.JLabel lblLuongCoBanVC;
    private javax.swing.JLabel lblLuongCoBanVP;
    private javax.swing.JLabel lblMaNhanVienDH;
    private javax.swing.JLabel lblMaNhanVienSX;
    private javax.swing.JLabel lblMaNhanVienVC;
    private javax.swing.JLabel lblMaNhanVienVP;
    private javax.swing.JLabel lblMaPhongSX;
    private javax.swing.JLabel lblNamDH;
    private javax.swing.JLabel lblNamSX;
    private javax.swing.JLabel lblNamVC;
    private javax.swing.JLabel lblNamVP;
    private javax.swing.JLabel lblPhuCapDH;
    private javax.swing.JLabel lblPhuCapDH3;
    private javax.swing.JLabel lblPhuCapKhacDH;
    private javax.swing.JLabel lblPhuCapKhacVC;
    private javax.swing.JLabel lblPhuCapKhacVP;
    private javax.swing.JLabel lblPhuCapSX;
    private javax.swing.JLabel lblPhuCapVP;
    private javax.swing.JLabel lblSoNgayCongDH;
    private javax.swing.JLabel lblSoNgayCongSX;
    private javax.swing.JLabel lblSoNgayCongVC;
    private javax.swing.JLabel lblSoNgayCongVP;
    private javax.swing.JLabel lblSoNgayLamThemDH;
    private javax.swing.JLabel lblSoNgayLamThemSX;
    private javax.swing.JLabel lblSoNgayLamThemVC;
    private javax.swing.JLabel lblSoNgayLamThemVP;
    private javax.swing.JLabel lblSoNgayNghiDH;
    private javax.swing.JLabel lblSoNgayNghiSX;
    private javax.swing.JLabel lblSoNgayNghiVC;
    private javax.swing.JLabel lblSoNgayNghiVP;
    private javax.swing.JLabel lblThangDH;
    private javax.swing.JLabel lblThangSX;
    private javax.swing.JLabel lblThangVC;
    private javax.swing.JLabel lblThangVP;
    private javax.swing.JPanel pnKhoiDieuHanh;
    private javax.swing.JPanel pnKhoiSanXuat;
    private javax.swing.JPanel pnKhoiVanPhong;
    private javax.swing.JPanel pnlPhuCapVC;
    private javax.swing.JTable tblDH;
    private javax.swing.JTable tblSX;
    private javax.swing.JTable tblVC;
    private javax.swing.JTable tblVP;
    private javax.swing.JTextField txtGhiChuDH;
    private javax.swing.JTextField txtGhiChuSX;
    private javax.swing.JTextField txtGhiChuVC;
    private javax.swing.JTextField txtGhiChuVP;
    private javax.swing.JTextField txtLuongCoBanDH;
    private javax.swing.JTextField txtLuongCoBanSX;
    private javax.swing.JTextField txtLuongCoBanVC;
    private javax.swing.JTextField txtLuongCoBanVP;
    private javax.swing.JTextField txtLuongDH;
    private javax.swing.JTextField txtLuongSX;
    private javax.swing.JTextField txtLuongVC;
    private javax.swing.JTextField txtLuongVP;
    private javax.swing.JTextField txtPhuCapDH;
    private javax.swing.JTextField txtPhuCapKhacDH;
    private javax.swing.JTextField txtPhuCapKhacVC;
    private javax.swing.JTextField txtPhuCapKhacVP;
    private javax.swing.JTextField txtPhuCapSX;
    private javax.swing.JTextField txtPhuCapVC;
    private javax.swing.JTextField txtPhuCapVP;
    private javax.swing.JTextField txtSoNgayCongDH;
    private javax.swing.JTextField txtSoNgayCongSX;
    private javax.swing.JTextField txtSoNgayCongVC;
    private javax.swing.JTextField txtSoNgayCongVP;
    private javax.swing.JTextField txtSoNgayLamThemDH;
    private javax.swing.JTextField txtSoNgayLamThemSX;
    private javax.swing.JTextField txtSoNgayLamThemVC;
    private javax.swing.JTextField txtSoNgayLamThemVP;
    private javax.swing.JTextField txtSoNgayNghiDH;
    private javax.swing.JTextField txtSoNgayNghiSX;
    private javax.swing.JTextField txtSoNgayNghiVC;
    private javax.swing.JTextField txtSoNgayNghiVP;
    private javax.swing.JTextField txtThangDH;
    private javax.swing.JTextField txtThangSX;
    private javax.swing.JTextField txtThangVC;
    private javax.swing.JTextField txtThangVP;
    // End of variables declaration//GEN-END:variables
}
