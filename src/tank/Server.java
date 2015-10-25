
package tank;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import map.Mapviewer;

public class Server extends Thread{
    ServerSocket serverSocket;
    Socket socket;
    Client c;
    public Server(Client client) throws IOException{
        serverSocket=new ServerSocket(7000);
        this.c=client;
    }
    @Override
    public void run(){
        c.run("JOIN#");//request sent to the server to join
        
        while(true){
            try {
                socket=serverSocket.accept();
                BufferedReader msg=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s=msg.readLine();
                System.out.println(s);
                if(s.charAt(0)=='I'&&s.charAt(1)==':'){//for priority I
                    Mapviewer.createMap(s);
                }
                if(s.charAt(0)=='G'&&s.charAt(1)==':'){
                    
                    Mapviewer.updateMap(s);
                }
                 
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    public static void main(String[] args) {
        Client tankClient=new Client();
        try {
            Server tankServer=new Server(tankClient);
            tankServer.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
