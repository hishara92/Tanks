/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ai;

import Gui.MapMain;
import map.KeyCtrl;
import map.MapDetails;
import map.Player;
import tank.ClientServer;

/**
 *
 * @author Hishara
 */
public class AiMoves {

    int i = 0;
    ClientServer c = new ClientServer();
    Thread t3;
    private char[] direction = {'S', 'E', 'N', 'W'};
    private String[] command = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};

    
    //this method is to auto play(move player to desired location)
    public void move(char[] wavePath, Player player) {

        for (i = 0; i < 1000; i++) {
//            System.out.println("");
//            System.out.print(wavePath[i]);
            if (wavePath[i] == 'S' || wavePath[i] == 'E' || wavePath[i] == 'N' || wavePath[i] == 'W') {
                for (int j = 0; j < 4; j++) {
                    KeyCtrl.cmd = command[j];
                    if (wavePath[i] == direction[j]) {
                        if (player.getDirect() == j) {
                            fireAtBricks(player);
                            keepOutOfWater(player);
                            c.tankControl(command[j]);
                            //System.out.println(command[j]);
                            MapMain.updatePlayerLocation(MapDetails.player1);
                            t3 = new Thread(new AiTimer(1500));
                            t3.start();
                            while (true) {
                                if (!t3.isAlive()) {
                                    break;
                                }
                            }
                        } else {
                            c.tankControl(command[j]);
                            //System.out.println(command[j]);
                            MapMain.updatePlayerLocation(MapDetails.player1);
                            t3 = new Thread(new AiTimer(1500));
                            t3.start();
                            while (true) {
                                if (!t3.isAlive()) {
                                    break;
                                }
                            }
                            fireAtBricks(player);
                            keepOutOfWater(player);
                            c.tankControl(command[j]);
                            //System.out.println(command[j]);
                            MapMain.updatePlayerLocation(MapDetails.player1);
                            t3 = new Thread(new AiTimer(1500));
                            t3.start();
                            while (true) {
                                if (!t3.isAlive()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                break;
            }

        }



    }

    
    //this is to shoot when players come across with a brick
    public void fireAtBricks(Player player) {
        if (player.getDirect() == 0) {
            if (MapDetails.map[player.getPosY() - 1][player.getPosX()].equals("B") || MapDetails.map[player.getPosY() - 1][player.getPosX()].startsWith("P")) {
                for (int h = 0; h < 4; h++) {
                    c.tankControl("SHOOT#");
                    System.out.println("shoot");
                    MapMain.updatePlayerLocation(MapDetails.player1);
                    t3 = new Thread(new AiTimer(1500));
                    t3.start();
                    while (true) {
                        if (!t3.isAlive()) {
                            break;
                        }
                    }
                }
            }
        } else if (player.getDirect() == 1) {
            if (MapDetails.map[player.getPosY()][player.getPosX() + 1].equals("B") || MapDetails.map[player.getPosY()][player.getPosX() + 1].startsWith("P")) {
                for (int h = 0; h < 4; h++) {
                    c.tankControl("SHOOT#");
                    //System.out.println(command[j]);
                    MapMain.updatePlayerLocation(MapDetails.player1);
                    t3 = new Thread(new AiTimer(1500));
                    t3.start();
                    while (true) {
                        if (!t3.isAlive()) {
                            break;
                        }
                    }
                }
            }
        } else if (player.getDirect() == 2) {
            if (MapDetails.map[player.getPosY() + 1][player.getPosX()].equals("B") || MapDetails.map[player.getPosY() + 1][player.getPosX()].startsWith("P")) {
                for (int h = 0; h < 4; h++) {
                    c.tankControl("SHOOT#");
                    //System.out.println(command[j]);
                    MapMain.updatePlayerLocation(MapDetails.player1);
                    t3 = new Thread(new AiTimer(1500));
                    t3.start();
                    while (true) {
                        if (!t3.isAlive()) {
                            break;
                        }
                    }
                }
            }
        } else if (player.getDirect() == 3) {
            if (MapDetails.map[player.getPosY()][player.getPosX() - 1].equals("B") || MapDetails.map[player.getPosY()][player.getPosX() - 1].startsWith("P")) {
                for (int h = 0; h < 4; h++) {
                    c.tankControl("SHOOT#");
                    //System.out.println(command[j]);
                    MapMain.updatePlayerLocation(MapDetails.player1);
                    t3 = new Thread(new AiTimer(1500));
                    t3.start();
                    while (true) {
                        if (!t3.isAlive()) {
                            break;
                        }
                    }
                }
            }
        }
    }

    
    //this is to check and keep out of water when traversing
    public void keepOutOfWater(Player player) {
        if (player.getDirect() == 0) {
            if (MapDetails.map[player.getPosY() - 1][player.getPosX()].equals("W")) {

                String[] m = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};
                for (int z = 0; z < 4; z++) {
                    if (KeyCtrl.cmd.equals(m[z])) {
                        if (z < 3) {
                            c.tankControl(m[z + 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        } else {
                            c.tankControl(m[z - 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else if (player.getDirect() == 1) {
            if (MapDetails.map[player.getPosY()][player.getPosX() + 1].equals("W")) {

                String[] m = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};
                for (int z = 0; z < 4; z++) {
                    if (KeyCtrl.cmd.equals(m[z])) {
                        if (z < 3) {
                            c.tankControl(m[z + 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        } else {
                            c.tankControl(m[z - 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else if (player.getDirect() == 2) {
            if (MapDetails.map[player.getPosY() + 1][player.getPosX()].equals("W")) {

                String[] m = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};
                for (int z = 0; z < 4; z++) {
                    if (KeyCtrl.cmd.equals(m[z])) {
                        if (z < 3) {
                            c.tankControl(m[z + 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        } else {
                            c.tankControl(m[z - 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else if (player.getDirect() == 3) {
            if (MapDetails.map[player.getPosY()][player.getPosX() - 1].equals("W")) {

                String[] m = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};
                for (int z = 0; z < 4; z++) {
                    if (KeyCtrl.cmd.equals(m[z])) {
                        if (z < 3) {
                            c.tankControl(m[z + 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        } else {
                            c.tankControl(m[z - 1]);
                            Thread t1 = new Thread(new AiTimer(1000));
                            t1.start();
                            while (true) {
                                if (!t1.isAlive()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    
}
