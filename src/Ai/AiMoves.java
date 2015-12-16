/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ai;

import Gui.MapMain;
import map.MapDetails;
import map.Player;
import tank.ClientServer;

/**
 *
 * @author Hishara
 */
public class AiMoves {

    int i=0;
    ClientServer c = new ClientServer();
    Thread t3;
    private char[] direction = {'S', 'E', 'N', 'W'};
    private String[] command = {"UP#", "RIGHT#", "DOWN#", "LEFT#"};

    public void move(char[] wavePath, Player player) {
        //char p=wavePath[i];
        for( i=0;i<100;i++){
            
                for (int j = 0; j < 4; j++) {
                    if (wavePath[i] == direction[j]) {
                        if (player.getDirect() == j) {
                            c.tankControl(command[j]);
                            MapMain.updatePlayerLocation(MapDetails.player1);
                            t3 = new Thread(new AiTimer(1500));
                            t3.start();
                            while (true) {
                                if (!t3.isAlive()) {
                                    break;
                                }
                            }
                        }
                        else{
                           c.tankControl(command[j]);
                           MapMain.updatePlayerLocation(MapDetails.player1);
                            t3 = new Thread(new AiTimer(1500));
                            t3.start();
                            while (true) {
                                if (!t3.isAlive()) {
                                    break;
                                }
                            }
                            c.tankControl(command[j]);
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

    }

//    public void moveToPoint(char[] wavePath, Player player) throws InterruptedException {
//        Thread t1 = new Thread(new AiTimer(2000));
//        for (i = 0; i < 1000; i++) {
//            switch (wavePath[i]) {
//                case 'S':
//                    if (player.getDirect() == 0) {
//                        c.tankControl("UP#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//
//
//                    } else {
//                        c.tankControl("UP#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        c.tankControl("UP#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                    }
//                    break;
//
//                case 'N':
//                    if (player.getDirect() == 2) {
//                        c.tankControl("DOWN#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//
//                    } else {
//                        c.tankControl("DOWN#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        c.tankControl("DOWN#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                    }
//                    break;
//
//                case 'W':
//                    if (player.getDirect() == 0) {
//                        c.tankControl("LEFT#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//
//                    } else {
//                        c.tankControl("LEFT#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        c.tankControl("LEFT#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                    }
//                    break;
//
//                case 'E':
//                    if (player.getDirect() == 0) {
//                        c.tankControl("RIGHT#");
//                        Thread t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        MapMain.updatePlayerLocation(MapDetails.player1);
//
//                    } else {
//                        c.tankControl("RIGHT#");
//                        Thread t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        MapMain.updatePlayerLocation(MapDetails.player1);
//                        c.tankControl("RIGHT#");
//                        t3 = new Thread(new AiTimer(2000));
//                        t3.start();
//                        while (true) {
//                            if (!t3.isAlive()) {
//                                break;
//                            }
//                        }
//                        MapMain.updatePlayerLocation(MapDetails.player1);
//                    }
//                    break;
//
//
//            }
//
//        }
//    }
}
