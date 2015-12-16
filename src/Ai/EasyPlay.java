/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ai;

import java.util.Random;
import map.MapDetails;
import map.Player;
import tank.ClientServer;

/**
 *
 * @author Hishara
 */
public class EasyPlay {
    
    String[][] newMap=new String[10][10];
    String[][] pathMap=new String[10][10];
    int[][] pathFindMap=new int[10][10];
    MapDetails m=new MapDetails();
    
    public void getRealMap(){
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                newMap[x][y]=m.map[y][x];
            }
        }
    }
    
    
    public void reviewMap(){
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                if(newMap[x][y].equals("S") || newMap[x][y].equals("W") || newMap[x][y].startsWith("P")){
                    pathFindMap[x][y]=80;
                }
                
                else{
                    pathFindMap[x][y]=100;
                }
            }
        }
    }
    
    public void pathMap(){
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                if(newMap[x][y].equals("S") || newMap[x][y].equals("W") || newMap[x][y].startsWith("P")){
                    pathMap[x][y]="0";
                }
                else if(newMap[x][y].equals("B")){
                    pathMap[x][y]="2";
                }
                else if(newMap[x][y].equals("C")){
                    pathMap[x][y]="C";
                }
                else if(newMap[x][y].equals("L")){
                    pathMap[x][y]="L";
                }
                else{
                    pathMap[x][y]="1";
                }
            }
        }
    }
    
    ClientServer c = new ClientServer();
    
   public void randomRun(Player player){
       Random rand=new Random();
       int r=rand.nextInt(4);
       System.out.println(r);
       if(r==0){
           if(player.getDirect()!=0){
               c.tankControl("UP#");
           }
           if(pathMap[player.getPosX()-1][player.getPosY()].startsWith("P") || pathMap[player.getPosX()-1][player.getPosY()].equals("2")){
               while(pathMap[player.getPosX()-1][player.getPosY()].equals("0")){
                   c.tankControl("SHOOT#");
               }
           }
           else{
               c.tankControl("UP#");
           }
       }
       else if(r==1){
           if(player.getDirect()!=1){
               c.tankControl("RIGHT#");
           }
           if(pathMap[player.getPosX()][player.getPosY()+1].equals("0") || pathMap[player.getPosX()][player.getPosY()+1].equals("2")){
               
           }
           else{
               c.tankControl("RIGHT#");
           }
       }
       else if(r==2){
           if(player.getDirect()!=2){
               c.tankControl("DOWN#");
           }
           if(pathMap[player.getPosX()+1][player.getPosY()].equals("0") || pathMap[player.getPosX()+1][player.getPosY()].equals("2")){
               
           }
           else{
               c.tankControl("DOWN#");
           }
       }
       else if(r==3){
           if(player.getDirect()!=3){
               c.tankControl("LEFT#");
           }
           if(pathMap[player.getPosX()][player.getPosY()-1].equals("0") || pathMap[player.getPosX()][player.getPosY()-1].equals("2")){
               
           }
           else{
               c.tankControl("LEFT#");
           }
       }
       
   }
   
    public static void main(String[] args) {
        //randomRun();
        
        
        
        
    }
    
}
