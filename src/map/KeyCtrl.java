/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tank.ClientServer;

/**
 *
 * @author Hishara
 */
public class KeyCtrl implements KeyListener {

    ClientServer c = new ClientServer();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode==KeyEvent.VK_DOWN){
            c.tankControl("DOWN#");
        }
        else if(keyCode==KeyEvent.VK_UP){
            c.tankControl("UP#");
        }
        else if(keyCode==KeyEvent.VK_LEFT){
            c.tankControl("LEFT#");
        }
        else if(keyCode==KeyEvent.VK_RIGHT){
            c.tankControl("RIGHT#");
        }
        else if(keyCode==KeyEvent.VK_CONTROL){
            c.tankControl("SHOOT#");
        }
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
