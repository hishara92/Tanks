/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ai;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author Hishara
 */
public class AiTimer implements Runnable {

    private int time;
    
    public AiTimer(int time) {
        this.time=time;
    }

    @Override
    public void run() {
        try {
            //System.out.println("started");
            Thread.sleep(time);
            //System.out.println("slept for "+ti);
           
        } catch (Exception e) {
        }
    }

    
    

        //timer.start();
}
