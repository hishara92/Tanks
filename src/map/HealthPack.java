/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Hishara
 */
public class HealthPack {
    private int posX;
    private int posY;
    private int appearTime;

    public HealthPack(int posX, int posY, int appearTime) {
        this.posX = posX;
        this.posY = posY;
        this.appearTime = appearTime;
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
