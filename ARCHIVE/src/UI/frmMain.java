package UI;

import UI.frmBoPhan;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import icon.MenuItem;

import UI.frmTraCuu;
import UI.frmCheDo;
import UI.frmBoPhan;
import UI.frmLuong;
import UI.frmQLBangCong;
import UI.frmQLNhanSu;
import UI.frmQLPhongBan;
import UI.frmThongTinCaNhan;
import UI.frmTaoTK;
import UI.frmTraCuuLuong;
import java.awt.Color;
import javax.swing.JPanel;

public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public int k;

    public frmMain() {
        initComponents();
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //execute();
    }

    public void execute() {
        ImageIcon iconDanhMuc = new ImageIcon(getClass().getResource("/icon/document.png"));
        ImageIcon iconNhanSu = new ImageIcon(getClass().getResource("/icon/personnel.png"));
        ImageIcon iconTTCN = new ImageIcon(getClass().getResource("/icon/profile.png"));
        ImageIcon iconCheDo = new ImageIcon(getClass().getResource("/icon/list.png"));
        ImageIcon iconLuong = new ImageIcon(getClass().getResource("/icon/money-bag.png"));
        ImageIcon iconQuanLy = new ImageIcon(getClass().getResource("/icon/manager.png"));
        ImageIcon iconPhongBan = new ImageIcon(getClass().getResource("/icon/house-outline.png"));
        ImageIcon iconBoPhan = new ImageIcon(getClass().getResource("/icon/department.png"));
        ImageIcon iconHoSo = new ImageIcon(getClass().getResource("/icon/notebook.png"));
        ImageIcon iconBangCong = new ImageIcon(getClass().getResource("/icon/pay-day.png"));
        ImageIcon iconChucNang = new ImageIcon(getClass().getResource("/icon/gear.png"));
        ImageIcon iconTraCuu = new ImageIcon(getClass().getResource("/icon/loupe.png"));
        ImageIcon iconTaoTK = new ImageIcon(getClass().getResource("/icon/user.png"));

        //  create Danh Muc
        MenuItem menuNhanSu = new MenuItem(iconNhanSu, "Nh??n s???", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmQLNhanSu());
                lblLogo.setText("Qu???n l?? nh??n s???");
            }
        });
        MenuItem menuTTCN = new MenuItem(iconTTCN, "Th??ng tin c?? nh??n", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmThongTinCaNhan());
                lblLogo.setText("Th??ng tin c?? nh??n");

            }
        });
        MenuItem menuCheDo = new MenuItem(iconCheDo, "Ch??? ?????", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmCheDo());
                lblLogo.setText("Ch??? ????? nh??n vi??n");
            }
        });
        MenuItem menuLuong = new MenuItem(iconLuong, "Ti???n l????ng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmLuong());
                lblLogo.setText("Qu???n l?? ti???n l????ng");
            }
        });
        //  create Quan Ly

        MenuItem menuPhongBan = new MenuItem(iconPhongBan, "Ph??ng ban", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmQLPhongBan());
                lblLogo.setText("Qu???n l?? ph??ng ban");
            }
        });
        MenuItem menuBoPhan = new MenuItem(iconBoPhan, "B??? ph???n", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmBoPhan());
                lblLogo.setText("Qu???n l?? b??? ph???n");
            }
        });

        MenuItem menuBangCong = new MenuItem(iconBangCong, "B???ng c??ng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmQLBangCong());
                lblLogo.setText("Qu???n l?? b???ng c??ng");
            }
        });

        //  create Ch???c n??ng
        MenuItem menuTraCuu = new MenuItem(iconTraCuu, "Tra c???u", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmTraCuu());
                lblLogo.setText("Tra c???u th??ng tin");
            }
        });

        MenuItem menuTaoTK = new MenuItem(iconTaoTK, "T???o t??i kho???n", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmTaoTK());
                lblLogo.setText("");
            }
        });

        MenuItem menuTraCuuLuong = new MenuItem(iconTraCuu, "Tra c???u l????ng nh??n vi??n", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchPanels(new frmTraCuuLuong());
                lblLogo.setText("Tra c???u l????ng nh??n vi??n");
            }
        });

        if (k == 0) {
            MenuItem menuDanhMuc = new MenuItem(iconDanhMuc, "Danh M???c", null, menuNhanSu, menuTTCN, menuCheDo, menuLuong);
            MenuItem menuQuanLy = new MenuItem(iconQuanLy, "Qu???n L??", null, menuPhongBan, menuBoPhan, menuBangCong);
            MenuItem menuChucNang = new MenuItem(iconChucNang, "Ch???c N??ng", null, menuTraCuu, menuTraCuuLuong, menuTaoTK);

            menuDanhMuc.setBackground(Color.black);
            menuQuanLy.setBackground(Color.black);
            menuChucNang.setBackground(Color.black);

            addMenu(menuDanhMuc, menuQuanLy, menuChucNang);
        } else if (k == 1) {
            MenuItem menuDanhMuc = new MenuItem(iconDanhMuc, "Danh M???c", null, menuNhanSu, menuTTCN, menuCheDo, menuLuong);
            MenuItem menuQuanLy = new MenuItem(iconQuanLy, "Qu???n L??", null, menuPhongBan, menuBoPhan, menuBangCong);
            MenuItem menuChucNang = new MenuItem(iconChucNang, "Ch???c N??ng", null, menuTraCuu, menuTraCuuLuong);

            menuDanhMuc.setBackground(Color.black);
            menuQuanLy.setBackground(Color.black);
            menuChucNang.setBackground(Color.black);

            addMenu(menuDanhMuc, menuQuanLy, menuChucNang);
        } else if (k == 2) {
            MenuItem menuChucNang = new MenuItem(iconChucNang, "Ch???c N??ng", null, menuTraCuu, menuTraCuuLuong);

            menuChucNang.setBackground(Color.black);

            addMenu(menuChucNang);
        }
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            pnlMenus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        pnlMenus.revalidate();
    }

    public void switchPanels(JPanel panel) {
        pnlBody.removeAll();
        pnlBody.add(panel);
        pnlBody.repaint();
        pnlBody.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMini = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        icoLogout = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlMenus = new javax.swing.JPanel();
        pnlBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);

        pnlHeader.setBackground(new java.awt.Color(3, 100, 117));
        pnlHeader.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1295, 80));

        lblClose.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        lblClose.setForeground(new java.awt.Color(254, 255, 250));
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        lblMini.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblMini.setForeground(new java.awt.Color(254, 255, 250));
        lblMini.setText("-");
        lblMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMiniMouseClicked(evt);
            }
        });

        lblLogo.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(254, 255, 250));
        lblLogo.setText("Ph???n m???m qu???n l?? nh??n s??? v?? ti???n l????ng ");

        icoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/logout.png"))); // NOI18N
        icoLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icoLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icoLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(195, 195, 195)
                .addComponent(lblMini, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblClose)
                .addGap(27, 27, 27))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMini, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(icoLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(null);

        pnlMenus.setBackground(new java.awt.Color(107, 195, 196));
        pnlMenus.setLayout(new javax.swing.BoxLayout(pnlMenus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlMenus);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMenu, java.awt.BorderLayout.LINE_START);

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setPreferredSize(new java.awt.Dimension(939, 629));
        pnlBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1227, 653));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMiniMouseClicked

    private void icoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icoLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmDangNhap dn = new frmDangNhap();
        dn.setVisible(true);
        dn.pack();
        dn.setLocationRelativeTo(null);
    }//GEN-LAST:event_icoLogoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icoLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMini;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenus;
    // End of variables declaration//GEN-END:variables
}
