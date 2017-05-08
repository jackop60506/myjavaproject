package g1.oo.csie.mcu.edu.tw;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Graphics;
public class Control
{
   private ArrayList<Fish> fishs = new ArrayList<>();
   private ArrayList<Bird> birds = new ArrayList<>();
   private View view;
   public Control(){
       for(int i=0;i<500;i++){
           Fish f = new Fish(this);
           Bird b = new Bird(this);
           fishs.add(f);
           birds.add(b);
           
       }
       view = new View(this);
   }
   public static void main(String args[]){
       Control ctl =new Control();
       ctl.run();
   }
   public void run(){
       
       
       while(true){
          
             for(Fish s:fishs){
                   s.move();
             }
             
             for(Bird b:birds){
                   b.move();
             }
            view.display();
           try{
             Thread.sleep(100);
           }catch(Exception e){
            
           }
      
       }
   }
   void display(Graphics g){
         
           for(Fish s:fishs){
               s.display(g);
           }
           
           for(Bird b:birds){
               b.display(g);
           }
        
        
    }
}
