/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import map.Brick;
import map.KeyCtrl;
import map.MapDetails;
import map.Player;

/**
 *
 * @author Hishara
 */
public class MapMain extends javax.swing.JFrame {

    static JLabel[][] labelArray = new JLabel[10][10];

    /**
     * Creates new form MapMain
     */
    public MapMain() {
        initComponents();

        mapPanel.requestFocus();
        mapPanel.addKeyListener(new KeyCtrl());

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                labelArray[y][x] = new JLabel();
                mapPanel.setLayout(new GridLayout(10, 10));
                mapPanel.add(labelArray[y][x]);
                labelArray[y][x].setHorizontalTextPosition(JLabel.CENTER);
                switch (MapDetails.map[x][y]) {
                    case "S":
                        labelArray[y][x].setIcon(new ImageIcon(getClass().getResource("/img/stone.jpg")));
                        labelArray[y][x].setText("Stone");
                        break;
                    case "B":
                        labelArray[y][x].setIcon(new ImageIcon(getClass().getResource("/img/brick.jpg")));
                        labelArray[y][x].setForeground(Color.WHITE);
                        labelArray[y][x].setText("<html>Brick<br>100%</html>");
                        labelArray[y][x].getParent().revalidate();
                        break;
                    case "W":
                        labelArray[y][x].setIcon(new ImageIcon(getClass().getResource("/img/water.jpg")));
                        labelArray[y][x].setText("Water");
                        break;
                    case "0":
                        labelArray[y][x].setIcon(new ImageIcon(getClass().getResource("/img/prt.jpg")));
                        labelArray[y][x].setText(Integer.toString(y) + Integer.toString(x));
                        break;
                }

            }

        }
        //labelArray[1][1].setText("<html>Brick<br>" + 24 + "</html>");

    }

    public static void updateImage() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                switch (MapDetails.map[i][j]) {
                    case "L":
                        labelArray[j][i].setIcon(new ImageIcon(MapMain.class.getResource("/img/health.jpg")));
                        break;
                    case "C":
                        labelArray[j][i].setIcon(new ImageIcon(MapMain.class.getResource("/img/coin.jpg")));
                        break;
                    case "0":
                        labelArray[j][i].setIcon(new ImageIcon(MapMain.class.getResource("/img/prt.jpg")));
                        labelArray[j][i].setHorizontalTextPosition(JLabel.CENTER);
                        labelArray[j][i].setText(Integer.toString(j) + Integer.toString(i));
                        labelArray[j][i].getParent().revalidate();
                        break;
                }


            }

        }
    }

    public static void brickDamageChange(Brick newBrick) {
        labelArray[newBrick.getPosX()][newBrick.getPosY()].setIcon(new ImageIcon(MapMain.class.getResource("/img/brick.jpg")));
        String dLevel = Integer.toString(100 - newBrick.getDamageLevel() * 25);
        labelArray[newBrick.getPosX()][newBrick.getPosY()].setForeground(Color.WHITE);
        labelArray[newBrick.getPosX()][newBrick.getPosY()].setText("<html>Brick<br>" + dLevel + "%</html>");
        labelArray[newBrick.getPosX()][newBrick.getPosY()].getParent().revalidate();


    }

    public static void removeDeadBricks(Brick newBrick) {
        labelArray[newBrick.getPosX()][newBrick.getPosY()].setIcon(new ImageIcon(MapMain.class.getResource("/img/prt.jpg")));
        labelArray[newBrick.getPosX()][newBrick.getPosY()].setText(Integer.toString(newBrick.getPosX()) + Integer.toString(newBrick.getPosY()));
    }

    public static void updatePlayerLocation(Player player) {
        int a = player.getPosX();
        int b = player.getPosY();
        String[] names1 = {"P0", "P1", "P2", "P3", "P4"};
        String[][] imgName = {{"/img/tank_red.jpg", "/img/tank_red1.jpg", "/img/tank_red2.jpg", "/img/tank_red3.jpg"}, {"/img/tank_orange.jpg", "/img/tank_orange1.jpg", "/img/tank_orange2.jpg", "/img/tank_orange3.jpg"}, {"/img/tank_green.jpg", "/img/tank_green1.jpg", "/img/tank_green2.jpg", "/img/tank_green3.jpg"}, {"/img/tank_gray.jpg", "/img/tank_gray1.jpg", "/img/tank_gray2.jpg", "/img/tank_gray3.jpg"}, {"/img/tank_blue.jpg", "/img/tank_blue1.jpg", "/img/tank_blue2.jpg", "/img/tank_blue3.jpg"}};
        for (int z = 0; z < 5; z++) {
            if (player.getPlayerName().equals(names1[z])) {
                for (int k = 0; k < 5; k++) {
                    if (player.getDirect() == k) {
                        //System.out.println(player);
                        labelArray[a][b].setIcon(new ImageIcon(MapMain.class.getResource(imgName[z][k])));
                        labelArray[a][b].setForeground(Color.YELLOW);
                        labelArray[a][b].setText(Integer.toString(a) + Integer.toString(b));
                    }
                }

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mapPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 700));

        mapPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        mapPanel.setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setText("Player");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel2.setText("Coins");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel3.setText("Points");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel4.setText("Health");

        name1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 0, 51));
        name1.setText("Player 1");

        name2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        name2.setForeground(new java.awt.Color(255, 0, 51));
        name2.setText("Player 2");

        name4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        name4.setForeground(new java.awt.Color(255, 0, 51));
        name4.setText("Player 4");

        name3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        name3.setForeground(new java.awt.Color(255, 0, 51));
        name3.setText("Player 3");

        name5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        name5.setForeground(new java.awt.Color(255, 0, 51));
        name5.setText("Player 5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(name4, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(name3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MapMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    // End of variables declaration//GEN-END:variables
}
