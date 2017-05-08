
/**
 * Write a description of class Model here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Model
{
    int minute;
    int second;
    Controller oberver;
    public void setMinute(int m) { minute = m; oberver.notify(this);}
    public void setSecond(int s) { second = s; oberver.notify(this);}
    public int getMinute() { return minute; }
    public int getSecond() { return second;}
    public void display() {System.out.println(""+ minute+":"+second); }
    public void setOberver(Controller ctl) {
       oberver = ctl;
    }
}
