
package tank;

import Gui.MapMain;
import Gui.Wracked;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import map.MapDetails;

public class ClientMain extends Thread{
    ServerSocket serverSocket;
    Socket socket;
    ClientServer c;
    public ClientMain(ClientServer client) throws IOException{
        serverSocket=new ServerSocket(7000);
        this.c=client;
    }
    @Override
    public void run(){
        c.run("JOIN#");//request sent to the server to join
        //new Map().setVisible(true);
        //new MapMain().setVisible(true);
        while(true){
            try {
                socket=serverSocket.accept();
                BufferedReader msg=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s=msg.readLine();
                System.out.println(s);
                
                if(s.charAt(0)=='I'&&s.charAt(1)==':'){//for priority I
                    MapDetails.createMap(s);
                    new MapMain().setVisible(true);
                    //new MapMain().setVisible(true);
                }
                else if(s.charAt(0)=='G'&&s.charAt(1)==':'){
                    
                    MapDetails.updateMap(s);
                }
                
                else if(s.charAt(0)=='L'&&s.charAt(1)==':'){
                    MapDetails.updateLifePacks(s);
                }
                
                 else if(s.charAt(0)=='C'&&s.charAt(1)==':'){
                    MapDetails.updateCoinPiles(s);
                }
                 else if(s.charAt(0)=='S'){
                     
                 }
                
                 else{
                     if(s.equals("DEAD#")){
                         new Wracked().setVisible(true);
                         try {
                             Thread.sleep(100);
                             
                         } catch (InterruptedException ex) {
                             Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                     }
                     else{
                         JOptionPane.showMessageDialog(null, s);
                     }
                     
                 }
                MapMain.updatePointTable(MapDetails.playerList);
                 
            } catch (IOException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    public static void main(String[] args) {
        ClientServer tankClient=new ClientServer();
        ClientServer tankClient1=new ClientServer();
        try {
            ClientMain tankServer=new ClientMain(tankClient);
            tankServer.start();
//            ClientMain tankServer1=new ClientMain(tankClient1);
//            tankServer1.start();
        } catch (IOException ex) {
            Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
