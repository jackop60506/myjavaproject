import java.lang.*;
/**
 * Write a description of class Mythread here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestThread_Performance extends Thread
{
     public static Object lock = new Object();
     public String myId;
      public static int arr[]=new int[2000000];
      public static int arr_length=0;
      public static int arr_n[]=new int[2000000];
      public static int arr_n_length=0;
      public static boolean tag=true;
       public TestThread_Performance(String id){
           myId= id;
          
       }
      
       public void run(){
          
          final double qq=System.currentTimeMillis();
              while(arr_n_length<2000000){
                int a=0;
                while(a<10000){
                    a++;
                }
                synchronized(lock){
                 if(arr_n_length<2000000){
                     arr[arr_n_length]=arr_n_length;
                     arr_n_length++;
                    }
                }
            }
           final double ww=System.currentTimeMillis();
           if(tag==true){
               System.out.println(myId+" total seconds"+(ww-qq)/1000);
                System.out.println(arr[1999999]);
               tag=false;
            }
        }
        public void test(){
            final double qq=System.currentTimeMillis();
            while(arr_length<2000000){
                int a=0;
                while(a<10000){
                    a++;
                }
            //synchronized(lock){
                     arr[arr_length]=arr_length;
                     arr_length++;
            //}
            }
              final double ww=System.currentTimeMillis();
            System.out.println(myId+" total seconds"+(ww-qq)/1000);
            
        }
       public static void main(String args[]){
            
           TestThread_Performance t1 = new TestThread_Performance("T1");
           TestThread_Performance t2 = new TestThread_Performance("T2");
           TestThread_Performance t3 = new TestThread_Performance("T3");
           TestThread_Performance t4 = new TestThread_Performance("T4");
            t1.test();
            System.out.println("t1 not mulitithread execute");
            t2.start();
            t3.start();
            t4.start();
            System.out.println("t1、t2、t3 mulitithread execute");
        }
}
