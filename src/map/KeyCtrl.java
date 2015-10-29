/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tank.Client;

/**
 *
 * @author Hishara
 */
public class KeyCtrl implements KeyListener {
    
    Client c=new Client();

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        
//        if(keyCode==KeyEvent.VK_UP){
//            //System.out.println("LLLLLLLLLLLLLLLLLL");
//            c.tankControl("UP#");
//        }
        
        //else if(keyCode==KeyEvent.VK_DOWN)
        switch(keyCode){
            case KeyEvent.VK_ENTER:
                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHH");
                break;
           
            
            case KeyEvent.VK_UP:
                //System.out.println("LLLLLLLLLLLLLLLLLL");
                c.tankControl("UP#");
                break;
           
            case KeyEvent.VK_DOWN:
                c.tankControl("DOWN#");
                break;
                
                
            case KeyEvent.VK_LEFT:
                c.tankControl("LEFT#");
                break;
            
            case KeyEvent.VK_RIGHT:
                c.tankControl("RIGHT#");
                break;
            
                case KeyEvent.VK_SPACE:
                c.tankControl("SHOOT#");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
    
}
