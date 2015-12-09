/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import Gui.MapMain;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Hishara
 */
public class MapDetails {

    static int mapMax = 10;
    public static String map[][] = new String[mapMax][mapMax];
    static int x = 0, y = 0;
    static ArrayList<String> P0;
    static ArrayList<String> P1;
    static ArrayList<String> P2;
    static ArrayList<String> P3;
    static ArrayList<String> P4;
    static ArrayList<Player> playerList;
    static ArrayList<Coin> coinList;
    static ArrayList<Brick> brickList;
    public static ArrayList<HealthPack> healthPackList;
    static Player player1;
    static Player player2;
    static Player player3;
    static Player player4;
    static Player player5;
    static Coin coinObj;
    static Brick brickObj;
    static HealthPack helObj;
    static ArrayList<String> brick_pos = new ArrayList<String>();

    public static void createMap(String address) {

        String I;
        String playerNum;
        String brick;
        String stone;
        String water;

        ArrayList<String> stone_pos = new ArrayList<String>();
        ArrayList<String> water_pos = new ArrayList<String>();
        //String dtail="I:P0:5,7;1,3;6,8;8,7;0,4;2,6:4,8;3,2;7,1;9,3;7,4;4,2;8,1;3,6;5,8:6,2;3,1;1,7;1,2;4,7;9,2;5,4;7,2;8,6;2,4#";
        String new_add = address.substring(0, address.length() - 1);// to remove last # mark
        StringTokenizer str = new StringTokenizer(new_add, ":");
        I = str.nextToken();//check the first digit
        playerNum = str.nextToken();//get player names
        brick = str.nextToken();//get locations of bricks
        stone = str.nextToken();//get locations of stones
        water = str.nextToken();//get locations of water
        System.out.println("I = " + I + " brick = " + brick + " stone = " + stone + " water = " + water);

        StringTokenizer bri = new StringTokenizer(brick, ";");
        for (int i = 0; bri.hasMoreTokens(); i++) {
            brick_pos.add(i, bri.nextToken());
        }
        StringTokenizer sto = new StringTokenizer(stone, ";");
        for (int i = 0; sto.hasMoreTokens(); i++) {
            stone_pos.add(i, sto.nextToken());
        }
        StringTokenizer wat = new StringTokenizer(water, ";");
        for (int i = 0; wat.hasMoreTokens(); i++) {
            water_pos.add(i, wat.nextToken());
        }
        for (int i = 0; i < mapMax; i++) {
            for (int j = 0; j < mapMax; j++) {
                map[i][j] = "0";
            }
        }
        for (int i = 0; i < brick_pos.size(); i++) {
            String positions[] = brick_pos.get(i).split(",");
            x = Integer.parseInt(positions[0]);
            y = Integer.parseInt(positions[1]);
            map[y][x] = "B";//B for brick
        }
        for (int i = 0; i < stone_pos.size(); i++) {
            String positions[] = stone_pos.get(i).split(",");
            x = Integer.parseInt(positions[0]);
            y = Integer.parseInt(positions[1]);
            map[y][x] = "S";//S for stone
        }
        for (int i = 0; i < water_pos.size(); i++) {
            String positions[] = water_pos.get(i).split(",");
            x = Integer.parseInt(positions[0]);
            y = Integer.parseInt(positions[1]);
            map[y][x] = "W";//W for water
        }
        printMap();

    }

    private static void printMap() {
        for (int i = 0; i < mapMax; i++) {
            for (int j = 0; j < mapMax; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public static void updateMap(String G) {
        String raw_st = G.substring(2, G.length());


        StringTokenizer upmap = new StringTokenizer(raw_st, ":");
        for (int i = 0; upmap.hasMoreTokens(); i++) {

            String k = upmap.nextToken();
            if (k.charAt(0) == 'P') {
                playerUpdateStatus(k);
            } else {
                MapMain.updateImage();
                //updateBricks(k);
            }


        }


    }

    private static void playerUpdateStatus(String P) {


        ArrayList<String> tokens = new ArrayList<String>();
        StringTokenizer player = new StringTokenizer(P, ";");
        while (player.hasMoreTokens()) {
            tokens.add(player.nextToken());
        }
        String positions[] = tokens.get(1).split(",");
        x = Integer.parseInt(positions[0]);
        y = Integer.parseInt(positions[1]);


        map[y][x] = tokens.get(0);
        if ("P0".equals(tokens.get(0))) {
//            if (player1 == null) {
//                player1 = new Player(tokens.get(0), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)), Integer.parseInt(tokens.get(4)), Integer.parseInt(tokens.get(5)));
//                playerList.add(player1);
//            } else {
//                player1.setPlayerName(tokens.get(0));
//                player1.setPoints(Integer.parseInt(tokens.get(2)));
//                player1.setWhetherShoot(Integer.parseInt(tokens.get(3)));
//                player1.setHealth(Integer.parseInt(tokens.get(4)));
//                player1.setCoins(Integer.parseInt(tokens.get(5)));
//            }
            P0 = tokens;
        } else if ("P1".equals(tokens.get(0))) {
            P1 = tokens;
        } else if ("P2".equals(tokens.get(0))) {
            P2 = tokens;
        } else if ("P3".equals(tokens.get(0))) {
            P3 = tokens;
        } else if ("P4".equals(tokens.get(0))) {
            P4 = tokens;
        } else {
            
        }
        printMap();
        System.out.println(P0);
        System.out.println(P1);
    }

    public static void updateBricks(String B) {
        String details[] = B.split(";");
        for (int k = 0; k < brick_pos.size(); k++) {
            String split[]=brick_pos.get(k).split(",");
            brickList.add(new Brick(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 0));
        }

        for (int i = 0; i < details.length; i++) {
            String[] info = details[i].split(",");
            x = Integer.parseInt(info[0]);
            y = Integer.parseInt(info[1]);
            int j = 0;


            if (!brickList.isEmpty()) {
                for (j = 0; j < brickList.size(); j++) {
                    if (brickList.get(i).getPosX() == x && brickList.get(i).getPosY() == y) {
                        brickList.get(i).setDamageLevel(Integer.parseInt(info[2]));
                        break;
                    }

                }

            }

        }



    }

    public static void updateLifePacks(String L) {
        String details[] = L.split(":");
        String[] positions = details[1].split(",");
        x = Integer.parseInt(positions[0]);
        y = Integer.parseInt(positions[1]);
        
        //System.out.println(details[2].substring(0, details[2].length() - 1));

        helObj = new HealthPack(y, x, Integer.parseInt(details[2].substring(0, details[2].length() - 1)));
        System.out.println("ojmokmkomk");
        //healthPackList.add(helObj);

        map[y][x] = "L";      //To indicate life packs

    }

    public static void updateCoinPiles(String C) {
        String details[] = C.split(":");
        String[] positions = details[1].split(",");
        x = Integer.parseInt(positions[0]);
        y = Integer.parseInt(positions[1]);

//        coinObj = new Coin(y, x, Integer.parseInt(details[2]), Integer.parseInt(details[3].substring(0, details[3].length() - 1)));
//        coinList.add(coinObj);

        map[y][x] = "C";      //To indicate Coin piles

    }
}
