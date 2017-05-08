import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller{
    private Model model;
    private View viewer;
    private Counter counter;
    private Thread t;
    
    public Controller(Model md, View v ) {
        model = md;
        viewer = v;
        model.setOberver(this);
        
    }
    
   public void incMin() {
      
       int m = model.getMinute();
       int s = model.getSecond();
       
           m =  (m+1) % 61;
           if (m==60) s=0;
           model.setMinute(m);
           model.setSecond(s); 
       
    }
   public void incSec() {
      
       int m = model.getMinute();
       int s = model.getSecond();
      
       s=  (s+1) % 60;
       model.setSecond(s);
       
    }
    public void notify(Model model) {
     viewer.refresh( model.getMinute(), model.getSecond());
    }
    public void startCountDown() {
         counter = new Counter(model,this);
         counter.start(); 
    }
    public void pauseCountDown() {
        if (counter != null)
           counter.pause();
    } 
    public static void main(String[] args) {
       Model  model = new Model();
       View view = new View();
       
       Controller ctl = new Controller(model, view);
       
       view.setController(ctl);
       JFrame win = new JFrame("Timer");
       win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       win.setContentPane(view);
       win.setSize(220, 136);
       win.validate();
       win.setVisible(true);
       
    }   
    
}
