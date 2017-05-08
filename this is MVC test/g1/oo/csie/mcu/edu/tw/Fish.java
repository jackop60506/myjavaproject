package g1.oo.csie.mcu.edu.tw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

/**
 * Write a description of class fish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fish implements Character
{
  private double CurrX;
  private double CurrY;
  private Image image;
  private Model model;
  private static String path="pics/animal0/";
  private static String[] fnames = {"cat0.png", "cat1.png", "cat2.png" };
  private static ImgSequence is = new ImgSequence(path,fnames);
  public Fish(Control ctl){
    CurrX=Math.random()*200;
    CurrY=300;
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
     System.out.println("   Fish:(" +model.getCurrX() + "," + model.getCurrY() + ")");
  }
}
