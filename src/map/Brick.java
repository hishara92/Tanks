/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Hishara
 */
public class Brick {
    private int posX;
    private int posY;
    private int damageLevel;

    public Brick(int posX, int posY, int damageLevel) {
        this.posX = posX;
        this.posY = posY;
        this.damageLevel = damageLevel;
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

    public int getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(int damageLevel) {
        this.damageLevel = damageLevel;
    }
}
