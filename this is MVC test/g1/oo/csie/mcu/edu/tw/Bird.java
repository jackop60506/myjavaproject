package g1.oo.csie.mcu.edu.tw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public class Bird implements Character
{
  private double CurrX;
  private double CurrY;
  private Image image;
  private Model model;
  private static String path="pics/animal1/";
  private static String[] fnames = {"dog0.png", "dog1.png", "dog2.png" };
  private static ImgSequence is = new ImgSequence(path,fnames);
  public Bird(Control ctl){
    CurrX=Math.random()*200;
    CurrY=10;
    is = (ImgSequence)is.clone();
    model=new Model(ctl,CurrX,CurrY,50,50,is,this);
  }
  public void display(Graphics g){
      Image img=is.nextImage();
       
      g.drawImage(img , (int)model.getCurrX(), (int)model.getCurrY(), null,null);
  }
  public void move(){
     model.setCurrX(model.getCurrX()+1);
     model.setCurrY(model.getCurrY()+1);
     System.out.println("   Bird:(" +model.getCurrX() + "," + model.getCurrY() + ")");
  }
}
