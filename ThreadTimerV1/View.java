import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class View extends JPanel
{
   Controller ctl;
   ControlPanel ctlPanel;
   FacePanel facePanel;
   View() {  
     ctlPanel = new ControlPanel();
     facePanel = new FacePanel();
     setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,16,10,20), BorderFactory.createLineBorder(Color.black)));
     setLayout(new BorderLayout());
     add(facePanel, BorderLayout.CENTER);
     add(ctlPanel, BorderLayout.SOUTH);
   }
   public void setController(Controller ctl) {
       this.ctl = ctl;
   }
   public void refresh(int m, int s) {
       facePanel.setUp(m, s);
    }
   private class ControlPanel extends JPanel implements ActionListener {
     JButton m, s, sg;
     ControlPanel () {
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	  add(m = new JButton("min"));
      add(s = new JButton("sec"));
      add(sg = new JButton(" go "));
      m.setActionCommand("min");
      s.setActionCommand("sec");
      sg.setActionCommand(" go ");
      m.setBackground(Color.cyan);
      s.setBackground(Color.cyan);
      sg.setBackground(Color.cyan);
	  m.addActionListener(this);
	  s.addActionListener(this);
	  sg.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
        case "min": ctl.incMin(); break;
        case "sec": ctl.incSec(); break;
        case " go ":ctl.startCountDown();
        case " stop ":ctl.startCountDown();
      }
    }
  }
  private class FacePanel extends JPanel {
     private int m=0;
     private int s = 0;
     JLabel face ;
     FacePanel() {
        String time = ""+ String.format("%02d", m) + ":" + String.format("%02d", s);
        face = new JLabel(time, JLabel.CENTER) ;
        face.setForeground(Color.blue);
        face.setFont(new Font("Courier", Font.BOLD, 36));
        setLayout(new BorderLayout());
        add (face, BorderLayout.CENTER);
     }
     private void setUp(int m, int s) {
         this.m = m;
         this.s = s;
         String time = ""+ String.format("%02d", m) + ":" + String.format("%02d", s);
         face.setText(time);
     }
  }

}
