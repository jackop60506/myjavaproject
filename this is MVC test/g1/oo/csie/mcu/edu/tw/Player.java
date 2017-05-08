package g1.oo.csie.mcu.edu.tw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;


public class Player implements Character
{
  
  private double CurrX;
  private double CurrY;
  Image image;
  public Player(){
    CurrX= Math.random()*100;
    CurrY=Math.random()*100;
  }
  public void display(Graphics g){
      
      System.out.println("asdsad");
        try {
      File f=new File("pics/animal0/cat0.png");
      image = ImageIO.read(f);
      g.drawImage(image , (int)CurrX, (int)CurrY, 100,100, null);
    }
       catch (Exception ex) {
              System.out.println("No Image Card!!");
       }

  }
}
