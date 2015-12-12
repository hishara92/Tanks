/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hishara
 */
public class timeHandler extends Thread {
    int time;
    int x;
    int y;
    public timeHandler(Coin c) {
        time=c.getAppearTime();
        x=c.getPosX();
        y=c.getPosY();
    }
    
    public timeHandler(HealthPack h) {
        time=h.getAppearTime();
        x=h.getPosX();
        y=h.getPosY();
    }
    @Override
    public void run(){
        try {
            Thread.sleep(time);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        MapDetails.map[x][y]="0";
    }
    
    
}
