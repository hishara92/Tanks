package tank;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientServer extends Thread{
    private Socket socket;
    private DataOutputStream dos;
    private String ip="127.0.0.1";
    //private String ip="192.168.1.4";
    private int port=6000;
    
    private boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Unable to connect to the address: ");
			return false;
		}
		System.out.println("Successfully connected to the server.");
		return true;
	}

    
    public void run(String msg){
     connect();
        try {        
            dos.writeBytes(msg);
            dos.flush();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void tankControl(String input){
        run(input);
    }
    
    

    
}

