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
    private int points;
    private int whetherShoot;
    private int health;
    private int coins;

    public Player(String playerName, int points, int whetherShoot, int health, int coins) {
        this.playerName = playerName;
        this.points = points;
        this.whetherShoot = whetherShoot;
        this.health = health;
        this.coins = coins;
    }
    

    public int getWhetherShoot() {
        return whetherShoot;
    }

    public void setWhetherShoot(int whetherShoot) {
        this.whetherShoot = whetherShoot;
    }
    
    

   
    

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * @param coins the coins to set
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    
}
