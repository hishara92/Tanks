/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Hishara
 */
public class Player {
    private String playerName;
    private int posX;
    private int posY;
    private int direct;
    private int whetherShoot;
     private int health;
    private int coins;
    private int points;

    public Player(String playerName, int posX, int posY, int direct, int whetherShoot, int health, int coins, int points) {
        this.playerName = playerName;
        this.posX = posX;
        this.posY = posY;
        this.direct = direct;
        this.whetherShoot = whetherShoot;
        this.health = health;
        this.coins = coins;
        this.points = points;
    }

    public Player() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getWhetherShoot() {
        return whetherShoot;
    }

    public void setWhetherShoot(int whetherShoot) {
        this.whetherShoot = whetherShoot;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
   

    
    
    
}
