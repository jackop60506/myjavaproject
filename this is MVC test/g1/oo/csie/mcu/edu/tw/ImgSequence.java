package g1.oo.csie.mcu.edu.tw;
import java.util.*;
import java.awt.Image;
import java.io.*;
import javax.imageio.*;

/**
 * Write a description of class ImgSequence here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImgSequence implements Cloneable
{
    protected ArrayList<Image> imgs= new ArrayList<>();
    private int currentIdx=-1;
    public ImgSequence(String imgPath,String[] fnames){
        try{
            for(int i=0;i<fnames.length;i++){
                File f = new File(imgPath+fnames[i]);
                Image image = ImageIO.read(f);
                imgs.add(image);
            }
        }
        catch(Exception ex){
            System.out.println("no image!");
        }
    }
    public Image nextImage(){
        int size = imgs.size();
        currentIdx=(currentIdx+1) % size;
        
        return imgs.get(currentIdx);
    }
    public Object clone(){
        try {
            return super.clone(); //呼叫 Object的clone()
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
