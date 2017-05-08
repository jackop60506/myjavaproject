package g1.oo.csie.mcu.edu.tw;


/**
 * Write a description of class Model here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Model
{
  private double CurrX;
  private double CurrY;
  private double Width;
  private double Height;//設定長寬
  private ImgSequence is;
  private Fish f;
  private Bird b;
  private Control ctl;
  Model(Control ctl,double x, double y, double dw, double dh, ImgSequence seq,Fish f) {
        this.CurrX = x;
        this.CurrY = y;
        this.Width = dw;
        this.Height = dh;
        this.is =seq;
        this.f = f;
        this.ctl = ctl;
  }
  Model(Control ctl,double x, double y, double dw, double dh, ImgSequence seq,Bird f) {
        this.CurrX = x;
        this.CurrY = y;
        this.Width = dw;
        this.Height = dh;
        this.is =seq;
        this.b = f;
        this.ctl = ctl;
  }
  public double getCurrX(){return CurrX;}
  public double getCurrY(){return CurrY;}
  public synchronized void setCurrX(double x) { CurrX=x;}
  public synchronized void setCurrY(double y) { CurrY =y;}
  public double getWidth() { return Width;}
  public double getHeight() {return Height;}
  public ImgSequence getImageSequence(){return is;}
}
