package g1.oo.csie.mcu.edu.tw;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

/**
 * Write a description of class View here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class View extends JPanel
{
    Image image; //圖片
    JFrame jf; //panel
    String imgPath= "pics/";
    Control ctl;
    View(Control ctl){
       jf = new JFrame("This is JAVA GUI Basic Sample");
       jf.setSize((int)(500), (int)(500));
       jf.add(this);
       jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       jf.getContentPane().setBackground(Color.WHITE);
       this.ctl=ctl;
    }
  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// note here
        ctl.display(g);
    }
    void display(){
        jf.setVisible(true);
        this.repaint();
    }
    
}
