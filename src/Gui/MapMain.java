/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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
    static JLabel[][] pointLabels = new JLabel[6][4];
    private int mapMax;
    MapDetails md=new MapDetails();
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
                        labelArray[y][x].setForeground(Color.BLACK);
                        labelArray[y][x].setIcon(new ImageIcon(getClass().getResource("/img/prt.jpg")));
                        labelArray[y][x].setText(Integer.toString(y) + Integer.toString(x));
                        break;
                }

            }

        }
        
        String[] headers={"Player","Coin","Points","Health"};
        String[] headers1={"Player1","Player2","Player3","Player4","Player5"};
        for(int x=0;x<6;x++){
            for(int y=0;y<4;y++){
                pointPanal.setLayout(new GridLayout(6, 4));
                //pointPanal.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
                pointLabels[x][y]=new JLabel();
                //pointLabels[x][y].setAlignmentX(CENTER_ALIGNMENT);
                //pointLabels[x][y].setHorizontalTextPosition(JLabel.CENTER);
                pointPanal.add(pointLabels[x][y]);
                pointLabels[x][y].setPreferredSize(new Dimension(100, 25));
                pointLabels[x][y].setMaximumSize(new Dimension(100, 25));
                pointLabels[x][y].setMinimumSize(new Dimension(100, 25));
                if(x==0){
                    pointLabels[x][y].setFont(new Font("cooper black", Font.PLAIN, 14));
                    pointLabels[x][y].setText(headers[y]);
                }
                else{
                    if(y==0){
                        pointLabels[x][y].setFont(new Font("cooper black", Font.PLAIN, 12));
                        pointLabels[x][y].setForeground(Color.RED);
                        pointLabels[x][y].setText(headers1[x-1]);
                    }
                    else{
                        
                    }
                }
            }
        }
        

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
                        labelArray[j][i].setForeground(Color.BLACK);
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
    
    public static void changePlayerTracks(String name,int x,int y){
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.print(map[i][j] + "  ");
                if(MapDetails.map[i][j].equals(name) && x==j && y==i){
                    //System.out.println(i+"   "+j);
                    
                }
                else{
                    if(MapDetails.map[i][j].equals(name)){
                        MapDetails.map[i][j]="0";
                    labelArray[j][i].setForeground(Color.BLACK);
                    labelArray[j][i].setIcon(new ImageIcon(MapMain.class.getResource("/img/prt.jpg")));
                        labelArray[j][i].setHorizontalTextPosition(JLabel.CENTER);
                        labelArray[j][i].setText(Integer.toString(j) + Integer.toString(i));
                        labelArray[j][i].getParent().revalidate();
                    }
                    
                }
            }
            //System.out.println();
        }
    }
    
    public static void updatePointTable(ArrayList<Player> players){
        for(int x=0;x<players.size();x++){
            Integer[] det={players.get(x).getPoints(),players.get(x).getCoins(),players.get(x).getHealth()};
            for(int y=1;y<4;y++){
                pointLabels[x+1][y].setFont(new Font("Times new roman", Font.PLAIN, 12));
                pointLabels[x+1][y].setForeground(Color.BLUE);
                pointLabels[x+1][y].setText(Integer.toString(det[y-1]));
            }
        }
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
                MapMain.changePlayerTracks(player.getPlayerName(), player.getPosX(), player.getPosY());

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
        jLabel5 = new javax.swing.JLabel();
        pointPanal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 700));

        mapPanel.setBorder(new javax.swing.border.MatteBorder(null));
        mapPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        mapPanel.setLayout(new java.awt.GridLayout(1, 0));

        pointPanal.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout pointPanalLayout = new javax.swing.GroupLayout(pointPanal);
        pointPanal.setLayout(pointPanalLayout);
        pointPanalLayout.setHorizontalGroup(
            pointPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        pointPanalLayout.setVerticalGroup(
            pointPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("S t a s t i c s");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pointPanal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pointPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JPanel pointPanal;
    // End of variables declaration//GEN-END:variables
}
