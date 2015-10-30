/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Hishara
 */
public class Coin {
    private int posX;
    private int posY;
    private int appearTime;
    private int amount;

    public Coin(int posX, int posY, int appearTime, int amount) {
        this.posX = posX;
        this.posY = posY;
        this.appearTime = appearTime;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public int getAppearTime() {
        return appearTime;
    }

    public void setAppearTime(int appearTime) {
        this.appearTime = appearTime;
    }
    
    
    
}
