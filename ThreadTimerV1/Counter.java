import java.awt.*;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Thread {
    private Model model;
    private int m;
    private int s;
    private Counter me;
    private Controller ctl;
    public Counter(Model md,Controller ctl) {
         model = md;
         m = model.getMinute();
         s = model.getSecond();
         me=this;
         this.ctl=ctl;
    }
  
    public void countDown() { //how to count down? should be called every second
       //minus one  every second
       if (s <=0) { //沒有秒數了
           if (m <=0) { //也沒有分鐘數了, 時間到!
               beep(); //呼叫beep三聲
               pause();
            }
            else { //還有分鐘數
                s=59;
                m--;
                model.setMinute(m);
                model.setSecond(s);                
            }
       } else {
            s--;
            model.setSecond(s);
       }
    }
    
    public void pause() { //how to pause?
       me=null;
    }
    public void run(){
        while(Thread.currentThread() == me){
            countDown();
            try{
                sleep(1000);
            }catch(Exception e){
                break;
            }
        }
       
    }
    private void beep() { //beep三聲
        Toolkit bp = Toolkit.getDefaultToolkit(); 
        bp.beep();
        bp.beep();
        bp.beep();
    }
}
