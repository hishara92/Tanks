/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import map.MapDetails;

/**
 *
 * @author Hishara
 */
public class GuiUpdateTimer implements Runnable{

    
    
    
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            while(true){
                MapMain.updatePlayerLocation(MapDetails.player1);
                Thread.sleep(1000);
                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiUpdateTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
